package service;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static junit.framework.TestCase.assertTrue;


/**
 * Created by letayo on 1/16/17.
 */
public class ListePartageImplTest {
	
	private ListePartage listePartageImpl;

	
	@Before
	public void setUp() throws Exception {
		listePartageImpl = new ListePartageImpl();
	}
    //Test with list of Integers	
    @Test
    public void simplePartitionIntegerList() {
        List<Object> originalList = Arrays.asList(1, 2, 3, 4, 5);
        List<List<Object>> output = listePartageImpl.partition(originalList, 2);
        List<List<Integer>> testList = Arrays.asList(Arrays.asList(1, 2), Arrays.asList(3, 4), Collections.singletonList(5));
        for (int i = 0; i < output.size(); i++) {
            assertTrue(output.get(i).equals(testList.get(i)));
        }

        // display results
        System.out.println("Original list content: " + originalList);
        System.out.println("The partitioned List :" + output);
        output.forEach(subList -> System.out.println("SubList :" + subList));

    }

    //Test with list of String
    @Test
    public void simplePartitionStringList() {
        List<Object> originalList = Arrays.asList("France", "Russie", "Espagne", "Allemagne", "Finlande", "Pologne");
        List<List<Object>> output = listePartageImpl.partition(originalList, 2);
        List<List<String>> testList = Arrays.asList(Arrays.asList("France", "Russie"), Arrays.asList("Espagne", "Allemagne"), Arrays.asList("Finlande", "Pologne"));
        
        for (int i = 0; i < output.size(); i++) {
            assertTrue(output.get(i).equals(testList.get(i)));
        }

        // display results
        System.out.println("Original list content: " + originalList);
        System.out.println("The partitioned List :" + output);
        output.forEach(subList -> System.out.println("SubList :" + subList));
    }

    //the value of taille is zero
    @Test(expected = IllegalArgumentException.class)
    public void testWithZeroSize() {
        listePartageImpl.partition(Arrays.asList(1, 2, 3, 4, 5), 0);
    }

    // The value of taille is greater than size original list
    @Test(expected = IllegalArgumentException.class)
    public void testWithBigSize() {
        listePartageImpl.partition(Arrays.asList(1, 2, 3, 4, 5), 7);
    }

    //negative value for taille
    @Test(expected = IllegalArgumentException.class)
    public void testWithNegativeSize() {
        listePartageImpl.partition(Arrays.asList(1, 2, 3, 4, 5), -6);
    }

    //The size of the liste is zero
    @Test(expected = IllegalArgumentException.class)
    public void testithEmptOriginalList() {
        listePartageImpl.partition(new ArrayList<>(), 2);
    }

}


