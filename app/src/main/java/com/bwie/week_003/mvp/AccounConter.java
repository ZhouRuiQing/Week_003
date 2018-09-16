package com.bwie.week_003.mvp;

import com.bwie.week_003.base.IBaseModel;
import com.bwie.week_003.base.IBasePresent;
import com.bwie.week_003.base.IBaseView;

/**
 *  MVP 契约类
 */
public interface AccounConter {

    interface View extends IBaseView{

        void showing(String data);
        void hideing();
        void Erroring();
    }
    interface Model extends IBaseModel{

        interface NetCallBack{
            void onSucces(String result);
            void onError(String msg);
        }

        void loadData(String  url,NetCallBack callBack);
    }

    interface Present extends IBasePresent<View>{

        void  lodaData(String url);
    }
}
