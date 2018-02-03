package org.manu.rxjava2.ch1;

import io.reactivex.Observable;

import java.util.concurrent.TimeUnit;

public class Interval {
    public static void main(String[] args) throws InterruptedException {
        Observable.interval(1, TimeUnit.SECONDS)
                .subscribe(System.out::println);

        /* Hold main thread for 5 seconds */
        Thread.sleep(5000);
    }
}
