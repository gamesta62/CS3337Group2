package project.module2;

public class Module2CheckingThread implements Runnable {

    DataCenter dc;
    boolean status;
    
    public Module2CheckingThread(DataCenter dc) {
        this.dc = dc;
        this.status = true;
    }
    
    public void dataScheduler() {
        dc.tryRecordInfo();
    }
    
    public void stopAll() {
        this.status = false;
    }
    
    @Override
    public void run() {
        // work scheduler
        while (status) {
            this.dataScheduler();
            
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) { }
            
        }

    }

}
