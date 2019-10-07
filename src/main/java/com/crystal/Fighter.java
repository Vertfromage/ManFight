package com.crystal;

public class Fighter implements Character {
    private int arms;
    private int legs;
    private boolean hasBalls;
    private boolean scared;
    private String name;

    public Fighter(String name) {
        this.arms = 2;
        this.legs = 2;
        this.hasBalls = true;
        this.scared = false;
        this.name = name;
    }

    @Override
    public String getClassName() {
        return "Fighter";
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
        if (attack.equals("punch") && this.hasArms()) {
            System.out.println(this.getName() + ": 'Oww you broke my arm!'");
            this.arms--;
        } else if (attack.equals("kick") && this.hasLegs()) {
            System.out.println(this.getName() + ": 'Oww you broke my leg!'");
            this.legs--;
        } else if (attack.equals("headbutt") && this.hasBalls()) {
            System.out.println(this.getName() + ": 'Oww you got me in the Gronk Nuts!'");
            this.hasBalls = false;
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

    @Override
    public boolean isDead() {
        return !this.hasBalls() && !this.hasArms() && !this.hasLegs();
    }

    @Override
    public boolean attack(String move, Character characterBeingAttacked) {
        if (this.isScared()) {
            System.out.println(this.getName() + " is still scared! can't move!");
            this.setScared(false);
            return true;
        }
        switch (move) {
            case "kick":
                return kick(characterBeingAttacked);
            case "punch":
                return punch(characterBeingAttacked);
            case "headbutt":
                return headbutt(characterBeingAttacked);
            case "roar":
                return roar(characterBeingAttacked);
            default:
                System.out.println(move + " is not a valid move you skip your turn doofus!");
                return true;
        }
    }

    private boolean punch(Character characterBeingAttacked) {
        if (this.hasArms()) {
            characterBeingAttacked.receiveDamage("punch");
            return true;
        }
        System.out.println(this.getName() + ": I have no stinking arms!");
        return false;
    }

    private boolean kick(Character characterBeingAttacked) {
        if (this.hasLegs()) {
            characterBeingAttacked.receiveDamage("kick");
            return true;
        }
        System.out.println(this.getName() + ": I have no stinking legs!");
        return false;
    }

    private boolean headbutt(Character characterBeingAttacked) {
        characterBeingAttacked.receiveDamage("headbutt");
        return true;
    }

    private boolean roar(Character characterBeingAttacked) {
        characterBeingAttacked.receiveDamage("roar");
        return true;
    }

    public boolean hasBalls() {
        return hasBalls;
    }

    public String getName() {
        return name;
    }

    public boolean hasArms() {
        return this.arms > 0;
    }

    public boolean hasLegs() {
        return this.legs > 0;
    }
}
