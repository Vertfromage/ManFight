/* I am a complete beginner but wanted to help. I don't know if I have the skill to implement insults into manfight, 
but I can definitely add insults. I'm not sure if this is the best way to do this, but I think a string array would probably 
work best. 
My plan is to use an array and the random class from math to generate a random number which will be used to retrieve the insult stored in that array. 
--Steve T (Selsec). 
*/ 

//import the random class in order to generate a random number which will be used to retrieve the insult stored in that index of the array
import java.util.*;

public class Insults {
    int indexRef = 0; // will eventually be changed to the random number generated
    
    public String[] insultArray = new String[20]; // initialize the insult array and set the default value to 20
    
    // method to populate the array with insults      
    public void populateArray() {
        
        insultArray[0] = "Your mother was a hampster and your father smelt of elderberry!";
        insultArray[1] = "Villain, I have done thy mother!";
        insultArray[2] = "If I ever said anything to offend you, it was purely intentional.";
        insultArray[3] = "I'm really jealous of everyone that hasn't met you!";
        insultArray[4] = "The best part of you rolled down your mom's leg!";
        insultArray[5] = "Every time you talk I hear that sound that plays when Pacman dies.";
        insultArray[6] = "If I had a face like yours, I'd sue my parents.";
        insultArray[7] = "I’m jealous of people that don’t know you!";
        insultArray[8] = "If I wanted to kill myself I'd climb your ego and jump to your IQ!";
        insultArray[9] = "I don't know what makes you so stupid, but it really works.";
        insultArray[10] = "You obtuse piece of flotsam!";
        insultArray[11] = "You're a stuck up, half witted, scruffy looking nerf herder!";
        insultArray[12] = "Hey laser lips, you're mother was a snow-blower!";
        insultArray[13] = "Do hurry up. A hamster with a blunt penknife would do it quicker.";
        insultArray[14] = "If you had any more tawdry quirks, you could open up a Tawdry Quirk Shop.";
        insultArray[15] = "All right, I’ll confess… I confess you’re a bigger idiot than I thought you were!";
        insultArray[16] = "Some babies were dropped on their heads but you were clearly thrown at a wall!";
        insultArray[17] = "Please shut your mouth when you’re talking to me.";
        insultArray[18] = "They say opposites attract. I hope you meet someone who is good-looking, intelligent, and cultured.";
        insultArray[19] = "Why don't you slip into something more comfortable... like a coma.";
    }
    // insult getter method
    public String getInsult() {
        Random randomIndex = new Random(); // random object to create the index for the insult
        indexRef = randomIndex.nextInt(19); // generate random int between 0 and 19 for the array index
        String pulledInsult = insultArray[indexRef]; // store the pulled insult into a variable
        return pulledInsult;
    }
    
    public void Insults(){
       
    }
    
}