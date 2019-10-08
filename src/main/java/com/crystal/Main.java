package com.crystal;

public class Main {

    public static void main(String[] args) {
        //User creates a Mike character, who is either Fighter or Magician.
        Character user = CharacterCreation.CreateCharacter();

        //Computer creates either Hercules the Fighter or Robert the Magician
        int randomNum = (int) (Math.random() * ((1 - 0) + 1)) + 0;
        Character opponent;
        switch (randomNum) {
            case 0:
                opponent = new Fighter("Hercules");
                break;
            case 1:
                opponent = new Magician("Robert");
                break;
            default:
                opponent = new Fighter("Hercules");
        }
        ManFight fight = new ManFight(user, opponent);
        fight.startFight();
    }
}
