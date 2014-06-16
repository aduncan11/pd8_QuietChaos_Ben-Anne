import java.io.*;
import java.util.*;

public class DecisionStory extends StoryBit{

    private UserCharacter user;

    public DecisionStory(UserCharacter u){
	user=u;
    }

    public static void delay(double waitTime) {
	try {
	    Thread.sleep ((int)waitTime*1000);
	}
	catch (Exception e) {
	}
	System.out.println();
    
    }

    public static void delay() {
        try {
            Thread.sleep (4000);
        }
        catch (Exception e) {
        }
        System.out.println();
    }


    public void run(){
	System.out.println("You have the afternoon off. What would you like to do? (sleep, study, or hang out)");
	Scanner scan=new Scanner(System.in);
	String input="";
	while(!(input.equals("sleep")||input.equals("study")||input.equals("hang out"))){
	    input=scan.nextLine().trim();
	}

	if(input.equals("sleep")){
	    user.sleep();
	    delay();
	    System.out.println("Current sleep level: "+user.getSleep());
	    delay();
	}
	else if(input.equals("study")){
	    user.getTestScore(user.getGrades()+1);
	    delay();
	}
	else{
	    if(user.getFriend()==null){
		ComputerCharacter newFriend = new ComputerCharacter();
		user.makeFriend(newFriend);
		delay();
	    }
	    user.hangout();
	    delay();
	}
    }

}

