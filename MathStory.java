import java.io.*;
import java.util.*;
import java.lang.Math;

public class MathStory extends SchoolStory {

    ArrayList<String> questions;
    ArrayList<String[]> answers;
    int[] key;

    public MathStory(){
	questions=new ArrayList<String>();
	answers=new ArrayList();
	key=new int[5];

	//QUESTION 1
	questions.add("15 * 3");

	ArrayList<String> choices1 = new ArrayList<String>();
	choices.add("45");
	choices.add("30");
	choices.add("60");
	choices.add("75");

	answers.add(choices1);

	//QUESTION 2
	questions.add("112 - 80");
	
	ArrayList<String> choices2=new ArrayList<String>();
	choices2.add("32");
	choices2.add("41");
	choices2.add("30");
	choices2.add("62");

	answers.add(choices2);

	//QUESTION 3
	questions.add("Find x if (x-3)(x-2)(x)=0");
        
	ArrayList<String> choices3=new ArrayList<String>();
	
	choices3.add("All other choices");
	chocies3.add("2");
	choices3.add("3");
	choices3.add("0");

	answers.add(choices3);
	
	//QUESTION 4
	questions.add("If x=sqrt(87), then...");

	ArrayList<String> choices4=new ArrayList<String>();
	choices4.add("8 < x < 9");
	choices4.add("6 < x < 7");
	choices4.add("5 < x < 6");
	choices4.add("9 < x < 10");

	answers.add(choices4);

	//QUESTION 5
	questions.add("195 / 3");

	ArrayList<String> choices5= new ArrayList<String>();
	choices5.add("65");
	choices.add("55");
	choices.add("75");
	choices.add("85");

	answers.add(choices5);

	key=new int[5];
	
    }

    public void run(UserCharacter user){
	int score=0;
	
	for(int x=0;x<5;x++){
	    int randomQ=(int)Math.random()*6;
	    System.out.println(answers.get(randomQ));
	    for(int y=0;y<4;y++){
		int randomA=(int)Math.random()*5;
		System.out.println(randomA+". "+answers.get(randomQ).get(randomA));
		if(randomA==1) key[x]=y;
		answers.get(randomQ).remove(randomA);
	    }

	    Scanner scan=new Scanner(System.in);
            String input="";
            while(!(input.equals("1")||input.equals("2")||input.equals("3")||input.equals("4"))){
                input+=scan.nextLine().trim();
            }
            if(Integer.parseInt(input)==key[x]) score++;
	    questions.remove(randomQ);
	    answers.remove(randomQ);
        }

	user.getTestScore(4*score/5);
    }
    
}
