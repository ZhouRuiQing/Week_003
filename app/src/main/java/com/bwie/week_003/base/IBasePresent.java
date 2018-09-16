package com.bwie.week_003.base;

import java.lang.ref.WeakReference;

public  interface   IBasePresent<V extends IBaseView> {

    /*
    *
    * 和View层进行绑定
    * */

      void  attch(V v);
    /**
     * @param v 和View层解绑
     */
     void deattch();

    /**
     * @return 从弱引用中拿出对象
     */
    /*private V getView(){
        return view.get();
    }


    *//**
     * @return 判断是否为空
     *//*
    private boolean isViewattch(){
        return view!=null&&view.get()!=null;
    }*/


}
