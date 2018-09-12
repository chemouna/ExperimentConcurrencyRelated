package com.mounacheikhna.store.lib;

public interface DownloadCallback<T> {

    void onSuccess(T result);
    void onFailure(String cause);

}
