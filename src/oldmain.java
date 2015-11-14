

public class oldmain {  
	public static Vector3 position = new Vector3 ();
	public static Vector3 velocity = new Vector3 ();
    public static void main(String[] args) {
    	poseTest();
    }
    
  
	public static void poseTest () {
		
		
		Hub hub = new Hub("com.example.HelloMyo");
	    Myo myo = hub.waitForMyo(10000);
	    hub.addListener(new AbstractDeviceListener() {
	        @Override
	        public void onAccelerometerData(Myo myo, long timestamp, Vector3 vector) {
	        	velocity = vectorAdd (velocity, vectorClearNoise(vector));
	            position = vectorAdd (velocity,position);
	            System.out.println(vector);
	        }
	    });
	    while (true) {
	        hub.run(1000 / 20);
	    }
	}

	public static Vector3 vectorClearNoise (Vector3 v) {
		return new Vector3 (v.getX() >= 1 ? v.getX() : 0, v.getY() >= 1 ? v.getY() : 0, v.getZ() >= 1 ? v.getZ() : 0);
	}
	
	public static Vector3 vectorAdd (Vector3 v1, Vector3 v2) {
		return new Vector3 (v1.getX() + v2.getX(), v1.getY() + v2.getY(),v1.getZ() + v2.getZ());
	}
}