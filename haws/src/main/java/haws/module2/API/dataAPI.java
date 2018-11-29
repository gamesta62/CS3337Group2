package project.module2.API;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.Date;

import project.module2.Record;

public interface dataAPI {

    void store();
    
    boolean newPicture(InputStream pic, Date date);
    
    boolean newPassword(int[] psw);

    boolean tryRecordInfo();

    ArrayList<Record> getRecords();
    
}
