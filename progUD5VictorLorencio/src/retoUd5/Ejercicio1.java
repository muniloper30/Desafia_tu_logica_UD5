package retoUd5;


import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import javax.swing.JOptionPane;






public class Ejercicio1 {

	public static void main(String[] args )throws IOException {
		// TODO Auto-generated method stub

		//EJERCICIO1 CLASE FILE 
		/*
		 a) * Pide al usuario que introduzca por teclado el nombre de dos ficheros. El
		 * nombre de ambos ficheros debe tener una longitud igual o superior a 3, en
		 * caso contrario se le pregunta al usuario una y otra vez hasta que por fin
		 * introduzca un nombre válido tanto para el primer fichero como para el
		 * segundo. Cuando introduzca un nombre válido se le indica que… “el nombre del
		 * fichero XXX es válido”
		 */
		
		System.out.println("INTRODUZCA EL NOMBRE DE 2 FICHEROS DE TEXTO DIFERENTES" + "\n");
		
		String nombreArchivo1=null;
		String nombreArchivo2=null;
		
			do {
				nombreArchivo1 = JOptionPane.showInputDialog("Nombre del fichero 1 (longitud mínima: 3 carácteres");
				
				if (nombreArchivo1.length()<= 3) {
				System.out.println("El fichero introducido no es válido,\nDebe contener al menos 3 caracteres\n");
				 }else  {
				System.out.println("El nombre del fichero " + nombreArchivo1 + " es válido\n");
				}
			
			}while(nombreArchivo1.length()<=3);
		
			do {
				nombreArchivo2 = JOptionPane.showInputDialog("Nombre del fichero 2 (longitud mínima: 3 carácteres");
				
				if (nombreArchivo2.length()<= 3) {
				System.out.println("El fichero introducido no es válido,\nDebe contener al menos 3 caracteres\n");
				 }else  {
				System.out.println("El nombre del fichero " + nombreArchivo2 + " es válido\n");
				}
			
			}while(nombreArchivo2.length()<=3);
		
		
		/*b)
		 * Obtén la ruta de tu directorio actual con la instrucción
		 * System.getProperty("user.dir"); y muéstrala en consola.
		 */
		
		String directorioActual = System.getProperty("user.dir");
		System.out.println(directorioActual);
				
					
		/*c)
		* Construye la ruta relativa al primer fichero con la instrucción... String
		* rutaCompletaFich = directorioActual + File.separator + nombreArchivo1; y a
		* continuación crea el fichero usando métodos de la clase File, pero comprueba
		* con el método comprobarExiste(nombreArchivo1) si el fichero existe y en caso
		* de que exista ya no lo puedes crear, se mostrará mensaje apropiado. Haz el
		* mismo proceso con el segundo archivo.
		*/	
				
		String rutaCompletaFich1 = directorioActual + File.separator + nombreArchivo1;
		System.out.println(rutaCompletaFich1 + "\n");
				
				
		if(comprobarExiste(new File(nombreArchivo1))) { 
			System.out.println("El nombre dado para el fichero 1 hace referencia a un archivo ya existente y no se puede crear");
		}else {
			try {
				File archivo1 = new File(nombreArchivo1);
				archivo1.createNewFile();
			}catch(Exception e){
					e.printStackTrace();
				}
			 
		}
		
		System.out.println();//SALTO DE LÍNEA
				
				String rutaCompletaFich2= directorioActual + File.separator + nombreArchivo2;
				System.out.println(rutaCompletaFich2 + "\n");
		
		if(comprobarExiste(new File(nombreArchivo2))) {
			System.out.println("El nombre dado para el fichero 2 hace referencia a un archivo ya existente");
		}else {	
			try {
				File archivo2 = new File(nombreArchivo2);
				archivo2.createNewFile();//Si el archivo no existe, lo creamos con el método createNewFile
			}catch(Exception e) {
				e.printStackTrace();
			}
		}
		System.out.println();
		
		/*d) 
		 * En este punto se deben haber creado dos ficheros si es que los nombres de ficheros 
		 * introducidos por el usuario no eran ficheros ya existentes en la ruta actual.
		 
		 * e)
		 * A continuación, vas a grabar datos en el primer fichero, para ello vuelve a, comprobar con el método comprobarExiste(nombreArchivo1)
		 * si el fichero existe y en caso de que exista llama al método escribirEnFichero (nombreArchivo1) que contiene el código necesario
		 * para grabar en dicho fichero los números del 0-10, cada uno en una línea diferente
		 * y utilizando un bucle for. Usa la clase FileWriter. 
		 * (Para convertir los números a cadenas antes de escribirlos en el archivo se puede hacer usando String.valueOf(num) o 
		 * concatenando un espacio en blanco + " " al número.)
		 */
		
	if(comprobarExiste(new File(nombreArchivo1))) {
		System.out.println();
		escribirEnFichero(new File(nombreArchivo1));
		leerDeFichero(new File(nombreArchivo1));
	}
	
		System.out.println();//SALTO DE LINEA 
	
	
	/*g) Comprueba con el método comprobarExiste(nombreArchivo1) si el fichero existe, en ese caso se mostrarán los siguientes datos del fichero en pantalla: Usa los métodos de la clase File
	• Nombre del archivo.
	• Ruta absoluta
	• Ruta del directorio padre
	• Tamaño del fichero
	• ¿Es un fichero o un directorio?
	• Permiso de lectura
	• Permiso de escritura
	• Permiso de ejecución
	• ¿Está oculto?
	*/
		
	System.out.println("COMPROBACIÓN DE DATOS DE ARCHIVO");
	datosArchivo(new File(rutaCompletaFich1));
	System.out.println();//SALTO DE LINEA
	
	
	//h) Copia el contenido del primer fichero al segundo, usa el método duplicarFicheros(nombreArchivo1, nombreArchivo2)
	
	System.out.println("COPIANDO DATOS ENTRE ARCHIVOS");
	System.out.println("\n"+ "Copia de datos de "+ nombreArchivo1 + " a " + nombreArchivo2);
	duplicarFicheros(rutaCompletaFich1, rutaCompletaFich2); // LE PASAMOS LOS DOS STRING CON LAS RUTAS DE LOS FICHEROS CORRESPONDIENTES
	
	
	System.out.println();//SALTO DE LINEA
	
	// i) Borra el primer fichero cuyo nombre te indicó el usuario, con una llamada al método borrarFichero(nombreArchivo1
	System.out.println("BORRANDO PRIMER ARCHIVO");
	borrarFichero(new File(nombreArchivo1));
	
	System.out.println();//SALTO DE LINEA
	
	//j) En este punto el primer fichero ya no debería existir y el segundo fichero debe contener una copia del contenido del primero. 
	//Vuelve a leer el segundo archivo para comprobar que la copia se ha realizado y muestra contenido en pantalla.
	
	System.out.println("COMPROBACION DE DATOS EN EL SEGUNDO ARCHIVO: "+ nombreArchivo2);
	leerDeFichero(new File(nombreArchivo2));
	
	//k) Crea un directorio llamado “dirEjer1”, pero antes comprueba su existencia con el método que tienes ya creado para este fin y 
	//en caso de que no exista puedes crearlo.
	//Usa la misma fórmula utilizada anteriormente para la ruta y el método adecuado de la clase File.
	
	String nuevoDirectorio= "dirEjer1";
	String rutaCompletaNewDir= directorioActual + File.separator + nuevoDirectorio;
	
	System.out.println();//SALTO DE LINEA
	
	System.out.println("COMPROBACIÓN/CREACIÓN DE DIRECTORIO");
	
	if(comprobarDiretorio(new File(nuevoDirectorio))) {
		System.out.println("Éste directorio ya éxiste");
	}else {
		new File(rutaCompletaNewDir).mkdir();
	}
	
	
	} 

	
	
	
	
////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	
	
	
	/*
	 * METODOS NECESARIOS:
	Todos los métodos que se indican serán static(de esta forma se pueden llamar 
	desde el main, sin necesidad de crear un objeto o instancia, este modificador 
	se verá próximamente) y devuelven un boolean que verificamos dentro del main 
	para saber si la operación ha sido éxito o no, en cuyo caso se mostrarán los 
	mensajes idóneos para informar siempre al usuario.
	 */
	
	
	public static boolean comprobarExiste(File fichero) {  //METODO PARA COMPROBAR SI EXISTE O NO EL FICHERO CREADO
		if(fichero.exists()) {
			System.out.println("El fichero "+ fichero.getName()+ " ya existe" ); //Comprobamos con getName el nombre del fichero creado
			return true;
		}else {
			System.out.println("El fichero "+ fichero.getName()+ " No existe" + "\n" + "Archivo creado con éxito"); //Comprobamos con getName el nombre del fichero creado
			return false;
		}
	}
	
	
	public static boolean escribirEnFichero(File mifichero) { //METODO PARA ESCRIBIR EN EL FICHERO
		try {
			FileWriter escritura= new FileWriter(mifichero, true);
			for(int i=0;i<=10;i++) {
				escritura.write(String.valueOf(i) + "\n");
				
			}
			escritura.close();
			System.out.println("Números grabados en " + mifichero.getName());
			return true;
			
			}catch (IOException e) {
			e.printStackTrace();
			System.out.println("Error al grabar números en " + mifichero.getName());
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
	
	
	public static boolean datosArchivo(File mifichero) {  //MÉTODO PARA VERIFICAR DATOS DEL FICHERO 
		if(comprobarExiste(mifichero)) {
			System.out.println("Nombre del archivo: "+ mifichero.getName());
			System.out.println("Ruta absoluta: "+ mifichero.getAbsolutePath());
			System.out.println("Ruta del directorio padre: "+ mifichero.getParent());
			System.out.println("Tamaño del fichero: " + mifichero.length());
			System.out.println("¿Es un fichero o un directorio?");
				if(mifichero.isFile()) {
					System.out.println("Es un fichero");
					if(mifichero.isDirectory()) {
						System.out.println("Es un directorio");
					}}else {
						System.out.println("Archivo no reconocido");
					}
			System.out.println("Permiso de lectura: " + mifichero.canRead());
			System.out.println("Permiso de escritura: "+ mifichero.canWrite());
			System.out.println("Permiso de ejecución: " + mifichero.canExecute());
			System.out.println("¿Está oculto?: "+ mifichero.isHidden());
			return true;
		}else {
			System.out.println("El fichero " + mifichero.getName() + "No existe");
			return false;
		}
	
	}
	
	public static boolean duplicarFicheros(String ficheroEntrada, String ficheroSalida) { //METODO PARA DUPLICAR FICHEROS
		
		FileInputStream original = null;
		FileOutputStream copia = null;
		File archivo1 = new File(ficheroEntrada);
		File archivo2 = new File(ficheroSalida);
		
			try {
				original= new FileInputStream(archivo1);
				copia= new FileOutputStream(archivo2);
				int a;
				
				while((a= original.read()) != -1) {
					copia.write((byte)a);
				}
				return true;
			}catch (Exception e) {
				e.printStackTrace();
				System.out.println("Error al duplicar el archivo");
			}finally {
				try {
					original.close();
					copia.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			return false;
		}
		
		
	public static boolean borrarFichero(File mifichero) { //METODO PARA ELIMINAR FICHERO
		if(mifichero.exists()) {
			System.out.println("El archivo con el nombre " + mifichero + " fue eliminado satisfactoriamente.");
			mifichero.delete();
			return true;
		}else {
			return false;
		}
	}
	
	
	
	public static boolean comprobarDiretorio(File directorio) {  //METODO PARA COMPROBAR SI EXISTE O NO EL DIRECTORIO CREADO
		if(directorio.exists()) {
			System.out.println("El directorio "+ directorio.getName()+ " ya existe" ); //Comprobamos con getName el nombre del fichero creado
			return true;
		}else {
			System.out.println("El directorio	 "+ directorio.getName()+ " No existe" + "\n" + "Archivo creado con éxito"); //Comprobamos con getName el nombre del fichero creado
			return false;
		}
	}
	
	
	
	
	
	
}



