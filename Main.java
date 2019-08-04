package com.crystal;

public class Main {

    public static void main(String[] args) {
	Man Mike = new Man("Mike");
	Man Hercules = new Man("Hercules");

	ManFight mikeAndHercules = new ManFight(Mike,Hercules);
    }
}
