package hari;

import java.util.Arrays;

public class selectionSort {
    public static void main(String args[]) {
    	int[] arr = {0,-1,9,3,0,5,8,0,2,1,-9,-10,233,45,23,0};
//    	 QuickSort(arr, 0, arr.length-1);
    	Arrays.sort(arr);
//    	arr = MergeSort(arr);
    	for(int arrays:arr) {
    		System.out.print(arrays+", ");
    	}
    	
    	
    }
    
    public static void QuickSort(int[] arr, int low, int high) {
    	if(low >= high) {
    		return;
    	}
    	int start = low;
    	int end = high;
    	int mid = (start + end) / 2;
    	int pivot = arr[mid];
    	while(start <= end) {
    		while(arr[start] < pivot) {
    			start++;
    		}
    		while(arr[end] > pivot) {
    			end--;
    		}
    		if(start <= end) {
    			int temp = arr[start];
    			arr[start] = arr[end];
    			arr[end] = temp;
    			start++;
    			end--;
    		}
    	}
    	QuickSort(arr, low , end);
    	QuickSort(arr, start, high);
    	
    }
    //MergeSort
    public static int[] MergeSort(int[] arr) {
    	if(arr.length == 1) {
    		return arr;
    	}
    	int mid =arr.length / 2;
    	int[] left = MergeSort(Arrays.copyOfRange(arr, 0, mid));
    	int[] right = MergeSort(Arrays.copyOfRange(arr, mid, arr.length));
    	return Merge(left, right);
    }
    //Merge
    public static int[] Merge(int[] first, int[] second) {
    	int[] joined = new int[first.length + second.length];
    	int i = 0, j = 0, k = 0;
    	while(i < first.length && j < second.length) {
    		 if(first[i] < second[j]) {
    			 joined[k++] = first[i++];
    		 }else {
    			 joined[k++] = second[j++];
    		 }
    	}
    	
    	while(i < first.length) {
    		joined[k++] = first[i++];
    	}
    	while(j < second.length) {
    		joined[k++] = second[j++];
    	}
    	return joined;
    }
    //Bubble sort
    public static void BubbleSort() {
    	int[] arr = {5,4,2,1,99,0};
    	for(int i = 1; i < arr.length; i++) {
    		for(int j =0; j< arr.length-i; j++) {
    			if(arr[j]>arr[j+1]) {
    				int temp = arr[j];
    				arr[j] = arr[j+1];
    				arr[j+1] = temp;
    			}
    		}
    	}
    	System.out.println(Arrays.toString(arr));
    }
    //selection sort
    public static void selectionSort(){
    	int[] arr = {5,4,2,1,99,0};
    	for(int i = 0; i < arr.length; i++) {
    		for(int j =i+1; j< arr.length; j++) {
    			if(arr[i]>arr[j]) {
    				int temp = arr[i];
    				arr[i] = arr[j];
    				arr[j] = temp;
    			}
    		}
    	}
  	//System.out.println(Arrays.toString(arr));
    }
}
