import java.io.*;
import java.util.*;

public class ComputerCharacter extends Character implements Comparable <ComputerCharacter>{
    private int _friendship;
    private String [] boyNames = {"Bob", "John", "Jack", "Kyle", "Will", "Robert", "Chris"};
    private String [] girlNames = {"Julie", "Rebecca", "Phyllis", "Emily", "Aria", "Sarah"};
  

    public ComputerCharacter () {
	super();
	if (gender.equals("male")) {
	    int loc = rand.nextInt (boyNames.length);
	    _name = boyNames[loc];
	}
	else {
	int loc = rand.nextInt (girlNames.length);
	_name = girlNames[loc];
	}  
	    
	_friendship = rand.nextInt(6);
    }


    public int compareTo(ComputerCharacter c) { //Greater Friendship than Character C.
	if (_friendship > c.getFriendship()) {
	    return 1;
	}

	if (_friendship == c.getFriendship()) {//Same friendship as Character C.
	return 0;
	}

	return -1; //Lower friendship than Character C
    }
	



    // ----------------------------------- Setter Methods
 
    public void setFriendship (int i) {
	_friendship = _friendship + i;
    }

    //---------------------------Acccesor Methods
 
    public int getFriendship() {
	return _friendship;
    }
}