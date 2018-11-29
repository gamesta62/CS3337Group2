package project.module2;

import java.util.Date;

import project.module2.API.motionSensorAPI;

public class MotionSensor implements motionSensorAPI {
    
    Camera camera;
    int time;
    
    public MotionSensor(Camera camera) {
        // in order to construct motion sensor, the application have to
        // have a camera first
        
        this.camera = camera;
        this.time = 0;
    }

    @Override
    public void callCamera() {
        this.camera.call(new Date());
    }

    @Override
    public int getDetectedTimes() {
        return this.time;
    }

    @Override
    public boolean isDetected(boolean detected) {
        
        // if this methods was called it will check if the motion sensor detect a motion
        // if yes, it will call camera to take a photo
        
        if (detected == true) {
            this.callCamera();
            this.time++;
            return true;
        } else 
            return false;
    }

}
