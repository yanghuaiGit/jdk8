package com.yh.jdk8.model;

public class Apple {
    private String color;
    private Integer wight;

    public Apple(String color, int wight) {
        this.color = color;
        this.wight = wight;
    }

    public Apple() {
    }

    public Apple(Integer wight) {
        this.wight = wight;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public Integer getWight() {
        return wight;
    }

    public void setWight(Integer wight) {
        this.wight = wight;
    }

    @Override
    public String toString() {
        return "Apple{" +
                "color='" + color + '\'' +
                ", wight=" + wight +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        Apple apple = (Apple) o;

        if (!wight.equals(apple.wight)) {
            return false;
        }
        return color != null ? color.equals(apple.color) : apple.color == null;
    }

    @Override
    public int hashCode() {
        int result = color != null ? color.hashCode() : 0;
        result = 31 * result + wight;
        return result;
    }


}
