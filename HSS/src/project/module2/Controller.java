package project.module2;

import java.util.ArrayList;
import java.util.Date;

import project.module2.API.controllerAPI;

public class Controller implements controllerAPI{

    MotionSensor motionSensor;
    Camera camera;
    KeyPad keyPad;
    boolean[] statusOfDevices;
    DataCenter dataCenter;
    Module2CheckingThread m2ct;
    boolean actived;
    boolean motionTested;
    int paswd;
    boolean paswded;
    ArrayList<Record> searchRecords;
    boolean searched;
    
    public Controller() {
        //this.activeDevices();
        statusOfDevices = new boolean[3];
        actived = false;
        searched =false;
        this.paswd = -2;
    }
    
	public void searchRecords(int fromMonth, int fromDate, int toMonth, int toDate) {
		int f1 = fromMonth - 1;
		int f2 = fromDate;
		int t1 = toMonth - 1;
		int t2 = toDate;
		
		ArrayList<Record> allRecords = this.getRecords();
		ArrayList<Record> newRecords = new ArrayList<Record> ();
		
		for (Record a : allRecords) {
			Date day = a.getRecordDate();
			if ((day.getMonth() >= f1 && day.getDate() >= f2) && (day.getMonth() <= t1 && day.getDate() <= t2))
				newRecords.add(a);
		}
		this.searchRecords = newRecords;
        this.searched = true;
    }
	
	public boolean getSearched() {
		return this.searched;
	}
	
	public ArrayList<Record> getSearchRecords() {
		ArrayList<Record> records = this.searchRecords;
		this.searchRecords = new ArrayList<Record>();
		this.searched = false;
        return records;
    }
	
    public ArrayList<Record> getRecords() {
        return dataCenter.getRecords();
    }
    
    public boolean getMotionTested() {
        return this.motionTested;
    }
    
    public boolean getPaswded() {
        return this.paswded;
    }
    
    public boolean getKeyPadLocked() {
        return this.keyPad.lock;
    }
    
    public void motionTest() {
        // motion sensor will detect a movement.
        motionSensor.isDetected(true);
        motionTested = true;
        this.paswded = false;
        this.keyPad.reset();
    }
    
    public int getPassword() {
        return this.paswd;
    }
    
    public void keyPadTest(int psw) {
        // motion sensor will detect a movement.
        keyPad.enterPassword(psw);
        this.paswded = true;
        this.motionTested = false;
    }
    
    public boolean getPaswValid() {
    	return this.keyPad.isValid();
    }
    
    public int getEnterTimes() {
        return this.keyPad.attemptTimes();
    }
    
    public int[] getKeys() {
        int[] a = new int[12];
        for (int i = 0; i < 9; i++) {
            a[i] = i+1;
        }
        a[9] = -1;
        a[10] = 0;
        a[11] = 99;
        return a;
    }
    
    public byte[] getPicture(int id) {
        
        if (id < this.getNumberOfRecords()) 
            return this.getRecords().get(id).getPicture();
        else
            return null;
    }
    
    public boolean getActived() {
        if (actived == false)
            return false;
        else
            return true;
    }
    
    public void setPassword(int p) {
        if (this.paswd == -2)
            this.paswd = 0;
        
        if (p == -1) {
            this.paswd = this.paswd / 10;
            if (this.paswd == 0)
                this.paswd = -2;
            return;
        } else if (p == -3) {
            this.paswd = -2;
            return;
        }
        
        int n = this.paswd*10 + p;
        this.paswd = n;
    }
    
    @Override
    public void activeDevices() {
        if (actived == true)
            return;
        
        // setup all devices
        dataCenter = new DataCenter();
        camera = new Camera(dataCenter);
        motionSensor = new MotionSensor(camera);
        keyPad = new KeyPad(dataCenter);
        // statusOfDevices = new boolean[3];
        m2ct = new Module2CheckingThread(dataCenter);
        actived = true;
        try {
            // Let data record system working 24 hours
            new Thread(m2ct).start();
        } catch (Exception e) { }
    
    }

    @Override
    public boolean[] getStatusOfDevices() {
        boolean[] status = new boolean[this.statusOfDevices.length];

        // check KeyPad
        if (keyPad != null && keyPad instanceof KeyPad) 
            status[0] = true;
        
        // check Camera
        if (camera != null && camera instanceof Camera) 
            status[1] = true;
        
        // check Motion Sensor
        if (motionSensor != null && motionSensor instanceof MotionSensor) 
            status[2] = true;
        
        return status;
            
    }

    @Override
    public int getDetectedTimes() {
    	if (motionSensor == null)
    		return 0;
        return motionSensor.getDetectedTimes();
    }

    @Override
    public int getNumberOfRecords() {
    	if (this.dataCenter == null)
    		return 0;
        return this.dataCenter.getRecords().size();
    }
    
    @Override
    public Record getFirstRecord() {
        if (this.getNumberOfRecords() != 0)
            return dataCenter.getRecords().get(0);
        else
            return null;
    }

    @Override
    public Record getLastRecord() {
        if (this.getNumberOfRecords() != 0)
            return dataCenter.getRecords().get(this.getNumberOfRecords() - 1);
        else
            return null;
    }
    
}
