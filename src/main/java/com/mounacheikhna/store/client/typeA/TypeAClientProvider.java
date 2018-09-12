package com.mounacheikhna.store.client.typeA;

import com.mounacheikhna.store.lib.Client;
import com.mounacheikhna.store.lib.ClientLock;

import java.util.concurrent.Executor;

public class TypeAClientProvider {

    private static volatile TypeAClientProvider instance;
    private Client<ItemA> client;

    public static TypeAClientProvider get(Executor executor) {
        if (instance == null) {
            Client<ItemA> client = new Client<ItemA>(executor, "A", "a");
            instance = new TypeAClientProvider(client);
        }

        return instance;
    }

    public TypeAClientProvider(Client<ItemA> client) {
        this.client = client;
    }

    public Client<ItemA> getClient() {
        return client;
    }
}
