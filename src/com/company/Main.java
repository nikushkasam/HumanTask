package com.company;

public class Main {

    public static void main(String[] args) {
        Human firstHuman = Human.createHuman();
        System.out.println(firstHuman);

        Human secondHuman = Human.createHuman();
        System.out.println(secondHuman);

        Human compatibilityResult = Human.compatibilityTest(firstHuman, secondHuman);

        if (compatibilityResult == null) {
            System.out.println("Ничего не вышло, разбежались");
        } else {
            System.out.println(compatibilityResult);
        }
    }
}
