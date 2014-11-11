package beans;

public class BeanCitaMedica {

	private int idCita;
	private int estado;
	private int idMed;
	private int idServ;
	private int idPac;
	private String fecha;
	private String nomServ;
	private String nomMed;
	private double costo;
	
	public BeanCitaMedica() {
		super();
	}
	public BeanCitaMedica(int idCita, int estado, int idMed, int idServ,
			int idPac, String fecha, String nomServ, String nomMed, double costo) {
		super();
		this.idCita = idCita;
		this.estado = estado;
		this.idMed = idMed;
		this.idServ = idServ;
		this.idPac = idPac;
		this.fecha = fecha;
		this.nomServ = nomServ;
		this.nomMed = nomServ;
		this.costo = costo;
	}
	
	
	
	public String getNomServ() {
		return nomServ;
	}
	public void setNomServ(String nomServ) {
		this.nomServ = nomServ;
	}
	public String getNomMed() {
		return nomMed;
	}
	public void setNomMed(String nomMed) {
		this.nomMed = nomMed;
	}
	public double getCosto() {
		return costo;
	}
	public void setCosto(double costo) {
		this.costo = costo;
	}
	public String getFecha() {
		return fecha;
	}
	public void setFecha(String fecha) {
		this.fecha = fecha;
	}
	public int getIdCita() {
		return idCita;
	}
	public void setIdCita(int idCita) {
		this.idCita = idCita;
	}
	public int getEstado() {
		return estado;
	}
	public void setEstado(int estado) {
		this.estado = estado;
	}
	public int getIdMed() {
		return idMed;
	}
	public void setIdMed(int idMed) {
		this.idMed = idMed;
	}
	public int getIdServ() {
		return idServ;
	}
	public void setIdServ(int idServ) {
		this.idServ = idServ;
	}
	public int getIdPac() {
		return idPac;
	}
	public void setIdPac(int idPac) {
		this.idPac = idPac;
	}
}
