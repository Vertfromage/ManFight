package com.crystal;

public class Man {

    private int arms;
    private int legs;
    private boolean balls;
    private String name;

    public Man(String name) {
        this.arms = 2;
        this.legs = 2;
        this.balls = true;
        this.name = name;
    }

    public boolean hasBalls() {
        return balls;
    }

    public String getName() {
        return name;
    }

    public boolean hasArms() {
        if (this.arms > 0) {
            return true;
        } else return false;
    }

    public boolean hasLegs() {
        if (this.legs > 0) {
            return true;
        } else return false;
    }

    public boolean punch() {
        if (this.hasArms()) {
            return true;
        } else {
            System.out.println(this.getName()+": I have no stinking arms!");
            return false;
        }
    }

    public boolean kick() {
        if (this.hasLegs()) {
            return true;
        } else {
            System.out.println(this.getName()+": I have no stinking legs!");
            return false;
        }
    }

    public boolean headbutt() {
        if (this.hasBalls()) {
            return true;
        } else {
            System.out.println(this.getName()+": Ow my poor Gronk nuts, I've lost my nerve!");
            return false;
        }
    }

    public void isInjured(String attack){
        if (attack.equals("punch")&& this.arms>0) {
            System.out.println(this.getName()+": 'Oww you broke me arm!'");
            this.arms -= 1;
        }else if (attack.equals("kick")&& this.legs>0) {
            System.out.println(this.getName()+": 'Oww you broke me leg!'");
            this.legs -= 1;
        }else if (attack.equals("headbutt")&& this.hasBalls()) {
            System.out.println(this.getName()+": 'Oww you got me in the Gronk Nuts!'");
            this.balls = false;
        }else{
            System.out.println("'I'm in too much pain already to be bothered by your feeble attempts!'");
        }
    }

    public boolean isDead(){
        if (this.hasBalls()||this.hasArms()||this.hasLegs()){
            return false;
        }else{
            System.out.println(this.getName()+" is Dead!");
            return true;
        }
    }
}
