package genetics.stopConditions;

import genetics.stopConditions.AbstractStopCondition;

import java.sql.Timestamp;

public class ElapsedTimeStopCondition extends AbstractStopCondition {
    private long miliseconds, startTimestamp;
    public ElapsedTimeStopCondition(int value, TimeUnits unit){
        switch (unit){
            case SECONDS:
                miliseconds = value*1000;
                break;
            case MILISECONDS:
                miliseconds = value;
                break;
        }
    }

    public void startCountdown(){
        startTimestamp = System.nanoTime();
    }

    @Override
    public boolean shouldContinue(){
        return startTimestamp + miliseconds > System.nanoTime();
    }
}