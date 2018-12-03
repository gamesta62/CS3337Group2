package project.module2;

import java.util.Date;

public class Record {
    static int num = 0;
    int id;
    byte[] picture;
    int[] password;
    Date recordTime;
    
    public Record(int[] password, byte[] pic, Date time) {
        this.id = num++;
        this.picture = pic;
        this.password = password;
        this.recordTime = time;
    }
    
    public int getId() {
        return this.id;
    }
    
    public byte[] getPicture() {
        return this.picture;
    }
    
    public int[] getPassword() {
        return this.password;
    }

    public Date getRecordDate() {
        return this.recordTime;
    }
}
