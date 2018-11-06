package project.module2;

import java.io.InputStream;
import java.util.Date;

import project.module2.API.cameraAPI;

public class Camera implements cameraAPI {
    
    

    @Override
    public void access(InputStream data) {
        // TODO Auto-generated method stub

    }

    @Override
    public void takePicture() {
        // TODO Auto-generated method stub

    }

    @Override
    public boolean sendData() {
        // TODO Auto-generated method stub
        return false;
    }

    @Override
    public InputStream getData() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public void called(Date time) {
        // TODO Auto-generated method stub
        
    }

    @Override
    public Date getCalledDate() {
        // TODO Auto-generated method stub
        return null;
    }

}
