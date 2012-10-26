/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package test.wordplay;

import java.util.Hashtable;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import wordplay.DictionaryManager;

/**
 *
 * @author felix
 */
public class DictionaryManagerTest {
    
    public DictionaryManagerTest() {
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
     * Test of readDict method, of class Dictionary.
     */
    @Test
    public void testReadDict() {
        System.out.println("readDict");
        String fileName = "/home/felix/word-play/dictionaries/test-6-word.txt";
        DictionaryManager instance = new DictionaryManager();
        Hashtable expResult = null;
        Hashtable result = instance.readDict(fileName);
        assertEquals(expResult, result);
    }

    /**
     * Test of getDict method, of class Dictionary.
     */
    @Test
    public void testGetDict() {
        System.out.println("getDict");
        String dictName = "";
        DictionaryManager instance = new DictionaryManager();
        Hashtable expResult = null;
        Hashtable result = instance.getDict(dictName);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
}
