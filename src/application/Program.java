package application;

import java.text.SimpleDateFormat;
import java.util.Locale;
import java.util.Scanner;

import model.entities.Account;
import model.exception.DomainException;

public class Program {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		Locale.setDefault(Locale.US);
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		
		System.out.println("Enter account data: ");
		System.out.println("Number: ");
		int number = sc.nextInt();
		System.out.println("Holder: ");
		sc.nextLine();
		String holder = sc.nextLine();
		System.out.println("Initial balance: ");
		Double initialBalance = sc.nextDouble();
		System.out.println("Withdraw limit: ");
		double withdrawLimit = sc.nextDouble();
		Account account = new Account(number, holder, initialBalance, withdrawLimit);
		
		System.out.println();
		
		
		System.out.println("Enter amount for withdraw: ");
		double amount = sc.nextDouble();
		
		try {
			account.withdraw(amount);
			
			System.out.println("New balance: " + String.format("%.2f", account.getBalance()));

		} 
		catch(DomainException e){
			System.out.println("Withdraw error! " + e.getMessage());
		}
		sc.close();

	}

}
