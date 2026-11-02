package org.example;

import java.util.Arrays;

public class Main {

    public static <T> void swap(T[] array, int i, int j) {
        T temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }

    public static class Box<T, U, V> {
        private T first;
        private U second;
        private V third;

        public Box(T first, U second, V third) {
            this.first = first;
            this.second = second;
            this.third = third;
        }

        public T getFirst() {
            return first;
        }

        public U getSecond() {
            return second;
        }

        public V getThird() {
            return third;
        }

        public void setFirst(T first) {
            this.first = first;
        }

        public void setSecond(U second) {
            this.second = second;
        }

        public void setThird(V third) {
            this.third = third;
        }

        @Override
        public String toString() {
            return "Box{" + first + ", " + second + ", " + third + "}";
        }
    }

    public static <T extends Number, U extends Number, V extends Number>
    double sumOfNumbers(Box<T, U, V> box) {
        return box.getFirst().doubleValue()
                + box.getSecond().doubleValue()
                + box.getThird().doubleValue();
    }

    public static <T extends Number> double sumArray(T[] array) {
        double sum = 0;
        for (T item : array) {
            sum += item.doubleValue();
        }
        return sum;
    }

    public static void main(String[] args) {

        String[] words = {"Java", "Generics", "Box"};
        System.out.println("До swap:    " + Arrays.toString(words));
        swap(words, 0, 2);
        System.out.println("После swap: " + Arrays.toString(words));

        Integer[] numbers = {1, 2, 3};
        System.out.println("До swap:    " + Arrays.toString(numbers));
        swap(numbers, 0, 1);
        System.out.println("После swap: " + Arrays.toString(numbers));

        Double[] doubles = {1.1, 2.2, 3.3};
        swap(doubles, 1, 2);
        System.out.println("Double swap: " + Arrays.toString(doubles));

        System.out.println();


        Box<String, String, String> stringBox =
                new Box<>("Java", "Generics", "Box");
        Box<Integer, Integer, Integer> intBox =
                new Box<>(10, 20, 30);
        Box<Float, Float, Float> floatBox =
                new Box<>(1.5f, 2.5f, 3.5f);

        System.out.println("String box:  " + stringBox);
        System.out.println("Integer box: " + intBox);
        System.out.println("Float box:   " + floatBox);


        double total = sumOfNumbers(intBox) + sumOfNumbers(floatBox);

        System.out.println("\nСумма чисел (intBox + floatBox): " + total);


        System.out.println("Сумма массива Integer: " + sumArray(numbers));
        System.out.println("Сумма массива Double:  " + sumArray(doubles));

    }
}
