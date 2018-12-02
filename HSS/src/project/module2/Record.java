package project.module2;

import java.util.Date;

public class Record {
    static int num = 0;
    int id;
    byte[] picture;
    int[] password;
    Date recordTime;
    
    public Record(int[] password, byte[] pic, Date time) {
        this.id = ++num;
        this.picture = pic;
        this.password = password;
        this.recordTime = time;
    }
    
    int getId() {
        return this.id;
    }
    
    byte[] getPicture() {
        return this.picture;
    }
    
    int[] getPassword() {
        return this.password;
    }

    Date getRecordDate() {
        return this.recordTime;
    }
    
}
