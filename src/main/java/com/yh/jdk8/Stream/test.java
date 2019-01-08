package com.yh.jdk8.Stream;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import java.util.stream.Stream;

import static com.yh.jdk8.Stream.est.*;

public class test {
    public static void main(String[] args) {
        /**
         * consumer andthen
         */
        f.andThen(f2).andThen(f).andThen(f).accept("test1");
        ArrayList<Integer>a=new ArrayList<>();
        a.add(2);
        a.add(23);
        System.out.println(funadd.apply(2));
        //从右往左运行 5*2 +1 *2 *2=44
        System.out.println( funmul.compose(funmul).compose(funadd).compose(funmul).apply(5));
        System.out.println(funaddlist.apply(a));
        //先执行调用者方法，再执行andThen的方法
        System.out.println(funmul.andThen(funadd).apply(30));


        //相反值
        System.out.println( pS.negate().test("test"));
        //and 都必须是true
        System.out.println( pS.and(pvalue).test("tast"));
        System.out.println( pvalue.and(pvalue).or(pS).test("test"));


        List<String> list = Arrays.asList("a", "b", "c", "d");
        //获取串行的Stream对象
        Stream listStream = list.stream();
        //获取并行的Stream对象
        Stream parallelListStream = list.parallelStream();

        Stream.generate(()->Math.random()).limit(10).forEach(System.out::println);
        Optional o=Optional.ofNullable(null);
        System.out.println(o.orElse(0));
        }
}
