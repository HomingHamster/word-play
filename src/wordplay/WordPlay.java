package wordplay;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

/**
 *
 * @author Felix Farquharson
 */
public class WordPlay {
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args){
        DictionaryManager dictionary = 
                new DictionaryManager();
        
        while (true){
            System.out.println("Welcome to "
                    + "word-ladders");
            System.out.println("Please choose "
                    + "from the following:");
            System.out.println("(1) Generation "
                    + "(Not yet working)");
            System.out.println("(2) Discovery");
            System.out.print("Your choice: ");
            String choice;
            BufferedReader br = 
                    new BufferedReader(new 
                            InputStreamReader(System.in));
            String input = "";
            try {
            input = br.readLine();
            }
            catch (IOException ioe) {
                System.out.println("IO error trying "
                        + "to read your input!");
                System.exit(1);
            }
            if (input.equals("2")) {
                
                System.out.println(Routing.findRoute(
                        "head", "foot", dictionary.
                        readDict("/home/felix/word-"
                + "play/dictionaries/dict4.dat")));
            } else if (input.equals("1")) {
                System.out.print("Enter a word: ");
                input = "";
                try {
                    input = br.readLine();
                }
                catch (IOException ioe) {
                    System.out.println("IO error trying "
                            + "to read your input!");
                    System.exit(1);
                }
                if (input.length() == 4) {
                    System.out.println(
                    Routing.generate(
                            new ArrayList<String>(),
                            input, 0,
                            5, dictionary.
                        readDict("/home/felix/word-"
                + "play/dictionaries/dict4.dat")));
                } else {
                    System.out.println("Ran out of"
                            + " time to impliment "
                            + "more than 4 letters"
                            + " but the code is "
                            + "partically there");
                }
            }
        }
    }
    
}
