package com.company;

import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {

    public static void main(String[] args) {
        //1.	Написать регулярное выражение, которые проверят e-mail простого вида (например, test@test.test).
     String str1 = "test@test.test";
        System.out.println(str1);
        Pattern pattern1 = Pattern.compile("^[^@\\s]+@[^@\\s]+\\.[^@\\s]+$");
        Matcher matcher1 = pattern1.matcher(str1);
        boolean found = matcher1.matches();
        if(found)
            System.out.println("e-mail простого вида");
        else
            System.out.println("не e-mail простого вида");
        //2.	Написать программу, которые при помощи регулярных выражений заменяет слово «функция» в тексте на «<mark>функция</mark>».
        String str2 = "функция Java! Hello функция! функцияввв 8.";
        Pattern pattern2 = Pattern.compile("функция");
        Matcher matcher2 = pattern2.matcher(str2);
        String newStr = matcher2.replaceAll("<mark>функция</mark>");
        System.out.println(newStr); // Hello HTML! Hello HTML! HTML 8.
        //3.	Написать функцию, которая при помощи регулярных выражений разбивает текст на отдельные слова и находит частоту встречаемости отдельных слов.
        String str3 = "This is a sample text. It contains several words, some of which repeat. Sample text.";
        Map<String, Integer> frequencyInTheText= new HashMap<String, Integer>();
        Pattern pattern = Pattern.compile("\\b\\w+\\b");
        Matcher matcher = pattern.matcher(str3);
        while (matcher.find()) {
            String word = matcher.group();
            int frequency;
            if (frequencyInTheText.get(word) == null)
                frequency = 0;
            else
                frequency = frequencyInTheText.get(word);
            frequencyInTheText.put(word, frequency+1);
        }
        System.out.println(frequencyInTheText);

        NumberChecker numberChecker = (number) -> number % 13 == 0;
        boolean result = numberChecker.check(26);
        System.out.println(result);

        CompareStrings compareStrings = (str1, str2) -> str1.length()>str2.length()?str1:str2;
        String res = compareStrings.compare("string one","string 2");
        System.out.println(res);

        DiscriminantCalculator calculator1 = (a, b, c) -> (b * b) - (4 * a * c);
        double res = calculator1.calculateDiscriminant(3.0,4.0,5.5);
        System.out.println(res);

        DiscriminantCalculator calculator2 = (a, b, c) ->  a * Math.pow(b, c);
        double res2 = calculator2.calculateDiscriminant(3.0,4.0,5.5);
        System.out.println(res2);
    }
}

interface NumberChecker {
    boolean check(int number);
}
interface CompareStrings {
    String compare(String str1,String str2);
}

 interface DiscriminantCalculator {
    double calculateDiscriminant(double a, double b, double c);
}
/*
4.	Написать функциональный интерфейс с методом, который принимает число и возвращает булево значение.
Написать реализацию такого интерфейса в виде лямбда-выражения, которое возвращает true если переданное число делится без остатка на 13.
5.	 Написать функциональный интерфейс с методом, который принимает две строки и возвращает тоже строку.
 Написать реализацию такого интерфейса в виде лямбды, которая возвращает ту строку, которая длиннее.
6.	Написать функциональный интерфейс с методом, который принимает три дробных числа: a, b, c и возвращает тоже дробное число.
Написать реализацию такого интерфейса в виде лямбда-выражения, которое возвращает дискриминант. Кто забыл, D = b^2 — 4ac.
7.	Используя функциональный интерфейс из задачи 6 написать лямбда-выражение, которое возвращает результат операции a * b^c.

 */