import java.io.*;
import java.util.*;

public class SocialStory extends StoryBit{

    public void run(UserCharacter user){ 
	int social=0; 
	ComputerCharacter[] friends = new ComputerCharacter[5];
	for(int x=0;x<friends.length;x++){
	    friends[x]=user.getFriend();
	}
	int randfriend = (int)Math.random()*5*10;
	ComputerCharacter friend = friends[randfriend];
	System.out.println("Your friend" + friend.getName() + "needs help with a problem...");
	System.out.println("Hey, " +user.getName()+" Can you help me out with something?");
	System.out.println("yes or no");
	Scanner scan=new Scanner(System.in);
	//var name input
	String input="";
	while(!(input.equals("yes"))&&(!(input.equals("no")))){
	    input+=scan.nextLine().trim();
	}
	if(input.equals("yes")){
	    social++;
	    String n1="";
	    String n2="";
	    if(friend.getGender().equals("male")){
		n1="Julie";
		n2="Cindy";
	    }
	    else{
		n1="Kevin";
		n2="Brandon";
	    }
	    System.out.println("Great! So, JProm is tomorrow and I don't have a date, but " +n1+ " asked me if I wanted to go with zhim, but I told zhim I would have to think about it because I don't know if zhe likes me or if just wanted to go with me, and I don't know if " +n2+ " is going to ask me tomorrow. What should I do?? ...");
	    System.out.println("1. Go with "+n1);
	    System.out.println("2. Go with "+n2);
	    System.out.println("3. Go alone.");
	    System.out.println("4. Don't go.");
	    System.out.println("5. Come with me! I'm going with a group.");
	    System.out.println("(1,2,3,4, or 5)");
	    input="";
	    while(!(input.equals("1"))&&(!(input.equals("2")))&&(!(input.equals("3")))&&(!(input.equals("4")))&&(!(input.equals("5")))){
		input+=scan.nextLine().trim();
	    }
	    if( input.equals("1") || input.equals("2")){
		social--;
	    }
	    else if( input.equals("5")){
		social++;
	    }
	}
	else{
	    social--;
	    System.out.println("Wow. Way to be rude. ...");
	    System.out.println("1. Sorry! I'm on my way to class right now! Call me later.");
	    System.out.println("2. I really just don't care.");
	    input="";
	    while(!(input.equals("1") || input.equals("2"))){
		input+=scan.nextLine().trim();
	    }
	    if( input.equals("1")){
		social++;
	    }
	    else if( input.equals("5")){
		social--;
	    }
	}
	System.out.println("Social status change: "+social);
	user.hangout(friend,social);
    }
}
