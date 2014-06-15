import java.io.*;
import java.util.*;

public class Driver{
    
    /*
      PURPOSE: brings together all other class of game
      CONTAINS: main class, with the storyline queue and appropriate characters
     */

    public static void delay(double waitTime) {
	  try {
	      Thread.sleep ((int)waitTime*1000);
	  } 
	  catch (Exception e) {
	  }
	  System.out.println();
      } 

    public static void delay() {
	try {
	    Thread.sleep (2000);
	} 
	catch (Exception e) {
	}
	System.out.println();
    }

    public static void main(String[] Args){
	//INTRO
	 System.out.println(((char) 27)+"[2J"); 

	System.out.println("Welcome to Surviving Stuyvesant High School! Ben and Anne here.");
	delay();
	System.out.println("We could ask you for your name, but that can wait. For now we will call you Stan.");
	delay(4.0);
	System.out.println("Well, Stan, we hear you are a student at Stuyvesant High School, and while you are an upperclassman taking classes like APCS, and attending glamorous galas like JProm, you are still a little confused on how to handle this whole... scool thing.");
	delay(4.0);
	System.out.println("You don't have your life all figured out? Stan, where have you been all this time?");
	delay(4.0);
	System.out.println("Well, do not worry. Stan, my man, you can still be on the path to success if you are careful to balance your priorities and never get less than a 95 on any test. Easy!");
	delay(4.0);
	System.out.println("Most importantly, Stan, make sure to follow prompt instructions carefully, especially in regards to capitalization.");
	delay(4.0);
	System.out.println("Pay attention, and take advantage of long pauses we give you, Stan, because the current screen will disappear between scenes. Don't miss the information as it comes up!");
	delay(4.0);
	System.out.println("See you on the other side, Stan... if you make it...(Cue Indiana Jones themesong. https://www.youtube.com/watch?v=lOL3NShi5fU \n This is required to continue. Otherwise you will surely fail.");
	delay(4.0);
	System.out.println("Hit enter to continue");

	Scanner sc=new Scanner(System.in);
	String input="nothing";
	while(input.length()>0){
	    input=sc.nextLine().trim();
	}

	System.out.println(((char) 27)+"[2J"); 

	//variables for the whole game:
	LinkedList<StoryBit> story=new LinkedList<StoryBit>();
	UserCharacter user=new UserCharacter();

	//construct the queue (this can later be made more elaborate):
	for(int x=0;x<1;x++){
	    StoryBit next=new SocialStory(user);
	    story.add(next);
	}
	
	//traverse through queue and run the story...
	while(story.peek()!= null){
	    StoryBit next=story.remove(); //get the next part of the story!
	    next.run();//run that part with the user as the input character!
	}
	
	System.out.println("Game over.");
    }
}
