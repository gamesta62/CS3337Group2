package project.module2;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.Date;

import project.module2.API.dataAPI;

public class DataCenter implements dataAPI {
    
    ArrayList<Record> records;
    
    InputStream pic;
    int[] psw;
    Date time;
    
    public DataCenter() {
        this.pic = null;
        this.psw = null;
        this.time = null;
    }
    
    @Override
    public ArrayList<Record> getRecords(){
        return this.records;
    }

    @Override
    public boolean tryRecordInfo() {
        // This method is used to check if we have collect a set of data
        // which are Picture & Password, once we have both data, we will 
        // call store() method, to store these information
        
        // avoid having last event password still stored
        if (this.psw != null && this.time == null) 
            this.psw = null;
        
        Long timeDelay;
        
        if (this.time != null && this.psw == null) {
            timeDelay = ((new Date()).getTime() - this.time.getTime())/1000;
            
            // Here to test the time difference after detected a movement
            // if it is more than five mins and still not having keyPad password
            // we will consider this person did not use keypad
            // but will still record it.
            
            if (timeDelay > 5*60) {
                this.psw = new int[] {};
            }
        }
        
        if (this.pic != null && this.psw != null) {
            this.store();
            return true;
        } else
            return false;
    }

    @Override
    public void store() {
        // this method is used to make a record first, and then store all 
        // information we have, then empty the Picture & Password set.
        
        Record newRecord = new Record(this.psw, this.pic, this.time);
        this.records.add(newRecord);
        
        this.psw = null;
        this.pic = null;
        this.time = null;

    }

    @Override
    public boolean newPicture(InputStream pic, Date date) {
        if (pic != null) {
            this.pic = pic;
            this.time = date;
            return true;
        } else
            return false;
    }

    @Override
    public boolean newPassword(int[] psw) {
        if (psw != null) {
            this.psw = psw;
            return true;
        } else
            return false;
    }

}
