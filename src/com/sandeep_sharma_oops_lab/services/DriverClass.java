package com.sandeep_sharma_oops_lab.services;

import java.util.Scanner;

import com.sandeep_sharma_oops_lab.model.Employee;

public class DriverClass {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner in = new Scanner(System.in);
		
		System.out.println("Enter employee first name : ");
		String firstName = in.next();
		//in.nextLine();//To empty out enter, pressed after entering first name
		
		System.out.println("Enter employee last  name : ");
		String lastName = in.next();
		
		Employee employee = new Employee(firstName, lastName);
		
		String department = null;
		int options;
		do {
			System.out.println("Please enter the department for the employee : ");
			System.out.println("1. Technical");
			System.out.println("2. Admin");
			System.out.println("3. Human Resource");
			System.out.println("4. Legal");
			
			options = in.nextInt();
			
			switch(options) {
				case 1 :
					department = "Technical";
					break;
				case 2 :
					department = "Admin";
					break;
				case 3 :
					department = "Human Resource";
					break;
				case 4 :
					department = "Legal";
					break;
				default :
					System.out.println("Invalid choice. Please enter a number between 1-4.");
					break;
			}
			
			System.out.println("\n");
		} while (options != 1 && options != 2 && options != 3 && options != 4);
		
		employee.setDepartment(department);
		
		CredentialService cs = new CredentialService();	
		
		employee.setEmail(cs.generateEmailAddress(employee.getfirstName(), employee.getlastName(), employee.getDepartment()));
		employee.setPassword(cs.generatePassword());
		
		cs.showCredentials(employee);
		
		in.close();
	}

}
