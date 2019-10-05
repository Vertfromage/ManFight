package com.crystal;

public class Man {

    private int arms;
    private int legs;
    private boolean balls;
    private boolean scareStatus;
    private String name;

    private String manClass;
    private boolean hasMagicWand = false;

    public Man(String name) {
        this.arms = 2;
        this.legs = 2;
        this.balls = true;
        this.scareStatus = false;
        this.name = name;
        this.manClass = "Fighter";
    }

    public Man(String name, String manClass) {
        this.arms = 2;
        this.legs = 2;
        this.balls = true;
        this.name = name;
        this.manClass = manClass;
        if (this.manClass.equals("Magician")) {
            this.hasMagicWand = true;
        }
    }

    public boolean isScare() {
        return scareStatus;
    }

    public void setScare(boolean scareStatus) {
        this.scareStatus = scareStatus;
    }

    public boolean hasBalls() {
        return balls;
    }

    public String getName() {
        return name;
    }

    public String getManClass() {
        return manClass;
    }

    public boolean hasMagicWand() {
        return hasMagicWand;
    }

    public boolean hasArms() {
        if (this.arms > 0) {
            return true;
        }
        return false;
    }

    public boolean hasLegs() {
        if (this.legs > 0) {
            return true;
        }
        return false;
    }

    public boolean punch(Man manBeingAttacked) {
        if (this.hasArms() || this.getManClass().equals("Magician")) {
            manBeingAttacked.isInjured("punch");
            return true;
        }
        System.out.println(this.getName() + ": I have no stinking arms!");
        return false;

    }

    public boolean kick(Man manBeingAttacked) {
        if (this.hasLegs() || this.getManClass().equals("Magician")) {
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
        if(this.getManClass().equals("Magician")){
            magicianIsInjured();
            return;
        }
        if (attack.equals("punch") && this.hasArms()) {
            System.out.println(this.getName() + ": 'Oww you broke me arm!'");
            this.arms--;
        } else if (attack.equals("kick") && this.hasLegs()) {
            System.out.println(this.getName() + ": 'Oww you broke me leg!'");
            this.legs--;
        } else if (attack.equals("headbutt") && this.hasBalls()) {
            System.out.println(this.getName() + ": 'Oww you got me in the Gronk Nuts!'");
            this.balls = false;
        } else if (attack.equals("roar")) {
            int randomNum = (int)(Math.random() * ((1 - 0) + 1)) + 0;
            if(randomNum == 0){
                System.out.println(this.getName()+": 'What?'");
                System.out.println("Nothing happen!");
            } else {
                System.out.println(this.getName() + ": 'That's scary!'");
                System.out.println(this.getName()+" is scare from your roar!!");
                this.scareStatus = true;
            }
        } else {
            System.out.println("'I'm in too much pain already to be bothered by your feeble attempts!'");
        }
    }

    public void magicianIsInjured(){
        int randomNum = (int)(Math.random() * ((1 - 0) + 1)) + 0;
        if(randomNum == 0){
            System.out.println(this.getName()+": 'Useless!'");
        } else {
            System.out.println(this.getName()+": 'Oh no! my magic wand is broken!'");
            this.hasMagicWand = false;
            System.out.println(this.getName()+": 'My time has come.'");
            return;
        }
    }

    public boolean isDead() {
        if(this.getManClass().equals("Magician") && !this.hasMagicWand()){
            return true;
        }
        if (this.hasBalls() || this.hasArms() || this.hasLegs()) {
            return false;
        }
        return true;
    }
}
