package org.radargun.stages.stressors.stamp.vacation;

import org.radargun.CacheWrapper;
import org.radargun.stages.stressors.Parameters;
import org.radargun.stages.synthetic.XACT_RETRY;

/**
 * Created by: Fabio Perfetti E-mail: perfabio87@gmail.com Date: 5/7/13
 */
public class VacationParameter extends Parameters {

   private int queryPerTx;

   /* percentUser is the percentage of MakeReservationOperation */
   private int percentUser;

   /* queryRange defines which part of the data can possibly be touched by the transactions */
   private int queryRange;

   /* readOnlyPerc is what percentage of MakeReservationOperation are read-only */
   private int readOnlyPerc;

   private int relations;

   public VacationParameter(CacheWrapper cacheWrapper,
                            long simulationTimeSec,
                            int numOfThreads,
                            int nodeIndex,
                            long backOffTime,
                            XACT_RETRY retryOnAbort,
                            long statsSamplingInterval,

                            int queryPerTx,
                            int percentUser,
                            int queryRange,
                            int readOnlyPerc,
                            int relations) {
      super(cacheWrapper, simulationTimeSec, numOfThreads, nodeIndex, backOffTime, retryOnAbort, statsSamplingInterval);

      this.queryPerTx = queryPerTx;
      this.percentUser = percentUser;
      this.queryRange = queryRange;
      this.readOnlyPerc = readOnlyPerc;
      this.relations = relations;
   }

   public int getQueryPerTx() {
      return queryPerTx;
   }

   public void setQueryPerTx(int queryPerTx) {
      this.queryPerTx = queryPerTx;
   }

   public int getPercentUser() {
      return percentUser;
   }

   public void setPercentUser(int percentUser) {
      this.percentUser = percentUser;
   }

   public int getQueryRange() {
      return queryRange;
   }

   public void setQueryRange(int queryRange) {
      this.queryRange = queryRange;
   }

   public int getReadOnlyPerc() {
      return readOnlyPerc;
   }

   public void setReadOnlyPerc(int readOnlyPerc) {
      this.readOnlyPerc = readOnlyPerc;
   }

   public int getRelations() {
      return relations;
   }

   public void setRelations(int relations) {
      this.relations = relations;
   }
}
