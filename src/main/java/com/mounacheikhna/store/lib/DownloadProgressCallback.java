package com.mounacheikhna.store.lib;

public interface DownloadProgressCallback<T> extends DownloadCallback<T>  {
    void onProgress(long progress);
}
