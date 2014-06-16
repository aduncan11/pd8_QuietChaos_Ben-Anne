import java.io.*;
import java.util.*;
import java.lang.Math;

public class HistoryStory extends SchoolStory {

    private ArrayList<String> questions;
    private ArrayList<String[]> answers;
    private int[] key;
    private long time;
    private UserCharacter user;

    public HistoryStory(UserCharacter u){
	user=u;

	time=System.currentTimeMillis();
  
        questions = new ArrayList<String>();
        answers = new ArrayList<String[]>();
        key = new int[10];

	//QUESTIONS
	questions.add("The first US president was");
	questions.add("The president whose time in office led to the 22nd Ammendment is");
	questions.add("The result of Brown v. Board of Education was");
	questions.add("The 'Hollywood Ten' were investigated for");
	questions.add("1920's consumer consumption was due to");
	questions.add("The Spanish American war led to US control of... \n I. Guam \n II. Puerto Rico \n III. The Philippines");
	questions.add("Senators feared entering The League of Nations because they believed");
	questions.add("Andrew Jackson distrusted...");
	questions.add("The Hawley-Smoot tariff led to");
	questions.add("The 1950's suburban growth promoted the growth of");

	//ANSWER 1
        String[] choices1 ={"Washington","Jackson","Adams","Obama"};
	answers.add(choices1);

	//ANSWER 2
	String[] choices2={"FDR","Nixon","Hoover","Theodore Roosevelt"};

	answers.add(choices2);

	//ANSWER 3
	String[] choices3={"integration of schools","the spread of communism","The decentralization of banks","stricter regulation of federal government"};

	answers.add(choices3);

	//ANSWER 4
	String[] choices4={"communist propoganda","selling missile secrets to the Soviets","fraud","illegal monopolization of the media industry"};

	answers.add(choices4);

	//ANSWER 5
        String[] choices5= {"buying on credit","the baby boom","the success of farms","increased importation from Germany"};

	answers.add(choices5);

	//ANSWER 6
        String[] choices6= {"I, II, and III","II","I and II", "III"};

	answers.add(choices6);

	//ANSWER 7
        String[] choices7= {"it would drag America into another war","it would antagonize the USSR","Wilson had no points","it would cause brinkmanship with Mexico"};

	answers.add(choices7);

	//ANSWER 8
        String[] choices8= {"central banking","private banks","all banks","Canada"};

	answers.add(choices8);

	//ANSWER 9
        String[] choices9={"a deeper economic recession","inflation","increased trade with Western Europe","greater control over Cuba"};

	answers.add(choices9);

	//ANSWER 10
        String[] choices10={"the automobile industry","city education","public transportation","the railroad"};

	answers.add(choices10);

    }

    public void run(){
	int score=0;

	for(int x=0;x<questions.size();x++){
	    System.out.println(x+"/"+questions.size()+":");
	    delay();

	    int qnum=(int)Math.random()*questions.size();
	    System.out.println(questions.get(qnum));
	    delay();
	    for(int y=1;y<5;y++){
		int answerNum=(int)Math.random()*(answers.get(qnum).length);
		if(answers.get(qnum)[answerNum]==null){
		    y--;
		   
		}
		else {
		System.out.println(y+". "+answers.get(qnum)[answerNum]);
		delay();
		if(answerNum == 0) key[x]=y;
		answers.get(qnum)[answerNum]=null;
		}
	    }
	    System.out.println("(1, 2, 3, or 4)" + "\n");
	    
	    time=System.currentTimeMillis();

	    System.out.println("You have 5 seconds.");
	    delay(0.5);

	    Scanner scan=new Scanner(System.in);
	    String input="";
	    long timeChange = 0;
	    while(!(input.equals("1")||input.equals("2")||input.equals("3")||input.equals("4")) && System.currentTimeMillis()-time<5000){
		input+=scan.nextLine().trim();
		timeChange=System.currentTimeMillis()-time;
		if (timeChange > 5000) {
		    System.out.println("Time's up!");
		    delay();
		    break;
		}
	    }

	    if(timeChange<5000){
		if(Integer.parseInt(input)==key[x]) score++;
	    }	       

	    questions.remove(qnum);
	    answers.remove(qnum);

	    System.out.println(((char) 27)+"[2J");
	}

	System.out.println("Score received: "+100.0*score/5.0);
	delay();

	user.getTestScore(4*score/10);

	System.out.println("Hit enter to continue.");
	Scanner sc=new Scanner(System.in);
	String input="nothing";
	while(input.length()>0){
	    input=sc.nextLine().trim();
	}
    }
}
