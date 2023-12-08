package com.rohit.splitwiseclone.services.Strategy;

public class SettleUpStrategyFactory {
    public static SettleUpStrategy getSettleUpStrategy(SettleUpStrategies strategyName) {
        return new HeapBasedSettleUpStrategy();
    }
}
