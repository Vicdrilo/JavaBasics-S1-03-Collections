package n1exercici1;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

public class Main {
	public static void main(String[] args) {
		List<Month> monthList = new ArrayList<>();
		
		monthList.add(new Month("gener"));
		monthList.add(new Month("febrer"));
		monthList.add(new Month("març"));
		monthList.add(new Month("abril"));
		monthList.add(new Month("maig"));
		monthList.add(new Month("juny"));
		monthList.add(new Month("juliol"));
		monthList.add(new Month("septembre"));
		monthList.add(new Month("octubre"));
		monthList.add(new Month("novembre"));
		monthList.add(new Month("decembre"));
		
		for(Month month : monthList) {
			System.out.println(month.getName());
		}
		
		System.out.println("\nAfegeixo Agost a la llista al lloc on li toca... \n");
		monthList.add(7, new Month("agost"));
		
		for(Month month : monthList) {
			System.out.println(month.getName());
		}
		
		System.out.println("\n==============================\n"
				+ "Canvi de ArrayList a HasSet... \n"
				+ "==============================\n");
		Set<Month> monthSet = new HashSet<>(monthList);
		
		System.out.println("\n==============================\n"
				+ "Intent de afegri dades repetides al HasSet... \n"
				+ "==============================\n");
		boolean afegit = monthSet.add(new Month("agost"));
		System.out.println("S'ha afegit el mes d'agost duplicat? "+afegit);
		
		System.out.println("\n==============================\n"
				+ "Iterar amb Iterator... \n"
				+ "==============================\n");
		Iterator<Month> iteration = monthSet.iterator();
		while(iteration.hasNext()) {
			System.out.println(iteration.next().getName());
		}
		
	}
}
