package com.crystal;

public class Magician implements Character {
    private int arms;
    private int legs;
    private boolean hasBalls;
    private boolean scared;
    private String name;
    private boolean hasMagicWand;

    public Magician(String name) {
        this.arms = 2;
        this.legs = 2;
        this.hasBalls = true;
        this.scared = false;
        this.name = name;
        this.hasMagicWand = true;
    }

    @Override
    public String getClassName() {
        return "Magician";
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
    public void isInjured(String attack) {
        int randomNum = (int) (Math.random() * ((3 - 0) + 3)) + 0;
        if (randomNum == 0) {
            System.out.println(this.getName() + ": 'Oh no! my magic wand is broken!'");
            System.out.println(this.getName() + ": 'My time has come.'");
            this.hasMagicWand = false;
        } else {
            System.out.println(this.getName() + ": 'Useless!'");
        }
    }

    @Override
    public boolean isDead() {
        if (!this.hasMagicWand()) {
            return true;
        }
        return !this.hasBalls() && !this.hasArms() && !this.hasLegs();
    }

    @Override
    public boolean punch(Character characterBeingAttacked) {
        if (this.hasArms()) {
            characterBeingAttacked.isInjured("punch");
            return true;
        }
        System.out.println(this.getName() + ": I have no stinking arms!");
        return false;
    }

    @Override
    public boolean kick(Character characterBeingAttacked) {
        if (this.hasLegs()) {
            characterBeingAttacked.isInjured("kick");
            return true;
        }
        System.out.println(this.getName() + ": I have no stinking legs!");
        return false;
    }

    @Override
    public boolean headbutt(Character characterBeingAttacked) {
        characterBeingAttacked.isInjured("headbutt");
        return true;
    }

    @Override
    public boolean roar(Character characterBeingAttacked) {
        characterBeingAttacked.isInjured("roar");
        return true;
    }

    public boolean hasBalls() {
        return hasBalls;
    }

    public String getName() {
        return name;
    }

    public boolean hasMagicWand() {
        return hasMagicWand;
    }

    public boolean hasArms() {
        return this.arms > 0;
    }

    public boolean hasLegs() {
        return this.legs > 0;
    }
}
