import com.thalmic.myo.*;

public class hubLoop implements Runnable {
	public static Hub hub = new Hub("com.example.HelloMyo");
	
	/**
     * Thread for looping
     */
    @Override
    public void run() {
    	while (true) {
    		hub.run(1000 / 20);
    	}
    }
}
