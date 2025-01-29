package n1exercici3;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		//LECTURA ARCHIVO countries.txt Y ALMACENADO EN HASHMAP
		BufferedReader buffer = null;
		try {
			System.out.println(Paths.get("resources/countries.txt").toAbsolutePath());
			buffer = Files.newBufferedReader(Paths.get("resources/countries.txt"));
//			buffer = Files.newBufferedReader(path);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
 
		
		Map<String, String> hashMapPaisCaps = new HashMap<>();
		
		try {
			String line;
			while((line=buffer.readLine()) != null) {
				String[] aux = line.split(" ");
				hashMapPaisCaps.put(aux[0], aux[1]);
				System.out.println(hashMapPaisCaps.get(aux[0]));
			}
			System.out.println("Bucle ok.");
			buffer.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		//INICIO CUESTIONARIO
		Scanner scan = new Scanner(System.in);
		System.out.println("Escriu el teu nom: ");
		String nom = scan.nextLine();
		int punts = 0;
		
		System.out.println("El qüestionari està a punt de començar. Has d'escriure la capital del país que es mostri.");
		List<String> keys = new ArrayList<>(hashMapPaisCaps.keySet());
		
		int i=0;
		while(i!=10) {
			i++;
			int random = (int)(Math.random()*keys.size());
			System.out.println(keys.get(random));
			//System.out.println(hashMapPaisCaps.get(keys.get(Math.random()*keys.size())));
			
			String respuesta = scan.nextLine();
			if(respuesta.equalsIgnoreCase(hashMapPaisCaps.get(keys.get(random)))) {
				System.out.println("Correcte!");
				punts++;
			}else {
				System.out.println("Error! És "+hashMapPaisCaps.get(keys.get(random)));
			}
			
		}
		
		scan.close();
		
		
		//GUARDAR PUNTUACIÓ EN classificacio.txt
        try (BufferedWriter writer = Files.newBufferedWriter(Paths.get("resources/classificacio.txt"), StandardOpenOption.CREATE, StandardOpenOption.APPEND)) {
        	writer.write(nom + " : "+punts +"\n");
        } catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		
	}

}
