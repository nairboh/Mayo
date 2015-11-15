package myo;
import com.thalmic.myo.*;

public class hubLoop implements Runnable {
	public static Hub hub = new Hub("com.example.HelloMyo");
	Myo myo = hub.waitForMyo(1000);
	
	/**
     * Thread for looping
     */
    public void run() {
    	while (true) {
    		hub.run(1000 / 20);
    	}
    }
}
