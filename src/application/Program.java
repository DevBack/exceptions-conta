package application;

import java.util.Locale;
import java.util.Scanner;

import entities.Account;

public class Program {

	public static void main(String[] args) {
		
		Locale.setDefault(Locale.US);
		
		Scanner scanner = new Scanner(System.in);
		
		System.out.println("Informe os Dados da Conta\n");
		System.out.println("Número:");
		int number = scanner.nextInt();
		System.out.println("Titular:");
		scanner.nextLine();
		String holder = scanner.nextLine();
		System.out.println("Saldo Inicial:");
		double balance = scanner.nextDouble();
		System.out.println("Limite de Saque:");
		double withdrawLimit = scanner.nextDouble();
		
		Account account = new Account(number, holder, balance, withdrawLimit);
		
		System.out.println();
		System.out.println("Informe a Quantia para Sacar: ");
		double amount = scanner.nextDouble();
		
		String error = account.validateWithdraw(amount);
		if (error != null) {
			System.out.println(error);
		}
		else {
			account.withdraw(amount);
			System.out.printf("Novo Saldo: %.2f%n", account.getBalance());
		}
		scanner.close();
	}
}