package hari;

import java.util.Arrays;


public class Abstract {

	public static void main(String[] args) {
//		Searchable[] serchable = {new Document("Hi Hari, How are you?", "Hari"), new Webpage("https://www.harimani.com", "Hey Guys welcome to our page", "Hey")};
//		for(Searchable serch : serchable) {h
//			serch.search();
//		}
//		int[] array = {4,1,0,3};
//		
//		System.out.println(Arrays.toString(CyclicSort(array)));
//		System.out.print("hari" == "harii");
		
		
	}
	
	    
        

	//cyclic sort also index base, so values are available in no.of index and no.of values
	public static int[] CyclicSort(int arr[]) {
		 int i = 0;
		 while(i < arr.length-1) {
			 int correct = arr[i]-1;  //4,1,0,3
			 if(arr[i] != arr[correct]) {
				 swap(arr, i, correct);
			 }else {
				 i++;
			 }
		 }
		 return arr;
	}
	public static int[] insertionSort(int[] arr) {
		for(int i = 0; i < arr.length-1; i++) {
			for(int j = i+1; j > 0; j--) {
				//If arr[j] < arr[j-1] true swap the value 
				if(arr[j] < arr[j-1]) { //3,4,2,7,8,1,0
					swap(arr, j, j-1);
				}
			}
		}
		return arr;
	}
	public static int[] swap(int[] arr, int first, int second) {
		int temp = arr[first];
		arr[first] = arr[second];
		arr[second] = temp;
		return arr;
	}

}

interface Searchable{
	void search();
}
class Document implements Searchable {
    String content;
    String keyword;
    
	//Create a constructor
	Document(String content, String keyword){
		this.content = content;
		this.keyword = keyword;
	}
	
	@Override
	public void search( ) {
		System.out.println("The " + keyword + " is "+ content.contains(keyword));
	}
	
}
class Webpage implements Searchable {

	String content;
	String url;
	String keyword;
	//create a constructor
	Webpage(String url, String content, String keyword){
		this.url = url;
		this.content = content;
		this.keyword = keyword;
	}
	@Override
	public void search() {
		System.out.println("The " + keyword + " is "+ content.contains(keyword));
		
	}
				
}