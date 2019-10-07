package com.crystal;

//TODO finish this class
public class Monster implements Character {
    private int eyes;
    private int tentacles;
    private String name;
    private boolean scared;

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


    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public String getClassName() {
        return "Monster";
    }

    @Override
    public boolean isScared() {
        return scared;
    }

    @Override
    public void setScared(boolean scared) {
        this.scared = scared;
    }

    @Override
    public boolean attack(String move, Character characterBeingAttacked) {
        return false;
    }

    @Override
    public void receiveDamage(String attack) {

    }

    @Override
    public boolean isDead() {
        return false;
    }
}
