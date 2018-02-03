package org.manu.rxjava2.ch1;

import io.reactivex.Observable;

public class Launcher {
    public static void main(String[] args) {
        Observable<String> strings = Observable.just("Alpha", "Beta", "Gamma");
        strings.map(String::length)
                .subscribe(System.out::println);
    }
}
