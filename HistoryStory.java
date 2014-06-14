import java.io.*;
import java.util.*;
import java.lang.Math;

public class HistoryStory extends SchoolStory {

    ArrayList<String> questions;
    ArrayList<ArrayList<String>> answers;
    int[] key;

    public HistoryStory(){
        questions = new ArrayList<String>();
        answers = new ArrayList<ArrayListString>>>();
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
	ArrayList<String> choices1 =new ArrayList<String>();
	choices1.add("Washington");
	choices.add("Jackson");
	choices.add("Adams");
	choices.add("Obama");
	
	answers.add(choices1);

	//ANSWER 2
	ArrayList<String> choices2=new ArrayList<String>();
	choices2.add("FDR");
	choices2.add("Nixon");
	choices2.add("Hoover");
	choices2.add("Theodore Roosavelt");
	answers.add(choices2);

	//ANSWER 3
	ArrayList<String> choices3=new ArrayList<String>();
	choices.add("integration of schools");
	choices.add("the spread of communism");
	choices.add("The decentralization of banks");
	choices.add("stricter regulation of federal government");

	answers.add(choices3);

	//ANSWER 4
	ArrayList<String> choices4= new ArrayList<String>();
	choices4.add("communist propoganda");
	choices4.add("selling missile secrets to the Soviets");
	choices4.add("fraud");
	choices4.add("illegal monopolization of the media industry");

	answers.add(choices4);

	//ANSWER 5
	ArrayList<String> choices5= new ArrayList<String>();
	choices5.add("buying on credit");
	choices5.add("the baby boom");
	choices5.add("the success of farms");
	choices5.add("increased importation from Germany");

	answers.add(choices5);

	//ANSWER 6
	ArrayList choices6= new ArrayList<String>();
	choices6.add("I, II, and III");
	choices6.add("II");
	choices6.add("I and II");

	answers.add(choices6);

	//ANSWER 7
	ArrayList<String> choices7= new ArrayList<String>();
	choices7.add("it would drag America into another war");
	choices7.add("it would antagonize the USSR");
	choices7.add("Wilson had no points");
	choices7.add("it would cause brinkmanship with Mexico");

	answers.add(choices7);

	//ANSWER 8
	ArrayList<String> choices8= new ArrayList<String>();
	choices8.add("central banking");
	choices8.add("private banks");
	choices8.add("all banks");
	choices8.add("Canada");

	answers.add(choices8);

	//ANSWER 9
	ArrayList<String> choices9=new ArrayList<String>();
	choices9.add("a deeper economic recession");
	choices9.add("inflation");
	choices9.add("increased trade with Western Europe");
	choices9.add("greater control over Cuba");

	answers.add(choices9);

	//ANSWER 10
	ArrayList<String> choices10=new ArrayList<String>();
	choices10.add("the automobile industry");
	choices10.add("city education");
	choices10.add("public transportation");
	choices10.add("the railroad");

	answers.add(choices10);

    }

    public void run(UserCharacter user){
	int score=0;

	for(int x=0;x<questions.size();x++){
	    int qnum=(int)Math.random()*11;
	    System.out.println(questions.get(qnum));
	    for(int y=1;y<5;y++){
		int answerNum=(int)Math.random()*5;
		System.out.println(y+". "+answers.get(qnum)[answerNum]);
		if(answerNum == 0) key[x]=y;
		answers.get(qnum).remove(answerNum);
	    }
	    Scanner scan=new Scanner(System.in);
	    String input="";
	    while(!(input.equals("1")||input.equals("2")||input.equals("3")||input.equals("4"))){
		input+=scan.nextLine().trim();
	    }
	    if(Integer.parseInt(input)==key[x]) score++;
	    questions.remove(qnum);
	    answers.remove(qnum);
	}

	user.getTestScore(4*score/10);
    }
}
