package org.radargun.stages.stressors.syntethic.consumer;

import org.radargun.CacheWrapper;
import org.radargun.stages.AbstractBenchmarkStage;
import org.radargun.stages.stressors.AbstractBenchmarkStressor;
import org.radargun.stages.stressors.consumer.Consumer;
import org.radargun.stages.stressors.syntethic.SyntheticParameter;
import org.radargun.stages.stressors.systems.SystemType;
import org.radargun.stages.synthetic.SyntheticXactFactory;

/**
 * Author: Fabio Perfetti (perfabio87 [at] gmail.com)
 * Date: 8/3/13
 * Time: 3:47 PM
 */
public class SyntheticConsumer extends Consumer {

    private SyntheticXactFactory factory;

    public SyntheticConsumer(CacheWrapper cacheWrapper,
                             int threadIndex,
                             SystemType system,
                             AbstractBenchmarkStage stage,
                             AbstractBenchmarkStressor stressor,
                             SyntheticParameter parameters,
                             SyntheticXactFactory factory) {
        super(cacheWrapper, threadIndex, system, stage, stressor, parameters, factory);


        this.factory = factory;
    }

    public SyntheticXactFactory getFactory(){
        return factory;
    }

}
