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
