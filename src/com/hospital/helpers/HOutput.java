package com.hospital.helpers;

import java.util.List;

import com.hospital.enumerations.OperationEnum;

public class HOutput {
	
	public static <T>  void write(T Towrite) {
		System.out.println(Towrite);
	}

	public static  <T> void showList(List<T> list) {
		int i=1;
		for(T element:list) {
			System.out.println(i+"- "+element+"\n");
			i++;
		}
	}

	public static  <T> void showList(T[] arr) {
		int i=1;
		for(T element:arr) {
			System.out.println(i+"- "+element+"\n");
			i++;
		}
		
	}
}
