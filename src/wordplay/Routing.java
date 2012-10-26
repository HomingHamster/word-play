/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package wordplay;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Hashtable;

/**
 *
 * @author felix
 */
public class Routing {
    public static ArrayList<String> 
            findRoute(String word, String word2,
            Hashtable dict){
        ArrayList<String> route = new ArrayList<String>();
        ArrayList<ArrayList<String>> possibleRoutes;
        possibleRoutes = findRoutes(
                new ArrayList<String>(),
                word, word2, dict);
        System.out.println("We see possible routes: " + 
                possibleRoutes.toString());
        if (possibleRoutes.isEmpty()){
            route = null;
        }else{
            for (ArrayList<String> curRoute:possibleRoutes){
                if (route.isEmpty()){
                    route = curRoute;
                } else if (curRoute.size()<route.size()){
                        route = curRoute;
                }
            }
        }  
        return route;
    }
    
    public static ArrayList<String> generate(
            ArrayList<String> origonList,
            String currentWord, int currentStep,
            int amountOfSteps, Hashtable dict){
        
        ArrayList<String> output = 
                new ArrayList<String>();
        
        HashSet<String> toTestList = new HashSet<String>(
                (ArrayList<String>)dict.get(currentWord));
        
        toTestList.removeAll(origonList);
        
        if (toTestList.isEmpty()){
        } else {
            for (String thisWord:toTestList){
                if (amountOfSteps == (currentStep+1)){
                    origonList.add(thisWord);
                    return origonList;
                    
                } else {
                    origonList.add(currentWord);
                    currentStep++;
                    return
                    generate(origonList, thisWord,
                            currentStep, amountOfSteps,
                            dict);
                }
                
            }
        }
        
        return output;
    }

    private static ArrayList<ArrayList<String>> 
            findRoutes(ArrayList<String> origonList, 
            String currentWord, String destination, 
            Hashtable dict){
        ArrayList<ArrayList<String>> routes = 
                new ArrayList<ArrayList<String>>();
        ArrayList<String> tempList = new 
                ArrayList<String>();
        //Using a hashset to ensure uniqueness
        HashSet<String> toTestList = new 
                HashSet<String>();
        toTestList = new HashSet<String>(
                (ArrayList<String>)dict.get(currentWord));
        toTestList.removeAll(origonList);
        
        if (toTestList.isEmpty()){
        } else {
            for (String thisWord:toTestList){
                if (thisWord.equals(destination)){
                    tempList.addAll(origonList);
                    tempList.add(currentWord);
                    tempList.add(destination);
                    routes.add(tempList);
                    
                } else {
                    origonList.add(currentWord);
                    routes.addAll(findRoutes(
                            origonList, thisWord,
                            destination, dict));
                }
                
            }
        }
        
        return routes;
    }
}
