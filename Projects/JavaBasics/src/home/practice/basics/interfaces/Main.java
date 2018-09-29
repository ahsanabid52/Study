package home.practice.basics.interfaces;

import java.util.Random;
import java.util.function.Supplier;

public class Main {

  public static void main(String[] args) {
    
    abc a = new abc();
    
    a.print();
    
    IPhone myPhone = new DeskPhone(553273615, "AhsanAbid");
    myPhone.powerOn();
    myPhone.dial(508900196);
    myPhone.ring();

    myPhone = new MobilePhone();
    myPhone.powerOn();
    myPhone.dial(508900196);
    myPhone.ring();

    ISMS sms = (String m) -> {
      return m.toUpperCase();
    };

    String message = "This is my first functional interface.";
    System.out.println(sms.write(message));
    sms.read(message);

    SeriesGenerator seriesGenerator = (start, diff, cycles) -> {
      StringBuilder stringBuilder = new StringBuilder().append(start).append(",");
      for (int i = 0; i < cycles; i++) {
        start += diff;
        stringBuilder.append(start).append(",");
      }
      stringBuilder.replace(stringBuilder.lastIndexOf(","), stringBuilder.length(), ".....");
      return stringBuilder.toString();

    };

    System.out.println("Odd Numbers:- " + seriesGenerator.generateSeries(1, 2, 5));
    System.out.println("Even Numbers:- " + seriesGenerator.generateSeries(0, 2, 5));

    System.out.println("Custom Numbers:- " + seriesGenerator.generateSeries(0, -2, 5));

    Supplier<Integer> intSupplier;

    Random random = new Random();
    intSupplier = () -> {
      return random.nextInt(215442);
    };

    System.out.println(intSupplier.get());

  }
  
  
  
}


 class abc{
  public void print() {
    System.out.println("this is a public class");
  }
}