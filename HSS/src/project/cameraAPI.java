package project;

import java.io.InputStream;

public interface cameraAPI {

    void access(InputStream data);
    
    void takePicture();
    
    boolean hasData();
    
    InputStream getData();
    
}
