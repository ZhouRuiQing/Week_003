package com.bwie.week_003.mvp;

import android.util.Log;

import com.bwie.week_003.utils.OkhttpUtils;

import java.io.IOException;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class AccountModel implements AccounConter.Model {

    private OkhttpUtils okhttpUtils;
/*    public AccountModel() {
        okhttpUtils=new OkhttpUtils();
    }*/

public  AccountModel(){

    okhttpUtils=new OkhttpUtils();
}

    @Override
    public void loadData(String url, final NetCallBack callBack) {
        OkhttpUtils.getInstance().get(url, new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {
                String estring = e.getMessage();
                callBack.onError(estring);
            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {

                String estring = response.body().string().toString();
                Log.e("TAG",estring);
                callBack.onSucces(estring);

            }
        });
    }
}
