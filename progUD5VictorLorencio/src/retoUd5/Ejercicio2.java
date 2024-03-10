package retoUd5;


import java.awt.HeadlessException;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

import javax.swing.JOptionPane;


public class Ejercicio2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		//Se trata de crear una clase llamada Ejercicio2.java y allí elaborar un programa que se encargará de crear un directorio
		//y dentro dos ficheros, dentro de uno de los ficheros se almacenarán nombres de personas introducidos por teclado hasta que
		//el usuario te indique lo contrario. Maneja las excepciones necesarias. Sigue las instrucciones
		
		
		//a) Muestra el directorio actual por consola y allí crea un nuevo directorio llamado “dirEjer2” y dentro dos ficheros, 
		//el fichero “uno.txt” y “dos.txt”. (Usa clase File y sus métodos como anteriormente y comprueba si existen o no antes de crearlos).
		
	String dirEjercicio2 = "dirEjer2";
		
	System.out.println("DIRECTORIO ACTUAL");	
	String directorioActual = System.getProperty("user.dir");
	System.out.println(directorioActual);
	
	//NUEVO DIRECTORIO DENTRO DEL ACTUAL 
	System.out.println("NUEVO DIRECTORIO CREADO");
	String nuevoDirectorio = directorioActual + File.separator + dirEjercicio2;
	new File(nuevoDirectorio).mkdir();
	System.out.println("El nuevo directorio tiene el nombre de " + dirEjercicio2);
	//RUTA COMPLETA PARA LOS FICHEROS
	String fichero1= "uno.txt";
	String rutaCompletaFich1= nuevoDirectorio + File.separator + fichero1;
	String fichero2= "dos.txt";
	String rutaCompletaFich2= nuevoDirectorio + File.separator + fichero2;
	
	//COMPROBAMOS SI NO EXISTE EL PRIMER FICHERO Y SE CREA, SI EXISTE INDICAMOS QUE YA ESTÁ CREADO
	if(comprobarExiste(new File(rutaCompletaFich1))) {
		System.out.println("Nombre de fichero: "+ fichero1);
	}else {
		File archivo1 = new File(rutaCompletaFich1);
		try {
			archivo1.createNewFile();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	//COMPROBAMOS SI NO EXISTE EL SEGUNDO FICHERO Y SE CREA, SI EXISTE INDICAMOS QUE YA ESTÁ CREADO
	if(comprobarExiste(new File(rutaCompletaFich2))) {
		System.out.println("Nombre de fichero: "+ fichero2);
	}else {
		File archivo2 = new File(rutaCompletaFich2);
		try {
			archivo2.createNewFile();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	//PASAMOS A ESCRIBIR EN EL FICHERO Y ALMACENAR NOMBRES LINEA POR LINEA HASTA QUE SE PULSE "-"
	System.out.println("Escribir en mi fichero 1");
	escribirEnFichero(rutaCompletaFich1); //LE PASAMOS LA RUTA DEL PRIMER FICHERO PARA QUE ESCRIBA EN ÉL
	//////////////////////////////////////////////////////////
	//LE PASAMOS EL FICHERO QUE SE VA A LEER PARA COMPROBAR SI SE HAN GRABADO LOS NOMBRES CORRECTAMENTE
	// Abre el fichero “uno.txt” para lectura y muestra su contenido.
	leerDeFichero(new File(rutaCompletaFich1));	
			
		
	}
	
///////////////////////////////////////////////////////////////////////////////////////////////////////////
///////////////////////////////////////////////////////////////////////////////////////////////////////////
///////////////////////////////////////////////////////////////////////////////////////////////////////////
///////////////////////////////////////////////////////////////////////////////////////////////////////////
///////////////////////////////////////////////////////////////////////////////////////////////////////////
///////////////////////////////////////////////////////////////////////////////////////////////////////////

//MÉTODOS PARA EL PROGRAMA
	
	public static boolean comprobarExiste(File fichero) {  //METODO PARA COMPROBAR SI EXISTE O NO EL FICHERO CREADO
		if(fichero.exists()) {
			System.out.println("El fichero ya existe"); //Comprobamos con getName el nombre del fichero creado
			return true;
		}else {
			System.out.println("El fichero "+ fichero.getName()+ " No existe" + "\n" + "Archivo creado con éxito"); //Comprobamos con getName el nombre del fichero creado
			return false;
		}
	}
	
	public static boolean escribirEnFichero(String mifichero) { //METODO PARA ESCRIBIR EN EL FICHERO (PASANDOLE LA RUTA DEL FICHERO)
		Scanner sc = new Scanner(System.in);
		try {
			String escritura;
			File f = new File(mifichero);//Creamos un nuevo objeto file y lo iniciamos ocn la ruta del archivo que le pasaremos en el main
			FileWriter fw= new FileWriter(f, true);//Creamos un nuevo objeto FileWriter asociado al objeto 
			BufferedWriter bw= new BufferedWriter(fw);//Creamos un nuevo objeto BufferedWriter asociado al objeto FileWriter almacenando los datos en búfer antes de escribirlos
			do { //Ejetutamos una vez y repetimos hasta que se pulse "-" 
				System.out.println("Introduzca un nombre o pulse '-' para terminar");
				escritura = sc.nextLine();
				if(!escritura.equals("-")) {
					bw.write(escritura);
					bw.newLine();//Con esta línea de codigo vamos almacenando los caracteres en nuevas lineas una vez pulsemos enter
				}
			}while(!escritura.equals("-"));
			System.out.println("PROCESO TERMINADO");
				bw.close();
				sc.close();
				return true;
		}catch(Exception e) {
			e.printStackTrace();
			System.out.println("No se ha podido escribir en el archivo");
		}
		return false;
		}
	
	public static boolean leerDeFichero(File mifichero) { //MÉTODO PARA LEER DEL FICHERO EXISTENTE
		try {
			FileReader lectura= new FileReader(mifichero);
			BufferedReader bufferLectura = new BufferedReader(lectura);
			String linea="";
			
				
				while(linea!=null) {
					linea=bufferLectura.readLine();
					if(linea!=null) {
						System.out.println(linea);
						}
					  }
				lectura.close();
			return true;
		}catch(IOException e) {
			e.printStackTrace();
			System.out.println("Error al leer de " + mifichero.getName());
		}
		return false;
	}
	
	
	}

