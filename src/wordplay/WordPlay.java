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
        Routing.findRoute("flock", dictionary.readDict("/home/felix/word-"
                + "play/dictionaries/test-6-word.txt"));
        
        
    }
    
}
