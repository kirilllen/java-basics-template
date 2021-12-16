package com.epam.izh.rd.online.service;

import java.util.*;

public class SimpleMathService implements MathService {

    /**
     * Метод возвращает 0, если value1 = value2.
     * Метод возвращает -1, если value1 < value2.
     * Метод возвращает 1, если value1 > value2.
     *
     * Например для (-1, -1) метод должен вернуть 0;
     * Например для (-3, -1) метод должен вернуть -1;
     * Например для (3, 1) метод должен вернуть 1;
     */
    @Override
    public int compare(int value1, int value2) {
        if (value1>value2) {return 1;}
        else if (value1<value2) {return -1;}
        else {return 0;}
    }

    /**
     * Метод возвращает максимальное число из пары.
     * Например для списка (-1, 2) метод должен вернуть 2
     */
    @Override
    public int maxFrom(int value1, int value2) {
        if (value1>value2) {return value1;}
        else {return value2;}
    }

    /**
     * Метод возвращает максимальное число из переданного массива.
     * Например для списка {-1, -3, 4, 8, 5, 22, -5} метод должен вернуть 22
     */
    @Override
    public int maxFrom(int[] values) {
        int maxValue=values[0]; //принимает, что это максимальный элемент, затем с ним будем сравнивать
        for(int element:values){
            if (element>maxValue) {maxValue=element;}
        }
        return maxValue;
    }

    /**
     * Метод возвращает сумму чисел массива.
     * Например для списка {-1, -3, 4, 8, 5, 22, -5} метод должен вернуть 30
     */
    @Override
    public int sum(int[] values) {
        int sum=0; //переменная для суммирования
       for (int element:values) {
           sum+=element;
       }
       return sum;
    }

    /**
     * Метод фильтрует массив, оставляя только четные числа.
     * Например для списка {-1, -3, 4, 8, 5, 22, 17} метод должен вернуть {4, 8, 22}
     */
    @Override
    public int[] getEvenDigits(int[] values) {
        int i=0; //счётчик количества чётных чисел
        int[] evenOnly=new int[values.length]; //промежуточный массив только чётных чисел
        for (int element:values){
            if (element%2==0) {
               evenOnly[i]=element;
               i++;
            }
        }
        int [] returnedArray=new int[i]; //создаём новый массив, который возвращает метод
        if (i + 1 >= 0) System.arraycopy(evenOnly, 0, returnedArray, 0, i);
        return returnedArray;
    }

    /**
     * Метод считает факториал из заданного числа.
     * Например для числа 5 метод должен вернуть 120.
     * Факториал 0 должен быть равен 1.
     */
    @Override
    public long calcFactorial(int initialVal) {
        long factorial=1;
        for (int i=1; i<=initialVal; i++){
            factorial*=i;
        }
        return factorial;
    }

    /**
     * Метод возвращает число, которе находится на заданной позиции (счет начинается с нуля) в ряду фибоначчи.
     *
     * Ряд фибоначчи - ряд, следующие элементы которого состоят из суммы двух предыдущих.
     * Ряд начинается 0 и 1.
     * Пример 0, 1, 1, 2, 3, 5, 8, 13, 21, 34, 55 ...
     *
     * Для числа 9 метод должен вернуть 34
     * Для числа 0 метод должен вернуть 0
     */
    @Override
    public long calcFibonacci(int number) {
        long[] var=new long[number+1]; //инициализируем массив в котором будем хранить числа
        var[0]=0L;
        var[1]=1L; //задаём два первых числа
        for (int i=2; i<=number; i++){
            var[i]=var[i-2]+var[i-1];
        }
        return var[number];
    }

    /**
     * Метод возвращает отсортированный по возрастанию массив.
     * Например для массива {-1, -3, 4, 8, 5, 22, -5} метод должен вернуть {-5, -3, -1, 4, 5, 8, 22}
     */
    @Override
    public int[] sort(int[] values) {
        int[] valuesSorted=new int[values.length]; //инициализируем новый массив
        System.arraycopy(values, 0, valuesSorted, 0, values.length); //копируем массивы
        Arrays.sort(valuesSorted);
        return valuesSorted;
    }

    /**
     * Метод определяет, является ли заданное число простым.
     * Простое число - число, которое делится только на 1 и на само себя.
     *
     * Например для числа 22 вернется false, а для числа 23 true.
     */
    @Override
    public boolean isPrimary(int number) {
        int divs=0; //переменная количества делителей
        for (int i=1; i<=number; i++){
            if (number%i==0) {divs++;}
        }
        return divs == 2;
    }

    /**
     * Метод возвращает массив, в котором элементы расположены в обратном порядке.
     *
     * Например для массива {-1, -3, 4, 8, 5, 22, -5} метод вернет {-5, 22, 5, 8, 4, -3, -1}
     */
    @Override
    public int[] reverseArray(int[] values) {
        int[] tempArray=new int[values.length];
        for (int i=0; i<values.length; i++){
            tempArray[values.length-i-1]=values[i];
        }
        return tempArray;
    }
}
