package project.module2.API;

import project.module2.DataCenter;

public interface keyPadAPI {
    
    boolean isValid();
    
    int attemptTimes();
    
    void enterPassword(int psw);

    boolean tryRecordData(DataCenter dataCenter);
    
}
