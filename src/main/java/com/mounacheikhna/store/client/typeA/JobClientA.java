package com.mounacheikhna.store.client.typeA;

import com.mounacheikhna.store.lib.Client;
import com.mounacheikhna.store.lib.ClientLock;
import com.mounacheikhna.store.lib.DownloadCallback;

import java.util.List;
import java.util.concurrent.Executors;

public class JobClientA {

    public void run() {
        //TypeAClientProvider clientProvider = TypeAClientProvider.get(Executors.newSingleThreadExecutor());
        Client<ItemA> client = new Client<>(Executors.newSingleThreadExecutor(), "A-Job", "a");

        client.getItems("test", new DownloadCallback<List<ItemA>>() {
            @Override
            public void onSuccess(List<ItemA> result) {
                System.out.println("JobClientA success");
            }

            @Override
            public void onFailure(String cause) {
                System.out.println("JobClientA failure");
            }
        });
    }

}
