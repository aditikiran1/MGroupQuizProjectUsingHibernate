package com.quiz.util;

import java.util.Scanner;

import com.quiz.NewQuizProject.Main;

public class ConsoleUtil {
	
	public static Scanner sc;

	public static int getMenuOption() {
		System.out.println("Welcome! What would you like to do?");
		System.out.println("1.Play quiz");
		System.out.println("2.View score");
		System.out.println("3.View score list");
		System.out.println();
		System.out.println("4.Exit");
		System.out.println("Choose one of the above options: ");
		
		Scanner sc = new Scanner(System.in);
		int i = sc.nextInt();
		
		return i;
	}
	
	public static void doYouWantToContinue() {
		System.out.println("do you want to continue?");
		System.out.println("press y to continue or n to exit");
		Scanner sc = new Scanner(System.in);
		String userChoice = sc.next();
		Character ch = userChoice.charAt(0);
		String expectedChoice="";
		switch(Character.toLowerCase(ch)) {
		case 'y':  Main.main(null);
		break;
		case 'n': System.exit(0);
		break;
		default: System.out.println("you entered: "+userChoice);
		System.out.println("please enter correct choice:");
		doYouWantToContinue();
		break;
		}
		
	}
}
