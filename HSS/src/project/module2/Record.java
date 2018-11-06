package project.module2;

import java.io.InputStream;
import java.util.Date;

public class Record {
    static int num = 0;
    int id;
    InputStream picture;
    int[] password;
    Date recordTime;
    
    public Record(int[] password, InputStream pic, Date time) {
        this.id = num++;
        this.picture = pic;
        this.recordTime = time;
    }
    
    int getId() {
        return this.id;
    }
    
    InputStream getPicture() {
        return this.picture;
    }
    
    int[] getPassword() {
        return this.password;
    }

    Date getRecordDate() {
        return this.recordTime;
    }
    
}
