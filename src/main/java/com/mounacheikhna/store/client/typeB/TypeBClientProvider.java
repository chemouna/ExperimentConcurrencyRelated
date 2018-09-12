package com.mounacheikhna.store.client.typeB;

import com.mounacheikhna.store.lib.Client;
import com.mounacheikhna.store.lib.ClientLock;

import java.util.concurrent.Executor;

public class TypeBClientProvider {

    private static volatile TypeBClientProvider instance;
    private Client<ItemB> client;

    public static TypeBClientProvider get(Executor executor) {
        if (instance == null) {
            Client<ItemB> client = new Client<>(executor, "B", "b");
            instance = new TypeBClientProvider(client);
        }

        return instance;
    }

    public TypeBClientProvider(Client<ItemB> client) {
        this.client = client;
    }

    public Client<ItemB> getClient() {
        return client;
    }

}
