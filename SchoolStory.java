import java.io.*;
import java.util.*;
//import java.lang.Math;

public class SchoolStory extends StoryBit {
    
    /*To make sure we don't repeat questions*/
    protected CSStory _CompSciStory;
    protected MathStory _mathStory;
    protected HistoryStory _historyStory;
    //protected ScienceStory _scienceStory = new ScienceStory();

     UserCharacter user;

    public SchoolStory () {
	//This is so the subclasses can call this one without going into an infinite loop when constructed.
    }

    public SchoolStory (UserCharacter u) {
	user=u;
	_CompSciStory = new CSStory(user);
	_mathStory  = new MathStory(user);
	_historyStory  = new HistoryStory(user);
	//Can't think of if we need a specific constructor but here just in case
    }


    public void run(){

	System.out.println();  
    
    }
}
