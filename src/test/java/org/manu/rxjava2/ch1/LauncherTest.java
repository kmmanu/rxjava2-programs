package org.manu.rxjava2.ch1;

import io.reactivex.Observable;
import org.junit.Test;

import java.util.concurrent.TimeUnit;

public class LauncherTest {
    @Test
    public void observable_from_just() {
        Observable<String> strings = Observable.just("Alpha", "Beta", "Gamma");
        strings.map(String::length)
                .subscribe(System.out::println);
    }

    @Test
    public void create_interval_observable() throws InterruptedException {
        Observable.interval(1, TimeUnit.SECONDS)
                .subscribe(System.out::println);

        /* Hold main thread for 5 seconds */
        Thread.sleep(5000);
    }
}