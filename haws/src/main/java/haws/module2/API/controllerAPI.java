package project.module2.API;

import project.module2.Record;

public interface controllerAPI{

    public void activeDevices();
    
    public boolean[] getStatusOfDevices();
    
    public int getDetectedTimes();
    
    public int getNumberOfRecords();
    
    public Record getLastRecord();
    
    public Record getFirstRecord();
    
}
