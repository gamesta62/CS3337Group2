package project.module2;

import project.module2.API.keyPadAPI;

public class KeyPad implements keyPadAPI {

    DataCenter dataCenter;
    int psw;
    int[] pswTry;
    
    public KeyPad(DataCenter dataCenter){
        // initial password will be "123456"
        this(123456, dataCenter);
    }
    
    public KeyPad(int psw, DataCenter dataCenter){
        this.dataCenter = dataCenter;
        this.psw = psw;
        this.pswTry = new int[] {};
    }
    
    @Override
    public boolean isValid() {
        for (int psw : this.pswTry) {
            if (psw == this.psw)
                return true;
        }
        return false;
    }

    @Override
    public int attemptTimes() {
        return pswTry.length;
    }

    @Override
    public void enterPassword(int psw) {
        // TODO record the attempted password
        // Also, if enter more than 3 times, it will lock the keypad
        
        if (this.attemptTimes() < 3) {
            int[] newPswTry = new int[this.attemptTimes() + 1];
            for (int i = 0; i < this.attemptTimes(); i++)
                newPswTry[i] = this.pswTry[i];
            newPswTry[this.attemptTimes() + 1] = psw;
        } else {
            // ***************************************************
            // *  For further action such as locking the keyPad  *
            // ***************************************************
        }
        
        this.tryRecordData(this.dataCenter);
        
    }

    @Override
    public boolean tryRecordData(DataCenter dataCenter) {
        if(this.isValid() || (this.attemptTimes() == 3)) {
            // If the password is valid or more than 3 times in trying
            // we will record them, and empty the password-try array.
            dataCenter.newPassword(this.pswTry);
            this.pswTry = new int[] {};
            return true;
        }
        return false;
    }

}
