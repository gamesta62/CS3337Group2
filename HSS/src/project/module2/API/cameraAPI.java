package project.module2.API;

import java.util.Date;

import project.module2.DataCenter;

public interface cameraAPI {
    
    void call(Date time);
    
    void takePicture();
    
    boolean tryRecordData(DataCenter dataCenter);
    
}
