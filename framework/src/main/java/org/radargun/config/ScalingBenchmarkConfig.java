package org.radargun.config;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.radargun.Stage;

import java.util.ArrayList;
import java.util.List;

/**
 * A scaling benchmark is one that executes on an increasing number of slaves. E.g. considering the {@link
 * org.radargun.stages.WebSessionBenchmarkStage}, one might want to execute it over multiple clusters of
 * different sizes: e.g 2,3,4,5..10 etc in order to check how a product scales etc.
 *
 * @author Mircea.Markus@jboss.com
 */
public class ScalingBenchmarkConfig extends FixedSizeBenchmarkConfig {

   // For Apache/commons/logging Log doesn't need to be static.
   protected Log log = LogFactory.getLog(ScalingBenchmarkConfig.class);

    private boolean initialized = false;

   List<FixedSizeBenchmarkConfig> fixedBenchmarks = new ArrayList<FixedSizeBenchmarkConfig>();

   private int fixedBenchmarkIt = 0;

   //mandatory
   private int initSize = -1;

   //optional
   private int increment = 1;

   public int getInitSize() {
      return initSize;
   }

   public void setInitSize(int initSize) {
      this.initSize = initSize;
   }

   public int getIncrement() {
      return increment;
   }

   public void setIncrement(int increment) {
      this.increment = increment;
   }

   public void validate() {
      super.validate();
      if (initSize < 2)
         throw new RuntimeException("For scaling benchmarks(" + getProductName() + ") the initial size must be at least 2");
      if (getMaxSize() < initSize)
         throw new RuntimeException("Config problems for benchmark: " + getProductName() + " - maxSize must be >= initSize");
      if (increment <= 0) throw new RuntimeException("Increment must be positive!");
   }

   @Override
   public boolean hasNextStage() {
       log.trace("hasNextStage");
      initialize();
      log.trace("fixedBenchmarkIt=" + fixedBenchmarkIt);
      //log.warn("17Mar2013_3_12 Commenting next line, asking if there is any other stage to the fixedBenchmark");
       log.trace(fixedBenchmarkIt+"<"+(fixedBenchmarks.size() - 1));
       if (fixedBenchmarkIt < fixedBenchmarks.size() - 1) return true;
      return currentFixedBenchmark().hasNextStage();
   }

   private void initialize() {
       log.trace("initialize");
      if (!initialized) {
         log.info("Initializing.  Starting with " + initSize + " nodes, up to " + getMaxSize() + " nodes, incrementing by " + increment);
         for (int i = initSize; i <= getMaxSize(); i += increment) {
            log.info("Initializing configuration with " + i + " nodes");
            FixedSizeBenchmarkConfig conf = new FixedSizeBenchmarkConfig();
            conf.setMaxSize(getMaxSize());
            log.warn("Should not be necessary to initialize stages. It should takes the original stack.");
            conf.originalStackStages = getOriginalStages();
            conf.stages.set(getOriginalStages());
            conf.setSize(i);
            conf.setConfigName(super.configName);
            conf.setProductName(super.productName);
            fixedBenchmarks.add(conf);
         }
         initialized = new Boolean(true);
         log.info("Number of cluster topologies on which benchmark will be executed is " + fixedBenchmarks.size());
      }
   }

   @Override
   public Stage nextStage() {
       log.trace("nextStage");
      initialize();

      if (!currentFixedBenchmark().hasNextStage()) {
         fixedBenchmarkIt++;
          log.trace("fixedBenchmarkIt=" + fixedBenchmarkIt);
      }
      return currentFixedBenchmark().nextStage();
   }

   public FixedSizeBenchmarkConfig currentFixedBenchmark() {
      return fixedBenchmarks.get(fixedBenchmarkIt);
   }

   public void errorOnCurrentBenchmark() {
      currentFixedBenchmark().errorOnCurrentBenchmark();
   }

   @Override
   public ScalingBenchmarkConfig clone() {
      ScalingBenchmarkConfig clone = (ScalingBenchmarkConfig) super.clone();
      clone.fixedBenchmarks= new ArrayList<FixedSizeBenchmarkConfig>();
      for (FixedSizeBenchmarkConfig fbc : fixedBenchmarks) {
         clone.fixedBenchmarks.add(fbc.clone());
      }
      return clone;
   }

}
