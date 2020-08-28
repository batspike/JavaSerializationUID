package com.samcancode;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

public class Main {
	public static void main(String[] args) {
		String fileName = "employee.ser";
		
		Employee object = new Employee();
		object.setId(1);
		object.setName("Paul Brenson");
		
		serializeObject(fileName, object);
		deSerializeObject(fileName);
	}

	private static void deSerializeObject(String fileName) {
		try {
			ObjectInputStream ois = new ObjectInputStream(new FileInputStream(new File(fileName)));
			Employee object = (Employee) ois.readObject();
			System.out.println("Object has been deserialized...");
			System.out.println("Emoloyee Id: "+ object.getId());
			System.out.println("Employee Name: "+ object.getName());
		}
		catch (Exception e) {
			e.printStackTrace();
		}
	}

	private static void serializeObject(String fileName, Employee object) {
		try {
			ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(new File(fileName)));
			oos.writeObject(object);
			System.out.println("Object has been serialized!");
		}
		catch (Exception e) {
			e.printStackTrace();
		}
	}
}

class Employee implements Serializable {
	
	private int id;
	private String name;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	//==========================================
	
//	private double salary;
//	public double getSalary() {
//		return salary;
//	}
//	public void setSalary(double salary) {
//		this.salary = salary;
//	}
	
}