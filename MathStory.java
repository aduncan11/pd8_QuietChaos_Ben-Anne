import java.io.*;
import java.util.*;
import java.lang.Math;

public class MathStory extends SchoolStory {

    private ArrayList<String> questions;
    private ArrayList<String[]> answers;
    private int[] key;
    final static String ESC = "\033[";
    private long time;

    UserCharacter user;


    public MathStory(UserCharacter u){
	user=u;
	
	time=System.currentTimeMillis();

	questions=new ArrayList<String>();
	answers=new ArrayList();
	key=new int[5];

	//QUESTION 1
	questions.add("15 * 3");
	String[] choices1 = {"45","30","60","75"};
	answers.add(choices1);

	//QUESTION 2
	questions.add("112 - 80");
	String[] choices2={"32","41","30","62"};
	answers.add(choices2);

	//QUESTION 3
	questions.add("Find x if (x-3)(x-2)(x)=0");
        String[] choices3={"All other choices","2","3","0"};
	answers.add(choices3);
	
	//QUESTION 4
	questions.add("If x=sqrt(87), then...");
	String[] choices4={"8 < x < 9","6 < x < 7","5 < x < 6","9 < x < 10"};
	answers.add(choices4);

	//QUESTION 5
	questions.add("195 / 3");
        String[] choices5= {"65","55","75","85"};
	answers.add(choices5);

	key=new int[5];
	
    }

    public void run(){
	int score=0;
	
	for(int x=0;x<5;x++){
	    int randomQ=(int)Math.random()*6;
	    System.out.println(answers.get(randomQ));
	    for(int y=0;y<4;y++){
		int randomA=(int)Math.random()*(answers.get(randomQ).length);
		if(answers.get(randomQ)[randomA]==null){
		    y--;
		    break;
		}
		System.out.println(randomA+". "+answers.get(randomQ)[randomA]);
		if(randomA==1) key[x]=y;
		answers.get(randomQ)[randomA]=null;
	    }

	    System.out.println("You have 5 seconds.");

	    time=System.currentTimeMillis();
	    long change = 0;

	    Scanner scan=new Scanner(System.in);
            String input="";
            while(!(input.equals("1")||input.equals("2")||input.equals("3")||input.equals("4")) && System.currentTimeMillis()-time<5000){
                input+=scan.nextLine().trim();
		change=System.currentTimeMillis()-time;
            }

            if(change<5000){
		if(Integer.parseInt(input)==key[x]) score++;
	    }	    
	    else{
		System.out.println("Time's up!");
	    }
	    questions.remove(randomQ);
	    answers.remove(randomQ);
	    
	    System.out.print(ESC + "2J"); 
        }

	user.getTestScore(4*score/5);

	System.out.print(ESC + "2J"); 
    }
    
}
