package betheracer.devin_downloadfromserver;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    public String phoneNo1 = "01031287657";
    public String phoneNo2 = "15555215554";  // phone number of emulator



    public String urlStr = "http://192.168.0.16/shop/android/images/";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        new DownloadTask(this, urlStr).execute(phoneNo1);
        new DownloadTask(this, urlStr).execute(phoneNo2);

    }

}
