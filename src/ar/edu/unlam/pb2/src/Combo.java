package ar.edu.unlam.pb2.src;

import java.util.List;

public class Combo implements Venta {

	private String nombre;
	private List<Articulo> articulos;
	private Double valor;

	public Combo(String nombre, List<Articulo> articulos, Double valor) {
		this.nombre = nombre;
		this.articulos = articulos;
		this.valor = valor;
	}

	@Override
	public String getNombre() {
		return nombre;
	}

	@Override
	public String getDescripcion() {
		return "Combo: " + nombre;
	}

	@Override
	public Double getValor() {
		return valor;
	}

	@Override
	public Integer getCantidad() {
		// los combos no tienen cantidad, así que siempre se devuelve 1
		return 1;
	}

	@Override
	public Boolean esCombo() {
		return true;
	}

	public List<Articulo> getArticulos() {
		return articulos;
	}

	@Override
	public void setCantidad(Integer cantidad) {
		
	}

}
