/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package wordplay;

import java.util.Hashtable;
import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;


/**
 *
 * @author felix
 */
public class Dictionary {
    //maybe a hashtable of hashtables is going a bit far?
    private Hashtable dictionaries = new Hashtable<String, Hashtable>();
    //private Hashtable numbers = new Hashtable();
    
    public Dictionary(){
        //Load the dictionarys in the dict folder
        //maybe later.
        //for now just load the test one
        //dictionaries.put("test", 
              //readDict("/home/felix/word-play/dictionaries/test-6-word.txt"));
    }
    
    public Hashtable readDict(String fileName){
        Hashtable dictTable = new Hashtable<String, ArrayList<String>>();
        
        try {
            FileInputStream fstream = new FileInputStream(fileName);
            DataInputStream in = new DataInputStream(fstream);
            BufferedReader dictFile = 
                    new BufferedReader(new InputStreamReader(in));
            String strLine;
            ArrayList<String> wordList = new ArrayList<String>();
            while ((strLine = dictFile.readLine()) != null)   {
                wordList.add(strLine.trim());
            }
            System.out.println(wordList);
            //figure out how many letters is in the words here
            int wordLength = wordList.get(0).length()-1;
            //throw errors if there are different amounts of letters
            //put words into a hashtable where one word differences are the values.
            String curWord;
            ArrayList<String> curMatchList = new ArrayList<String>();
            for (int i=0;i<wordList.size();i++){
                curWord = wordList.get(i);
                System.out.println("we're on: " + curWord);
                checkWordLength(curWord, wordLength);
                System.out.println("cool for length");
                curMatchList = findMatches(curWord, wordList);
                dictTable.put(curWord, curMatchList);
            }
        }
        catch (Exception e) {
            System.err.println("Error: " + e.getMessage());
        }
        return dictTable;
    }
    
    /**
     * This function returns the relevant hashtable based
     * on the amount of letters in the given word.
     * @param dictName
     * @return 
     */
    public Hashtable getDict(String dictName){
        
        return null;
    }
    
    private static void checkWordLength(String word, int thisLength) 
            throws WordLengthException{
        if (word.length()-1 != thisLength){
            throw new WordLengthException();
        }
    }
    /**
     * finds all words that are one letter different to a given word from
     * a provided list of words. it returns a list of matches.
     * @param word
     * @param wordList
     * @return 
     */
    private ArrayList<String> findMatches(String word, 
            ArrayList<String> wordList){
        ArrayList<String> matchList = new ArrayList<String>();
        String curWord;
        int wrongLetters;
        System.out.println("finding matches for: " + word +"");
        for (int i = 0;i<wordList.size();i++){
            wrongLetters = 0;
            curWord = wordList.get(i);
            System.out.println("checking word: " + curWord); 
            for (int i2 = 0; i2<word.length();i2++){
                if (curWord.charAt(i2) != word.charAt(i2)){
                   wrongLetters++;
                }
                if (wrongLetters>1){
                    System.out.println("nope, not good word.");
                    break;
                }
            }
            if (wrongLetters==1){
                matchList.add(curWord);
            }
        }
        return matchList;
    }
}