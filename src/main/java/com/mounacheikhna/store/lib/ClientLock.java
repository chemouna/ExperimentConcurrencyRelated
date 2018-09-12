package com.mounacheikhna.store.lib;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class ClientLock {

    private static final Lock CLIENT_WRITE_LOCK = new ReentrantLock();

    Lock getLock() {
        return CLIENT_WRITE_LOCK;
    }

}
