import java.io.*;
import java.util.*;
import java.lang.Math;

public class CSStory extends SchoolStory{

    private ArrayList<String> questions;
    private ArrayList<String[]> answers;
    private int[] key;
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
	questions.add("Method that indicates how to create a new object");	
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
	answers.add(choices5);

	key=new int[5];
    }

    public void run(){
	int score=0;
	boolean solved;
	Random rand = new Random();

	for(int x=1;x<6;x++){
	    solved = false;
	    System.out.println(x+"/"+5+":");
	    delay();

	    int randQ=rand.nextInt(6-x);;
	    System.out.println(questions.get(randQ));
	    delay();
	    
	    for(int y=1;y<5;y++){
		int randA= rand.nextInt(5-y);
	        
		if(randA==0 && !solved) {
		    key[x-1]=y;
		    solved = true;
		}
		System.out.println(y+". "+answers.get(randQ)[randA]);
		// super.delay();
		String temp = answers.get(randQ)[4-y];
		answers.get(randQ)[4-y] = answers.get(randQ)[randA];
		answers.get(randQ)[randA] = temp;
		}
		System.out.println("(1, 2, 3, or 4)"+"\n");
	    
	    
	    prevTime=System.currentTimeMillis();

	    System.out.println("You have 5 seconds.");
	    super.delay(0.5);
	    
	    long timeChange = 0;

	    Scanner scan=new Scanner(System.in);
	    String input="";
	    while(!(input.equals("1")||input.equals("2")||input.equals("3")||input.equals("4"))){
		input=scan.nextLine().trim();
		timeChange =System.currentTimeMillis() - prevTime;
		if (timeChange > 5000) {
		    System.out.println("Time's up!");
		    break;
		}
	    }
	    
	    if(timeChange<5000){
	        
		if(Integer.parseInt(input)==key[x-1]) score++;
	    }

	
	    answers.remove(randQ);
	    questions.remove(randQ);
	    
	    System.out.println(((char) 27)+"[2J");
    
	}
    
	System.out.println(score);
	System.out.println("Score received: "+100.0*score/10);
	delay();

	user.getTestScore(score*4/5);

	System.out.println("Hit enter to continue.");
	Scanner sc=new Scanner(System.in);
	String input="nothing";
	while(input.length()>0){
	    input=sc.nextLine().trim();
	}
    }

}
