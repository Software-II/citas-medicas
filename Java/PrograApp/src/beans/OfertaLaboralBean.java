package beans;

public class OfertaLaboralBean {

	
	int idCategoria;
	String categoria;
	int idTrabajo;
	int idPostulacion;
	
	String trabajo;
	public String getTrabajo() {
		return trabajo;
	}
	public void setTrabajo(String trabajo) {
		this.trabajo = trabajo;
	}
	String descripcion;
	
	public int getIdPostulacion() {
		return idPostulacion;
	}
	public void setIdPostulacion(int idPostulacion) {
		this.idPostulacion = idPostulacion;
	}
	public int getIdCategoria() {
		return idCategoria;
	}
	public void setIdCategoria(int idCategoria) {
		this.idCategoria = idCategoria;
	}
	public String getCategoria() {
		return categoria;
	}
	public void setCategoria(String categoria) {
		this.categoria = categoria;
	}
	public int getIdTrabajo() {
		return idTrabajo;
	}
	public void setIdTrabajo(int idTrabajo) {
		this.idTrabajo = idTrabajo;
	}
	
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	
}
