package com.crystal;

import java.util.Scanner;

public class ManFight {
    private Character goodMan;
    private Character badMan;

    public ManFight(Character goodMan, Character badMan) {
        this.goodMan = goodMan;
        this.badMan = badMan;
    }

    public Character getGoodMan() {
        return goodMan;
    }

    public Character getBadMan() {
        return badMan;
    }

    public void startFight() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Welcome to the fight club!");
        System.out.println("You may punch, insult,  kick, headbutt or roar!");
        System.out.println("Type 'quit' to exit.");
        System.out.println("-------------------------------------------------------");
        System.out.println(this.getGoodMan().getName() + " the " + this.getGoodMan().getClassName() + " VS "
                + this.getBadMan().getName() + " the " + this.getBadMan().getClassName());
        System.out.println("-------------------------------------------------------");

        while (!this.getBadMan().isDead() && !this.getGoodMan().isDead()) {
            //Ask first player what he wants to do;
            System.out.println(this.getGoodMan().getName() + ", what's your move?");
            //input
            if (scanner.hasNextLine()) {
                String goodMove = scanner.nextLine();
                if (goodMove.equals("quit")) {
                    System.out.println("You quit!");
                    break;
                }
                if (!this.getGoodMan().attack(goodMove, this.getBadMan())) {
                    System.out.println(this.getGoodMan().getName() + " is out of moves! " + this.getGoodMan().getName() + " has lost!");
                    break;
                }
            } else {
                System.out.println("Not a valid input, you skip your turn");
            }
            System.out.println(this.getBadMan().getName() + ", what's your move?");
            if (scanner.hasNextLine()) {
                String badMove = scanner.nextLine();
                if (badMove.equals("quit")) {
                    System.out.println("You quit!");
                    break;
                }
                if (!this.getBadMan().attack(badMove, this.getGoodMan())) {
                    System.out.println(this.getBadMan().getName() + " is out of moves! " + this.getBadMan().getName() + " has lost!");
                    break;
                }
            } else {
                System.out.println("Not valid input, you skip your turn");
            }
        }
        if (this.getBadMan().isDead()) {
            System.out.println(this.getBadMan().getName() + " is dead!");
        }
        if (this.getGoodMan().isDead()) {
            System.out.println(this.getGoodMan().getName() + " is dead!");
        }
        System.out.println("Game over!");
        scanner.close();
    }
}

