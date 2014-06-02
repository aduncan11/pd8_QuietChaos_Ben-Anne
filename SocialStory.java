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

//We will clean this up


	Scanner scanner = (new Scanner(System.in)).useDelimiter(" ");
	while (!(scanner.hasNext())) {} //waits for input	    
	System.out.println("Press Ctrl + C to quit at any time.");
	scanner = new Scanner(System.in); //intentional, to clear any input from the previous scanner instance
	Character player = new Character (); //base player
	Character opponent = new Character (); //base opponent
	//Name
	System.out.print("Enter name: ");
	boolean input = false; //method to check input here is slightly different when actually looking for a specific input, rather than simply any input at all. Is there a more efficient method to do this?
	String name = "";
	while (!input) {
	    name = (scanner.nextLine()).trim();
	    if (!(name.equals(""))) {input = true;}
	}
	System.out.println(player.setBoldText + "Your name is " + name + "!" + "\n" + player.setPlainText); //Makes it bold
	//Class
	System.out.print("Select a class (0 - Random, 1 - Warrior, 2 - Wizard, 3 - Thief): ");
	input = false;
	String _class = "";
	while (!input) {
	    _class = (scanner.nextLine()).trim();
	    if ((_class.equals("0")) || (_class.equals("1")) || (_class.equals("2")) || (_class.equals("3"))) {input = true;} //is there a more efficient method to do this line?
	}
    }
}
