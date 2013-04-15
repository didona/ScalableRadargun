package org.radargun.workloadGenerator;

import org.radargun.stages.AbstractBenchmarkStage;

/**
 * Created by: Fabio Perfetti
 * E-mail: perfabio87@gmail.com
 * Date: 3/18/13
 */
public class ClosedWorkloadGenerator extends AbstractWorkloadGenerator {

    public ClosedWorkloadGenerator(AbstractBenchmarkStage stage) {
        super(stage);
    }

    @Override
    public int getCurrentArrivalRate() {
        return 0;
    }

    @Override
    public SystemType getSystemType(){ return SystemType.CLOSED; }

    @Override
    public ClosedWorkloadGenerator clone(){
        return (ClosedWorkloadGenerator) super.clone();
    }
}
