import com.thalmic.myo.*;

public class main {  
    public static void main(String[] args) {
      Hub hub = new Hub("com.example.HelloMyo");
      Myo myo = hub.waitForMyo(10000);
      hub.addListener(new AbstractDeviceListener() {
          @Override
          public void onPose(Myo myo, long timestamp, Pose pose) {
              System.out.println(String.format("Myo switched to pose %s.", pose.toString()));
          }
      });
      while (true) {
          hub.run(1000 / 20);
      }
    }
}