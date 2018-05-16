package com.java.produtcs;

import java.util.Scanner;

public class Product {

	private String ProductType;
	private String name;
	private double price;
	private double quantity;
	private static double dollarRate;
	
	
	
	
	
	public void setFullDetails(){
		Scanner s = new Scanner(System.in);
		
		System.out.println();
		System.out.println("Enter Product type:");
		setProductType(s.next());
		System.out.println("Enter Product name:");
		setName(s.next());
		
		Boolean flag = true;
		while (flag) {	
			System.out.println("Enter price:");
			
			String str = s.next();
			if (isAdouble(str)) {
				double input = Double.valueOf(str);
				if (input < 0) {
					System.err.println("Must enter a positive value.");
					continue;
				} else {
					setPrice(input);
					flag = false;
				}
			}
		}
		
		flag = true;
		while(flag) {
			System.out.println("Enter quantity:");
			
			String str = s.next();
			if (isAdouble(str)) {
				double input = Double.valueOf(str);
				if (input < 0) {
					System.err.println("Must enter a positive value.");
					continue;
				} else {
					setQuantity(input);
					flag = false;
				}
			}
		}
	}

	public void printProductsNames () {
		System.out.print(name);
	}
	
	public void setSpecificDetail () {
		Scanner j = new Scanner(System.in);
		
		Boolean flag = true;
		while(flag) {
			System.out.println("Select the number of the item you want to edit: ");
			System.out.println("1. Product Type.");
			System.out.println("2. Name.");
			System.out.println("3. Price.");
			System.out.println("4. Quantity.");
			System.out.println("5. Back to main menu.");
			
			String str = j.next();
			if (!isAnumber(str)) {		
				continue;
			}
			int userInput = Integer.valueOf(str);
			
			switch (userInput) {
			case 1:
				System.out.println("Enter product's type:");
				setProductType(j.next());
				break;
			case 2:
				System.out.println("Enter a new name:");
				setName(j.next());
				break;
			case 3:
				Boolean flag1 = true;
				while(flag1) {
					System.out.println("Enter a new price:");
					String str1 = j.next();
					if (isAdouble(str1)) {
						double input = Double.valueOf(str1);
						if (input < 0) {
							System.err.println("Must enter a positive value.");
							continue;
						} else {
							setPrice(input);
							flag1 = false;
						}
					}
				}
				break;
			case 4:
				flag1 = true;
				while(flag1) {
					System.out.println("Enter a new quantity value:");
					String str1 = j.next();
					if (isAdouble(str1)) {
						double input = Double.valueOf(str1);
						if (input < 0) {
							System.err.println("Must enter a positive value.");
							continue;
						} else {
							setQuantity(input);
							flag1 = false;
						}
					}
				}
				break;
			case 5:
				return;
				
			default:
				System.out.println("Must choose a number between 1-5.");
				break;
			}
		}
	}
	
	public void printProductReport() {
		System.out.println();
		System.out.println("Product Type: "+ ProductType + ".");
		System.out.println("Product name: "+ name + ".");
		System.out.println("Price: "+ price + " NIS.");
		System.out.println("Quantity: "+ quantity + ".");
		System.out.println("Stock Value: " + quantity * price + " NIS.");
		System.out.println("Dollar rate: " + dollarRate + ".");
		System.out.println("Stock Value in $: " + (price * dollarRate) * quantity + "$.");
		System.out.println("_______________________________");
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
	
	public static boolean isAdouble(String str) {
		try {
			Double.valueOf(str); //if str not a number The command will fail and jump to catch
			return true;
		} catch (Exception e) {
			System.err.println("Must enter a number.");
			return false;
		}
	}
	
	
	
	public String getName() {
		return name;
	}

	private void setName(String name) {
		this.name = name;
	}

	public double getPrice() {
		return price;
	}

	private void setPrice(double price) {
		this.price = price;
	}

	public double getQuantity() {
		return quantity;
	}

	private void setQuantity(double quantity) {
		this.quantity = quantity;
	}

	public String getProductType() {
		return ProductType;
	}

	private void setProductType(String productType) {
		ProductType = productType;
	}

	public static double getDollarRate() {
		return dollarRate;
	}

	public static void setDollarRate() {
		Scanner j = new Scanner(System.in);
		Boolean flag = true;
		while(flag) {
			System.out.println("Enter a new dollar rate:");
			String str1 = j.next();
			if (isAdouble(str1)) {
				double input = Double.valueOf(str1);
				if (input < 0) {
					System.err.println("Must enter a positive value.");
					continue;
				} else {
					Product.dollarRate = input;;
					flag = false;
				}
			}
		}
		
	}
	
	
	

	
}
