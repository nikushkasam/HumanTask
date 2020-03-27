package com.company;

import java.util.Scanner;

public class Man extends Human {

    public Man(String name, String lastName, Float height, Float weight, boolean gender) {
        super(name, lastName, height, weight, gender);
    }

    public Man() {
    }

    @Override
    public String toString() {
        return "Man " + super.toString();
    }

}
