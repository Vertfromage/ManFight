package com.crystal;

import java.util.Scanner;

public class ManFight {
    private Man goodMan;
    private Man badMan;

    public ManFight(Man goodMan, Man badMan) {
        this.goodMan = goodMan;
        this.badMan = badMan;
        startFight();
    }

    public Man getGoodMan() {
        return goodMan;
    }

    public Man getBadMan() {
        return badMan;
    }

    public void startFight() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Welcome to the fight club!");
        System.out.println("You may punch, kick, headbutt or roar!");
        System.out.println("Type 'quit' to exit.");
        System.out.println("-------------------------------------------------------");
        System.out.println(this.getGoodMan().getName() + " the " + this.getGoodMan().getManClass() + " VS "
            + this.getBadMan().getName() + " the " + this.getBadMan().getManClass());
        System.out.println("-------------------------------------------------------");

        while (!this.getBadMan().isDead() && !this.getGoodMan().isDead()) {
            //Ask first player what he wants to do;
            System.out.println(this.getGoodMan().getName() + " What's your move?");
            //input
            if (scanner.hasNextLine() == true) {
                String goodMove = scanner.nextLine();
                if (goodMove.equals("quit")) {
                    System.out.println("You quit!");
                    break;
                }
                if (!DoMove(goodMove, this.getGoodMan(), this.getBadMan())) {
                    System.out.println(this.getGoodMan().getName() + " is out of moves! You lose!");
                    break;
                }
            } else {
                System.out.println("Not valid input, you skip your turn");
            }
            System.out.println(this.getBadMan().getName() + " What's your move?");
            if (scanner.hasNextLine() == true) {
                String badMove = scanner.nextLine();
                if (badMove.equals("quit")) {
                    System.out.println("You quit!");
                    break;
                }
                if (!DoMove(badMove, this.getBadMan(), this.getGoodMan())) {
                    System.out.println(this.getBadMan().getName() + " is out of moves! You lose!");
                    break;
                }
            } else {
                System.out.println("Not valid input, you skip your turn");
            }
        }
        if(this.getBadMan().isDead()){
            System.out.println(this.getBadMan().getName()+" is Dead!");
        }
        if(this.getGoodMan().isDead()){
            System.out.println(this.getGoodMan().getName()+" is Dead!");
        }
        System.out.println("Game over!");
        scanner.close();
    }

    public boolean DoMove(String move, Man manAttacking, Man manBeingAttacked) {
        if(manAttacking.isScare()){
            System.out.println(manAttacking.getName() + " is still scare! can't move!");
            manAttacking.setScare(false);
            return true;
        }
        if(manAttacking.getManClass().equals("Magician")){
            move = DoMoveAsMagician(move, manAttacking);
        }
        if (move.equals("kick"))
           return manAttacking.kick(manBeingAttacked);
        else if (move.equals("punch"))
            return manAttacking.punch(manBeingAttacked);
        else if (move.equals("headbutt"))
            return manAttacking.headbutt(manBeingAttacked);
        else if (move.equals("roar"))
            return manAttacking.roar(manBeingAttacked);
        else if (move.equals("ilostmagicwand"))
            return true;
        else {
            System.out.println(move + " is not a valid move you skip your turn doofus!");
            return true;
        }
    }

    public String DoMoveAsMagician(String move, Man manAttacking){
        if(manAttacking.hasMagicWand()){
            System.out.println(manAttacking.getName() + " is casting " + move + "!");
            int randomNum = (int)(Math.random() * ((3 - 0) + 3)) + 0;
            switch(randomNum){
                case 0:
                    move = "kick";
                    break;
                case 1:
                    move = "punch";
                    break;
                case 2:
                    move = "headbutt";
                    break;
                case 3:
                    move = "roar";
                    break;
            }
            System.out.println("Oh! " + manAttacking.getName() + " is casting " + move + " magic!");
            return move;
        } else {
            System.out.println(manAttacking.getName()+": 'I lost my magic wand. so I can't fight you.'");
            return move = "ilostmagicwand";
        }
    }
}

