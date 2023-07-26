package ar.edu.unlam.pb2.src;

import java.util.List;

public class SistemaVenta {

	private List<Cliente> clientes;
	private List<Articulo> articulos;
	private List<Combo> combos;

	public SistemaVenta(List<Cliente> clientes, List<Articulo> articulos, List<Combo> combos) {
		this.clientes = clientes;
		this.articulos = articulos;
		this.combos = combos;
	}

	public List<Cliente> getClientes() {
		return clientes;
	}

	public void setClientes(List<Cliente> clientes) {
		this.clientes = clientes;
	}

	public List<Articulo> getArticulos() {
		return articulos;
	}

	public void setArticulos(List<Articulo> articulos) {
		this.articulos = articulos;
	}

	public List<Combo> getCombos() {
		return combos;
	}

	public void setCombos(List<Combo> combos) {
		this.combos = combos;
	}

}
