package com.crystal;

public class Main {

	public static void main(String[] args) {
	Man Mike = CharacterCreation.CreateCharacter();
	Man Hercules = new Man("Hercules");
	Man Robert = new Man("Robert", "Magician");

	int randomNum = (int)(Math.random() * ((1 - 0) + 1)) + 0;
	switch(randomNum){
		case 0:
			ManFight mikeAndHercules = new ManFight(Mike, Hercules);
			mikeAndHercules.startFight();
			break;
		case 1:
			ManFight mikeAndRobert = new ManFight(Mike, Robert);
			mikeAndRobert.startFight();
			break;
		}
    }
}
