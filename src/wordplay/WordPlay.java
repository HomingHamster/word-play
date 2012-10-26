package wordplay;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

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
            }
        }
    }
    
}
