﻿package org.sunj.jabook.ch07;

public class BombComputerUser1 {

	public static void main(String[] args) {
		BombComputer bc = new BombComputer();

		try {
			bc.powerOn();
			bc.processJob();
			bc.powerOff();
		} catch (Exception e) {
			System.out.println("--Exception 발생구문--");
			System.out.println("정보:e.getMessage(): " + e.getMessage());
			System.out.println("정보:e.toString(): " + e.toString());
			System.out.print("정보:e.printStackTrace():");
			e.printStackTrace();
		}
	}
}