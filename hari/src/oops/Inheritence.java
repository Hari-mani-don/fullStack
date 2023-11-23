package oops;

public class Inheritence {

	public static void main(String[] args) {
		SavingsAccount sav = new SavingsAccount("3939348701",220,7);
		sav.displayInfo();
	}

}
//class Vehicle{
//	String make;
//	String model;
//	Vehicle(String make, String model){
//		this.make = make;
//		this.model = model;
//	}
//	
//}
//class Car extends Vehicle {
//	int numDoors;
//	Car(String make,String model, int numDoors){
//		super(make,model);
//		this.numDoors = numDoors;
//	}
//	public void displayInfo() {
//		System.out.println("make: "+ super.make);
//		System.out.println("make: "+ super.model);
//		System.out.println("make: "+ numDoors);
//	}
//	
//}



//class Person{
//	String name;
//	int age;
//	Person(String name, int age){
//		this.name = name;
//		this.age = age;
//	}
//	
//}
//class Student extends Person {
//	int studentId;
//	Student(String name,int age, int studentId){
//		super(name,age);
//		this.studentId = studentId;
//	}
//	public void displayInfo() {
//		System.out.println("name: "+ super.name);
//		System.out.println("age: "+ super.age);
//		System.out.println("studentId: "+ studentId);
//	}
//	
//}



//
//interface Shape{
//
//	public double area();
//	public double perimeter();
//}
//class Circle implements Shape {
//    
//	double radius;
//	Circle(double radius){
//		this.radius = radius;
//	}
//	@Override
//	public double area() {
//		return Math.PI * radius * radius;
//		
//	}
//
//	@Override
//	public double perimeter() {
//		// TODO Auto-generated method stub
//		return 2 * Math.PI * radius;
//	}
//	
//	
//}
//class Rectangle implements Shape {
//
//	double length;
//	double width;
//	
//	Rectangle(double length, double width){
//		this.length = length;
//		this.width = width;
//	}
//	@Override
//	public double area() {
//		// TODO Auto-generated method stub
//		return length * width;
//	}
//
//	@Override
//	public double perimeter() {
//		// TODO Auto-generated method stub
//		return 2 * (length + width);
//	}
//
//	
//}	
	
class BankAccount{
	String accountNumber;
	double balance;
	BankAccount(String accountNumber, double balance){
		this.accountNumber = accountNumber;
		this.balance = balance;
	}
	
}
class SavingsAccount extends BankAccount {
	double interestRate;
	SavingsAccount(String accountNumber,int balance, double interestRate){
		super(accountNumber,balance);
		this.interestRate = interestRate;
	}
	public void displayInfo() {
		System.out.println("make: "+ super.accountNumber);
		System.out.println("make: "+ super.balance);
		System.out.println("make: "+ interestRate);
	}
	
}
	
	
	
