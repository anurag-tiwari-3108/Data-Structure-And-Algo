package com.codex.dsa.hashmaps;

import java.util.HashMap;
import java.util.Hashtable;
import java.util.Map;

/**
 * @author Anurag
 *
 */
public class HashMapOperations {
	
	public static void main(String [] args){
		
		Map<Integer, String> myMap = new HashMap<Integer, String>();
		myMap.put(1, "India");
		myMap.put(2, "Newyork");
		myMap.put(3, "London");
		myMap.put(4, "Swden");
		myMap.put(5, "Prag");
		
		Hashtable<Integer, String> myTable = new Hashtable<Integer, String>();
		myTable.put(1, "India");
		myTable.put(2, "Newyork");
		myTable.put(3, "London");
		myTable.put(4, "Swden");
		myTable.put(5, "Prag");

		
		System.out.println("Going to show the map values");
		for(int i=1; i<=5 ; i++){
			System.out.print(myMap.get(i)+"  ");
		}

		System.out.println("\nGoing to show the Hash Table values");
		for(int i=1; i<=5 ; i++){		
			System.out.print(myTable.get(i)+"  ");			
		}
	}
}
