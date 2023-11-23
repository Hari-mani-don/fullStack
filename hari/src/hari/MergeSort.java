package hari;

import java.util.Arrays;

public class MergeSort {

	public static void main(String[] args) {
		 int[] arr = {3, 8, 5, 12, 10, 7, 9, 6};
	      
//	       arr = mergeSort(arr);
//	    
//
//	        System.out.println("Sorted Array:");
//	        System.out.println(Arrays.toString(arr));
		 for(int i = 0; i < 50; i++) {
			 System.out.println(i+".");
		 }
//		 int a =1234;
//		 String b = ""+a;
//		 System.out.println(b.length());
		 

	}
	
	//Merge sort
    public static int[] mergeSort(int[] arr) {
        if (arr.length == 1) {
            return arr;
        }

        int mid = arr.length / 2;
        int[] left = mergeSort(Arrays.copyOfRange(arr, 0, mid));
        int[] right = mergeSort(Arrays.copyOfRange(arr, mid, arr.length));
        
      return  merge(left, right);
    }
    
	 public static int[] merge( int[] first, int[] second) {
	    	int[] mix = new int[first.length + second.length];
	        int i = 0, j = 0, k = 0;

	        while (i < first.length && j < second.length) {
	            if (first[i] < second[j]) {
	                mix[k] = first[i];
	                i++;
	            } else {
	                mix[k] = second[j];
	                j++;
	            }
	            k++;
	        }
      //copy remaining elements
	        while (i < first.length) {
	            mix[k] = first[i];
	            i++;
	            k++;
	        }

	        while (j < second.length) {
	            mix[k] = second[j];
	            j++;
	            k++;
	        }
	        return mix;
    }
	

}
