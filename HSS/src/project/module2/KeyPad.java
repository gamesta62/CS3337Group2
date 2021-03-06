package project.module2;

import project.module2.API.keyPadAPI;
import project.User;
import project.Notifier;

public class KeyPad implements keyPadAPI {

    DataCenter dataCenter;
    int psw;
    int[] pswTry;
    int numOfPasw;
    boolean isValid;
    boolean lock;
    
    public KeyPad(DataCenter dataCenter){
        // initial password will be "123456"
        this(123456, dataCenter);
    }
    
    public KeyPad(int psw, DataCenter dataCenter){
        this.dataCenter = dataCenter;
        this.psw = psw;
        this.pswTry = new int[] {};
        this.numOfPasw = 0;
    }
    
    public void reset() {
        this.numOfPasw = 0;
        this.lock = false;
        this.isValid = false;
    }
    
    @Override
    public boolean isValid() {
        if (this.isValid == true)
            return true;
        
        for (int i = 0; i < pswTry.length; i++) {
            if (pswTry[i] == psw) {
                this.isValid = true;
                return true;
            }
        }
        return false;
    }

    @Override
    public int attemptTimes() {
        return numOfPasw;
    }

    @Override
    public void enterPassword(int psw) {
        // TODO record the attempted password
        // Also, if enter more than 3 times, it will lock the keypad
        
        if (this.attemptTimes() < 3) {
            int[] newPswTry = new int[this.attemptTimes() + 1];
            for (int i = 0; i < this.attemptTimes(); i++)
                newPswTry[i] = this.pswTry[i];
            newPswTry[this.attemptTimes()] = psw;
            this.pswTry = newPswTry;
        } else {
            // ***************************************************
            // *  For further action such as locking the keyPad  *
            // ***************************************************
            this.lock = true;
            Notifier notifier = new Notifier();
            User owner = new User(0,"Kamron","19492904003","kzadeh1@gmail.com");
    		owner.setNotifyByEmail(true);
    		owner.setNotifyByText(true);
            notifier.notify(owner, "Failed door unlock attempt detected from module 2");
        }
        numOfPasw++;
        
        this.tryRecordData(this.dataCenter);
        
    }

    @Override
    public boolean tryRecordData(DataCenter dataCenter) {
        if(this.isValid()) {
            // If the password is valid or more than 3 times in trying
            // we will record them, and empty the password-try array.
            dataCenter.newPassword(this.pswTry);
            this.pswTry = new int[] {};
            this.isValid = true;
            return true;
        } else if ((this.attemptTimes() == 3)) {
        	dataCenter.newPassword(this.pswTry);
        	this.pswTry = new int[] {};
            this.isValid = false;
            this.lock = true;
        }
        return false;
    }

}
