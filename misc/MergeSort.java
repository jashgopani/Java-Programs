package misc;
import java.util.*;
import java.io.*;

public class MergeSort{
	
	public static void mergeSort(int[] array,int[] temp,int leftStart,int rightEnd){
		if(leftStart >= rightEnd){
			return;
		}

		int middle = (leftStart + rightEnd)/2;

		mergeSort(array,temp,leftStart,middle);
		mergeSort(array,temp,middle+1,rightEnd);

		mergeHalves(array,temp,leftStart,rightEnd);
	}

	public static void mergeHalves(int[] arr,int[] temp,int leftStart,int rightEnd){
		int leftEnd = (leftStart + rightEnd)/2;//ending index of left sub array
		int rightStart = leftEnd+1;//starting index of right sub array
		int size = rightEnd - leftStart +1;

		int i=leftStart;//starting index for left sub array
		int j=rightStart;//starting index for right sub array
		int k=leftStart;//starting index for temp array

		System.out.println("Inside mergeHalves : ");
		printArray(temp);


		while(i<=leftEnd && j<=rightEnd){
			if(arr[i] <= arr[j]){
				temp[k] = arr[i];
				i++;
			}else{
				temp[k] = arr[j];
				j++;
			}
			k++;
		}

		/*	
			System.arraycopy(source_array[],source_array_index,dest_array[],dest_array_index,number of elements)
		*/

		//copying remaining elements into temp array then temp to original array
		System.arraycopy(arr,i,temp,k,leftEnd-i+1);
		System.arraycopy(arr,j,temp,k,rightEnd - j +1 );
		System.arraycopy(temp,leftStart,arr,leftStart,size);
	}

	public static void printArray(int arr[]){
		for (int i=0; i<arr.length; i++) {
			System.out.print(arr[i]+"\t");
		}
		System.out.println();
	}

	public static void main(String[] args) {
		int arr[] = {89,38,1,43,10,69};
		System.out.println("Before Sort");
		printArray(arr);
		mergeSort(arr,new int[arr.length],0,arr.length-1);
		System.out.println("After Sort");
		printArray(arr);
	}
}