package retoUd5;

import java.io.Serializable;

public class Persona implements Serializable {

	private String nombre;
	private String apellido;
	private int edad;
	private String direccion;
	private int numeroTelefono;
	
	public Persona(String nombre, String apellido, int edad, String direccion, int numeroTelefono) {
		this.nombre= nombre;
		this.apellido= apellido;
		this.edad=edad;
		this.direccion=direccion;
		this.numeroTelefono=numeroTelefono;
	}
	
	@Override
	public String toString() {
		return "Persona{" +"Nombre: '" + nombre + '\'' +", Apellido: " + apellido +", Edad: " + edad +", Dirección: " + direccion +", Teléfono: " + numeroTelefono +'}';
	}
	
	
	///Metodos Getter para obtener datos 
	
	public String getNombre() {//Método para obtener el nombre
		return nombre;
	}
	public String getApellido() {//Método para obtener el apellido
		return apellido;
	}
	public int getEdad() {//Método para obtener la edad
		return edad;
	}
	public String getDireccion() {//Método para obtener la edad
		return direccion;
	}
	public int numeroTelefono() {//Método para obtener el número de tenlefono
		return numeroTelefono;
	}

	///Métodos Setter para modificar datos 
	
	public static void setNombre(String nombre) { //Setter para modificar el nombre
		System.out.println("Nombre: "+ nombre);
	}
	public static void setApellido(String apellido) { //Setter para modificar el nombre
		System.out.println("Apellido: "+ apellido);
	}
	public static void setEdad(int edad) { //Setter para modificar el nombre
		System.out.println("Edad: "+ edad);
	}
	public static void setDireccion(String direccion) { //Setter para modificar el nombre
		System.out.println("Dirección: "+ direccion);
	}
	public static void setTelefono(int numeroTelefono) { //Setter para modificar el nombre
		System.out.println("Número de teléfono: "+ numeroTelefono);
	}
}
