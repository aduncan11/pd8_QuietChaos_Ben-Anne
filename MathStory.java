import java.io.*;
import java.util.*;
import java.lang.Math;

public class MathStory extends SchoolStory {

    private ArrayList<String> questions;
    private ArrayList<String[]> answers;
    private int[] key;
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
	Random rand = new Random();
	int score=0;
	boolean solved;
	
	for(int x=1;x<6;x++){
	    solved = false;
	    System.out.println(x+ "/" + 5 + " :");
	    int randomQ=rand.nextInt(6-x);
	    System.out.println(questions.get(randomQ));
	    delay();
	    for(int y=1;y<5;y++){
		int randomA=rand.nextInt(5-y);
		System.out.println(y+". "+answers.get(randomQ)[randomA]);
		if(randomA==0 && !solved) {
		    key[x-1]=y;
		    solved = true;
		}
	        String temp = answers.get(randomQ)[4-y];
		answers.get(randomQ)[4-y] = answers.get(randomQ)[randomA];
		answers.get(randomQ)[randomA] = temp;
	    }
	    
	    System.out.println("(1, 2, 3, or 4)"+"\n");

	    System.out.println("You have 5 seconds.");
	    delay(0.5);

	    time=System.currentTimeMillis();
	    long change = 0;

	    Scanner scan=new Scanner(System.in);
            String input="";
            while(!(input.equals("1")||input.equals("2")||input.equals("3")||input.equals("4"))){
                input=scan.nextLine().trim();
		change=System.currentTimeMillis()-time;
		if (change > 5000) {
		    System.out.println("Time's up!");
		    delay();
		    break;
		}
	    }

            if(change<5000){
		if(Integer.parseInt(input)==key[x-1]) score++;
	    }	    
	   
	    questions.remove(randomQ);
	    answers.remove(randomQ);
	    
	    System.out.println(((char) 27)+"[2J");
        }

	System.out.println("Score received: "+100.0*score/5.0 );
	delay();

	user.getTestScore(4*score/5);

	System.out.println("Hit enter to continue.");
	Scanner sc=new Scanner(System.in);
	String input="nothing";
	while(input.length()>0){
	    input=sc.nextLine().trim();
	} 
    }
    
}
