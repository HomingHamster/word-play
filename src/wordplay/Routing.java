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
    public static ArrayList<String> findRoute(String word, String word2,
            Hashtable dict){
        ArrayList<String> route = new ArrayList<String>();
        ArrayList<ArrayList<String>> possibleRoutes;
        possibleRoutes = findRoutes(new ArrayList<String>(), word, word2, dict);
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

    private static ArrayList<ArrayList<String>> findRoutes(ArrayList<String> origonList, 
            String currentWord, String destination, Hashtable dict){
        ArrayList<ArrayList<String>> routes = new ArrayList<ArrayList<String>>();
        ArrayList<String> tempList = new ArrayList<String>();
        //Using a hashset to ensure uniqueness
        HashSet<String> toTestList = new HashSet<String>();
        toTestList = new HashSet<String>((ArrayList<String>)dict.get(currentWord));
        toTestList.removeAll(origonList);
        
        if (toTestList.isEmpty()){
            System.out.println("value of routes on nullify: "+
                    routes);
            routes = null;
        } else {
            for (String thisWord:toTestList){
                if (thisWord.equals(destination)){
                    tempList.addAll(origonList);
                    tempList.add(currentWord);
                    tempList.add(destination);
                    System.out.println("made it here: " + tempList.toString());
                    routes.add(tempList);
                    
                    System.out.println("incremental value of routes"+ routes);
                } else {
                    origonList.add(currentWord);
                    routes.addAll(findRoutes(origonList, thisWord,
                            destination, dict));
                }
                
            }
        }
        
        return routes;
    }
}
