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
        System.out.println("You may punch, kick, headbutt or roar!");
        System.out.println("Type 'quit' to exit.");
        System.out.println("-------------------------------------------------------");
        System.out.println(this.getGoodMan().getName() + " the " + this.getGoodMan().getClassName() + " VS "
                + this.getBadMan().getName() + " the " + this.getBadMan().getClassName());
        System.out.println("-------------------------------------------------------");

        while (!this.getBadMan().isDead() && !this.getGoodMan().isDead()) {
            //Ask first player what he wants to do;
            System.out.println(this.getGoodMan().getName() + " What's your move?");
            //input
            if (scanner.hasNextLine()) {
                String goodMove = scanner.nextLine();
                if (goodMove.equals("quit")) {
                    System.out.println("You quit!");
                    break;
                }
                if (!doMove(goodMove, this.getGoodMan(), this.getBadMan())) {
                    System.out.println(this.getGoodMan().getName() + " is out of moves! " + this.getGoodMan().getName() + " has lost!");
                    break;
                }
            } else {
                System.out.println("Not a valid input, you skip your turn");
            }
            System.out.println(this.getBadMan().getName() + " What's your move?");
            if (scanner.hasNextLine()) {
                String badMove = scanner.nextLine();
                if (badMove.equals("quit")) {
                    System.out.println("You quit!");
                    break;
                }
                if (!doMove(badMove, this.getBadMan(), this.getGoodMan())) {
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

    public boolean doMove(String move, Character manAttacking, Character characterBeingAttacked) {
        if (manAttacking.isScared()) {
            System.out.println(manAttacking.getName() + " is still scared! can't move!");
            manAttacking.setScared(false);
            return true;
        }
        if (manAttacking instanceof Magician) {
            boolean hasMagicWand = doMoveAsMagician(move, (Magician) manAttacking);
            if (!hasMagicWand) {
                return false;
            }
        }
        switch (move) {
            case "kick":
                return manAttacking.kick(characterBeingAttacked);
            case "punch":
                return manAttacking.punch(characterBeingAttacked);
            case "headbutt":
                return manAttacking.headbutt(characterBeingAttacked);
            case "roar":
                return manAttacking.roar(characterBeingAttacked);
            default:
                System.out.println(move + " is not a valid move you skip your turn doofus!");
                return true;
        }
    }

    public boolean doMoveAsMagician(String move, Magician manAttacking) {
        if (manAttacking.hasMagicWand()) {
            System.out.println(manAttacking.getName() + " is casting " + move + "!");
            return true;
        } else {
            System.out.println(manAttacking.getName() + ": 'I lost my magic wand. so I can't fight you.'");
            return false;
        }
    }
}

