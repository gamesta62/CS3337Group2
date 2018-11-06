package project.module2.API;

import java.io.InputStream;
import java.util.Date;

public interface dataAPI {

    boolean checkAllInfo();
    
    void store();
    
    boolean newPicture(InputStream pic, Date date);
    
    boolean newPassword(int[] psw);
    
}
