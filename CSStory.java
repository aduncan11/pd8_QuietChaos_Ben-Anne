import java.io.*;
import java.util.*;
import java.lang.Math;

public class CSStory extends SchoolStory{

    private ArrayList<String> questions;
    private ArrayList<String[]> answers;
    private int[] key;
    final static String ESC = "\033[";
    private long currTime;
    private long prevTime;

    UserCharacter user;

    public CSStory(UserCharacter u){
	
	user=u;

	currTime=System.currentTimeMillis();
	prevTime=currTime;

	questions=new ArrayList<String>();
	answers=new ArrayList<String[]>();

	//QUESTION 1
	questions.add("Process of creating a new object");
        String[] choices1={"instantiation","declaration","statement","valuation"};
	answers.add(choices1);

	//QUESTION 2
	questions.add("Method that indicates how to create a new object)");	
        String[] choices2={"constructor","abstract","void","static"};
	answers.add(choices2);

	//QUESTION 3
	questions.add("A class that inherits characteristics from another class that is higher up in the heirarchy tree");
        String[] choices3={"subclass","superclass","interface","abstract"};
	answers.add(choices3);
	
	//QUESTION 4
	questions.add("An error that causes the program to crash");
        String[] choices4={"runtime error","syntax error","compile-time error","logical error"};
	answers.add(choices4);
	
	//QUESTION 5
	questions.add("A method invoking itself is called");
        String[] choices5={"recursion","incursion","traversal","iteration"};
	answers.add(choices4);

	key=new int[5];
    }

    public void run(){
	int score=0;

	for(int x=0;x<questions.size();x++){
	    System.out.println(x+"/"+questions.size()+":");
	    delay();

	    int randQ=(int)Math.random()*questions.size();
	    System.out.println(questions.get(randQ));
	    delay();
	    
	    for(int y=0;y<4;y++){
		int randA=(int)Math.random()*(answers.get(randQ).length);
		if(answers.get(randQ)[randA]==null){
		    y--;
		}
		else{
		    if(randA==0) key[x]=y;
		    System.out.println(y+". "+answers.get(randQ)[randA]);
		    // super.delay();
		    answers.get(x)[randA]=null;
		}
		System.out.println("1, 2, 3, or 4"+"\n");
	    }
	    
	    prevTime=System.currentTimeMillis();

	    System.out.println("You have 5 seconds.");
	    super.delay(0.5);
	    
	    long timeChange = 0;

	    Scanner scan=new Scanner(System.in);
	    String input="";
	    while(!(input.equals("1")||input.equals("2")||input.equals("3")||input.equals("4"))){
		input+=scan.nextLine().trim();
		timeChange =System.currentTimeMillis() - prevTime;
		if (timeChange > 5000) {
		    System.out.println("Time's up!");
		    break;
		}
	    }
	    
	    if(timeChange<5000){
		if(Integer.parseInt(input)==key[x]) score++;
	    }

	    answers.remove(randQ);
	    questions.remove(randQ);
	    
	    System.out.print(ESC + "2J"); 
	    delay();
    
	}
    
	System.out.println("Score received: "+100.0*score/5.0);
	delay();

	user.getTestScore(score*4/5);
	delay(5.0);
    }

}
