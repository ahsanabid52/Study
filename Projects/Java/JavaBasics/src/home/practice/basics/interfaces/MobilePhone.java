package home.practice.basics.interfaces;

public class MobilePhone implements IPhone, ISMS {

  int number;
  String name;

  public MobilePhone() {
    super();
  }

  public MobilePhone(int number, String name) {
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
    System.out.println("DeskPhoneDialing the number: " + phoneNumber);
  }

  @Override
  public String write(String message) {
    System.out.println("Message Written to : " + message);
    return message.toUpperCase();
  }
}