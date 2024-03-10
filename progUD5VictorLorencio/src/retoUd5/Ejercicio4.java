package retoUd5;

import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Scanner;

import javax.swing.JOptionPane;

import retoUd5.Persona;

public class Ejercicio4 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Persona[] personas = {
				new Persona(JOptionPane.showInputDialog("Nombre: "),JOptionPane.showInputDialog("Apellido: "),Integer.parseInt(JOptionPane.showInputDialog("Edad: ")), JOptionPane.showInputDialog("Dirección: "), Integer.parseInt(JOptionPane.showInputDialog("Número de teléfono: "))),
				new Persona(JOptionPane.showInputDialog("Nombre: "),JOptionPane.showInputDialog("Apellido: "),Integer.parseInt(JOptionPane.showInputDialog("Edad: ")), JOptionPane.showInputDialog("Dirección: "), Integer.parseInt(JOptionPane.showInputDialog("Número de teléfono: "))),
				new Persona(JOptionPane.showInputDialog("Nombre: "),JOptionPane.showInputDialog("Apellido: "),Integer.parseInt(JOptionPane.showInputDialog("Edad: ")), JOptionPane.showInputDialog("Dirección: "), Integer.parseInt(JOptionPane.showInputDialog("Número de teléfono: ")))
		};
		
		escribirFichero(personas); //Se crea automaticamente al escribir en el archivo 
		leerFichero();
		
		
	}

	
	public static void crearFichero(File mifichero)throws IOException { //Método para crear el fichero si no existe
		String directorioActual= System.getProperty("user.dir");
		String rutaCompletaFich= directorioActual + File.separator + mifichero;
		if(mifichero.exists()) {
			System.out.println("Este archivo ya existe y no puede crearse.");
		}else {
			try {
				File archivo= new File(rutaCompletaFich);
				archivo.createNewFile();
				System.out.println("El archivo " + mifichero + " se ha creado satisfactoriamente");
			}catch(IOException e) {
				System.out.println("Error de creación de archivo");
				e.printStackTrace();
			}
		}
	}
	
	public static void escribirFichero(Persona[] personas) {
		try(ObjectOutputStream obj = new ObjectOutputStream(new FileOutputStream("persona.dat"))){
			for(Persona persona: personas) {
				obj.writeObject(persona);
			}
		}catch(IOException e) {
			System.out.println("Error de datos");
			e.printStackTrace();
		}
	}
	
	public static void leerFichero() {
        try (ObjectInputStream obj = new ObjectInputStream(new FileInputStream("persona.dat"))) {
            while (true) {
                Persona persona = (Persona) obj.readObject();
                System.out.println(persona);
            }
        } catch (EOFException e) {
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
	
}
