package beans;

public class BeanPaciente {
	
	private int idPaciente;
	private String nombre;
	private String apellido;
	private double saldo;
	private int dni;
	
	public double getSaldo() {
		return saldo;
	}
	public void setSaldo(double saldo) {
		this.saldo = saldo;
	}
	public int getIdPaciente() {
		return idPaciente;
	}
	public void setIdPaciente(int idPaciente) {
		this.idPaciente = idPaciente;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getApellido() {
		return apellido;
	}
	public void setApellido(String apellido) {
		this.apellido = apellido;
	}
	public void setDni(int dni) {
		this.dni=dni;
	}
	
	public int getDni() {
		return dni;
	}
	
	

}
