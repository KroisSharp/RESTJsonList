package mik.easj.skole.restjsonlist;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;

public class HttpHelper {


    public static CharSequence GetHttpResponse(String urlStrings) throws IOException {
        URL url = new URL(urlStrings);
        URLConnection connection = url.openConnection();
        if (!(connection instanceof HttpURLConnection)) {
            throw new IOException("not an http connection");
        }
        HttpURLConnection httpURLConnection = (HttpURLConnection) connection;
        int responsecode = httpURLConnection.getResponseCode();
        if (responsecode != httpURLConnection.HTTP_OK) {
            String Responsemsg = httpURLConnection.getResponseMessage();
            throw new IOException("http response code: " + Responsemsg);
        }
        InputStream inputStream = httpURLConnection.getInputStream();
        BufferedReader reader = null;
        try{
            reader = new BufferedReader(new InputStreamReader(inputStream));
            int contentlenght = httpURLConnection.getContentLength();
            StringBuilder result = (contentlenght > 0) ? new StringBuilder(contentlenght) : new StringBuilder();
            while (true)
            {
                String line = reader.readLine();
                if (line == null) break;
                result.append(line);
            }
            return result;
        }finally {
            if (reader !=null) reader.close();
        }
    }
}
