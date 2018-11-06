package project.module2.API;

import java.io.InputStream;
import java.util.Date;

public interface cameraAPI {
    
    void called(Date time);
    
    Date getCalledDate();

    void access(InputStream data);
    
    void takePicture();
    
    boolean sendData();
    
    InputStream getData();
    
}
