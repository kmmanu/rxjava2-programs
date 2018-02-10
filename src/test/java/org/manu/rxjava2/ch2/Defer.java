package org.manu.rxjava2.ch2;

import io.reactivex.Observable;
import org.junit.Test;

public class Defer {
    private static int count = 5;
    private static int start = 1;


    @Test
    public void try_defer_to_update_state_of_observable() {

        Observable<Integer> source = Observable.defer(() -> Observable.range(start, count));
        source.subscribe(System.out::println);

        System.out.println("\nWith updated count");
        count = 6;              /******* Update state ********/
        source.subscribe(System.out::println);

    }
}
