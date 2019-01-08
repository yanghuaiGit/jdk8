package com.yh.jdk8.Lambda;

import com.yh.jdk8.model.Apple;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

public class LambdaTest {

    public static void main(String[] args) {

        Predicate<Apple> pred = (p) -> p.getWight() > 65;


        List<Apple> appleList = Arrays.asList(new Apple("RED", 80),
                new Apple("GREEN", 100),
                new Apple("BLACK", 150));
        appleList= getApple(appleList);



        forEach(appleList,
                s -> {
                       s.setWight( s.getWight()+20);
                    });



        List<String> stringList = Arrays.asList("lambda", "test", "javascript");
        List<Integer> map = map(stringList, s -> s.length());
        System.out.println(map);




        for(Apple apple:appleList){
            System.out.print(apple+" ");
        }


       String br = processFile(b -> b.readLine()+b.readLine());
        System.out.println(br);

        /**
         * 函数调用 ::
         */
        List<String> list = Arrays.asList("a", "b", "A", "B");
        // 调用compareToIgnoreCase进行比较
        list.sort(String::compareToIgnoreCase);
        System.out.println(list);


    }


    /**
     * PredicatePredicate接口测试
     */

  public static List<Apple> getApple( List<Apple> appleList){

      // 重量大于100
      List<Apple> filterApple = filterApple(appleList, apple -> apple.getWight() > 100);
      return filterApple;
      // 红色的苹果
     // filterApple = filterApple(appleList, apple -> apple.getColor().equals("RED"));
  }

    /**
     Predicate<T>接口：默认调用test方法，返回boolean值，传递的参数只有一个。
     在需要调用Lambeda表达式返回boolean的时候使用。
     */
    public static List<Apple> filterApple(List<Apple> appleList, Predicate<Apple> predicate){
        List<Apple> apples = new ArrayList<>();
        appleList.forEach(apple -> {if(predicate.test(apple)) {
            apples.add(apple);
        }
        } ); {

        }
        return apples;
    }
    public static List<Apple> filterApple1(List<Apple> appleList, Predicate<Apple> predicate){
        List<Apple> apples = new ArrayList<>();
        for (Apple apple : appleList) {
            if(predicate.test(apple)){
                apples.add(apple);
            }
        }
        return apples;
    }

    /**
     * Consumer<T>提供了一个accept方法，返回void类型。
     */
    public static <T>void forEach(List<T> list, Consumer<T> s){
        for (T t : list) {
            s.accept(t);
        }
    }

    /**
     * Function<T, R>, T表示传入的类型，R表示返回的类型。即传入T类型的参数，返回R类型的参数
     * @param list
     * @param function
     * @param <T>
     * @param <R>
     * @return
     */
    public static <T,R> List<R> map(List<T> list, Function<T, R> function){
        List<R> result = new ArrayList<>();
        for (T t : list) {
            result.add(function.apply(t));
        }
        return result;
    }

    /**
     * 将读取文件的动作封装成参数
     * @param b
     * @return
     */
    public static String processFile(BufferedReaderProcess b){
        try(BufferedReader br =
                    new BufferedReader(
                            new FileReader("F:\\Codelearn\\JDK8学习\\jdk8\\src\\main\\java\\com\\yh\\jdk8\\Lambda\\BufferedReaderProcess.java"))){
            return b.process(br);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }




}
