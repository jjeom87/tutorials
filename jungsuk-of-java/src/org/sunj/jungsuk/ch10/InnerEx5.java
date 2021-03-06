﻿package org.sunj.jungsuk.ch10;

class InnerEx5 {
	public static class Outer {
		int value = 10; // Outer.this.value

		class Inner {
			int value = 20; // this.value

			void method1() {
				int value = 30;
				System.out.println("           value :" + value);
				System.out.println("      this.value :" + this.value);
				System.out.println("Outer.this.value :" + Outer.this.value);
			}
		} // Inner클래스의 끝
	} // Outer클래스의 끝

	public static void main(String args[]) {
		Outer outer = new Outer();
		Outer.Inner inner = outer.new Inner();
		inner.method1();
	}
} // InnerEx5 끝