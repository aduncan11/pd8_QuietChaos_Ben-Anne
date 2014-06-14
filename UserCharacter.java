import java.io.*;
import java.util.*;

public class UserCharacter extends Character{

    private Character _loveInterest;
    private PriorityQueue<ComputerCharacter> _friends;
    private Scanner scan;

    public UserCharacter () {
	super();

	 scan=new Scanner(System.in);
	//var name input
	 System.out.println ("What is your name?");
	String input="";
	while(input.equals("")){
	    input+=scan.nextLine().trim();
	}
    
	super.setName (input);

	System.out.println ("What is your gender?   (male or female - CAPS MATTER)");
	input = "";
	while ((!input.equals("male")) || (!input.equals ("female"))) {
	    input += scan.nextLine().trim();
	}
	    super.setGender(input);
    
	_loveInterest = null;
	_friends = new PriorityQueue <ComputerCharacter> ();

	System.out.println ("Students at this school have three main characteristics that they try to balance - Their social status, their grades, and how much sleep they can get. Jocks have very good social status but bad grades. Nerds have good grades but bad social skills. Narcoleptics have a lot of sleep but bad social status.");

	System.out.println ("What is your status as a student? - Type (0) for Jock, (1) for Nerd, and (2) for Narcoleptic");

	input = "";
	while ((!input.equals ("1")) || (!input.equals ("2")) || (!input.equals ("3"))) {
	    input += scan.nextLine().trim();
	}
	    if (input.equals ("0")) {
		super._grades = 1;
		super._socialLife = 5;  
		super._sleep= 5;
	    }
	    else {
		if (input.equals ("1")) {
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
    }

    public void sleep(){
	_sleep = _sleep + 5; //Susceptible to change
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
    }
    
    public void getTestScore(int x){
    	super._grades=(super._grades+x)/2;
	System.out.println("Your average is now "+super._grades);
    }

    //---------------------------Acccesor Methods
    public ComputerCharacter getFriend() {
	return _friends.peek();
    }
}
