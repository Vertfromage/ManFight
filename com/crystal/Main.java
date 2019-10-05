package com.crystal;

public class Main {

	public static void main(String[] args) {
	Man Mike = new Man("Mike");
	Man Hercules = new Man("Hercules");
	Man Robert = new Man("Robert", "Magician");

    int randomNum = (int) ((Math.random() * ((1) + 1)) + 0);
	switch(randomNum){
		case 0:
      new ManFight(Mike, Hercules);
			break;
		case 1:
      new ManFight(Mike, Robert);
			break;
		}
    }
}

