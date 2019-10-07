package com.crystal;

import java.util.Scanner;

public class CharacterCreation {
    static Scanner kbd = new Scanner(System.in);

    public static Character CreateCharacter() {
        int choose;

        System.out.printf("Choose your class:%n"
                + "1. Fighter%n"
                + "2. Magician%n");
        choose = kbd.nextInt();
        kbd.nextLine(); //clean buffer

        switch (choose) {

            case 1:
                return CreateFighter();
            case 2:
                return CreateMagician();
        }
        //In case the user doesn't choose a valid option it creates a fighter.
        return CreateFighter();
    }

    private static Character CreateFighter() {
        return new Fighter(askForName());
    }

    private static Character CreateMagician() {
        return new Magician(askForName());
    }

    private static String askForName() {
        String name;
        boolean sentinel = false;

        do {
            System.out.println("Write the name of your character: ");
            name = kbd.nextLine();

            if (name.matches("[A-z]*")) {
                sentinel = true;
            } else {
                System.out.println("Invalid name. Character names only can have letters.");
            }
        } while (!sentinel);
        return name;
    }
}
