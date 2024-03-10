package retoUd5;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.InputMismatchException;
import java.util.Scanner;

import javax.swing.JPopupMenu.Separator;

public class Ejercicio3 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		// Consiste en crear una clase llamada Ejercicio3.java y allí desarrollar un programa que creará 
		//y almacenará en el fichero “tres.dat” (fichero binario) los números positivos que 
		//se introducirán por consola, hasta que se introduzca uno negativo 
		//(que indicará el fin de introducción de datos). Utiliza las clases indicadas y maneja las excepciones necesarias.
		//*Utiliza los métodos que creas necesarios para agrupar código y hacer llamadas 
		//a dichos métodos desde el main.
		
		//CREAMOS EL FICHERO "tres.txt" si no existe
		String fichero3 = "tres.txt";
		String directorioActual = System.getProperty("user.dir");
		String rutaCompletaFich3 = directorioActual + File.separator + fichero3;
		
		if(comprobarExiste(new File(rutaCompletaFich3))) {
			System.out.println("Nombre de fichero: " + fichero3);
		}else {
			File archivo3= new File(rutaCompletaFich3);
			try {
				archivo3.createNewFile();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		
		System.out.println("Introduce números positivos [NÚMERO NEGATIVO PARA SALIR]");
		try {
			escribirEnFichero(new File(rutaCompletaFich3));
		}catch(InputMismatchException e) {
			System.out.println("Error: Carácteres erroneos para números positivos");
		}
		
		
	}
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

	//MÉTODOS PARA EL PROGRAMA 
	
	public static boolean comprobarExiste(File fichero) {
		if(fichero.exists()) {
			System.out.println("El fichero ya existe");
			return true;
		}else {
			System.out.println("El fichero " + fichero.getName()+ " no existe. Fichero creado satisfactoriamente");
			return false;
		}
	}
	
	public static void escribirEnFichero(File mifichero)throws InputMismatchException {
		try {
			ObjectOutputStream obj = new ObjectOutputStream(new FileOutputStream(mifichero, true));
			Scanner sc = new Scanner(System.in);
			int num;
			
			do {
				num = sc.nextInt();
				if(num>0) {
					obj.writeInt(num);
				}
			}while(num>0);
			System.out.println("PROCESO FINALIZADO");
			
		}catch(Exception e) {
			System.out.println("Error de escritura");
			System.out.println("Error de tipo InputMismatchException" + "\n" + "");
			e.printStackTrace();
		}
	}
}
