package n3exercici1;

import java.util.Objects;

public class Persona implements Comparable<Persona> {
	private String nom;
	private String cognom;
	private String dni;
	
	public Persona(String nom, String cognom, String dni) {
		this.nom = nom;
		this.cognom = cognom;
		this.dni = dni; 
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getCognom() {
		return cognom;
	}

	public void setCognom(String cognom) {
		this.cognom = cognom;
	}

	public String getDni() {
		return dni;
	}

	public void setDni(String dni) {
		this.dni = dni;
	}

	@Override
	public int hashCode() {
		return Objects.hash(cognom, dni, nom);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Persona other = (Persona) obj;
		return Objects.equals(cognom, other.cognom) && Objects.equals(dni, other.dni) && Objects.equals(nom, other.nom);
	}

	@Override
	public int compareTo(Persona o) {
		if(this.nom.compareTo(o.nom) != 0) {
			return this.nom.compareTo(o.nom);
		}
		
		if(this.cognom.compareTo(o.cognom) != 0) {
			return this.cognom.compareTo(o.cognom);
		}
		
		return this.dni.compareTo(o.dni);
	}

	@Override
	public String toString() {
		return this.nom + "," + this.cognom + "," + this.dni;
	}
	
	
}
