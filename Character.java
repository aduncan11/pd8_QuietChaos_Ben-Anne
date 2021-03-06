
import java.io.*;
import java.util.*;

public class Character{

    protected int _socialLife; //0-5 inclusive
    protected int _sleep; //0-10 inclusive
    protected int _grades; //0-4 inclusive
    protected String gender;
    protected String _name;
    protected Random rand = new Random ();

    public Character () {
	_socialLife = 0;
	_sleep = 0;
	_grades = 0;
	_name = ""; //Add ask for name as well

	if (rand.nextInt(2) == 0) {
	    gender = "male";
	}
	else {
	    gender = "female";
	}
    }

	



    // ----------------------------------- Setter Methods
    public void setSocialLife (int i) {
	_socialLife = _socialLife + i;
	if(_socialLife<0) _socialLife=0;
	if(_socialLife>5) _socialLife=5;
    }

    public void setSleep(int i) {
	_sleep = _sleep + i;
	if(_sleep<0) _sleep=0;
	if(_sleep>10) _sleep=10;
    }

    public void setGrades(int i) {
	_grades = _grades + i;
	if(_grades<0) _grades=0;
	if(_grades>4) _grades=4;
    }

    public void setGender (String s) {
	gender = s;
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

    public String getGender() {
	return gender;
    }

    public String getName() {
	return _name;
    }
}
