package com.mounacheikhna.store.lib;

import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.Executor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Client<T> {

    private static long CLIENT_WRITE_LOCK_WAIT_MINUTES = 5;

    private Requests<T> requests;
    private Executor executor;
    private Locks<T> clientLock;
    private String type;

    private static final ConcurrentMap<String, Lock> clientLocks = new ConcurrentHashMap<>();
    private String lockKey;

    public Client(Executor executor, String type, String lockKey) {
        System.out.println("instance of Client created for " + type);
        this.requests = new Requests<T>();
        this.executor = executor;
        this.lockKey = lockKey;
        this.type = type;
        clientLocks.putIfAbsent(lockKey, new ReentrantLock());
    }

    public void getItems(String storeId, DownloadCallback<List<T>> callback) {
        executor.execute(() -> {
            try {
                Lock lock = clientLocks.get(lockKey);
                System.out.println("Trying to acquire lock " + lock.toString() + " for " + type);
                if (lock.tryLock(CLIENT_WRITE_LOCK_WAIT_MINUTES, TimeUnit.MINUTES)) {
                    System.out.println("acquired lock for client " + type);
                    List<T> items = fetch(storeId, "100");
                    callback.onSuccess(items);
                } else {
                    System.out.println("failure to get lock for client " + type);
                    callback.onFailure("Waiting time elapsed before being able to get the lock");
                }
            } catch (InterruptedException ex) {
                System.out.println("InterruptedException when trying to get lock for " + type);
            } catch (Exception e) {
                callback.onFailure("Generic exception");
            }
        });
    }

    private List<T> fetch(String storeId, String limit) throws Exception {
        return requests.fetchItems(storeId, limit).call();
    }

    public void fetchItemAsyncWithProgress(String itemId, DownloadProgressCallback<T> callback) {
        executor.execute(() -> requests.fetchItemWithProgress(itemId).call(callback::onProgress));
    }

    public static class Locks<T> {
        private static Lock lock = new ReentrantLock();

        public static Lock getLock() {
            return lock;
        }
    }

}
