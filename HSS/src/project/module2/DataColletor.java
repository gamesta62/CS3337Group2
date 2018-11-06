package project.module2;

import java.io.InputStream;
import java.util.Date;

import project.module2.API.dataAPI;

public class DataColletor implements dataAPI {
    
    InputStream pic;
    int[] psw;
    Date time;
    
    public DataColletor() {
        this.pic = null;
        this.psw = null;
        this.time = null;
    }

    @Override
    public boolean checkAllInfo() {
        // this method is used to check if we have collect a set of data
        // which are Picture & Password, once we have both data, we will 
        // call store() method, to store these information
        
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

    }

    @Override
    public boolean newPicture(InputStream pic) {
        // TODO Auto-generated method stub
        return false;
    }

    @Override
    public boolean newPassword(int[] psw) {
        // TODO Auto-generated method stub
        return false;
    }

}
