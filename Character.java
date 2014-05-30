public class Character{

    private int _socialLife;
    private int _sleep;
    private int _grades;
    private String _name;
    private Character _loveInterest;
    private Character[] friends;

    public Character () {
	_socialLife = 0;
	_sleep = 0;
	_grades = 0;
	_name = ""; //Add ask for name as well

	_loveInterest = null;
	friends = new Character[10]; //just 10 for now.

	//Later we will create a method that will ask the player what type of Character they want to be. Jock, Nerd, or Narcolept - the answer will determine the starting values of the 3 instance variables 
    }
    
    public void setSocialLife (int i) {
	_socialLife = _socialLife + i;
    }

    public void setSleep(int i) {
	_sleep = _sleep + i;
    }

    public void setGrades(int i) {
	_grades = _grades + i;
    }

    public void setName (String s) {
	_name = s;
    }

    public int getSocialLife(){
	return _socialLife;
    }

    public int getSleep() {
	return _sleep;
    }

    public int getGrades() {
	return _grades;
    }

    public String getName() {
	return _name;
    }
}