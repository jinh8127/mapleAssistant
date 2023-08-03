package com.jin.mapleAssistant.mapleSimulator.model;

import java.math.BigInteger;


public class StarForceSimulationRequest extends SimulationRequest {

    private int targetStarForceLevel;

    private BigInteger itemPriceInMeso;

    private MvpType mvpType;

    private boolean isShiningEvent;

    private boolean isSundayDiscountEvent;

    private boolean isPcBangDiscounted;

    private boolean isStarCatchOn;

    private boolean preventDestructionAt15;

    private boolean preventDestructionAt16;

    public StarForceSimulationRequest(int numberOfTries, int itemLevel, int targetStarForceLevel, BigInteger itemPriceInMeso,
                                      MvpType mvpType, boolean isShiningEvent, boolean isSundayDiscountEvent, boolean isPcBangDiscounted,
                                      boolean isStarCatchOn, boolean preventDestructionAt15, boolean preventDestructionAt16) {
        super(numberOfTries, itemLevel);
        this.targetStarForceLevel = targetStarForceLevel;
        this.itemPriceInMeso = itemPriceInMeso;
        this.mvpType = mvpType;
        this.isShiningEvent = isShiningEvent;
        this.isSundayDiscountEvent = isSundayDiscountEvent;
        this.isPcBangDiscounted = isPcBangDiscounted;
        this.isStarCatchOn = isStarCatchOn;
        this.preventDestructionAt15 = preventDestructionAt15;
        this.preventDestructionAt16 = preventDestructionAt16;
    }

    public StarForceSimulationRequest(int numberOfTries, int itemLevel) {
        super(numberOfTries, itemLevel);
    }

    public int getTargetStarForceLevel() {
        return targetStarForceLevel;
    }

    public void setTargetStarForceLevel(int targetStarForceLevel) {
        this.targetStarForceLevel = targetStarForceLevel;
    }

    public BigInteger getItemPriceInMeso() {
        return itemPriceInMeso;
    }

    public void setItemPriceInMeso(BigInteger itemPriceInMeso) {
        this.itemPriceInMeso = itemPriceInMeso;
    }

    public MvpType getMvpType() {
        return mvpType;
    }

    public void setMvpType(MvpType mvpType) {
        this.mvpType = mvpType;
    }

    public boolean isShiningEvent() {
        return isShiningEvent;
    }

    public void setShiningEvent(boolean shiningEvent) {
        isShiningEvent = shiningEvent;
    }

    public boolean isSundayDiscountEvent() {
        return isSundayDiscountEvent;
    }

    public void setSundayDiscountEvent(boolean sundayDiscountEvent) {
        isSundayDiscountEvent = sundayDiscountEvent;
    }

    public boolean isPcBangDiscounted() {
        return isPcBangDiscounted;
    }

    public void setPcBangDiscounted(boolean pcBangDiscounted) {
        isPcBangDiscounted = pcBangDiscounted;
    }

    public boolean isStarCatchOn() {
        return isStarCatchOn;
    }

    public void setStarCatchOn(boolean starCatchOn) {
        isStarCatchOn = starCatchOn;
    }

    public boolean isPreventDestructionAt15() {
        return preventDestructionAt15;
    }

    public void setPreventDestructionAt15(boolean preventDestructionAt15) {
        this.preventDestructionAt15 = preventDestructionAt15;
    }

    public boolean isPreventDestructionAt16() {
        return preventDestructionAt16;
    }

    public void setPreventDestructionAt16(boolean preventDestructionAt16) {
        this.preventDestructionAt16 = preventDestructionAt16;
    }


}
