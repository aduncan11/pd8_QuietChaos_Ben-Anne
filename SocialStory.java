public class SocialStory extends StoryBit{

    public void run(Character c){
	int social=0;
	System.out.println("Your friend Veronica needs help with a problem...");
	System.out.println("Hey, " +c.getName()+" Can you help me out  with something?");
	System.out.println("yes or no");
	Scanner scan=new Scanner();
	//var name input
	if(input.equals("yes")){
	    social++;
	}
	else if(input.equals("no")){
	    social--;
	}
    }
	
}