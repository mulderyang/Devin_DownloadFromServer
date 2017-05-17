package betheracer.devin_downloadfromserver;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.AsyncTask;

import java.io.File;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URL;

/**
 * Created by jeny on 2017-05-17.
 */
public class DownloadTask extends AsyncTask<String, Void, Void> {

    private Context mContext;
    private String mUrl;
    private Uri mOutputUri;

    public DownloadTask(Context context, String urlStr) {

        mContext = context;
        mUrl = urlStr;
    }

    @Override
    protected Void doInBackground(String... params) {

        String phoneNo = params[0];
        mUrl = mUrl + phoneNo + ".png";
        mOutputUri = getOutputUri(phoneNo);

        Bitmap bitmap = getBitmapFromNetwork();

        writeBitmapToUri(mContext, bitmap, mOutputUri);

        return null;
    }



    private Uri getOutputUri(String phoneNo) {

        Uri uri = null;

        File file = mContext.getFilesDir();
        String fileStr = file.toString();
        fileStr = fileStr + File.separator + phoneNo + ".png";

        File file2 = new File(fileStr);
        uri = Uri.fromFile(file2);

        return uri;
    }



    private Bitmap getBitmapFromNetwork() {

        Bitmap bitmap = null;

        try {
            InputStream inputStream = (new URL(mUrl)).openStream();

            bitmap = BitmapFactory.decodeStream(inputStream);

        } catch (Exception e) {
            e.printStackTrace();
        }

        return bitmap;

    }



    private void writeBitmapToUri(Context context, Bitmap bitmap, Uri uri) {

        OutputStream outputStream = null;

        try {
            outputStream = context.getContentResolver().openOutputStream(uri);
            bitmap.compress(Bitmap.CompressFormat.PNG, 90, outputStream);

        } catch (Exception e) {
            e.printStackTrace();
        }

    }


}
