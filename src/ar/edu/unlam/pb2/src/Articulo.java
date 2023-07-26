package ar.edu.unlam.pb2.src;

public class Articulo implements Venta {

	private String nombre;
	private String descripcion;
	private Double valor;
	private Integer cantidad;
	private TipoArticulo tipo;

	public Articulo(String nombre, String descripcion, Double valor, Integer cantidad, TipoArticulo tipo) {
		this.nombre = nombre;
		this.descripcion = descripcion;
		this.valor = valor;
		this.cantidad = cantidad;
		this.tipo = tipo;
	}

	public TipoArticulo getTipo() {
		return tipo;
	}

	public void setTipo(TipoArticulo tipo) {
		this.tipo = tipo;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public void setValor(Double valor) {
		this.valor = valor;
	}

	public void setCantidad(Integer cantidad) {
		this.cantidad = cantidad;
	}

	@Override
	public String getNombre() {
		return nombre;
	}

	@Override
	public String getDescripcion() {
		return descripcion;
	}

	@Override
	public Double getValor() {
		return valor;
	}

	@Override
	public Integer getCantidad() {
		return cantidad;
	}

	@Override
	public Boolean esCombo() {
		return false;
	}

}
