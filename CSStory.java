import java.io.*;
import java.util.*;
import java.lang.Math;

public class CSStory{

    private ArrayList<String> questions;
    private ArrayList<ArrayList<String>> answers;
    private int[] key;

    public CSStory(){
	questions=new ArrayList<String>();
	answers=new ArrayList<ArrayList<String>>();

	//QUESTION 1
	questions.add("Process of creating a new object");
	
	ArrayList<String> choices1=new ArrayList<String>();
	choices1.add("instantiation");
	choices1.add("declaration");
	choices1.add("statement");
	choices1.add("valuation");
	
	answers.add(choices1);

	//QUESTION 2
	questions.add("Method that indicates how to create a new object)");
	
	ArrayList<String> choices2=new ArrayList<String>();
	choices2.add("constructor");
	choices2.add("abstract");
	choices2.add("void");
	choices2.add("static");
	
	answers.add(choices2);

	//QUESTION 3
	questions.add("A class that inherits characteristics from another class that is higher up in the heirarchy tree");
	
	ArrayList<String> choices3=new ArrayList<String>();
	choices3.add("subclass");
	choices3.add("superclass");
	choices3.add("interface");
	choices3.add("abstract");
	
	answers.add(choices3);
	
	//QUESTION 4
	questions.add("An error that causes the program to crash");
	
	ArrayList<String> choices4=new ArrayList<String>();
	choices4.add("runtime error");
	choices4.add("syntax error");
	choices4.add("compile-time error");
	choices4.add("logical error");
	
	answers.add(choices4);
	
	//QUESTION 5
	questions.add("A method invoking itself is called");
	
	ArrayList<String> choices5=new ArrayList<String>();
	choices5.add("recursion");
	choices5.add("incursion");
	choices5.add("traversal");
	choices5.add("iteration");
	
	answers.add(choices4);

	key=new int[5];
    }

    public void run(UserCharacter user){
	int score=0;

	for(int x=0;x<5;x++){
	    int randQ=(int)Math.random()*5;
	    System.out.println(questions.get(randQ));
	    
	    for(int y=0;y<4;y++){
		int randA=(int)Math.random()*4-y;
		System.out.println(y+". "+answers.get(x).get(randA));
		answers.get(x).remove(randA);
	    }
	    
	    Scanner scan=new Scanner(System.in);
	    String input="";
	    while(!(input.equals("1")||input.equals("2")||input.equals("3")||input.equals("4"))){
		input+=scan.nextLine().trim();
	    }
	    if(Integer.parseInt(input)==key[x]) score++;
	    answers.remove(randQ);
	    questions.remove(randQ);
    
	}
    
	user.getTestScore(score*4/5);
    }

}
