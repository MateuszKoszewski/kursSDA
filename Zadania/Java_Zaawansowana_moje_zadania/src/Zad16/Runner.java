package Zad16;

import java.util.Optional;

public enum Runner {
    BEGINNER(110, Integer.MAX_VALUE),
    INTERMEDIATE(Runner.LIMIT_1,Runner.LIMIT_2),
    ADVANCED(1,Runner.LIMIT_1);

    private int minTime;
    private int maxTime;
    private static final int LIMIT_1 = 70;
    private final static int LIMIT_2 = 110;

    Runner (int minTime, int maxTime){
        this.minTime = minTime;
        this.maxTime = maxTime;
    }

    static Runner getFitnessLevel (int time){
        if (time <= Runner.ADVANCED.maxTime && time > Runner.ADVANCED.minTime) {
            return Runner.ADVANCED;
        }
        if (time <= Runner.INTERMEDIATE.maxTime && time > Runner.INTERMEDIATE.minTime) {
            return Runner.INTERMEDIATE;
        }
        if (time <= Runner.BEGINNER.maxTime && time > Runner.BEGINNER.minTime) {
            return Runner.BEGINNER;
        }
        throw new IllegalArgumentException("wrong time");
    }
}
