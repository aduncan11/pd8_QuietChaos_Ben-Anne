import java.io.*;
import java.util.*;

public class UserCharacter extends Character{

    private Character _loveInterest;
    private PriorityQueue<ComputerCharacter> _friends;
    private Scanner scan;

    public UserCharacter (int i) {
	//just a dud for testing
    }

    public UserCharacter() {
	super();

	 scan=new Scanner(System.in);
	//var name input
	 System.out.println ("What is your name?");
	String input="";
	while(input.equals("")){
	    input=scan.nextLine().trim();
	}
    
	super.setName (input);

	System.out.println ("What is your gender?   (male or female)");
	input = "";
	while (!(input.equals("male") || input.equals ("female"))) {
	    input = scan.nextLine().trim();
	}
	delay(0.5);
	    super.setGender(input);
    
	_loveInterest = null;
	_friends = new PriorityQueue <ComputerCharacter> ();

	System.out.println ("Students at this school have three main characteristics that they try to balance - Their social status, their grades, and how much sleep they can get. Jocks have very good social status but bad grades. Nerds have good grades but bad social skills. Narcoleptics have a lot of sleep but bad social status.");
	delay();

	System.out.println ("What is your status as a student? \n Type (1) for Jock, (2) for Nerd, and (3) for Narcoleptic");

	input = "";
	while (!(input.equals ("1")) || (input.equals ("2")) || (input.equals ("3"))) {
	    input = scan.nextLine().trim();
	}
	delay(0.5);
	    if (input.equals ("1")) {
		super._grades = 1;
		super._socialLife = 5;  
		super._sleep= 5;
	    }
	    else {
		if (input.equals ("2")) {
		    super._grades = 4;
		    super._socialLife = 1;  
		    super._sleep= 5;		     
		}
		else {
		    super._grades = 2;
		    super._socialLife = 2;  
		    super._sleep= 10;
		}
	    }

	    printStats();

	    System.out.println(((char) 27)+"[2J");

    }

    public void printStats(){
	System.out.println("Starting Stats:");
	delay(1.0);
	System.out.println("Grades: " + super._grades +" out of 4.0");
	delay(1.0);
	System.out.println("Social Life: "+super._socialLife+" out of 5");
	delay(1.0);
	System.out.println("Sleep Acquired: "+super._sleep+" out of 10 hours");
	delay(5.0);
    }

    public void sleep(){
	int change=(_sleep+10)/2;
	setSleep(change); //Susceptible to change
	System.out.println("Sleep change: "+change);
    }

    public void hangout() {
	ComputerCharacter c = _friends.peek();
	System.out.println ("You hang out with " + c.getName() + ".");
	super.setSocialLife(5); 
	System.out.println ("You raised your social life by 5 points!");
    }

    // ----------------------------------- Setter Methods
    public void makeFriend(ComputerCharacter c) {
	super.setSocialLife(c.getSocialLife());
	_friends.add(c);
	System.out.println("Friend added: "+c.getName());
    }
    
    public void getTestScore(int x){
    	setGrades((super._grades+x+1)/2);
	System.out.println("Your average is now "+super._grades);
    }

    //---------------------------Acccesor Methods
    public ComputerCharacter getFriend() {
	return _friends.peek();
    }


    //------------------------------- Delay Methods!
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

}
