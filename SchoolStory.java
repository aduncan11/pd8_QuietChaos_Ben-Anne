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

	int lastClass = -1;

	System.out.println("Have you been to a class yet? 3 for no, 0 for Computer Science, 1 for History, 2 for Math. If you've taken more than one class, answer with your most recent class.");

	Scanner scan2 = new Scanner (System.in);
	String input2="";
	while (!(input2.equals ("1")) || (input2.equals ("2")) || (input2.equals ("3")) || (input2.equals ("0"))) {
	    input2 = scan2.nextLine().trim();
	}

	lastClass = Integer.parseInt(input2);
	

	System.out.println("You have gone to school. Which class would you like to attend? \n (math, history, or cs)");  
	//delay();
	
	Scanner scan = new Scanner(System.in);
	String input="";
	while(!(input.equals("history") || input.equals("math") || input.equals("cs"))){
	    input=scan.nextLine().trim();
	}
	if(input.equals("history")){
	    MazeSolver ms = new MazeSolver("maze03.dat", 1, lastClass, user);
	    //clear screen
	    System.out.println( "[2J" ); 

	    //display maze 

	    System.out.println(ms); //Reveal the maze for the first time

	    ms.run(); //Journey through the maze
	    nextClass=new HistoryStory(user);
	}

	else if(input.equals("cs")){
	    MazeSolver ms = new MazeSolver("maze03.dat", 0, lastClass, user);
	    //clear screen
	    System.out.println( "[2J" ); 

	    //display maze 

	    System.out.println(ms); //Reveal the maze for the first time

	    ms.run(); //Journey through the maze
	    nextClass=new CSStory(user);
	}
	
	else{
	    MazeSolver ms = new MazeSolver("maze03.dat", 2, lastClass, user);
	    //clear screen
	    System.out.println( "[2J" ); 

	    //display maze 

	    System.out.println(ms); //Reveal the maze for the first time

	    ms.run(); //Journey through the maze

	    nextClass=new MathStory(user);
	}
	
	System.out.println("Hit enter to continue.");
	Scanner sc=new Scanner(System.in);
	input="nothing";
	while(input.length()>0){
	    input=sc.nextLine().trim();
	}

	nextClass.run();

    }
}
