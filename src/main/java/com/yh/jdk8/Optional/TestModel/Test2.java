package com.yh.jdk8.Optional.TestModel;

public class Test2 {
    private Test1 test1;

    public Test2() {
    }

    public Test2(Test1 test1) {
        this.test1 = test1;
    }

    public Test1 getTest1() {
        return test1;
    }

    public void setTest1(Test1 test1) {
        this.test1 = test1;
    }
}
