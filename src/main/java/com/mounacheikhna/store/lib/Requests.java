package com.mounacheikhna.store.lib;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;

class Requests<T> {

    Callable<List<T>> fetchItems(String storeId, String limit) {
        return () -> {
            Thread.sleep(1000);
            return new ArrayList<>();
        };
    }

    ProgressCallable<T> fetchItemWithProgress(String itemId) {
        return callableProgress -> {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
            }
            return null;
        };
    }

}
