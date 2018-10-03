package home.practice.basics.interfaces;

public class DeskPhone implements IPhone {

  int number;
  String name;

  public DeskPhone() {
    super();
  }

  public DeskPhone(int number, String name) {
    super();
    this.number = number;
    this.name = name;
  }

  @Override
  public void powerOff() {
    System.out.println("DeskPhonePowerOff");
  }

  @Override
  public void powerOn() {
    System.out.println("DeskPhonePowerOn");
  }

  @Override
  public String ring() {
    return "The Phone is ringing.";
  }

  @Override
  public void dial(int phoneNumber) {
    System.out.println("DeskPhone Dialing the number: " + phoneNumber);
  }

}