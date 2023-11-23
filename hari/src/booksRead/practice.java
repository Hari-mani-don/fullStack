package booksRead; //source file package name
import java.util.Random; //package add or import 
public class practice { //class start
      public static void main(String args[]) { //main method start
    	  String[] words = {"hari", "mani","done"}; //list of words something
    	  int wordLength = words.length; //words length
    	  Random Randomgenerate = new Random(); //declare Random objcet
    	  int i =0; //decalre variable "i" assign value of 0
    	  while(i < 5) { // while loop start
    		  int rand1 = Randomgenerate.nextInt(wordLength);// generate radom number
    		  System.out.println(words[rand1]); //print the words data
    		  i = i + 1; // increase i value 
    	  } //while loop end
      }//main method end
}//class end
