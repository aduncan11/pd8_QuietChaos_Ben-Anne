import java.io.*;
import java.util.*;

public class Driver{

    /*
      PURPOSE: brings together all other class of game
      CONTAINS: main class, with the storyline queue and appropriate characters
     */

    public static void main(String[] Args){
	//variables for the whole game:
	LinkedList<StoryBit> story=new LinkedList<StoryBit>();
	UserCharacter user=new UserCharacter();

	//construct the queue (this can later be made more elaborate):
	for(int x=0;x<1;x++){
	    StoryBit next=new SocialStory();
	    story.add(next);
	}
	
	//traverse through queue and run the story...
	while(story.peek()!= null){
	    StoryBit next=story.remove(); //get the next part of the story!
	    next.run(user);//run that part with the user as the input character!
	}
	
	System.out.println("Game over.");
    }
}