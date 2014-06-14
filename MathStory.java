import java.io.*;
import java.util.*;
import java.lang.Math;

public class MathStory extends SchoolStory {

    ArrayList<String> questions = new ArrayList<String>();
    ArrayList<String[]> answers = new ArrayList<String[]>();
    int[] key;

    public MathStory(){
	questions.add("15 * 3");
	String[] choices1 = {"45", "30", "60", "75"};
	answers.add(choices1);

	questions.add("112 - 80");
	String[] choices2={"32", "41", "30", "62"};
	answers.add(choices2);

	questions.add("Find x if (x-3)(x-2)(x)=0");
        String[] choices3={"All other choices", "2", "3", "0"};
	answers.add(choices3);
	
	questions.add("If x=sqrt(87), then...");
	String[] choices4={"8 < x < 9", "6 < x < 7", "5 < x < 6", "9 < x < 10"};
	answers.add(choices4);

	questions.add("195 / 3");
	String[] choices5={"65", "55", "75", "85"}
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
		System.out.println(randomA+". "+answers.get(randomQ)[randomA]);
		if(randomA==1) key[x]=y;
	    }

	    Scanner scan=new Scanner(System.in);
            String input="";
            while(!(input.equals("1")||input.equals("2")||input.equals("3")||input.equals("4"))){
                input+=scan.nextLine().trim();
            }
            if(Integer.parseInt(input)==key[x]) score++;
        }

	user.getTestScore(4*score/5);
    }
    
}
