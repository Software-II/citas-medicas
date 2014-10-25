package beans;

public class BeanCitaMedica {

	private int idCita;
	private int estado;
	private int idMed;
	private int idServ;
	private int idPac;
	
	public BeanCitaMedica() {
		super();
	}
	public BeanCitaMedica(int idCita, int estado, int idMed, int idServ,
			int idPac) {
		super();
		this.idCita = idCita;
		this.estado = estado;
		this.idMed = idMed;
		this.idServ = idServ;
		this.idPac = idPac;
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
