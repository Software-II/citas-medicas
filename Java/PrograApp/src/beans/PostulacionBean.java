package beans;

public class PostulacionBean {
	int idPostulacion;
	int idUsuario;
	int idMoneda;
	String fecDispo;
	String fecPostulacion;
	float salario; 
	String cvRuta;
	String webPersona;
	public int getIdPostulacion() {
		return idPostulacion;
	}
	
	public void setIdPostulacion(int idPostulacion) {
		this.idPostulacion = idPostulacion;
	}
	
	public int getIdUsuario() {
		return idUsuario;
	}
	
	public void setIdUsuario(int idUsuario) {
		this.idUsuario = idUsuario;
	}
	
	public int getIdMoneda() {
		return idMoneda;
	}
	
	public void setIdMoneda(int idMoneda) {
		this.idMoneda = idMoneda;
	}
	
	public String getFecDispo() {
		return fecDispo;
	}
	
	public void setFecDispo(String fecDispo) {
		this.fecDispo = fecDispo;
	}
	
	public String getFecPostulacion() {
		return fecPostulacion;
	}
	
	public void setFecPostulacion(String fecPostulacion) {
		this.fecPostulacion = fecPostulacion;
	}
	
	public float getSalario() {
		return salario;
	}
	
	public void setSalario(float salario) {
		this.salario = salario;
	}
	
	public String getCvRuta() {
		return cvRuta;
	}
	
	public void setCvRuta(String cvRuta) {
		this.cvRuta = cvRuta;
	}
	
	public String getWebPersona() {
		return webPersona;
	}
	
	public void setWebPersona(String webPersona) {
		this.webPersona = webPersona;
	}
}
