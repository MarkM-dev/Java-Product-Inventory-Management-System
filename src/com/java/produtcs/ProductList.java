package com.java.produtcs;

import java.util.Scanner;

public class ProductList {

	private final static String welcomeMsg = "Welcome! This is a product inventory management system.";
	private Product [] arrPro = new Product[1000];
	private int index = 0;
	
	public void run() {
		showWelcomeMsg ();
		printMenu();
		
	}
	
	
	private void showWelcomeMsg () {
		System.out.println("****************************************************************");
		System.out.println("*                                                              *");
		System.out.println("*                                                              *");
		System.out.println("*         " + welcomeMsg + "        *");
		System.out.println("*                                                              *");
		System.out.println("*                                                              *");
		System.out.println("*                                                              *");
		System.out.println("****************************************************************");
	}
	
	private void printMenu () {
		Scanner scanner = new Scanner(System.in);
		
		boolean flag = true;
		
		while(flag){
			
			System.out.println("Please Enter an option.");
			System.out.println("1 Add Product.");
			System.out.println("2 Edit Product / Dollar Rate.");
			System.out.println("3 Print Product report.");
			System.out.println("4 exit.");
			
			String str = scanner.next();
			if (!isAnumber(str)) {		
				continue;
			}
			
			int key = Integer.valueOf(str);
			
			switch (key) {
			case 1:
				System.out.println("Add Product:");
				addNewProduct();
				break;
			case 2:
				editProduct();
				break;
			case 3:
				printProductReport();
				break;
			case 4:
				System.out.println("Exit.");
				flag = false;
				break;
	
			default:
				System.out.println("Must choose a number between 1-4.");
				break;
			}
		}
		
	}
	
	private void addNewProduct () {
		arrPro[index] = new Product();
		arrPro[index].setFullDetails();
		
		index++;
	}
	
	private void editProduct () {
		if (index == 0) {
			System.err.println("No products have been entered.");
			return;
		}
		System.out.println("Edit Product:");
		Scanner scanner = new Scanner(System.in);
		Boolean flag = true;
		
		while(flag) {
			System.out.println("Enter product's index number to edit:");
			System.out.println("0.Dollar rate");
			printProductsNames();
			String str = scanner.next();
			if (isAnumber(str)) {
				int input = Integer.valueOf(str);
				if (input > index || input < 0) {
					System.err.println("Not a valid product number.");
					continue;
				} else {
					if(input == 0) {
						arrPro[0].setDollarRate();
						return;
					} else {
						arrPro[input-1].setSpecificDetail();
						flag = false;
					}
				}
			}
		}
	}
	
	private void printProductsNames() {
		for (int i = 0; i < index; i++) {
			System.out.print(i + 1 + ".");
			arrPro[i].printProductsNames();
			System.out.println();
		}
	}
	
	private void printProductReport (){
		if (index == 0){
			System.err.println("No products to print a report of.");
		} else {
			System.out.println("Printing product report.");
			for (int i = 0; i < index; i++) {
				arrPro[i].printProductReport();
			}
		}	
	}
	
	public boolean isAnumber(String str) {
		try {
			Integer.valueOf(str); //if str not a number The command will fail and jump to catch
			return true;
		} catch (Exception e) {
			System.err.println("Must enter a number.");
			return false;
		}
	}
	
	
	
}
