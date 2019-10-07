package com.crystal;

public class Monster {
    private int eyes;
    private int tentacles;
    private String name;


    public Monster(String name, int eyes, int tentacles) {
        this.name = name;
        this.tentacles = tentacles;
    }

    public void rankMonster() {
        if (name.length() > 3) {
            System.out.println("longboi");
        } else {
            System.out.println("midget");
        }
        if (tentacles != 3) {
            System.out.println("generic octopus");
        } else {
            System.out.println("chad octocat");
        }
        if (eyes > 5) {
            System.out.println("all-seeing behemoth");
        }
    }
}
