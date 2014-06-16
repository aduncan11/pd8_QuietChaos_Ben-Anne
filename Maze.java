import java.io.*;
import java.util.*;
import java.awt.event.*;

class MazeSolver {

    private char[][] maze;
    private int h, w; //height, width of maze
    private boolean solved;
    private char theChosenOne;
    long currentTime, prevTime,timeChange;
    private String input;

 
    private char HERO =         '@';
    private char PATH =         '#';
    private char WALL =         ' ';
    private char EXIT =         '$';
    private char VISITED_PATH = '.';
    private char HISTORY = 'H';
    private char MATH = 'M';
    private char CS = 'C';


    private int x;
    private int y;

    private UserCharacter user;
    
    public MazeSolver( String inputFile, int _class, int prevClass, UserCharacter u ) { //Credit for this constructor goes to Mr. Brown who gave us this skeleton at the beginning of the year on our Maze Homework

	//Significance of dimensions? It's the same size as the terminal (Actually may be one bigger, terminal may be 80 by 24 --better safe than sorry) but this is so the whole maze can take up the terminal screen since we aren't creating a GUI.

	currentTime = System.currentTimeMillis();
	prevTime = System.currentTimeMillis();
	timeChange = 0;
	user = u;

	maze = new char[80][25];
	h = 0;
	w = 0;

	try {
	    Scanner sc = new Scanner( new File(inputFile) );

	    int row = 0;

	    while( sc.hasNext() ) {

		String line = sc.nextLine();

		if ( w < line.length() ) 
		    w = line.length();

		for( int i=0; i<line.length(); i++ )
		    maze[i][row] = line.charAt( i );

		h++;
		row++;
	    } 

	    for( int i=0; i<w; i++ )
		maze[i][row] = WALL;
	    h++;
	    row++;

	} catch( Exception e ) { System.out.println( "Error reading file" ); }


	solved = false;
	if (_class == 0) {
	    theChosenOne = 'C'; //So we know what is our final destination
	}
	else if (_class == 1) {
	    theChosenOne = 'H';
	}

	else if (_class == 2) {
	    theChosenOne = 'M';
	}

	if (prevClass == 0) {
	    x = 16;
	    y = 6;
	    maze[x][y] = HERO;
	    //Will add in position of A over here.
	}
	else if (prevClass == 1) {
	    x = 40;
	    y = 8;
	    maze[x][y] = HERO;
	}

	else if (prevClass == 2) {
	    x= 9;
	    y = 10;
	    maze [x][y] = HERO;
	   
	}

	else if (prevClass == 3) {
	    Random rand = new Random();
	      x = rand.nextInt(w);
	      y = rand.nextInt(h);

	     while (maze[x][y]!= PATH) {
		 x = rand.nextInt(w);
		 y = rand.nextInt(h);
	     }

	     maze[x][y] = HERO;
	}

	System.out.println ("You are about to take a journey to your next class. You are going to ________" + "\n");//(we need to just write this separately for each one).
	
	delay (2000);

	System.out.println("To move, use the w,a,s, and d keys. You must click enter after typing them for the computer to register your key stroke. Don't get lazy." + "\n");

	delay(3000);

	System.out.println ("What's what? The # characters are the hallway. Blankspaces are walls. C is computer science. H is history. M is math. Can you remember? I hope so for your sake!" + "\n");

	delay (3500);
	System.out.println ("You have 15 seconds to get to your next class. Good luck!");
	delay(3000);
    
    }//end constructor


    public String toString() {
	//send ANSI code "ESC[0;0H" to place cursor in upper left
	String retStr = "[0;0H";  
	//emacs shortcut: C-q, then press ESC
	//emacs shortcut: M-x quoted-insert, then press ESC
	// (alternatively, just copy and paste from this file...)

	int i, j;
	for( i=0; i<h; i++ ) {
	    for( j=0; j<w; j++ )
		retStr = retStr + maze[j][i];
	    retStr = retStr + "\n";
	}
	return retStr;
    }


    //helper method to keep try/catch clutter out of main flow
    private void delay( int n ) {
	try {
	    Thread.sleep(n);
	}
	catch( InterruptedException e ) {
	    System.exit(0);
	}
    }


    public void run() {

	prevTime = System.currentTimeMillis();

	Scanner scan = new Scanner (System.in);
	input = "";

	while(timeChange < 15000){
	    timeChange =System.currentTimeMillis() - prevTime;

	    input=scan.nextLine().trim();
	        
	    if (input.equals("w")) {
		moveUp();
	    }

	    if (input.equals("a")) {
		moveLeft();
	    }

	    if (input.equals( "s")) {
		moveDown();
	    }

	    if (input.equals("d")) {
		moveRight();
	    }

	    System.out.println(this);

	    if (solved) {
		System.out.println ("Congratulations! You have made it to class on time! Your GPA has gone up 1");
		user.setGrades (1);
		System.out.println ("Your GPA is now: " + user.getGrades());
		break;
	    }


	}

	if (!solved) {
	System.out.println ("Times up! You're late to class!");
	System.out.println("You're GPA has gone down one.");
	user.setGrade(-1);
	delay (500);
	System.out.println("Your GPA is now: " + user.getGrades());
	}
    }

	    	

    public void moveRight() {
	if (maze [x+1][y] == VISITED_PATH || maze [x+1][y] == PATH || maze [x+1][y] == theChosenOne) {

	    if (maze [x+1][y] == theChosenOne) {
		solved = true;
	    }

	    maze [x][y] = VISITED_PATH;
	    x = x + 1;
	    maze [x][y] = HERO;
	}
    }
	    
    public void moveUp(){
	if (maze [x][y-1] == VISITED_PATH || maze [x][y-1] == PATH || maze [x][y-1] == theChosenOne) {

	    if (maze [x][y-1] == theChosenOne) {
		solved = true;
	    }

	    maze [x][y] = VISITED_PATH;
	    y = y - 1;
	    maze [x][y] = HERO;

	    System.out.println (x + " " + y);
	}
    }

    public void moveLeft(){
	if (maze [x-1][y] == VISITED_PATH || maze [x-1][y] == PATH || maze [x-1][y] == theChosenOne) {

	    if (maze [x-1][y] == theChosenOne) {
		solved = true;
	    }

	    maze [x][y] = VISITED_PATH;
	    x = x - 1;
	    maze [x][y] = HERO;
	}
    }

    public void moveDown() {
	if (maze [x][y+1] == VISITED_PATH || maze [x][y+1] == PATH || maze [x][y+1] == theChosenOne) {

	    	if (maze [x][y+1] == theChosenOne) {
		    solved = true;
		}

	    maze [x][y] = VISITED_PATH;
	    y = y + 1;
	    maze [x][y] = HERO;
	}
    }



}//end class MazeSolver


/*
The maze that represents the school is called maze03.dat. The second variable will either be the number 0, 1, or 2. That will determine what class you are going to for this period. 0 is ComputerScience, 1 is History, 2 is math. The third variable will either be the number 0,1,2, or 3. That will determine what class you are coming from. 0 is Computer Science, 1 is History, 2 is Math, and 3 is for the first class of the day so you'll be put in randomly. 
*/


public class Maze {

    public static void main( String[] args ) {



	UserCharacter u = new UserCharacter(1);

	MazeSolver ms = new MazeSolver ("maze03.dat",0,3,u);

     

	//clear screen
	System.out.println( "[2J" ); 

	//display maze 

	System.out.println(ms); //Reveal the maze for the first time

	ms.run(); //Journey through the maze

    }

}//end class Maze
