package n2exercici2;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;
import java.util.TreeSet;

public class Restaurant implements Comparable<Restaurant> {
	private String nom;
	private int puntuacio;
	
	public Restaurant(String nom, int puntuacio) {
		this.nom = nom;
		this.puntuacio = puntuacio;
	}
	
	public void setNom(String nom) {
		this.nom = nom;
	}
	public String getNom() {
		return this.nom;
	}
	public void setPuntuacio(int puntuacio) {
		this.puntuacio = puntuacio;
	}
	public int getPuntuacio() {
		return this.puntuacio;
	}
	
	public static void main(String[] args) {
		
		Set<Restaurant> llistaRestaurants = new HashSet<>();
		
		llistaRestaurants.add(new Restaurant("Can Vidalet", 8));
		llistaRestaurants.add(new Restaurant("Can Rostit", 8));
		llistaRestaurants.add(new Restaurant("Escorxador", 8));
		llistaRestaurants.add(new Restaurant("La Pubilla", 8));
		llistaRestaurants.add(new Restaurant("Can Vidalet", 8));
		llistaRestaurants.add(new Restaurant("Escorxador", 7));
		llistaRestaurants.add(new Restaurant("Can Vidalet", 5));
		llistaRestaurants.add(new Restaurant("Can Rostit", 6));
		llistaRestaurants.add(new Restaurant("Escorxador", 10));
		
		
		for (Restaurant r : llistaRestaurants) {
			System.out.println("Restaurnat: "+r.nom+". Té una puntuació de "+r.puntuacio+".");
		}
		
		System.out.println("\n________________________________________\n"
				+ "Ordena la llista per nom i per puntuació en ordre ascendent..."
				+ "\n________________________________________\n");
		
		Set<Restaurant> llistatOrdenat = new TreeSet<>(llistaRestaurants); 
		
		for (Restaurant r : llistatOrdenat) {
			System.out.println("Restaurnat: "+r.nom+". Té una puntuació de "+r.puntuacio+".");
		}
		
	}
	
	
	@Override
	public int compareTo(Restaurant o) {
		// TODO Auto-generated method stub
		int compNames = this.nom.compareTo(o.nom);
		if(compNames != 0) {
			return compNames;
		}
		
		return Integer.compare(this.puntuacio, o.puntuacio);
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

}
