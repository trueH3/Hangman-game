import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws Exception {

        MovieList myMovieList = new MovieList();                //initializing MovieList class

        String decrypted =myMovieList.randomFlm();              //method call: .randomFilm()
        String encrypted=  myMovieList.guess(decrypted);        //method call: .guess(.randomFlm())


        Scanner scanner = new Scanner(System.in);               //creating scanner object
        StringBuilder builder =new StringBuilder(encrypted);    //because Strings are immutable, i need to create StringBuilder object from String encrypted
        int mishitCounter=0;                                    //StringBuilder object are mutable
        String wrongLetters="";



        while(!(decrypted.contentEquals(builder))) {            // to compare String and StringBuilder object i cant use .Equals method,
            System.out.println("You are guessing: "+builder);   //instead i can use .contentEquals
            System.out.println("You have guessed ("+mishitCounter+") wrong letters: "+wrongLetters);
            System.out.print("Guess a letter:");
            char answer = scanner.nextLine().charAt(0);

            int counterCheck = decrypted.indexOf(answer);       //to compare indexes of particular letters in String i use method .indexOf
            if(counterCheck==-1){                               //important note .indexOf=-1 if checked letter isn't in String
                ++mishitCounter;                                //unfortunately if in the String is more than 1 same character .indexOf returns only first index
                wrongLetters=wrongLetters+" "+answer;           //of that character, to get them all I've created  a loop below

            }


            for (int indeks = decrypted.indexOf(answer); indeks >= 0; indeks = decrypted.indexOf(answer, indeks + 1)) { //this loop is created to get all indexes
                builder.setCharAt(indeks, answer);
            }



            if(decrypted.contentEquals(builder)){
                System.out.println("You Win!\nYou have guessed "+decrypted+" correctly.");
            }
            if(mishitCounter==10){
                System.out.println("You Loose!\nCorrect answer is: "+decrypted);
                break;
            }
        }

    }
}

