import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;
import javafx.util.*;

public class Solution {

    // Complete the minimumSwaps function below.
    static int minimumSwaps(int[] arr) {
      //array length
      int n=arr.length;
      //array for storing elements and positions
      ArrayList<Pair<Integer,Integer>> arrpos = new ArrayList<Pair<Integer,Integer>>();
      
      for(int i=0;i<n;i++)
        arrpos.add(new Pair<Integer,Integer>(arr[i],i));
      
      // System.out.println(arrpos);

      arrpos.sort(new Comparator<Pair<Integer,Integer>>(){
        
        public int compare(Pair<Integer,Integer> p1,Pair<Integer,Integer> p2){
          if(p1.getKey()<p2.getKey())return -1;
          else if(p1.getKey().equals(p2.getKey()))return 0;
          else return 1;
        }
      });

      // System.out.println(arrpos);
      boolean visited[] = new boolean[n];
      int result=0;

      for(int i=0;i<n;i++){
        /*
          if the current element is at right position or 
          if it is already visited then ignore
        */
        if(visited[i] || arrpos.get(i).getValue()==i)continue;


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
          visited[j]=true;
          j=arrpos.get(j).getValue();
          cycle++;
        }
        //number of swaps = cycles-1;
        if(cycle > 0)
          result+=(cycle-1);
      }
      
      return result;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int n = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        int[] arr = new int[n];

        String[] arrItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < n; i++) {
            int arrItem = Integer.parseInt(arrItems[i]);
            arr[i] = arrItem;
        }

        int res = minimumSwaps(arr);

        bufferedWriter.write(String.valueOf(res));
        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}
