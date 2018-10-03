package home.practice.basics;

public class HelloWorld {
  public static int a = 0;

  public int getA() {
    return ++a;
  }

  public static void main(String[] args) {
    System.out.println("Hello World");
    /* Whole Numbers */
    /* one byte */
    byte myByteValue = 20;
    /* two byte */
    short myshortValue = 10;
    /* four byte */
    int myIntValue_old = 5;

    long myLongValue = 50000 + (10 * (myshortValue + myByteValue + myIntValue_old));
    System.out.println(myLongValue);

    /* Float & Double Numbers */

    int myIntValue = 5 / 3;
    /* four byte */
    float myFloatValue = 5f / 3f;
    /* eight byte */
    double myDoubleValue = 5d / 3d;

    System.out.println("myIntValue = " + myIntValue);
    System.out.println("myFloatValue = " + myFloatValue);
    System.out.println("myDoubleValue = " + myDoubleValue);

    double pounds = 200d;

    double kilograms = pounds * 0.45359237d;

    System.out.println(kilograms);

    /* char & boolean */

    /* two bytes */
    char myChar = '\u00A9';
    System.out.println("myChar = " + myChar);

    boolean myBoolean = false;

    System.out.println(myBoolean);

    /* Primitive Types Finished */

    /* Strings */
    String myString = "Ahsan Abid \u00A9";
    System.out.println(myString);

    /* Operators & Operator Precedence */

    boolean flag = false;

    if (flag = true) {
      System.out.println("This is not supposed to happen.");
    }

    if (flag) {
      System.out.println("This is the proper way to test the boolean.");
    }

    boolean wasFlag = flag ? true : false;
    System.out.println("Ternary operator result is:- " + wasFlag);

    double firstNumber = 20D;
    double secondNumber = 80D;

    double result = (firstNumber + secondNumber) * 25d;
    System.out.println(result);
    double remainder = result % 40d;

    System.out.println(remainder);

    if (remainder <= 20d) {
      System.out.println("Total was over the limit.");
    }

    /* Bitwise and Bit Shift Operators */

  }
}