package wordplay;

/**
 *
 * @author Felix Farquharson
 */
public class WordPlay {
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Dictionary dictionary = new Dictionary();
        System.out.println("lets try and find a route...");
        System.out.println();
        System.out.println("WE BUILT THIS CITY!"+
        dictionary.readDict("/home/felix/word-"
                + "play/dictionaries/test-6-word.txt").toString());
        System.out.println(Routing.findRoute("click", "clack", dictionary.readDict("/home/felix/word-"
                + "play/dictionaries/test-6-word.txt")));
        
        while (true){
            System.out.println("Welcome to word-ladders");
            System.out.println("Please choose from the following:");
            System.out.println("(1) Generation (Not yet working)");
            System.out.println("(2) ");
        }
        
        
    }
    
}
