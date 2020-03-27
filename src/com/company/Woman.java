package com.company;


public class Woman extends Human {

    public Woman(String name, String lastName, Float height, Float weight, boolean gender) {
        super(name, lastName, height, weight, gender);
    }

    public Woman() {
    }

    @Override
    public String toString() {
        return "Woman " + super.toString();
    }


    public Human giveBirthToHuman(Human man) {
        if (Math.random() <= 0.5) {
            System.out.println("Поздравляем, у вас родился мальчик!");
            return this.createChildBoy(man);
        } else {
            System.out.println("Поздравляем, у вас родилась девочка!");
            return this.createChildGirl(man);
        }
    }

    private Human createChildGirl(Human person) {
        System.out.println("Пожалуйста, введите имя девочки: ");
        String girlName = InputHumanData.inputName();
        String girlLastName = person.getLastName();
        float girlHeight = (float) (this.getHeight() + 0.1 * (person.getHeight() - this.getHeight()));
        float girlWeight = (float) (this.getWeight() + 0.1 * (person.getWeight() - this.getWeight()));
        Woman newGirl = new Woman(girlName, girlLastName, girlHeight, girlWeight, false);
        System.out.println("Новая ячейка общества: ");
        return newGirl;
    }

    private Human createChildBoy(Human person) {
        System.out.println("Пожалуйста, введите имя мальчика: ");
        String boyName = InputHumanData.inputName();
        String boyLastName = person.getLastName();
        float boyHeight = (float) (person.getHeight() + 0.1 * (this.getHeight() - person.getHeight()));
        float boyWeight = (float) (person.getWeight() + 0.1 * (this.getWeight() - person.getWeight()));
        Man newBoy = new Man(boyName, boyLastName, boyHeight, boyWeight, true);
        System.out.println("Новая ячейка общества: ");
        return newBoy;
    }


}

