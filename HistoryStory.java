import java.io.*;
import java.util.*;
import java.lang.Math;

public class HistoryStory extends SchoolStory {

    public void run(UserCharacter user){
	int score=0;

	ArrayList<String> questions = new ArrayList<String>();
	ArrayList<String[]> answers = new ArrayList<String[]>();
	int[] key = new int[10];

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

	String[] choices ={"Washington", "Jackson", "Adams", "Obama"};
	answers.add(choices);
	String[] choices2={"FDR", "Nixon", "Hoover", "Theodore Roosavelt"};
	answers.add(choices2);
	String[] choices3={"integration of schools", "the spread of communism", "The decentralization of banks", "stricter regulation of federal government"};
	answers.add(choices3);
	String[] choices4={"communist propoganda", "selling missile secrets to the Soviets", "fraud", "illegal monopolization of the media industry"};
	answers.add(choices4);
	String[] choices5={"buying on credit", "the baby boom", "the success of farms", "increased importation from Germany"};
	answers.add(choices5);
	String[] choices6={"I, II, and III", "II", "I and II"};
	answers.add(choices6);
	String[] choices7={"it would drag America into another war", "it would antagonize the USSR", "Wilson had no points", "it would cause brinkmanship with Mexico"};
	answers.add(choices7);
	String[] choices8={"central banking", "private banks", "all banks", "Canada"};
	answers.add(choices8);
	String[] choices9={"a deeper economic recession", "inflation", "increased trade with Western Europe", "greater control over Cuba"};
	answers.add(choices9);
	String[] choices10={"the automobile industry", "city education", "public transportation", "the railroad"};
	answers.add(choices10);

	for(int x=0;x<questions.size();x++){
	    int qnum=(int)math.random()*11;
	    System.out.println(questions.get(qnum)+"\n");
	    for(int y=1;y<5;y++){
		int answerNum=(int)math.random()*5;
		System.out.println(y+". "+answers.get(answerNum)+"\n");
		if(answerNum == 0) key[x]=y;
	    }
	    Scanner scan=new Scanner(System.in);
	    String input="";
	    while(!(input.equals("1")||input.equals("2")||input.equals("3")||input.equals("4"))){
		input+=scan.nextLine().trim();
	    }
	    if(Integer.getInt(input)==key[x]) score++;
	}
    }
}