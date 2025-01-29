package n2exercici1;

import java.util.HashSet;
import java.util.Objects;
import java.util.Scanner;
import java.util.Set;

public class Restaurant {
	private String nom;
	private int puntuacio;
	
	public Restaurant(String nom, int puntuacio) {
		this.nom = nom;
		this.puntuacio = puntuacio;
	}
	@Override
	public int hashCode() {
		return Objects.hash(nom, puntuacio);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Restaurant other = (Restaurant) obj;
		return Objects.equals(nom, other.nom) && puntuacio == other.puntuacio;
	}
	
	public static void main(String[] args) {
		
		Set<Restaurant> llistaRestaurants = new HashSet<>();
		boolean ok = true;
		try(Scanner scan = new Scanner(System.in)){
			while(ok) {
				System.out.println("MENÚ____________________________________\n"
						+ "1. Introuir un restaurant.\n"
						+ "2. Borrar restaurant.\n"
						+ "3. Mostra tots\n"
						+ "4. Sortir.\n"
						+ "________________________________________");
				int opcio = scan.nextInt();
				
				switch(opcio) {
					case 1:
						scan.nextLine();
						System.out.println("Nom: ");
						String n = scan.nextLine();
						System.out.println("Puntuació: ");
						int p = scan.nextInt();
						
						if(n.length() != 0 && (p >= 0 || p <= 10)) {
							llistaRestaurants.add(new Restaurant(n, p));
						}else {
							System.out.println("Hi hagut un error amb les dades introduides.");
						}
						break;
					case 2:
						System.out.println("Es borra un restaurant - CODI SENSE FER.");
						break;
					case 3:
						for (Restaurant r : llistaRestaurants) {
							System.out.println("Restaurnat: "+r.nom+". Té una puntuació de "+r.puntuacio+".");
						}
						break;
					case 4:
						ok = false;
						break;
					default:
						System.out.println("Opció no existeix.");
						break;
				}
				
			}
		}
		
	}
	
	
}
