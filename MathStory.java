import java.io.*;
import java.util.*;

public class MathStory extends SchoolStory {

    ArrayList<String> questions = new ArrayList<String>();
    ArrayList<String> answers = new ArrayList<String>();

    public SchoolStory(){
	questions.add("15 * 3");
	answers.add("45");

	questions.add("112 - 80");
	answer.add("32");

	questions.add("Find x if (x-3)(x-2)(x)=0");
	answers.add("All of the above");
	
	questions.add("If x=sqrt(87), then...");
	answers.add("8 < x < 9");

	questions.add("195 / 3");
	answers.add("65");
	
    }

    public void run(UserCharacter user){
	score=0;

	Random rand = new Random ();
	int i = rand.nextInt(_testBank.size());
	String s = testBank.get(i);
	
	System.out.println(user.getName()+", can you help me out with something?");
	System.out.println("yes or no");
	Scanner scan=new Scanner(System.in);
	//var name input
	String input="";
	while(!(input.equals("yes"))&&(!(input.equals("no")))){
	    input+=scan.nextLine().trim();
	}
	if(input.equals("yes")){
	    
	    System.out.println(questions[1]);
	    System.out.prinln("1. 30");
	    System.out.println("2. 60");
	    System.out.prinln("3. "+answers[1]);
	    System.out.println("Type 1, 2, or 3.");
	    input="";
	    while(!(input.equals("1") || input.equals("2") || input.equals("3"))){
		input+=scan.nextLine().trim();
	    }
	    if(input.equals("3")) score+=20;

	    System.out.println(questions[2]);
	    System.out.println("1. 41");
	    System.out.println("2 "+answers[2]);
	    System.out.println("3. 30");
	    input="";
	    while(!(input.equals("1") || input.equals("2") || input.equals("3"))){
		input+=scan.nextLine().trim();
	    }
	    if(input.equals("2")) score+=20;

	    System.out.println(questions[3]);
	    System.out.println("1. 2");
	    System.out.println("2. 3");
	    System.out.println("3. 0");
	    System.out.println("4. "+answers[3]);
	    input="";
	    while(!(input.equals("1") || input.equals("2") || input.equals("3") ||input.equals("4"))){
		input+=scan.nextLine().trim();
	    }
	    if(input.equals("4")) score+=20;

	    System.out.println(questions[4]);
	    System.out.println("1. "+answers[4]);
	    System.out.println("2. 6 < x < 7");
	    System.out.println("3. 9 < x < 10");
	    input="";
	    while(!(input.equals("1") || input.equals("2") || input.equals("3"))){
		input+=scan.nextLine().trim();
	    }
	    if(input.equals("1")) score+=20;

	    System.out.println(questions[5]);
	    System.out.prinln("1. "+answers[1]);
	    System.out.println("2. 55");
	    System.out.println("3. 75");
	    input="";
	    while(!(input.equals("1") || input.equals("2") || input.equals("3"))){
		input+=scan.nextLine().trim();
	    }
	    if(input.equals("1")) score+=20;

	    user.setGrades(score*4/100);
	}
	if(input.equals("no")){
	    user.setSocial(-1);
	}

	
    }
    
}
