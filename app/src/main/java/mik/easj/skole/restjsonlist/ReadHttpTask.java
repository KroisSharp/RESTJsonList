package mik.easj.skole.restjsonlist;


import android.os.AsyncTask;

import java.io.IOException;

public class ReadHttpTask extends AsyncTask<String, Void, CharSequence> {
    @Override
    protected CharSequence doInBackground(String... urls) {
        String urlString = urls[0];
        try{
            CharSequence res = HttpHelper.GetHttpResponse(urlString);
            return res;
        }catch (IOException ex){
            cancel(true);
            String errormsg = ex.getMessage();
            return errormsg;
        }
    }
}
