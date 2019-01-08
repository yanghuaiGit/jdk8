package com.yh.jdk8.Stream;

import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

public interface est {
    Consumer f = System.out::println;
    Consumer f2 = n -> System.out.println(n + "-F2");

    Function<List<Integer>, Integer> funaddlist = s -> s.stream().reduce((x,y)->x+y).orElse(0);
    Function<Integer, Integer> funadd = s -> ++s;
    Function<Integer, Integer> funmul = s -> s * 2;
    Predicate<String> pvalue = o -> o.equals("aest");
    Predicate<Integer> psize = o -> o<10;
    Predicate<String> pS = o -> o.startsWith("t");
}
