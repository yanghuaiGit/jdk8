package com.yh.jdk8.Lambda;

import java.io.BufferedReader;
import java.io.IOException;


/**
 * @FunctionalInterface注解，
 * 用于只是该接口是函数式接口，如果没有该注释也可以编译通过，
 * 但是编译器就不能判断他只能拥有一个未实现的方法。
 */
@FunctionalInterface
public interface BufferedReaderProcess {

    String process(BufferedReader b) throws IOException;

}

