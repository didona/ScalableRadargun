//package org.radargun.stressors.consumer;
//
//import org.apache.commons.logging.Log;
//import org.apache.commons.logging.LogFactory;
//import org.radargun.CacheWrapper;
//import org.radargun.Transaction;
//import org.radargun.stages.AbstractBenchmarkStage;
//import org.radargun.stressors.BenchmarkStressor;
//import org.radargun.stressors.StressorParameter;
//import org.radargun.stressors.producer.RequestType;
//import org.radargun.workloadGenerator.AbstractWorkloadGenerator;
//import org.radargun.workloadGenerator.MuleSystem;
//import org.radargun.workloadGenerator.OpenSystem;
//import org.radargun.workloadGenerator.SystemType;
//
///**
// * Created by: Fabio Perfetti
// * E-mail: perfabio87@gmail.com
// * Date: 4/24/13
// */
//public class MuleConsumer extends Consumer<MuleSystem> {
//
//    private static Log log = LogFactory.getLog(MuleConsumer.class);
//
//    public MuleConsumer(CacheWrapper cacheWrapper,
//                        int threadIndex,
//                        MuleSystem system,
//                        AbstractBenchmarkStage stage,
//                        BenchmarkStressor stressor,
//                        StressorParameter parameters) {
//        super(cacheWrapper, threadIndex, system, stage, stressor, parameters);
//    }
//
//    @Override
//
//}
//
//
////                      COMMENTATO POICHé NON DOVREI MAI ENTRARE QUI
////                        if PassiveReplication so skip whether:
////                        a) master node && readOnly transaction
////                        b) slave node && write transaction
////                        boolean masterAndReadOnlyTx = cacheWrapper.isTheMaster() && tx.isReadOnly();
////                        boolean slaveAndWriteTx = (!cacheWrapper.isTheMaster() && !tx.isReadOnly());
////
////                        if (cacheWrapper.isPassiveReplication() && (masterAndReadOnlyTx || slaveAndWriteTx)) {
////                            continue;
////                        }