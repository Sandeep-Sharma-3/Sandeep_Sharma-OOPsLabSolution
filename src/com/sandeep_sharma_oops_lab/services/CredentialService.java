package com.sandeep_sharma_oops_lab.services;

import com.sandeep_sharma_oops_lab.model.Employee;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

public class CredentialService {	
	
	public char[] generatePassword() {
		//Declare Strings for all usable letters in password
		String caps = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
		String smalls = "abcdefghijklmnopqrstuvwxyz";
		String specialChars = "!@#$%^&*_=+-/.?<>)";
		String numbers = "0123456789";
		//Including more special characters so that probability of choosing the will increase slightly
		String values = caps + smalls + specialChars + numbers;
		
		//There should be at least one small letter, one capital letter, one special character and one number
		Random random = new Random();
		
		int password_length = 10;
		
		//ArrayList data structure is chosen for password which will be converted to char[] 
		//This is because, I need to use Collections.shuffle(), which takes ArrayList as its parameter
		ArrayList<Character> password_list = new ArrayList<>(password_length);
		
		//initialize and add first four elements of ArrayList password_list
		char small_letter = smalls.charAt(random.nextInt(smalls.length()));
		char cap_letter = caps.charAt(random.nextInt(caps.length()));
		char special_char = specialChars.charAt(random.nextInt(specialChars.length()));
		char number = (char)(random.nextInt(10)+'0');
		
		password_list.add(small_letter);
		password_list.add(cap_letter);
		password_list.add(special_char);
		password_list.add(number);
		
		//add rest of elements
		int i;
		for(i = 4; i < password_length; ++i) {
			password_list.add(values.charAt(random.nextInt(values.length())));
		}
		
		//shuffle the list
		Collections.shuffle(password_list);
		
		//make password char[]
		char[] password = new char[password_length];
		for(i = 0; i < password_length; ++i) {
		    password[i] = password_list.get(i);
		  }
		return password;
	}
	
	public String generateEmailAddress(String firstName, String lastName, String department) {
		String email = null;
		
		switch(department) {
			case "Technical" :
				email = firstName.toLowerCase() + lastName.toLowerCase() + "@" + "tech.company.com";
				break;
			case "Admin" :
				email = firstName.toLowerCase() + lastName.toLowerCase() + "@" + "adm.company.com";
				break;
			case "Human Resource" :
				email = firstName.toLowerCase() + lastName.toLowerCase() + "@" + "hr.company.com";
				break;
			case "Legal" :
				email = firstName.toLowerCase() + lastName.toLowerCase() + "@" + "lg.company.com";
				break;
			default :
				System.out.println("Invalid Department.");
		}
		
		return email;
	}
	
	public void showCredentials(Employee emp) {
		System.out.println("Dear " + emp.getfirstName() + " your generated credentials are as follows : ");
		System.out.println("Email ---> " + emp.getEmail());
		String pass = new String(emp.getPassword());
		System.out.println("Password ---> " + pass);
	}
}
