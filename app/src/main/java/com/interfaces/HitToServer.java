package com.interfaces;

/**
 * Created by Shahbaz on 4/12/2016.
 */
public interface HitToServer {
    String setParams();
    void onSuccess(String result);
    String onFailure();
}
