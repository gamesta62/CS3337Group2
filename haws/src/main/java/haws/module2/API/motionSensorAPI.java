package project.module2.API;

public interface motionSensorAPI {
    boolean isDetected(boolean detected);
    void callCamera();
    int getDetectedTimes();
}
