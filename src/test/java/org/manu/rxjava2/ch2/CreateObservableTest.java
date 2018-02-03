package org.manu.rxjava2.ch2;

import io.reactivex.Observable;
import org.junit.Test;

public class CreateObservableTest {
    @Test
    public void create_observable_with_emitter() {
        Observable<Object> source = Observable.create(emitter -> {

            emitter.onNext("Hello");
            emitter.onNext("Hi");
            emitter.onNext("How");
            emitter.onNext("Are");
            emitter.onNext("You");

            emitter.onComplete();

            emitter.onNext("After completion");  // won't emit this value
        });

        source.subscribe(val -> System.out.println("RECEIVED :" + val));
    }
}