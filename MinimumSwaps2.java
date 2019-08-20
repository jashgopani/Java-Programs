import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;
import javafx.util.*;

    /*
      Working of the function
      [4=0, 3=1, 1=2, 2=3]
      [1=2, 2=3, 3=1, 4=0]
      1=2
      Starting Cycle detection
      1=2 -> 3=1 -> 2=3 -> 4=0 ->
      Cycles = 4
      2=3
      3=1
      4=0
    */
    // Complete the minimumSwaps function below.
    static int minimumSwaps(int[] arr) {
      //array length
      int n=arr.length;
      //array for storing elements and positions
      ArrayList<Pair<Integer,Integer>> arrpos = new ArrayList<Pair<Integer,Integer>>();
      
      for(int i=0;i<n;i++)
        arrpos.add(new Pair<Integer,Integer>(arr[i],i));
      
      System.out.println(arrpos);

      arrpos.sort(new Comparator<Pair<Integer,Integer>>(){
        
        public int compare(Pair<Integer,Integer> p1,Pair<Integer,Integer> p2){
          if(p1.getKey()<p2.getKey())return -1;
          else if(p1.getKey().equals(p2.getKey()))return 0;
          else return 1;
        }
      });

      System.out.println(arrpos);
      boolean visited[] = new boolean[n];
      int result=0;

      for(int i=0;i<n;i++){
        /*
          if the current element is at right position or 
          if it is already visited then ignore
        */
        System.out.println(arrpos.get(i));
        if(visited[i] || arrpos.get(i).getValue()==i)continue;

        System.out.println("Starting Cycle detection ");
        /* else
          start counting cycles from the current element
        */
        int cycle=0;
        int j=i;//starting node of the cycle is current element
        /* 
          While the cycle does not end,
          1. mark the current node as visited
          2. move to the next node which was expected to be at the current position(j)
          3. This forms a cycle hence increment cycle
          4.repeat this until you cover the entire cycle
        */
        while(!visited[j]){
          System.out.print(arrpos.get(j)+" -> ");
          visited[j]=true;
          j=arrpos.get(j).getValue();
          cycle++;
        }
        //number of swaps = cycles-1;
        if(cycle > 0)
          result+=(cycle-1);
        
        System.out.println("\n Cycles = "+cycle);
      }
      
      return result;
    }

    
