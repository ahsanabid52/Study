package home.practice.basics.lamdaexpressions;

/*
 * 		Argument List			Arrow Token				Body
 *		(int x, int y)			 ->						x + y
 *
 *
*/

/*Predicate Method test
Determines if the input object matches some criteria. 
*/

/*Consumer Method accept
An operation which accepts a single input argument and returns no result. Unlike most other functional interfaces, Consumer is expected to operate via side-effects.*/

/*Supplier
An operation which returns a result based on the lambda expression and it takes no input.*/

/*Function
Represents a function that accepts one argument and produces a result.*/

/*Method References*/

/*Kinds of Method References
There are four kinds of method references:

Kind  Example
Reference to a static method                                                ContainingClass::staticMethodName
Reference to an instance method of a particular object                      containingObject::instanceMethodName
Reference to an instance method of an arbitrary object of a particular type ContainingType::methodName
Reference to a constructor                                                  ClassName::new
*/

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class LambdaExpressions {

  public static void main(String[] args) throws InterruptedException {
    new Thread(new myclass()).start();

    new Thread(new Runnable() {
      @Override
      public void run() {
        System.out.println("in runnable of anonyomous class");
      }
    }).start();
    /*
     * Lambda expressions can only be used with interfaces which have only one functions
     */
    Thread thread = new Thread(() -> {
      System.out.println("in runnable from the lambda expression");
      System.out.println("more code");
    });

    System.out.println("before");
    thread.start();

    Employee ahsan = new Employee("Ahsan Abid", 30);
    Employee kaka = new Employee("Kaka", 40);
    Employee umair = new Employee("Umair Naushad", 33);
    Employee atif = new Employee("Atif Rehman", 34);

    List<Employee> employees = new ArrayList<Employee>();
    employees.add(ahsan);
    employees.add(umair);
    employees.add(atif);
    employees.add(kaka);

    // Collections.sort(employees, new Comparator<Employee>() {
    // @Override
    // public int compare(Employee o1, Employee o2) {
    // return o1.getName().compareTo(o2.getName());
    // }
    // });

    // Collections.sort(employees, (Employee e1, Employee e2) ->
    // e1.getName().compareTo(e2.getName()));

    Collections.sort(employees, (e1, e2) -> e2.getName().compareTo(e1.getName()));

    for (Employee employee : employees) {
      System.out.println(employee);
    }

    /* With static final method */
    IUpperAndConcat uc = (s1, s2) -> {
      String result = s1.toUpperCase() + "--" + s2.toUpperCase();
      return result;
    };

    String sillyString = doStringStuff(uc, employees.get(0).getName(), employees.get(1).getName());
    System.out.println(sillyString);

    UpperAndConcat uc1 = new UpperAndConcat();
    System.out.println(uc1.doSomething());
    System.out.println("**********************************");
    for (Employee employee : employees) {
      System.out.println(employee.getName());
      new Thread(() -> System.out.println(employee.getAge())).start();
    }

    Thread.sleep(10000);

    System.out.println("**********************************");
    for (int i = 0; i < employees.size(); i++) {
      Employee employee = employees.get(i);
      System.out.println(employee.getName());
      new Thread(() -> System.out.println(employee.getAge())).start();
    }

  }

  public final static String doStringStuff(IUpperAndConcat uc, String s1, String s2) {
    return uc.upperAndConcat(s1, s2);

  }

}

class Employee {

  String name;
  int age;

  public Employee(String name, int age) {
    super();
    this.name = name;
    this.age = age;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public int getAge() {
    return age;
  }

  public void setAge(int age) {
    this.age = age;
  }

  @Override
  public String toString() {
    StringBuilder builder = new StringBuilder();
    builder.append("Employee [name=");
    builder.append(name);
    builder.append(", age=");
    builder.append(age);
    builder.append("]");
    return builder.toString();
  }

}

class myclass implements Runnable {
  @Override
  public void run() {
    System.out.println("in runnable of class");
  }
}

class UpperAndConcat {
  public String doSomething() {

    IUpperAndConcat uc = (s1, s2) -> {
      System.out.println("This class name is: " + getClass().getSimpleName());
      String result = s1.toUpperCase() + s2.toUpperCase();
      return result;
    };
    System.out.println("This UpperAndConcatImpl name is: " + getClass().getSimpleName());

    return LambdaExpressions.doStringStuff(uc, "Ahsan ", "Abid");

  }

  public void printNumber() {
    int number = 25;
    Runnable r = () -> {
      try {
        Thread.sleep(500);
      } catch (InterruptedException e) {
        e.printStackTrace();
      }
      System.out.println("Number is :" + number);
    };

    new Thread(r).start();
  }

}

interface IUpperAndConcat {
  public String upperAndConcat(String s1, String s2);
}