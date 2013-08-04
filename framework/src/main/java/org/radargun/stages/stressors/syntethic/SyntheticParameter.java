package org.radargun.stages.stressors.syntethic;

import org.radargun.stages.stressors.Parameter;
import org.radargun.stages.stressors.StringKeyGenerator;

/**
 * Author: Fabio Perfetti (perfabio87 [at] gmail.com)
 * Date: 8/3/13
 * Time: 2:40 PM
 */
public class SyntheticParameter extends Parameter {

    /**
     * for each session there will be created fixed number of attributes. On those attributes all the GETs and PUTs are
     * performed (for PUT is overwrite)
     */
    protected int numberOfAttributes = 100;

    /**
     * Each attribute will be a byte[] of this size
     */
    protected int sizeOfAnAttribute = 1000;

    /**
     * Out of the total number of request, this define the frequency of writes (percentage)
     */
    protected int writePercentage = 20;

    protected String keyGeneratorClass = StringKeyGenerator.class.getName();

    private int updateXactWrites = 1;

    private int readOnlyXactSize = 1;

    private int updateXactReads = 1;

    private boolean allowBlindWrites = false;

    private int readsBeforeFirstWrite = 1;



    public int getNumberOfAttributes() {
        return numberOfAttributes;
    }

    public void setNumberOfAttributes(int numberOfAttributes) {
        this.numberOfAttributes = numberOfAttributes;
    }

    public int getSizeOfAnAttribute() {
        return sizeOfAnAttribute;
    }

    public void setSizeOfAnAttribute(int sizeOfAnAttribute) {
        this.sizeOfAnAttribute = sizeOfAnAttribute;
    }

    public int getWritePercentage() {
        return writePercentage;
    }

    public void setWritePercentage(int writePercentage) {
        this.writePercentage = writePercentage;
    }

    public String getKeyGeneratorClass() {
        return keyGeneratorClass;
    }

    public void setKeyGeneratorClass(String keyGeneratorClass) {
        this.keyGeneratorClass = keyGeneratorClass;
    }

    public int getUpdateXactWrites() {
        return updateXactWrites;
    }

    public void setUpdateXactWrites(int updateXactWrites) {
        this.updateXactWrites = updateXactWrites;
    }

    public int getReadOnlyXactSize() {
        return readOnlyXactSize;
    }

    public void setReadOnlyXactSize(int readOnlyXactSize) {
        this.readOnlyXactSize = readOnlyXactSize;
    }

    public int getUpdateXactReads() {
        return updateXactReads;
    }

    public void setUpdateXactReads(int updateXactReads) {
        this.updateXactReads = updateXactReads;
    }

    public boolean isAllowBlindWrites() {
        return allowBlindWrites;
    }

    public void setAllowBlindWrites(boolean allowBlindWrites) {
        this.allowBlindWrites = allowBlindWrites;
    }

    public int getReadsBeforeFirstWrite() {
        return readsBeforeFirstWrite;
    }

    public void setReadsBeforeFirstWrite(int readsBeforeFirstWrite) {
        this.readsBeforeFirstWrite = readsBeforeFirstWrite;
    }



}
