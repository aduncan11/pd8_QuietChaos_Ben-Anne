import java.io.*;
import java.util.*;
//import java.lang.Math;

public class SchoolStory extends StoryBit {
    
    /*To make sure we don't repeat questions*/
    protected CSStory _CompSciStory;
    protected MathStory _mathStory;
    protected HistoryStory _historyStory;
    //protected ScienceStory _scienceStory = new ScienceStory();

     UserCharacter user;

    public SchoolStory () {
	//This is so the subclasses can call this one without going into an infinite loop when constructed.
    }

    public SchoolStory (UserCharacter u) {
	user=u;
	_CompSciStory = new CSStory(user);
	_mathStory  = new MathStory(user);
	_historyStory  = new HistoryStory(user);
	//Can't think of if we need a specific constructor but here just in case
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

	SchoolStory nextClass;

	System.out.println("You have gone to school. Which class would you like to attend? \n (math, history, or cs)");  
	//delay();
	
	Scanner scan = new Scanner(System.in);
	String input="";
	while(!(input.equals("history") || input.equals("math") || input.equals("cs"))){
	    input+=scan.nextLine().trim();
	}
	if(input.equals("history")){
	    nextClass=new HistoryStory(user);
	}

	else if(input.equals("cs")){
	    nextClass=new CSStory(user);
	}
	
	else{
	    nextClass=new MathStory(user);
	}
	
	System.out.println("Hit enter to continue.");
	input="nothing";
	while(input.length()>0){
	    input=sc.nextLine().trim();
	}

	nextClass.run();

    }
}
