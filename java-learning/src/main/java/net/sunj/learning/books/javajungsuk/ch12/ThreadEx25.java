﻿package net.sunj.learning.books.javajungsuk.ch12;

class ThreadEx25 {
	public static void main(String args[]) {
		Runnable r = new RunnableEx101();
		Thread t1 = new Thread(r);
		Thread t2 = new Thread(r);

		t1.start();
		t2.start();
	}

	public static class Account {
		int balance = 1000;

		public synchronized void withdraw(int money) {
			if (balance >= money) {
				try {
					Thread.sleep(1000);
				} catch (Exception e) {
				}
				balance -= money;
			}
		} // withdraw
	}

	public static class RunnableEx101 implements Runnable {
		Account acc = new Account();

		public void run() {
			while (acc.balance > 0) {
				int money = (int) (Math.random() * 3 + 1) * 100;
				acc.withdraw(money);
				System.out.println("balance:" + acc.balance);
			}
		} // run()
	}
}
