package home.practice.basics.lamdaexpressions.util;

/*Streams
A stream represents a sequence of elements and supports different kind of operations to perform computations upon those elements:
*/
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class LEStreams {

  static Employee ahsan = new Employee("Ahsan Abid", 30);
  static Employee kaka = new Employee("Kaka", 40);
  static Employee umair = new Employee("Umair Naushad", 33);
  static Employee atif = new Employee("Atif Rehman", 34);
  static Employee atif1 = new Employee("Atif Rehman", 27);
  static Employee atif2 = new Employee("Atif Rehman", 23);

  public static void main(String[] args) throws IOException {

    // streamsBasics();

    usingFlatMaps();

  }

  private static void usingFlatMaps() {
    /* Using FlatMap */
    System.out.println("###############################");
    System.out.println("###########FlatMaps############");
    Department sales = new Department("Sales");
    sales.addEmployee(kaka);
    sales.addEmployee(umair);
    sales.addEmployee(atif);
    sales.addEmployee(atif1);
    sales.addEmployee(atif2);

    Department development = new Department("Development");
    development.addEmployee(ahsan);

    List<Department> listOfDepartments = new ArrayList<>();
    listOfDepartments.add(development);
    listOfDepartments.add(sales);

    listOfDepartments.stream().flatMap(department -> department.getEmployees().stream())
        .forEach(System.out::println);
    Map<Integer, List<Employee>> employeesByAge = listOfDepartments.stream()
        .flatMap(department -> department.getEmployees().stream())
        .collect(Collectors.groupingBy(employee -> employee.getAge()));
    System.out.println("###############################");

    listOfDepartments.stream().flatMap(department -> department.getEmployees().stream())
        .reduce((e1, e2) -> e1.getAge() < e2.getAge() ? e1 : e2).ifPresent(System.out::println);
    System.out.println("###############################");

    Stream.of("AB", "AA", "AC", "CA", "XX", "AHS").filter(s -> s.length() == 2)
        .forEach(System.out::println);

    System.out.println("###############################");
  }

  private static void streamsBasics() {
    System.out.println("###############################");
    List<String> names = Arrays.asList("ahsan", "abid", "atif", "zubair");
    List<String> alphaNames = new ArrayList<>();
    names.forEach(name -> {
      if (name.startsWith("a")) {
        alphaNames.add(name);
      }
    });

    alphaNames.sort((String s1, String s2) -> s1.compareTo(s2));
    alphaNames.forEach(name -> System.out.println(name));

    System.out.println("###############################");
    System.out.println("\n\n\n###########STREAMS############");

    /* Method reference */
    names.stream().map(String::toUpperCase).filter(s -> s.startsWith("A")).sorted()
        .forEach(System.out::println);
    /* For each is a terminal operations as it does not returns a stream. */
    System.out.println("###############################");
    System.out.println("\n\n\n###########STREAMS############");
    Stream<String> listOfStrings = Stream.of("ahsan", "mohsin", "asim", "umair", "ahsan", "mohsin");
    Stream<String> concatStreams = Stream.concat(listOfStrings, names.stream());
    System.out
        .println("Count is : " + concatStreams.sequential().peek(System.out::println).count());

    List<String> namesStartingWithAsc = names.stream().map(String::toUpperCase)
        .filter(s -> s.startsWith("A")).sorted().collect(Collectors.toList());

    List<String> namesStartingWithDesc = names.stream().map(String::toUpperCase)
        .filter(s -> s.startsWith("A")).sorted((String s1, String s2) -> s2.compareTo(s1))
        .collect(ArrayList::new, ArrayList::add, ArrayList::addAll);

    PrinterObject print = new PrinterObject();
    /* Multiple ways to iterate over the collection */
    namesStartingWithAsc.forEach(s -> System.out.println(s));
    namesStartingWithAsc.forEach(System.out::println);
    namesStartingWithAsc.forEach(home.practice.basics.lamdaexpressions.util.LEStreams::printString);
    namesStartingWithAsc.forEach(print::printString);
    System.out.println("###############################");

    namesStartingWithDesc.forEach(print::printString);

  }

  public static void printString(String name) {
    System.out.println("Printing a name using method references :: " + name);
  }

}