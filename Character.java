import java.io.*;
import java.util.*;

public class Character implements Comparable <Character>{

    private int _socialLife;
    private int _sleep;
    private int _grades;
    private String _name;
    private Character _loveInterest;
    private int _friendship;
    private PriorityQueue<Character> _friends;
    private PriorityQueue<Character> _enemies;
    private Random rand = new Random ();

    public Character () {
	_socialLife = 0;
	_sleep = 0;
	_grades = 0;
	_name = ""; //Add ask for name as well

	_loveInterest = null;
	_friends = new PriorityQueue <Character> (); 
	_enemies = new PriorityQueue <Character> ();

	//Later we will create a method that will ask the player what type of Character they want to be. Jock, Nerd, or Narcolept - the answer will determine the starting values of the 3 instance variables 


	_friendship = rand.nextInt(6);
    }

    public void sleep(){
	_sleep = _sleep + 5; //Susceptible to change
    }

    public void makeFriend(Character c) {
	_socialLife = _socialLife + c.getSocialLife();
	_friends.add(c);
    }


    /*This will be used to sort Priority Queue of Friends */

    public int compareTo(Character c) { //Greater Friendship than Character C.
	if (_friendship > c.getFriendship()) {
	    return 1;
	}

	if (_friendship == c.getFriendship()) {//Same friendship as Character C.
	return 0;
	}

	return -1; //Lower friendship than Character C
    }
	



    // ----------------------------------- Setter Methods
    public void setSocialLife (int i) {
	_socialLife = _socialLife + i;
    }

    public void setSleep(int i) {
	_sleep = _sleep + i;
    }

    public void setGrades(int i) {
	_grades = _grades + i;
    }

    public void setFriendship (int i) {
	_friendship = _friendship + i;
    }

    public void setName (String s) {
	_name = s;
    }

    //---------------------------Acccesor Methods
    public int getSocialLife(){
	return _socialLife;
    }

    public int getSleep() {
	return _sleep;
    }

    public int getGrades() {
	return _grades;
    }

    public int getFriendship() {
	return _friendship;
    }

    public String getName() {
	return _name;
    }
}