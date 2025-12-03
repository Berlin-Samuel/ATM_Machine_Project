/**
 * FileName: ATMDriver.java
 * Author   : Admin
 * Version  : 1.0
 * Date     : 03-Dec-2025
 * 
 * This file is part of a personal learning project.
 * 
 * Licensed under the MIT License.
 * 
 * Copyright (c) 2025 Berlin Samuel.
 * Permission is hereby granted, free of charge, to any person obtaining a copy  
 * of this software and associated documentation files (the "Software"), to deal  
 * in the Software without restriction, including without limitation the rights  
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell  
 * copies of the Software, and to permit persons to whom the Software is  
 * furnished to do so, subject to the following conditions:
 * 
 * The above copyright notice and this permission notice shall be included in  
 * all copies or substantial portions of the Software.
 * 
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR  
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,  
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT.
 * 
 * REVISION     DATE           NAME         DESCRIPTION  
 * 1.0          03-Dec-2025        Berlin        Initial Code  
 * 
 * @author Berlin
 * @version 1.0
 * @since 03-Dec-2025
 */
package com.mylearnings.driverclass;

import java.util.Scanner;

import com.mylearnings.service.ATMOperation;
import com.mylearnings.service.ATMOperationInmplement;

public class ATMDriver {
	public static void main(String[] args) {
		ATMOperation opAtm = new ATMOperationInmplement();
		int atmNumber = 12345;
		int atmPin = 123;
		System.out.println("Welcome To ATM Machine");
		System.out.println("==============");
		Scanner scan = new Scanner(System.in);
		System.out.print("Enter the ATM Number : ");
		int atmnumber = scan.nextInt();
		System.out.print("Enter the ATM Pin : ");
		int atmpin = scan.nextInt();
		if ((atmNumber == atmnumber) && (atmPin == atmpin)) {
			boolean running = true;
			while (running) {
				System.out.println(
						"1.View Available Balance\n2.Withdraw Amount\n3.Deposit Amount\n4.View Ministatement\n5.Exit");
				System.out.println("Enter Choice :");
				int choice = scan.nextInt();
				switch (choice) {
				case 1:
					opAtm.viewBalance();
					break;
				case 2:
					System.out.println("Enter Amount to Withdraw : ");
					double withdrawAmount = scan.nextDouble();
					opAtm.withdrawAmount(withdrawAmount);
					break;
				case 3:
					System.out.println("Enter Amount to Deposit : ");
					double depositAmount = scan.nextDouble();
					opAtm.depositAmount(depositAmount);
					break;
				case 4:
					opAtm.viewMiniStatement();
					break;
				case 5:
					System.out.println("Collect your ATM Card\n Thank You for Using this ATM");
					System.exit(0);
					break;
				default:
					System.out.println("Please enter the correct choice");
				}
			}
		} else {
			System.out.println("Incorrect ATM Number or PIN");
			System.exit(0);
		}
		scan.close();
	}
}
