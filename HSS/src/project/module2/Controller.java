package project.module2;

import java.util.ArrayList;

import project.module2.API.controllerAPI;

public class Controller implements controllerAPI{

    MotionSensor motionSensor;
    Camera camera;
    KeyPad keyPad;
    boolean[] statusOfDevices;
    DataCenter dataCenter;
    Module2CheckingThread m2ct;
    
    public Controller() {
        this.activeDevices();
    }
    
    public ArrayList<Record> getAllRecords() {
        return dataCenter.getRecords();
    }
    
    public void motionTest() {
        // motion sensor will detect a movement.
        motionSensor.isDetected(true);
    }
    
    public void keyPadTest(int psw) {
        // motion sensor will detect a movement.
        keyPad.enterPassword(psw);
    }
    
    @Override
    public void activeDevices() {
        // setup all devices
        dataCenter = new DataCenter();
        camera = new Camera(dataCenter);
        motionSensor = new MotionSensor(camera);
        keyPad = new KeyPad(dataCenter);
        statusOfDevices = new boolean[3];
        m2ct = new Module2CheckingThread(dataCenter);
        
        try {
            // Let data record system working 24 hours
            new Thread(m2ct).start();
        } catch (Exception e) { }
    
    }

    @Override
    public boolean[] getStatusOfDevices() {
        boolean[] status = new boolean[this.statusOfDevices.length];

        // check KeyPad
        if (keyPad != null && keyPad instanceof KeyPad) 
            status[0] = true;
        
        // check Camera
        if (camera != null && camera instanceof Camera) 
            status[1] = true;
        
        // check Motion Sensor
        if (motionSensor != null && motionSensor instanceof MotionSensor) 
            status[2] = true;
        
        return status;
    }

    @Override
    public int getDetectedTimes() {
        return motionSensor.getDetectedTimes();
    }

    @Override
    public int getNumberOfRecords() {
        return dataCenter.getRecords().size();
    }
    
    @Override
    public Record getFirstRecord() {
        if (this.getNumberOfRecords() != 0)
            return dataCenter.getRecords().get(0);
        else
            return null;
    }

    @Override
    public Record getLastRecord() {
        if (this.getNumberOfRecords() != 0)
            return dataCenter.getRecords().get(this.getNumberOfRecords() - 1);
        else
            return null;
    }
    
}
