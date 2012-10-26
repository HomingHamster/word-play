/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package wordplay;

/**
 *
 * @author felix
 */
public class WordLengthException extends Exception {

    /**
     * Creates a new instance of <code>WordLengthException</code> without detail message.
     */
    public WordLengthException() {
    }

    /**
     * Constructs an instance of <code>WordLengthException</code> with the specified detail message.
     * @param msg the detail message.
     */
    public WordLengthException(String msg) {
        super(msg);
    }
}
