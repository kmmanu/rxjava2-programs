package org.manu.rxjava2.ch2;

import io.reactivex.Observable;
import org.junit.Test;

public class CreateObservable {
    @Test
    public void create_observable_with_emitter() {
        Observable<String> source = Observable.create(emitter -> {

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

    @Test
    public void handle_error() {
        Observable<String> source = Observable.create(emitter -> {
            try {
                emitter.onNext("Hello");
                emitter.onNext("Hi");
                emitter.onNext("How");
                emitter.onNext("Are");

                errorScenario();

                emitter.onNext("You");

            } catch (Exception e) {
                emitter.onError(e);
            }
        });

        source.subscribe(System.out::println, Throwable::printStackTrace);
    }

    @Test
    public void observable_transformation() {
        Observable<String> source = Observable.create(emitter -> {
            try {
                emitter.onNext("Hello");
                emitter.onNext("Hi");
                emitter.onNext("How");
                emitter.onNext("Are");

                errorScenario();

            } catch (Exception e) {
                emitter.onError(e);
            }
        });

        Observable<String> filtered = source.filter(str -> str.startsWith("H"));
        Observable<String> transformed = filtered.map(String::toLowerCase);

        transformed.subscribe(System.out::println, Throwable::printStackTrace);
    }

    @Test
    public void null_not_allowed() {
        Observable<String> source = Observable.create(emitter -> {
            emitter.onNext("Hello");
            emitter.onNext(null);
            emitter.onNext("How");  // omitted
        });

        source.subscribe(System.out::println, Throwable::printStackTrace);
    }

    private void errorScenario() {
        throw new IllegalStateException("Error on emitting data");
    }
}