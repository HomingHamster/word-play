/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package test.wordplay;

import java.util.ArrayList;
import java.util.Hashtable;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import wordplay.DictionaryManager;
import wordplay.Routing;

/**
 *
 * @author felix
 */
public class RoutingTest {
    
    public RoutingTest() {
    }

    @BeforeClass
    public static void setUpClass() throws Exception {
    }

    @AfterClass
    public static void tearDownClass() throws Exception {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of findRoute method, of class Routing.
     */
    @Test
    public void testFindRoute() {
        DictionaryManager dictionary = new DictionaryManager();
        System.out.println("findRoute");
        String word = "click";
        String word2 = "clack";
        Hashtable dict = dictionary.readDict("/home/felix/word-"
                + "play/dictionaries/test-6-word.txt");
        ArrayList expResult = null;
        ArrayList result = Routing.findRoute(word, word2, dict);
        assertEquals(expResult, result);
        
    }
}
