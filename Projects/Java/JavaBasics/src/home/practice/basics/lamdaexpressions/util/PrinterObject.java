package home.practice.basics.lamdaexpressions.util;

public class PrinterObject {

	public void printString(String name) {
		System.out.println(
				"Printing a name using method references with class name " + getClass().getSimpleName() + " :: " + name);
	}
}