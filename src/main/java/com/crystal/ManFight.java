package com.crystal;

import java.util.Scanner;

public class ManFight {
    private Character goodMan;
    private Character badMan;
    int selection;

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
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            selection = (int) Math.floor(Math.random() * 3) + 1;

            switch (selection) {
                case 1:
                    System.out.println("punch");
                    this.getBadMan().attack("punch", this.getGoodMan());
                    break;
                case 2:
                    System.out.println("insult");
                    this.getBadMan().attack("insult", this.getGoodMan());
                    break;
                case 3:
                    System.out.println("kick");
                    this.getBadMan().attack("kick", this.getGoodMan());
                    break;
                case 4:
                    System.out.println("headbutt");
                    this.getBadMan().attack("headbutt", this.getGoodMan());
                case 5:
                    System.out.println("roar!");
                    this.getBadMan().attack("roar!", this.getGoodMan());
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

