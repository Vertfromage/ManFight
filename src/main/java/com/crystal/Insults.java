package com.crystal;

public class Insults {
/**
 This class has lists of insults of varying severity, insults should be effective against man and wizards,
 but not against monsters. Weak insult makes opponent laugh and improves health.
 */
int serverityOfInsult;
List<String> weakInsults;
List<String> meanInsults;
List<String> awesomeInsults;

// methods
// prints insult and returns severityOfInsult 
public static int sayInsult(){
    serverityOfInsult = (int)(Math.random()*3);
    System.out.println(pickInsult(serverityOfInsult));
    return serverityOfInsult;
}

// picks the insult randomly from list based on severity
public String pickInsult(int serverityOfInsult){
    
    switch(serverityOfInsult){
        case 0:
        return weakInsults.get((int)(Math.random*weakInsults.size()));
        case 1:
        return meanInsults.get((int)(Math.random*weakInsults.size()));
        case 2:
        return awesomeInsults.get((int)(Math.random*weakInsults.size()));
    }
}

/** Lists of insults - Try to limit to one liners */

// Childish insults that a child would say. 
weakInsults = Arrays.asList("You're a poo!", "You're mean.");

// Mean but keep it pg13. 
meanInsults = Arrays.asList("Is that your face or your ass?", 
"Do you want me to call your mom to pick you up before you get hurt?"  );

// Funny insults from movies, books, famous people. 
awesomeInsults = Arrays.asList("Your father smells like elderberries and your mother is related to hamsters.", 
"Thou art a boil, a plague sore, an embossed carbuncle in my corrupted blood.", "Villain, I have done thy mother!"  );
}

/** Insult's origin for reference:
"Your father smells like elderberries and your mother is related to hamsters." - Monty Python
“Thou art a boil, a plague sore, an embossed carbuncle in my corrupted blood.” - King Lear, Shakespeare
 */
