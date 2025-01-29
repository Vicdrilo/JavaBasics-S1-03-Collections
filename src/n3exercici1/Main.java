package n3exercici1;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class Main {
	Scanner scan = new Scanner(System.in);
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Main m = new Main();
		boolean ok = true;
		while(ok) {
			ok = m.inici();	
		}
		
	}
	
	public boolean inici() {
		int option; 
		System.out.println(""
				+ "___________________________________________________________\r\n"
				+ "MENÚ_______________________________________________________"
				+ "\r\n"
				+ "1.- Introduir persona.\r\n"
				+ "\r\n"
				+ "2.- Mostrar les persones ordenades per nom (A-Z).\r\n"
				+ "\r\n"
				+ "3.- Mostrar les persones ordenades per nom (Z-A).\r\n"
				+ "\r\n"
				+ "4.- Mostrar les persones ordenades per cognoms (A-Z).\r\n"
				+ "\r\n"
				+ "5.- Mostrar les persones ordenades per cognoms (Z-A).\r\n"
				+ "\r\n"
				+ "6.- Mostrar les persones ordenades per DNI (1-9).\r\n"
				+ "\r\n"
				+ "7.- Mostrar les persones ordenades per DNI (9-1).\r\n"
				+ "\r\n"
				+ "0.- Sortir.\r\n"
				+ "___________________________________________________________");
		option = scan.nextInt();
		
		
		switch(option) {
			case 1:
				introduirPersona();
				return true;
			case 2:
				ordrePerNomAsc(new ComparatorNomAscendent());
				return true;
			case 3:
				ordrePerNomDesc(new ComparatorNomDescendent());
				return true;
			case 4:
				ordrePerCognomAsc(new ComparatorCognomAscendent());
				return true;
			case 5:
				ordrePerCognomDes(new ComparatorCognomDescendent());
				return true;
			case 6: 
				ordrePerDNIAsc(new ComparatorDNIAscendent());
				return true;
			case 7:
				ordrePerDNIDes(new ComparatorDNIDescendent());
				return true;
			case 0:
				return false;
			default:
				System.out.println("No existeix aquesta opció.");
				return true;	
		}
	}
	
	
	public void introduirPersona() {
		String nom;
		String cognom;
		String dni;
		scan.nextLine();
		
		//Getting personal data
		System.out.println("Escriu el nom: ");
		nom = scan.nextLine();
		System.out.println("Escriu el cognom: ");
		cognom = scan.nextLine();
		System.out.println("Escriu el dni: ");
		dni = scan.next();
		
		//Creating a Persona's instance
		Persona p = new Persona(nom, cognom, dni);
		
		//Opening BufferedWriter to add Persona to the csv file 
		//StandardOpenOption.CREATE: If the file doesn't exist it will be created
		//StandardOpenOption.APPEND: If the file exists the new data will be appended on the next line
		try(BufferedWriter writer = Files.newBufferedWriter(Paths.get("resources/fitxer.csv"), StandardOpenOption.CREATE, StandardOpenOption.APPEND)){
			writer.write(p.toString()); //Persona.toString returns a String with the correct format for de csv file
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public void ordrePerNomAsc(Comparator<Persona> comparator) {
		List<Persona> list = getAllCSVData();
		
		Collections.sort(list, comparator);
		
		System.out.println("___Nom___ ____Cognoms___ __NIF__");
		for (Persona p : list) {
			System.out.println(p.getNom()+"\t"+p.getCognom()+"\t"+p.getDni());
		}
	}
	
	public void ordrePerNomDesc(Comparator<Persona> comparator) {
		List<Persona> list = getAllCSVData();
		
		Collections.sort(list, comparator);
		
		System.out.println("___Nom___ ____Cognoms___ __NIF__");
		for (Persona p : list) {
			System.out.println(p.getNom()+"\t"+p.getCognom()+"\t"+p.getDni());
		}
	}
	
	public void ordrePerCognomAsc(Comparator<Persona> comparator) {
		List<Persona> list = getAllCSVData();
		
		Collections.sort(list, comparator);
		
		printData(list);
		
	}
	
	public void ordrePerCognomDes(Comparator<Persona> comparator) {
		List<Persona> list = getAllCSVData();
		
		Collections.sort(list, comparator);
		
		printData(list);
		
	}
	
	public void ordrePerDNIAsc(Comparator<Persona> comparator) {
		List<Persona> list = getAllCSVData();
		
		Collections.sort(list, comparator);
		
		printData(list);
	}
	
	public void ordrePerDNIDes(Comparator<Persona> comparator) {
		List<Persona> list = getAllCSVData();
		
		Collections.sort(list, comparator);
		
		printData(list);
		
	}
	
	public ArrayList<Persona> getAllCSVData(){
		String line;
		List<Persona> list = new ArrayList<>();
		
		try(BufferedReader reader = Files.newBufferedReader(Paths.get("resources/fitxer.csv"))){
			while((line = reader.readLine()) != null) {
				String[] arrLine = line.split(",");
				
				list.add(new Persona(arrLine[0], arrLine[1], arrLine[2]));
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return (ArrayList<Persona>) list;
	}
	
	public void printData(List<Persona> list) {
		System.out.println("___Nom___ ____Cognoms___ __NIF__");
		for (Persona p : list) {
			System.out.println(p.getNom()+"\t"+p.getCognom()+"\t"+p.getDni());
		}
	}

}

class ComparatorNomAscendent implements Comparator<Persona>{

	@Override
	public int compare(Persona o1, Persona o2) {
		return o1.getNom().compareTo(o2.getNom());
	}
	
}

class ComparatorNomDescendent implements Comparator<Persona>{

	@Override
	public int compare(Persona o1, Persona o2) {
		return o2.getNom().compareTo(o1.getNom());
	}
	
}

class ComparatorCognomAscendent implements Comparator<Persona>{

	@Override
	public int compare(Persona o1, Persona o2) {
		return o1.getCognom().compareTo(o2.getCognom());
	}
	
}

class ComparatorCognomDescendent implements Comparator<Persona>{

	@Override
	public int compare(Persona o1, Persona o2) {
		return o2.getCognom().compareTo(o1.getCognom());
	}
	
}

class ComparatorDNIAscendent implements Comparator<Persona>{

	@Override
	public int compare(Persona o1, Persona o2) {
		return o1.getDni().compareTo(o2.getDni());
	}
	
}

class ComparatorDNIDescendent implements Comparator<Persona>{

	@Override
	public int compare(Persona o1, Persona o2) {
		return o2.getDni().compareTo(o1.getDni());
	}
	
}
