package ar.edu.unlam.pb2.src;

import java.util.ArrayList;
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

	public Venta sugerirArticuloOCombo(Cliente cliente) {
		Venta mejorSugerencia = null;
		Double mejorValor = Double.MAX_VALUE;

		for (Articulo articulo : articulos) {
			if (articulo.getTipo() == cliente.getTipoPreferido() && articulo.getCantidad() > 0) {
				Double valorArticulo = articulo.getValor();
				if (valorArticulo < mejorValor) {
					mejorSugerencia = articulo;
					mejorValor = valorArticulo;
				}
			}
		}

		for (Combo combo : combos) {
			Boolean todosDisponibles = true;
			for (Articulo articulo : combo.getArticulos()) {
				if (articulo.getCantidad() == 0) {
					todosDisponibles = false;
					break;
				}
			}

			if (todosDisponibles) {
				Double valorCombo = combo.getValor();
				if (valorCombo < mejorValor) {
					mejorSugerencia = combo;
					mejorValor = valorCombo;
				}
			}
		}

		return mejorSugerencia;
	}

	private boolean puedeComprar(Cliente cliente, Venta item) {
		return cliente.getPresupuesto() >= item.getValor() && item.getCantidad() > 0;
	}

	private boolean seComproArticulo(Cliente cliente, Articulo articulo) {
		for (Venta compra : cliente.getCompras()) {
			if (compra.getNombre().equals(articulo.getNombre())) {
				return true;
			}
		}
		return false;
	}

	// metodo para realizar una compra por parte del cliente
	public void comprar(Cliente cliente, Venta item) throws CreditosInsuficientesException {
		if (puedeComprar(cliente, item)) {
			if (item.esCombo()) {
				Combo combo = (Combo) item;
				for (Articulo articulo : combo.getArticulos()) {
					articulo.setCantidad(articulo.getCantidad() - 1);
				}
			} else {
				item.setCantidad(item.getCantidad() - 1);
			}
			cliente.agregarCompra(item);
		} else {
			throw new CreditosInsuficientesException();
		}
	}

	// metodo para buscar combos vigentes que el cliente pueda comprar
	public List<Combo> buscarCombosVigentes(Cliente cliente) {
		List<Combo> combosVigentes = new ArrayList<>();
		for (Combo combo : combos) {
			if (puedeComprar(cliente, combo)) {
				combosVigentes.add(combo);
			}
		}
		return combosVigentes;
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
