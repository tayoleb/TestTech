package service;

import java.util.Arrays;
import java.util.List;

public class ListePartageMain {
	public static void main(String[] args) {
		ListePartage listePartageImpl = new ListePartageImpl();
		List<Object> originalList = Arrays.asList('A', 'D', 'N', 'E', 'O', 'M');
		List<List<Object>> output = listePartageImpl.partition(originalList, 2);
		System.out.println("Original list content: " + originalList);
	    System.out.println("The partitioned List :" + output);
	    output.forEach(subList -> System.out.println("SubList :" + subList));
       	}
}
