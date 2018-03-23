package org.sunj.refactoring.ch01.refactoring01;

import java.util.Enumeration;
import java.util.Vector;

public class Customer {
  private String _name;
  private Vector<Rental> _rentals = new Vector<Rental>();

  public Customer(String name) {
    _name = name;
  };

  public void addRental(Rental arg) {
    _rentals.addElement(arg);
  }

  public String getName() {
    return _name;
  };

  public String statement() {
    Enumeration<Rental> rentals = _rentals.elements();
    String result = getName() + " 고객님의 대여 기록\n";
    while (rentals.hasMoreElements()) {
      Rental each = rentals.nextElement();

      // 이번에 대여하는 비디오 정보와 대여료를 출력
      result += "\t" + each.getMovie().getTitle() + "\t" + String.valueOf(each.getCharge()) + "\n";
    }

    // 푸터 행 추가
    result += "누적 대여료 : " + String.valueOf(getTotalCharge()) + "\n";
    result += "적립 포인트 : " + String.valueOf(getToalFrequentRenterPoints());
    return result;
  }

  public String htmlStatement() {
    Enumeration<Rental> rentals = _rentals.elements();
    String result = "<h1><em>" + getName() + " 고객님의 대여 기록</em></h1><p>\n";
    while (rentals.hasMoreElements()) {
      Rental each = rentals.nextElement();

      // 이번에 대여하는 비디오 정보와 대여료를 출력
      result +=
          "\t" + each.getMovie().getTitle() + "\t" + String.valueOf(each.getCharge()) + "<br>\n";
    }

    // 푸터 행 추가
    result += "<p>누적 대여료 : <em>" + String.valueOf(getTotalCharge()) + "</em><p>\n";
    result += "<p>적립 포인트 : <em>" + String.valueOf(getToalFrequentRenterPoints() + "</em><p>");
    return result;
  }

  private int getToalFrequentRenterPoints() {
    int result = 0;
    Enumeration<Rental> rentals = _rentals.elements();
    while (rentals.hasMoreElements()) {
      Rental each = rentals.nextElement();
      result += each.getFrequentRenterPoints();
    }
    return result;
  }

  private double getTotalCharge() {
    double result = 0;
    Enumeration<Rental> rentals = _rentals.elements();
    while (rentals.hasMoreElements()) {
      Rental each = rentals.nextElement();
      result += each.getCharge();
    }
    return result;
  }

}
