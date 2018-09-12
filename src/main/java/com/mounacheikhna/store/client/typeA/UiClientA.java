package com.mounacheikhna.store.client.typeA;

import com.mounacheikhna.store.lib.DownloadCallback;
import com.mounacheikhna.store.lib.DownloadProgressCallback;
import com.mounacheikhna.store.lib.Client;

import java.util.List;
import java.util.concurrent.Executors;

public class UiClientA {

    public void run() {
        //TypeAClientProvider clientProvider = TypeAClientProvider.get(Executors.newSingleThreadExecutor());
        Client<ItemA> client = new Client<>(Executors.newSingleThreadExecutor(), "A-UI", "a");

        // fetch a list of items
        client.getItems("items", new DownloadCallback<List<ItemA>>() {
            @Override
            public void onSuccess(List<ItemA> result) {
                System.out.println("Ui Success: "+ result);
            }

            @Override
            public void onFailure(String cause) {
                System.out.println("Ui Failure, cause: "+ cause);
            }
        });

        // fetch an item
        client.fetchItemAsyncWithProgress("items", new DownloadProgressCallback<ItemA>() {
            @Override
            public void onProgress(long progress) {

            }

            @Override
            public void onSuccess(ItemA result) {
                System.out.println("Success");
            }

            @Override
            public void onFailure(String cause) {
                System.out.println("Failure");
            }
        });


    }
}
