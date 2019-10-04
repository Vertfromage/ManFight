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
        System.out.println("You may punch, kick, or headbutt!");
        System.out.println("Type 'quit' to exit.");

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
        if (move.equals("kick"))
           return manAttacking.kick(manBeingAttacked);


        else if (move.equals("punch"))
            return manAttacking.punch(manBeingAttacked);




         else if (move.equals("headbutt"))
             return manAttacking.headbutt(manBeingAttacked);



         else {
            System.out.println(move + " is not a valid move you skip your turn doofus!");
            return true;
        }
    }
}

