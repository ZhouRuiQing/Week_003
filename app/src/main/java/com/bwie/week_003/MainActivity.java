package com.bwie.week_003;

import android.Manifest;
import android.os.Build;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;

import com.bwie.week_003.apdater.Myapdater;
import com.bwie.week_003.base.IBaseView;
import com.bwie.week_003.bean.UIbean;
import com.bwie.week_003.mvp.AccounConter;
import com.bwie.week_003.mvp.AccountPresent;
import com.google.gson.Gson;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements AccounConter.View{

    private RecyclerView recylerView;
    private AccountPresent present;
    private List<UIbean.Pois> list = new ArrayList<>();
    private Myapdater apdater;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recylerView = findViewById(R.id.recylerView);

        recylerView.setLayoutManager(new LinearLayoutManager(this));
        apdater = new Myapdater(list,this);
        recylerView.setAdapter(apdater);
        recylerView.addItemDecoration(new DividerItemDecoration(this,DividerItemDecoration.VERTICAL));


        present=new AccountPresent();
        present.attch(this);
        present.lodaData("https://restapi.amap.com/v3/place/around?key=d78f39012867929dc6ad174dd498f51f&location=116.473168,39.993015&keywords=%E7%BE%8E%E9%A3%9F&types=&radius=1000&offset=20&page=1&extensions=all");
    }

    @Override
    public void showing(String data) {

        Log.i("aaa",data+"ssss");
        Gson gson = new Gson();
        final UIbean ibean = gson.fromJson(data, UIbean.class);

       runOnUiThread(new Runnable() {
           @Override
           public void run() {
               list.addAll(ibean.getPois());

               apdater.notifyDataSetChanged();
           }
       });
    }

    @Override
    public void hideing() {

    }

    @Override
    public void Erroring() {

    }

}
