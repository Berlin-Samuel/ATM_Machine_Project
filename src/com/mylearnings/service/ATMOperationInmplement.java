/**
 * FileName: ATMOperationInmplement.java
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
package com.mylearnings.service;

import java.util.HashMap;
import java.util.Map;

import com.mylearnings.pojo.ATM;

public class ATMOperationInmplement implements ATMOperation {
	ATM atm = new ATM();
	Map<Double, String> ministatement = new HashMap<>();

	@Override
	public void viewBalance() {
		System.out.println("Available Balance is : " + atm.getBalance());
		System.out.println("==========================================");
	}

	@Override
	public void withdrawAmount(double withdrawAmount) {
		if (withdrawAmount % 500 == 0) {
			if (withdrawAmount < atm.getBalance()) {
				ministatement.put(withdrawAmount, " Amount Withdrawn");
				System.out.println("Collect the Cash " + withdrawAmount);
				atm.setBalance(atm.getBalance() - withdrawAmount);
				viewBalance();
			} else {
				System.out.println("Insufficient Balance");
				System.out.println("==========================================");
			}
		} else {
			System.out.println("Please enter the amount multiple of 500");
		}
	}

	@Override
	public void depositAmount(double depositAmount) {
		ministatement.put(depositAmount, " Amount Deposited");
		System.out.println(depositAmount + " Deposited Successfully !!!!");
		atm.setBalance(atm.getBalance() + depositAmount);
		viewBalance();
	}

	@Override
	public void viewMiniStatement() {
		for (Map.Entry<Double, String> min : ministatement.entrySet()) {
			System.out.println(min.getKey() +" "+ min.getValue());

		}
		System.out.println("==========================================");

	}

}
