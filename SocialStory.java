import java.io.*;
import java.util.*;

public class SocialStory extends StoryBit{

    ComputerCharacter friend;
    UserCharacter user;
    final static String ESC = "\033[";

    public SocialStory(UserCharacter u){
	user=u;
	
	if(user.getFriend()==null){
	    friend=new ComputerCharacter();
	}
	else{
	    friend=user.getFriend();
	}

    }


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
    
    public void run(){ 
	int social=0; 

	System.out.println(friend.getName() + "needs help with a problem...");
	delay();
	System.out.println(friend.getName()+": Hey, " +user.getName()+" Can you help me out with something?");
	delay()
	System.out.println("(yes or no)");

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

	    delay();

	    System.out.print(ESC + "2J"); 

	    System.out.println("Great! So, JProm is tomorrow and I don't have a date, but " +n1+ " asked me if I wanted to go with zhim, but I told zhim I would have to think about it because I don't know if zhe likes me or if just wanted to go with me, and I don't know if " +n2+ " is going to ask me tomorrow. What should I do?? ...");
	    delay();

	    System.out.println("1. Go with "+n1);
	    delay();
	    
	    System.out.println("2. Go with "+n2);
	    delay();
	    
	    System.out.println("3. Go alone.");
	    delay();

	    System.out.println("4. Don't go.");
	    delay();
	    
	    System.out.println("5. Come with me! I'm going with a group.");
	    delay();

	    System.out.println("(1, 2, 3, 4, or 5)");

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

	    delay();
	    System.out.print(ESC + "2J"); 

	}

	else{
	    social--;
	    System.out.println("Wow. Way to be rude. ...");
	    delay();

	    System.out.println("1. Sorry! I'm on my way to class right now! Call me later.");
	    delay();

	    System.out.println("2. I really just don't care.");
	    delay();

	    System.out.println("(1 or 2)");

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

	    delay();

	    System.out.print(ESC + "2J"); 
	}

	System.out.println("Social status change: "+social);
	delay();

	user.hangout(friend,social);
	delay(5.0);

	System.out.print(ESC + "2J"); 

    }
}
