package com.company;

import java.util.Scanner;

public abstract class Human {

    private String name, lastName;
    private Float height, weight;
    private boolean gender;

    public Human(String name, String lastName, Float height, Float weight, boolean gender) {
        this.name = name;
        this.lastName = lastName;
        this.height = height;
        this.weight = weight;
        this.gender = gender;
    }

    public Human() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Float getHeight() {
        return height;
    }

    public void setHeight(Float height) {
        this.height = height;
    }

    public Float getWeight() {
        return weight;
    }

    public void setWeight(Float weight) {
        this.weight = weight;
    }

    public boolean isGender() {
        return gender;
    }

    public void setGender(boolean gender) {
        this.gender = gender;
    }

    @Override
    public String toString() {
        return "Human{" +
                "name='" + name + '\'' +
                ", lastName='" + lastName + '\'' +
                ", height=" + height +
                ", weight=" + weight +
                ", gender=" + gender +
                '}';
    }

    public static Human createHuman() {
        System.out.println("Введите пол: (true/false):");
        boolean gender = InputHumanData.inputGender();

        System.out.println("Введите имя человека:");
        String name = InputHumanData.inputName();

        System.out.println("Введите фамилию человека:");
        String surname = InputHumanData.inputName();

        System.out.println("Введите рост человека(см):");
        float height = Human.InputHumanData.inputHeight();

        System.out.println("Введите вес человека(кг):");
        float weight = InputHumanData.inputWeight();

        return gender ? new Man(name, surname, height, weight, gender)
                : new Woman(name, surname, height, weight, gender);
    }


    public static class InputHumanData {

        static boolean inputGender() {
            boolean gender = true, repeat = false;
            Scanner scanner = new Scanner(System.in);

            do {
                String input = scanner.nextLine();

                if (input.equals("false")) {
                    gender = false;
                    break;
                } else if (input.equals("true")) {
                    break;
                } else {
                    repeat = true;
                    System.out.println("Некорректный ввод. Пожалуйста повторите:");
                }

            } while (repeat == true);

            return gender;
        }

        static String inputName() {
            Scanner scanner = new Scanner(System.in);
            String input = scanner.nextLine();
            return input;
        }

        static float inputWeight() {
            return inputParameters();
        }

        static float inputHeight() {
            return inputParameters();
        }

        private static float inputParameters() {
            Scanner scanner = new Scanner(System.in);
            String input = scanner.nextLine();
            return Float.parseFloat(input);
        }
    }

    private boolean talk(Human human) {
        if (this.isGender() && human.isGender()) {
            return Math.random() < 0.5;
        } else {
            return true;
        }

    }

    private boolean tolerateSociety(Human human) {

        if (this.isGender() || human.isGender()) {
            return Math.random() < 0.7;
        } else if (!this.isGender() && !human.isGender()) {
            return Math.random() < 0.05;
        } else {
            return Math.random() < 0.056;
        }

    }

    private boolean spendTimeTogether(Human human) {
        float h1 = this.getHeight();
        float h2 = human.getHeight();
        if (h1 > h2) {
            return compareHeight(h1, h2);
        } else {
            return compareHeight(h2, h1);
        }
    }

    private static boolean compareHeight(float tallerHeight, float lowerHeight) {
        if ((100 - lowerHeight * 100 / tallerHeight) > 10) {
            return Math.random() <= 0.85;
        } else {
            return Math.random() <= 0.95;
        }
    }

    public static Human compatibilityTest(Human firstHuman, Human secondHuman) {
        return firstHuman.toBeInRelationships(secondHuman);
    }

    private Human toBeInRelationships(Human human) {
        if (this.talk(human) && this.tolerateSociety(human) && this.spendTimeTogether(human)) {
            if (this.isGender() == human.isGender()) {
                System.out.println("Люди одного пола, и они не могут родить ребенка.");
                return null;
            } else {
                return createChildHuman(this, human);
            }
        } else {
            return null;
        }
    }


    private static Human createChildHuman(Human firstHuman, Human secondHuman) {
        if (!firstHuman.isGender()) {
            Woman woman = (Woman) firstHuman;
            return woman.giveBirthToHuman(secondHuman);
        } else {
            Woman woman = (Woman) secondHuman;
            return woman.giveBirthToHuman(firstHuman);
        }

    }

}

