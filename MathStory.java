import java.io.*;
import java.util.*;

public class MathStory extends SchoolStory {


    //I'M LEAVING THIS ALONE FOR NOW, BUT WE NEED TO FIGURE OUT A DATA STRUCTURE THAT CAN HOLD TWO DISTINCT PIECES OF INFOMRATION. QUESTION AND ANSWER.
    //OTHERWISE I'M THINKING OF HAVING TWO ARRAYLISTS THAT COMMUINCATE WITH EACH OTHER BY THEIR LOCATION VALUES IN THE ARRAYLIST. 

    Random rand = new Random ();
    int i = rand.nextInt(_testBank.size());
    String s = testBank.get(i);

	System.out.println(user.getName()+", an you help me out with something?");
	System.out.println("yes or no");
	Scanner scan=new Scanner(System.in);
	//var name input
	String input="";
	while(!(input.equals("yes"))&&(!(input.equals("no")))){
	    input+=scan.nextLine().trim();
	}
	if(input.equals("yes")){
	}


}
