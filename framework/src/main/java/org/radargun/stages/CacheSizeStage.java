package org.radargun.stages;

import org.radargun.CacheWrapper;
import org.radargun.DistStageAck;
import org.radargun.state.MasterState;
import org.radargun.utils.CacheSizeValues;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by IntelliJ IDEA. Date: 3/4/12 Time: 12:04 PM
 *
 * @author Pedro Ruivo
 */
public class CacheSizeStage extends AbstractDistStage {

   private String statName = "CACHE_SIZE_" + System.nanoTime();

   private boolean reset = false;

   @Override
   public DistStageAck executeOnSlave() {
      DefaultDistStageAck ack = newDefaultStageAck(this.getClass().getName());
      CacheWrapper wrapper = slaveState.getCacheWrapper();
      if (wrapper == null) {
         log.info("Not executing any test as the wrapper is not set up on this slave ");
         ack.setError(true);
         ack.setErrorMessage("Cache Wrapper is null");
         return ack;
      }
      log.info("Cache size " + wrapper.getCacheSize());
      ack.setPayload(wrapper.getCacheSize());
      ack.setDuration(0);
      return ack;
   }

   @Override
   public boolean processAckOnMaster(List<DistStageAck> acks, MasterState masterState) {
      log.info("CacheSizeStage processAckOnMaster see " + getActiveSlaveCount() + " active slaves");
      CacheSizeValues cacheSizeValues = new CacheSizeValues(processStatName(), getActiveSlaveCount());
      for (DistStageAck ack : acks) {
         if (ack instanceof DefaultDistStageAck) {
            log.info("Processing CacheSizeStage for slave " + ack.getSlaveIndex());
            Integer cacheSize = (Integer) ((DefaultDistStageAck) ack).getPayload();
            cacheSizeValues.setCacheSize(ack.getSlaveIndex(), cacheSize);
         }
      }

      List<CacheSizeValues> allCacheSizeValues = (List<CacheSizeValues>) masterState.get("CacheSizeResults");
      if (allCacheSizeValues == null || reset) {
         allCacheSizeValues = new LinkedList<CacheSizeValues>();
         masterState.put("CacheSizeResults", allCacheSizeValues);
      }
      //This add is correct, because you can have multiple CacheSizeStages during a benchmark to track the evolution of the cache
      //and you don't want to lose information
      //Nevertheless, once you produce the csv, these info must be erased from the master state!
      allCacheSizeValues.add(cacheSizeValues);
      log.info("allCacheSizeValues " + allCacheSizeValues.toString());
      return super.processAckOnMaster(acks, masterState);    //To change body of overridden methods use File | Settings | File Templates.
   }

   private String processStatName() {
      StringBuilder sb = new StringBuilder();
      String tmp = statName.trim();
      for (char c : tmp.toCharArray()) {
         if (Character.isSpaceChar(c)) {
            sb.append("_");
         } else {
            sb.append(c);
         }
      }
      return sb.toString();
   }

   @Override
   public String toString() {
      return "CacheSizeStage{" +
            "statName='" + statName + '\'' +
            ", reset=" + reset +
            '}';
   }

   public void setStatName(String statName) {
      this.statName = statName;
   }


   public void setReset(boolean reset) {
      this.reset = reset;
   }
}
