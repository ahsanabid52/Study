package home.practice.basics.lamdaexpressions.util;

/*
 * 		Argument List			Arrow Token				Body
 *		(int x, int y)			 ->						x + y
 *
 *
*/

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.function.Function;
import java.util.function.IntPredicate;
import java.util.function.Predicate;
import java.util.function.Supplier;

@SuppressWarnings("unused")
public class LambdaExpressionsMain {

	/* Consumer vs Predicate vs Supplier vs Functions */

	public static void main(String[] args) throws InterruptedException {

		Employee ahsan = new Employee("Ahsan Abid", 30);
		Employee kaka = new Employee("Kaka", 40);
		Employee umair = new Employee("Umair Naushad", 33);
		Employee atif = new Employee("Atif Rehman", 34);
		Employee atif1 = new Employee("Atif Rehman", 27);
		Employee atif2 = new Employee("Atif Rehman", 23);

		List<Employee> employees = new ArrayList<Employee>();
		employees.add(ahsan);
		employees.add(umair);
		employees.add(atif);
		employees.add(atif1);
		employees.add(atif2);
		employees.add(kaka);
		/* Predicates */
		// predicatesTesting(employees);
		/* Suppliers */
		// suppliersTesting(employees);

		/* Functions */
		 functionsTesting(employees);

	}

	private static void functionsTesting(List<Employee> employees) {
		System.out.println("####################################");
		System.out.println("#############Functions##############");
		Function<Employee, String> getTheLastName = employee -> {
			return employee.getName().substring(employee.getName().indexOf(' ') + 1);
		};

		System.out.println(getTheLastName.apply(employees.get(5)));

		Function<Employee, String> getTheFirstName = employee -> {
			return employee.getName().substring(0, employee.getName().indexOf(' ') + 1);
		};

		Random random = new Random();

		for (Employee employee2 : employees) {

			if (random.nextBoolean()) {
				System.out.println(getAName(getTheFirstName, employee2));
			} else {
				System.out.println(getAName(getTheLastName, employee2));
			}
		}
		System.out.println("####################################");
		System.out.println("######Chaining Functions############");
		Function<Employee, String> getName = employee -> employee.getName().replaceAll(" ", "");
		Function<String, String> userName = name -> name.toLowerCase();
		Function<Employee, String> makeUserName = getName.andThen(userName);

		for (Employee employee2 : employees) {
			System.out.println(makeUserName.apply(employee2));
		}
		System.out.println("####################################");
	}

	private static String getAName(Function<Employee, String> function, Employee e) {
		return function.apply(e);
	}

	private static void suppliersTesting(List<Employee> employees) {
		Random random = new Random();
		Supplier<Integer> supInt = () -> random.nextInt(10);

		for (int i = 0; i < 10; i++) {
			System.out.println(supInt.get());
		}

		employees.forEach(employee -> {
			String lastName = employee.getName().substring(employee.getName().indexOf(' ') + 1,
					employee.getName().length());
			System.out.println(lastName);
		});

	}

	private static void predicatesTesting(List<Employee> employees) {

		System.out.println("####################################");
		printEmployeesByAge(employees);
		System.out.println("####################################");

		String condition = "Print the employee whose age is greater then or equal to 30";
		Predicate<Employee> ageGreaterThen30 = employee -> employee.getAge() >= 30;
		printEmployeesByAgeUsingPredicate(employees, condition, ageGreaterThen30);
		System.out.println("####################################");

		condition = "Print the employee whose age is lesser then 30";
		Predicate<Employee> ageLesserThen30 = employee -> employee.getAge() < 30;
		printEmployeesByAgeUsingPredicate(employees, condition, ageLesserThen30);

		System.out.println("####################################");

		condition = "Print the employee whose age is lesser then 25";

		printEmployeesByAgeUsingPredicate(employees, condition, new Predicate<Employee>() {
			@Override
			public boolean test(Employee t) {
				return t.getAge() < 25;
			}
		});

		IntPredicate greaterThen15 = i -> i > 15;
		IntPredicate lessThen30 = i -> i < 30;
		System.out.println(greaterThen15.test(employees.get(0).getAge()));
		System.out.println(greaterThen15.and(lessThen30).test(employees.get(0).getAge()));

	}

	private static void printEmployeesByAge(List<Employee> employees) {
		employees.forEach(employee -> {
			if (employee.getAge() >= 30) {
				System.out.print("Name: " + employee.getName());
				System.out.println(" Age: " + employee.getAge());
			}
		});
	}

	private static void printEmployeesByAgeUsingPredicate(List<Employee> employees, String condition,
			Predicate<Employee> predicate) {
		System.out.println(condition);
		for (Employee employee : employees) {
			if (predicate.test(employee)) {
				System.out.print("Name: " + employee.getName());
				System.out.println(" Age: " + employee.getAge());
			}
		}
	}
}