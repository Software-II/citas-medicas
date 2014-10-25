package beans;

public class BeanServicio {
	
	private int idServicio;
	private String nomServ;
	private double cost;
	private String descr;
	
	public BeanServicio() {
		super();
	}
	public BeanServicio(int idServicio, String nomServ, double cost,
			String descr) {
		super();
		this.idServicio = idServicio;
		this.nomServ = nomServ;
		this.cost = cost;
		this.descr = descr;
	}
	public int getIdServicio() {
		return idServicio;
	}
	public void setIdServicio(int idServicio) {
		this.idServicio = idServicio;
	}
	public String getNomServ() {
		return nomServ;
	}
	public void setNomServ(String nomServ) {
		this.nomServ = nomServ;
	}
	public double getCost() {
		return cost;
	}
	public void setCost(double cost) {
		this.cost = cost;
	}
	public String getDescr() {
		return descr;
	}
	public void setDescr(String descr) {
		this.descr = descr;
	}
}
