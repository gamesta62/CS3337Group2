package project.module2;

import java.io.InputStream;
import java.util.Date;

import project.module2.API.cameraAPI;

public class Camera implements cameraAPI {
    
    DataCenter dataCenter;
    Date calledDate;
    InputStream pic;
    
    public Camera(DataCenter dataCenter) {
        this.dataCenter = dataCenter;
        this.calledDate = null;
        this.pic = null;
    }

    public void access(InputStream data) {
        this.pic = data;
    }

    @Override
    public void takePicture() {
        // not yet
    }

    @Override
    public void call(Date time) {
        this.calledDate = time;
        this.takePicture();
        this.tryRecordData(this.dataCenter);
    }

    @Override
    public boolean tryRecordData(DataCenter dataCenter) {

        if (this.pic != null) {
            dataCenter.newPicture(this.pic, this.calledDate);
            this.pic = null;
            this.calledDate = null;
            return true;
        }
        
        return false;
    }

}
