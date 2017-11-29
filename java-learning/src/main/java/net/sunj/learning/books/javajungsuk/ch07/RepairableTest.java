﻿package net.sunj.learning.books.javajungsuk.ch07;

class RepairableTest {
	public static void main(String[] args) {
		Tank tank = new Tank();
		Dropship dropship = new Dropship();

		Marine marine = new Marine();
		SCV scv = new SCV();

		scv.repair(tank); // SCV가 Tank를 수리하도록 한다.
		scv.repair(dropship);
		// scv.repair(marine); // 에러! repair(Repairable) in SCV cannot be
		// applied to (Marine)
	}

	public static interface Repairable {
	}

	public static class GroundUnit extends Unit {
		GroundUnit(int hp) {
			super(hp);
		}
	}

	public static class AirUnit extends Unit {
		AirUnit(int hp) {
			super(hp);
		}
	}

	public static class Unit {
		int hitPoint;
		final int MAX_HP;

		Unit(int hp) {
			MAX_HP = hp;
		}
		// ...
	}

	public static class Tank extends GroundUnit implements Repairable {
		Tank() {
			super(150); // Tank의 HP는 150이다.
			hitPoint = MAX_HP;
		}

		public String toString() {
			return "Tank";
		}
		// ...
	}

	public static class Dropship extends AirUnit implements Repairable {
		Dropship() {
			super(125); // Dropship의 HP는 125이다.
			hitPoint = MAX_HP;
		}

		public String toString() {
			return "Dropship";
		}
		// ...
	}

	public static class Marine extends GroundUnit {
		Marine() {
			super(40);
			hitPoint = MAX_HP;
		}
		// ...
	}

	public static class SCV extends GroundUnit implements Repairable {
		SCV() {
			super(60);
			hitPoint = MAX_HP;
		}

		void repair(Repairable r) {
			if (r instanceof Unit) {
				Unit u = (Unit) r;
				while (u.hitPoint != u.MAX_HP) {
					/* Unit의 HP를 증가시킨다. */
					u.hitPoint++;
				}
				System.out.println(u.toString() + "의 수리가 끝났습니다.");
			}
		}
		// ...
	}
}