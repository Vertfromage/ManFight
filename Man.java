package com.crystal;

public class Man {

    private int arms;
    private int legs;
    private boolean balls;
    private boolean scared;
    private String name;

    private ManClass manClass;
    private boolean hasMagicWand = false;

    public Man(String name, ManClass manClass) {
        this.arms = 2;
        this.legs = 2;
        this.balls = true;
        this.scared = false;
        this.name = name;
        this.manClass = manClass;
        if (this.manClass == ManClass.MAGICIAN) {
            this.hasMagicWand = true;
        }
    }

    public boolean isScared() {
        return scared;
    }

    public void setScared(boolean scared) {
        this.scared = scared;
    }

    public boolean hasBalls() {
        return balls;
    }

    public String getName() {
        return name;
    }

    public ManClass getManClass() {
        return manClass;
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

    /************
     * ATTACKS
     *********** */

    public boolean punch(Man manBeingAttacked) {
        if (this.hasArms() || this.getManClass() == ManClass.MAGICIAN) {
            manBeingAttacked.isInjured("punch");
            return true;
        }
        System.out.println(this.getName() + ": I have no stinking arms!");
        return false;
    }

    public boolean kick(Man manBeingAttacked) {
        if (this.hasLegs() || this.getManClass() == ManClass.MAGICIAN) {
            manBeingAttacked.isInjured("kick");
            return true;
        }
        System.out.println(this.getName() + ": I have no stinking legs!");
        return false;
    }

    public boolean headbutt(Man manBeingAttacked) {
        manBeingAttacked.isInjured("headbutt");
        return true;
    }

    public boolean roar(Man manBeingAttacked) {
        manBeingAttacked.isInjured("roar");
        return true;
    }

    public void isInjured(String attack) {
        if (this.getManClass() == ManClass.MAGICIAN) {
            magicianIsInjured();
            return;
        }
        if (attack.equals("punch") && this.hasArms()) {
            System.out.println(this.getName() + ": 'Oww you broke my arm!'");
            this.arms--;
        } else if (attack.equals("kick") && this.hasLegs()) {
            System.out.println(this.getName() + ": 'Oww you broke my leg!'");
            this.legs--;
        } else if (attack.equals("headbutt") && this.hasBalls()) {
            System.out.println(this.getName() + ": 'Oww you got me in the Gronk Nuts!'");
            this.balls = false;
        } else if (attack.equals("roar")) {
            int randomNum = (int) (Math.random() * ((1 - 0) + 1)) + 0;
            if (randomNum == 0) {
                System.out.println(this.getName() + ": 'What?'");
                System.out.println("Nothing happens!");
            } else {
                System.out.println(this.getName() + ": 'That's scary!'");
                System.out.println(this.getName() + " is scared from your roar!!");
                this.scared = true;
            }
        } else {
            System.out.println("'I'm in too much pain already to be bothered by your feeble attempts!'");
        }
    }

    public void magicianIsInjured() {
        int randomNum = (int) (Math.random() * ((3 - 0) + 3)) + 0;
        if (randomNum == 0) {
            System.out.println(this.getName() + ": 'Oh no! my magic wand is broken!'");
            System.out.println(this.getName() + ": 'My time has come.'");
            this.hasMagicWand = false;
        } else {
            System.out.println(this.getName() + ": 'Useless!'");
        }
    }

    public boolean isDead() {
        if (this.getManClass() == ManClass.MAGICIAN && !this.hasMagicWand()) {
            return true;
        }
        return !this.hasBalls() && !this.hasArms() && !this.hasLegs();
    }
}
