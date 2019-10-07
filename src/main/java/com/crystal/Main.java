package com.crystal;

public class Main {

    public static void main(String[] args) {
        //User creates a Mike character, who is either Fighter or Magician.
        Man user = CharacterCreation.CreateCharacter();

        //Computer creates either Hercules the Fighter or Robert the Magician
        int randomNum = (int) (Math.random() * ((1 - 0) + 1)) + 0;
        Man opponent;
        switch (randomNum) {
            case 0:
                opponent = new Man("Hercules", ManClass.FIGHTER);
                break;
            case 1:
                opponent = new Man("Robert", ManClass.MAGICIAN);
                break;
            default:
                opponent = new Man("Hercules", ManClass.FIGHTER);
        }
        ManFight fight = new ManFight(user, opponent);
        fight.startFight();
    }
}
