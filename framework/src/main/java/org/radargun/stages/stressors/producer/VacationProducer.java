package org.radargun.stages.stressors.producer;

import org.radargun.portings.stamp.vacation.Random;
import org.radargun.stages.ScalableSyntheticStageStressor;
import org.radargun.stages.stressors.AbstractBenchmarkStressor;
import org.radargun.stages.stressors.stamp.vacation.VacationParameter;
import org.radargun.stages.stressors.stamp.vacation.VacationStressor;
import org.radargun.stages.stressors.syntethic.SyntheticParameter;
import org.radargun.stages.synthetic.xactClass;



/**
 * Author: Fabio Perfetti (perfabio87 [at] gmail.com)
 * Date: 8/3/13
 * Time: 5:33 PM
 */
public class VacationProducer extends Producer<VacationStressor, VacationParameter> {

    private Random rnd = new Random();
    private Producer producer;

    public VacationProducer(int _id,
                            VacationStressor stressor,
                            Producer producer,
                            VacationParameter params) {
        super(_id, stressor, params);
        this.producer = producer;

    }

    @Override
    protected double getSleepTime() {
        return producer.getSleepTime();
    }

    @Override
    protected void sleep() {
        producer.sleep();
    }

    @Override
    protected RequestType createRequestType(int reqType) {
        return producer.createRequestType(reqType);
    }

    @Override
    public void doNotify() {
        producer.doNotify();
    }

    @Override
    protected int nextTransaction() {
        int r = rnd.posrandom_generate() % 100;
        int action = stressor.selectAction(r, parameter.getPercentUser());
        //RequestType requestType = new RequestType(System.nanoTime(),action);

        return action;
    }



}