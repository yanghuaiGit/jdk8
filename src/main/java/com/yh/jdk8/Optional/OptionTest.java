package com.yh.jdk8.Optional;

import com.yh.jdk8.Optional.TestModel.Test1;
import com.yh.jdk8.Optional.TestModel.Test2;
import com.yh.jdk8.Optional.TestModel.Test3;
import com.yh.jdk8.Optional.TestModel.Test4;
import com.yh.jdk8.model.Apple;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.function.BinaryOperator;
import java.util.function.Consumer;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class OptionTest {
    /**
     *
     */
    public static void main(String[] args) {
        Test1 test1=new Test1("test1");
       // Test4 test4=new Test4(new Test3(new Test2()));
        Test4 test4=new Test4(new Test3(new Test2(test1)));
      String name= Optional.ofNullable(test4).flatMap(test44->Optional.ofNullable(test44.getTest3())
                .flatMap(test33->Optional.ofNullable(test33.getTest2()))
                .flatMap(test22->Optional.ofNullable(test22.getTest1()))
                .map(Test1::getName)).orElse("===");
       System.out.println(name);

       System.out.println( Optional.ofNullable(Arrays.asList(new Apple("RED", 80),
               new Apple("GREEN", 100),
               new Apple("BLACK", 150))).map(apples -> {

                   apples.stream().forEach(
                           s ->
                           {
                               s.setWight(s.getWight()+20);
                           }
                   );
              return     apples.stream().map(a->a.getWight()).collect(Collectors.toList())
                   ;
               }
       ).orElseThrow(()->new IllegalArgumentException("The value of param comp isn't available.") ));

        System.out.println( Optional.ofNullable(Arrays.asList(new Apple("RED", 80),
                new Apple("GREEN", 100),
                new Apple("BLACK", 150))).map(apples -> {
                    ArrayList<Integer> arrayList=new ArrayList();
                    apples.stream().forEach(
                            s ->
                            {
                                s.setWight(s.getWight()+20);
                                arrayList.add(s.getWight());

                            }
                    );


            return arrayList.stream().reduce((x,y)->x+y).orElse(0);
                }
        ).orElseThrow(()->new IllegalArgumentException("The value of param comp isn't available.") ));

        Optional.ofNullable(Arrays.asList(new Apple("RED", 80),
                new Apple("GREEN", 100),
                new Apple("BLACK", 150))).map(u->{u.stream().forEach(System.out::println);return 10;});

        Apple  apple=new Apple();
        apple.setWight(120);
        try{
            getName(apple);
        }catch (Exception e){
                  System.out.println(e);
        return;
        }

      System.out.println("2");
           }

    ;public static Apple getoptional(){
       Optional<Apple>apple= Optional.ofNullable(null);

        apple.ifPresent(System.out::println);
       return apple.orElse(new Apple("coloe",12));
    }

    public static Integer getName(Apple u) throws  IllegalArgumentException{
        Optional.of(u).filter(w -> w.getWight()>100).orElseThrow(()->new IllegalArgumentException("The value of param is to weight."));
        return Optional.ofNullable(u)
                .map(user->user.getWight())
                .map(weight->weight+20)
                .orElseThrow(()->new IllegalArgumentException("The value of param comp isn't available."));
    }
}
