﻿package net.sunj.learning.books.javajungsuk.ch07;

class InstanceofTest {
	public static void main(String args[]) {
		FireEngine fe = new FireEngine();

		if (fe instanceof FireEngine) {
			System.out.println("This is a FireEngine instance.");
		}

		if (fe instanceof Car) {
			System.out.println("This is a Car instance.");
		}

		if (fe instanceof Object) {
			System.out.println("This is an Object instance.");
		}
	}

	public static class Car {
	}

	public static class FireEngine extends Car {
	}
} // class
