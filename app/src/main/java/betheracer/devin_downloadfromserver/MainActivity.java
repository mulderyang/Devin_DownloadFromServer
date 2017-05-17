package betheracer.devin_downloadfromserver;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    //public String phoneNo = "01031287657";
    public String phoneNo = "15555215554";  // phone number of emulator



    public String urlStr = "http://192.168.0.16/shop/android/images/";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);



        DownloadTask task = new DownloadTask(this, urlStr);
        task.execute(phoneNo);
    }

}
