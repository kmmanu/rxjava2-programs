package org.manu.rxjava2.ch2;

import io.reactivex.Observable;
import org.junit.Test;

public class Just {
    @Test
    public void just_to_pass_upto_10_items() {
        Observable<String> source =
                Observable.just("Alpha", "Beta", "Gamma", "Delta", "Epsilon");

        source.map(String::toUpperCase)
                .subscribe(s -> System.out.println("RECEIVED: " + s),
                        Throwable::printStackTrace,
                        () -> System.out.println("....Finished....")); 
    }

    @Test
    public void create_without_onComplete() {
        Observable<String> source = Observable.create(emitter -> {
            emitter.onNext("Hello");
            emitter.onNext("Hi");
            emitter.onNext("How");
            emitter.onNext("Are");
            emitter.onNext("You");
        });

        source.map(String::toUpperCase)
                .subscribe(s -> System.out.println("RECEIVED: " + s),
                        Throwable::printStackTrace,
                        () -> System.out.println("....Finished....")); //complete wont be executed
    }
}
