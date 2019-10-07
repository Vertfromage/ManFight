package com.crystal;

public class Magician implements Character {
    private int arms;
    private int legs;
    private boolean hasBalls;
    private boolean scared;
    private String name;
    private boolean hasMagicWand;

    Magician(String name) {
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
    public void receiveDamage(String attack) {
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
    public boolean attack(String move, Character characterBeingAttacked) {
        if (this.hasMagicWand()) {
            System.out.println(this.getName() + " is casting " + move + "!");
            characterBeingAttacked.receiveDamage(move);
            return true;
        } else {
            System.out.println(this.getName() + ": 'I lost my magic wand. so I can't fight you.'");
            return false;
        }
    }

    private boolean hasBalls() {
        return hasBalls;
    }

    public String getName() {
        return name;
    }

    private boolean hasMagicWand() {
        return hasMagicWand;
    }

    private boolean hasArms() {
        return this.arms > 0;
    }

    private boolean hasLegs() {
        return this.legs > 0;
    }
}
