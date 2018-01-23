import java.io.File;
import java.util.Scanner;

public class MovieList {


    private String[] films;                //field

    MovieList() {                    //default constructor
        films = new String[100];
    }


    public String randomFlm() throws Exception {            //I need to throw exception here because of file import


        File file = new File("movies.txt");             //importing text file
        Scanner scanner = new Scanner(file);
        int i = -1;


        while (scanner.hasNextLine()) {                     //creating Array with all films
            String filmName = scanner.nextLine();
            films[++i] = filmName;


        }
        ++i;
        int randomNumber = (int) (Math.random() * i);
        String rand = films[randomNumber];                  //Choosing random film from Array of films


        return rand;
    }


    public String guess(String rand) {               //creating encrypted string with length corresponding to chosen random film

        int len = rand.length();
        String encrypted="";
        for (int j = 0; j < len; ++j) {
            encrypted=encrypted+"-";

        }
        return encrypted;
    }
}

