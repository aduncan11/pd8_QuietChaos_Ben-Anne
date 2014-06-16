import java.io.*;
import java.util.*;
import java.lang.Math;

public class DressingUp extends StoryBit{

    private ArrayList<String> questions;
    private ArrayList<String[]> answers;
    private int[] key;
    private long currTime;
    private long prevTime;

    UserCharacter user;

    public DressingUp(UserCharacter u){
	
	user=u;

	currTime=System.currentTimeMillis();
	prevTime=currTime;

	questions=new ArrayList<String>();
	answers=new ArrayList<String[]>();

	//QUESTION 1
	questions.add("What is your headwear?");
        String[] choices1={"Fedora","Ratty cap","A broken feather","A fishnet"};
	answers.add(choices1);

	//QUESTION 2
	questions.add("Pants?");	
        String[] choices2={"Jeans","No pants (Who need 'em?)","A fishnet","Superman It (Underwear over your pants)"};
	answers.add(choices2);

	//QUESTION 3
	questions.add("You seem tired. What shirt do you want?");
        String[] choices3={"Fancy Shirt","A fishnet","Stained T-Shirt","Ten Sweaters (You can never go wrong with sweaters)"};
	answers.add(choices3);
	
	//QUESTION 4
	questions.add("I'm not sure on this one, but I think you need to wear shoes. Right?");
        String[] choices4={"Nikes","A fishnet","Your really sexy sandals and socks look","Stan's famous Red Cowboy Boots"};
	answers.add(choices4);
	
	//QUESTION 5
	questions.add("Do you want to accesorize?");
        String[] choices5={"Gold Necklace","No","God No","A Fishnet"};
	answers.add(choices5);

	key=new int[5];
    }

    public void run(){
	int score=0;
	Random rand = new Random();
	boolean solved;

	for(int x=1;x<6;x++){
	    System.out.println(x+"/"+5+":");
	    delay();
	    solved = false;

	    int randQ=rand.nextInt(6-x);
	    System.out.println(questions.get(randQ));
	    delay();
	    
	    for(int y=1;y<5;y++){
		int randA=rand.nextInt(5-y);

        
		if(randA==0 && !solved) {
		    key[x-1]=y;
		    solved = true;
		}

		System.out.println(y+". "+answers.get(randQ)[randA]);

		String temp = answers.get(randQ)[4-y];
		answers.get(randQ)[4-y] = answers.get(randQ)[randA];
		answers.get(randQ)[randA] = temp;
		  

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

	    answers.remove(randQ);
	    questions.remove(randQ);
	    
	    System.out.println(((char) 27)+"[2J");
    
	}
    
	System.out.println("Score received: "+100.0*score/5.0);
	delay();

	user.setSocialLife (score - 2);

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
