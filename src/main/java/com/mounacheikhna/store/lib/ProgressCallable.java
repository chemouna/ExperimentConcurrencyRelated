package com.mounacheikhna.store.lib;

interface ProgressCallable<T> {

    T call(Progress progress);

    interface Progress {
        void onProgress(long progress);
    }

}
