package com.bwie.week_003.utils;

import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;

public class OkhttpUtils {

    public OkHttpClient client;

    private static  OkhttpUtils okhttpUtils = new OkhttpUtils();

    public static OkhttpUtils getInstance() {

        if(okhttpUtils==null){

            synchronized (OkhttpUtils.class){

                if(okhttpUtils==null){

                    okhttpUtils=new OkhttpUtils();
                }
            }
        }

        return okhttpUtils;
    }

    public OkhttpUtils() {

        if(client==null){
            synchronized (OkHttpClient.class){

                if(client==null){
                    client=new OkHttpClient.Builder().build();
                }
            }
        }

    }

    public  void  get (String url, Callback callback){

        Request build = new Request.Builder().url(url).build();
        client.newCall(build).enqueue(callback);
    }


}
