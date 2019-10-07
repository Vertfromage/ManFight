package com.crystal;

import java.util.Scanner;

public class CharacterCreation {
	static Scanner kbd = new Scanner(System.in);
	
	public static Man CreateCharacter() {
		int choose;
		
		System.out.printf("Choose your class:%n"
				+ "1. Fighter%n"
				+ "2. Wizard%n");
		choose = kbd.nextInt();
		kbd.nextLine(); //clean buffer
		
		switch(choose) {

		case 1:
			return CreateFighter();
		case 2:
			return CreateWizard();
		}
		//In case the user doen't choose a valid option it creates a fighter.
		return CreateFighter();
	}
	
	private static Man CreateFighter() {
		return new Man(askForName());
	}
	
	private static Man CreateWizard() {
		return new Man(askForName(), "wizard");
	}
	
	private static String askForName() {
		String name;
		boolean sentinel = false;
		
		do {			
			System.out.println("Write the name of your character: ");
			name = kbd.nextLine();
			
			if(name.matches("[A-z]*")) {
				sentinel = true;
			}
			else {
				System.out.println("Invalid name. Character names only can have letters.");
			}
		}while(!sentinel);
		return name;
	}
}
