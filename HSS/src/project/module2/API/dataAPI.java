package project.module2.API;

import java.io.InputStream;

public interface dataAPI {

    boolean checkAllInfo();
    
    void store();
    
    boolean newPicture(InputStream pic);
    
    boolean newPassword(int[] psw);
    
}
