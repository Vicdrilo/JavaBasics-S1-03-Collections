package n1exercici2;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Main {

	public static void main (String[] args) {
		System.out.println("Creació de firstList: \n\n");
		List<Integer> firstList = new ArrayList<>();
		int i = 0;
		while(i!=10) {
			i++;
			firstList.add(i);
		}
		for (Integer item : firstList) {
			System.out.println(item+"\n");
		}
		
		System.out.println("----------------------------------\nCreació de secondList: \n\n");
		List<Integer> secondList = new ArrayList<>(firstList.reversed());
		for (Integer item : secondList) {
			System.out.println(item+"\n");
		}
		
		System.out.println("----------------------------------\nCreació de thirdList: \n\n");
		List<Integer> thirdList = new ArrayList<>();
		Iterator<Integer> iteration = firstList.iterator();
		
		while(iteration.hasNext()) {
			thirdList.addFirst(iteration.next());
		}
		for (Integer item : thirdList) {
			System.out.println(item+"\n");
		}
	}
	
}
