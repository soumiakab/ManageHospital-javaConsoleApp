package com.hospital.helpers;

import java.util.Scanner;

public class HValidateInput {
	static Scanner input = new Scanner(System.in);

	public static Integer getInteger() {
	boolean isInteger=false;
	int i=0;
		do {
			try {
				String str =input.nextLine();
				 i = Integer.parseInt(str);				
				 isInteger=true;
			}catch (Exception e) {
				HOutput.write("Veuillez entrer un numero valid");
				isInteger=false;
			}
			
		}while (!isInteger || i==0);
		i--;
		return i;
	}
	
	
	
	public static Double getDouble() {
		boolean isDouble=false;
		double i=0;
			do {
				try {
					String str =input.nextLine();
					 i = Double.parseDouble(str);				
					 isDouble=true;
				}catch (Exception e) {
					HOutput.write("Veuillez entrer un chiffre valid");
					isDouble=false;
				}
				
			}while (!isDouble || i==0);
			return i;
		}
	
	
}
