package com.interfaces;

import android.os.AsyncTask;

import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;

/**
 * Created by Shahbaz on 4/12/2016.
 */

class getRequestAsync extends AsyncTask<URL, Integer, String> {

    HitToServer requestObj;

    String url = "";

    getRequestAsync(HitToServer requestObj){
        this.requestObj = requestObj;
    }

    private String readStream(InputStream is) {
        try {
            ByteArrayOutputStream bo = new ByteArrayOutputStream();
            int i = is.read();
            while(i != -1) {
                bo.write(i);
                i = is.read();
            }
            return bo.toString();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    protected String doInBackground(URL... urls) {
        InputStream in = null;
        URL url;
        HttpURLConnection urlConnection = null;
        try {
            this.url = requestObj.setParams();

            url = new URL(this.url);
            urlConnection = (HttpURLConnection) url.openConnection();
            in = urlConnection.getInputStream();

        }catch (Exception ex){
            ex.printStackTrace();
        }
        return readStream(in);
    }

    protected void onPostExecute(String result) {
        if(result != null && !result.equals("")) {
            requestObj.onSuccess(result);
        }else{
            requestObj.onFailure();
        }
    }
}

