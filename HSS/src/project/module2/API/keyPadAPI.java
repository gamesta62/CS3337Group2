package project.module2.API;

public interface keyPadAPI {
    
    boolean isValid();
    
    int attemptTimes();
    
    int[] getData();
    
    boolean sendData();
    
}
