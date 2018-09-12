package com.mounacheikhna.store.client;

import com.mounacheikhna.store.client.typeA.JobClientA;
import com.mounacheikhna.store.client.typeA.UiClientA;
import com.mounacheikhna.store.client.typeB.JobClientB;
import com.mounacheikhna.store.client.typeB.UiClientB;

public class Main {

    public static void main(String[] args) {
        System.out.println("A :");
        new UiClientA().run();
        new JobClientA().run();

        try {
            Thread.sleep(5000L);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("----------");

        System.out.println("B :");
        new UiClientB().run();
        new JobClientB().run();
    }

}
