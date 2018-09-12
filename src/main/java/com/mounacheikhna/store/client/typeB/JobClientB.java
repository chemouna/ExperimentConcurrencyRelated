package com.mounacheikhna.store.client.typeB;

import com.mounacheikhna.store.lib.Client;
import com.mounacheikhna.store.lib.DownloadCallback;

import java.util.List;
import java.util.concurrent.Executors;

public class JobClientB {

    public void run() {
        //TypeBClientProvider clientProvider = TypeBClientProvider.get(Executors.newSingleThreadExecutor());
        Client<ItemB> client = new Client<>(Executors.newSingleThreadExecutor(), "B-Job", "b");

        client.getItems("test", new DownloadCallback<List<ItemB>>() {
            @Override
            public void onSuccess(List<ItemB> result) {
                System.out.println("JobClientB success");
            }

            @Override
            public void onFailure(String cause) {
                System.out.println("JobClientB failure");
            }
        });
    }
}
