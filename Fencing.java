import java.io.*;
import java.util.*;
import java.lang.Math;

public class Fencing extends StoryBit{

    private ArrayList<String> Scenarios;
    private ArrayList<String[]> Choices;
    private int[] key;
    private long currTime;
    private long prevTime;

    UserCharacter user;

    public Fencing (UserCharacter u){
	
	user=u;

	currTime=System.currentTimeMillis();
	prevTime=currTime;

	Scenarios=new ArrayList<String>();
	Choices=new ArrayList<String[]>();

	//QUESTION 1
	Scenarios.add("Your opponent lunges at you");
        String[] choices1={"Parry","Get hit","An arrow flys through the window. You take it to your knee","He disarms you"};
	Choices.add(choices1);

	//QUESTION 2
	Scenarios.add("You notice an opening to your opponents left");	
        String[] choices2={"Take it","Cry","Do the Armadillo","Manage to stab yourself"};
	Choices.add(choices2);

	//QUESTION 3
	Scenarios.add("Your opponent drops his sword");
        String[] choices3={"ATTACK!!!","Pick it up for him","Realize that he's your long lost brother and walk off slowly into the sunset together","Trip and impale yourself on your sword"};
	Choices.add(choices3);
	
	//QUESTION 4
	Scenarios.add("Quick! Dodge the attack!");
        String[] choices4={"Successfully avoid the blow","Get trapped in a fishnet","Get stabbed","Lose an ear (Your left one)"};
	Choices.add(choices4);


	key=new int[4];
    }

    public void run(){
	int score=0;
	boolean solved;
	Random rand = new Random();

	for(int x=1;x<5;x++){
	    solved = false;
	    System.out.println(x+"/"+4+":");
	    delay();

	    int randQ=rand.nextInt(5-x);
	    System.out.println(Scenarios.get(randQ));
	    delay();
	    
	    for(int y=1;y<5;y++){
		int randA=rand.nextInt(5-y);
	        
		if(randA==0 && !solved) {
		    key[x-1]=y;
		    solved = true;
		}
		    System.out.println(y+". "+Choices.get(randQ)[randA]);
		 String temp = Choices.get(randQ)[4-y];
		Choices.get(randQ)[4-y] = Choices.get(randQ)[randA];
		Choices.get(randQ)[randA] = temp;
	    }
		System.out.println("(1, 2, 3, or 4)"+"\n");
	
	    
	    prevTime=System.currentTimeMillis();

	    System.out.println("You have 5 seconds.");
	    delay(0.5);
	    
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

	    Choices.remove(randQ);
	    Scenarios.remove(randQ);
	    
	    System.out.println(((char) 27)+"[2J");
    
	}
    
	System.out.println("Score received: "+100.0*score/4.0);
	delay();

	user.setSocialLife (score - 2);
	if (score > 2) {
	    System.out.println ("Your social life improved by " + (score -2) + " points!");
	}

	else {
	    System.out.println("Your social life changed by " + (score - 2) + " points!");
	}

	delay();

	System.out.println("Your SocialLife is now " + user.getSocialLife());
	delay();

	System.out.println("Hit enter to continue.");
	Scanner sc=new Scanner(System.in);
	String input="nothing";
	while(input.length()>0){
	    input=sc.nextLine().trim();
	}
    }


     public static void delay() {try {Thread.sleep (2000);} catch (Exception e) {}} 

    public static void delay(double waitTime) {try {Thread.sleep ((int)waitTime*1000);} catch (Exception e) {}} 

}
