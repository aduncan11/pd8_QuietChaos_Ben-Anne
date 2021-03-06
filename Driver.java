import java.io.*;
import java.util.*;
import java.lang.Math;

public class Driver{

    /*                                                                                                         
      PURPOSE: brings together all other class of game                                                         
      CONTAINS: main class, with the storyline queue and appropriate characters                                
     */

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


    public static void main(String[] Args){
        //INTRO                                                                                                
         System.out.println(((char) 27)+"[2J");

        System.out.println("Welcome to Surviving Stuyvesant High School! Ben and Anne here.");
        delay(1.0);
        System.out.println("We could ask you for your name, but that can wait. For now we will call you Stan."
);
        delay();
        System.out.println("Well, Stan, we hear you are a student at Stuyvesant High School, and while you are an upperclassman taking classes like APCS, and attending glamorous galas like JProm, you are still a little confused on how to handle this whole... school thing.");
        delay(4.0);
        System.out.println("You don't have your life all figured out? Stan, where have you been all this time?");
        delay(4.0);
        System.out.println("Well, do not worry. Stan, my man, you can still be on the path to success if you are careful to balance your priorities and never get less than a 95 on any test. Easy!");
        delay(4.0);
        System.out.println("Most importantly, Stan, make sure to follow prompt instructions carefully, especially in regards to capitalization.");
        delay(4.0);
        System.out.println("Pay attention, and take advantage of long pauses we give you, Stan, because the current screen will disappear between scenes. Don't miss the information as it comes up!");
        delay(4.0);
        System.out.println("See you on the other side, Stan... if you make it...(Cue Indiana Jones themesong. https://www.youtube.com/watch?v=lOL3NShi5fU \n This is required to continue. Otherwise you will surely fail.");
        delay(4.0);
        System.out.println("Hit enter to continue");
           Scanner sc=new Scanner(System.in);
        String input="nothing";
        while(input.length()>0){
            input=sc.nextLine().trim();
        }

	
	System.out.println(((char) 27)+"[2J");

       
        //SETUP                                                                                                

        //variables for the whole game:                                                                        
        LinkedList<StoryBit> story=new LinkedList<StoryBit>();
        UserCharacter user=new UserCharacter();

	Random rand = new Random();


        ArrayList<StoryBit> storyBits = new ArrayList<StoryBit>();
        storyBits.add(new SchoolStory(user));
        storyBits.add(new DecisionStory(user));
        storyBits.add(new SocialStory(user));
        storyBits.add(new DressingUp(user));
        storyBits.add(new SchoolStory(user));
        storyBits.add(new DecisionStory(user));
        storyBits.add(new Fencing(user));
        storyBits.add(new DecisionStory(user));
        storyBits.add(new SchoolStory(user));
	storyBits.add(new Fencing(user));
        storyBits.add(new DressingUp(user));

	for(int x=0;x<11;x++){
            int randBit=rand.nextInt(11 - x);

	    story.add(storyBits.get(randBit));
	    storyBits.remove(randBit);

        }

        //traverse through queue and run the story...                                                          
        while(story.peek()!= null){
            StoryBit next=story.remove(); //get the next part of the story!                                    
            next.run();//run that part with the user as the input character!                                   
	  
            System.out.println(((char) 27)+"[2J"); //Clear scree

	                                         
            user.printStats();

            System.out.println("Hit enter to continue");

            input="nothing";
            while(input.length()>0){
                input=sc.nextLine().trim();
            }
        }

        System.out.println("Game over.");
        delay();
        System.out.println("Disengage Indiana Jones. Enter final countdown mode. \n"+"http://tinyurl.com/pgb2crl");
        delay();
	System.out.println("Hit enter");
        input="nothing";
        while(input.length()>0){
            input=sc.nextLine().trim();
        }
        user.printStats();

        if(user.getSocialLife()>3){
            if(user.getSleep()>8){
                if(user.getGrades()>3){

                    System.out.println("Congrats! Stan-- err, we mean "+user.getName()+" you have won due to your genetic superiority.");
                    delay();
                    System.out.println("You have not only survived Stuyvesant High School, but you have succeeded in balancing your sleep, social life, and grades.");
                    delay();
                    System.out.println("You are the impossible child.");
                    delay();
                    System.out.println("You are the chosen one.");
                    delay();
                }

                System.out.println("Your social life and grades were on point, Stan-- err, we mean "+user.getName()+" but your grades could use a little more studying. Better luck next time.");
                delay();

            }
            else if(user.getGrades()>3){
                System.out.println("Well, it looks like you never slept. This is probably a medical issue youwill want to deal with before playing again.");
                delay();
            }
            else{
                System.out.println("Yikes! All you did was socialize. Get on top of your priorities!");
                delay();
            }

        }
        else if(user.getSleep()>8){
            if(user.getGrades()>3){
                System.out.println("Well, Stan-- err, we mean "+user.getName()+"  you slept, and you did well in school, but you made no friends. Why you make no friends? Agh.");
                delay();
            }
            else{
                System.out.println("You can't only sleep if you want to survive high school!");
                delay();
            }
        }
        else if(user.getGrades()>3){
            System.out.println("All you did was study. What are you doing?? Get out of the house!");
            delay();
	}
        else{
            System.out.println("Okay, you really need to work on this. You didn't sleep. You didn't make any friends. You didn't even do well in school!");
            delay();
            System.out.println("Who are you? What are you doing? These are the panic-inducing questions you can face in college.");
            delay();
            System.out.println("Don't come back to high school.");
            delay();
        }
     
	System.out.println("The end");
	System.exit(0);
        }

    }

}
