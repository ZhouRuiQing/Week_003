package com.bwie.week_003.mvp;

import android.util.Log;

import com.bwie.week_003.base.IBaseView;

import java.lang.ref.WeakReference;

public class AccountPresent implements AccounConter.Present{

    //引用
    private WeakReference<AccounConter.View> viewWeakReference;
    private WeakReference<AccountModel> modelWeakReference;
    private AccounConter.View view ;
    private AccounConter.Model model;


    @Override
    public void lodaData(String url) {

        model.loadData(url, new AccounConter.Model.NetCallBack() {
            @Override
            public void onSucces(String result) {
                view.showing(result);
                //hviewWeakReference.get().showing(result);
                Log.i("aaaa", "onSucces: "+result);
            }

            @Override
            public void onError(String msg) {
                String s = msg.toString();

            }
        });
    }


    @Override
    public void attch(AccounConter.View view) {
        this.view = view;
        viewWeakReference = new WeakReference(view);
        model = new AccountModel();
        modelWeakReference=new WeakReference(model);

    }

    @Override
    public void deattch() {

        if(viewWeakReference!=null){

            viewWeakReference.clear();
            viewWeakReference=null;

            modelWeakReference.clear();
            modelWeakReference=null;
        }

    }
}
