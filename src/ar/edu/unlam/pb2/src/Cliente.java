package ar.edu.unlam.pb2.src;

import java.util.ArrayList;
import java.util.List;

public class Cliente {

	private String nombre;
	private Double presupuesto;
	private TipoArticulo tipoPreferido;
	private List<Venta> compras;

	public Cliente(String nombre, Double presupuesto, TipoArticulo tipoPreferido) {
		this.nombre = nombre;
		this.presupuesto = presupuesto;
		this.tipoPreferido = tipoPreferido;
		this.compras = new ArrayList<>();
	}

	public List<Venta> getCompras() {
		return compras;
	}

	public void agregarCompra(Venta venta) {
		compras.add(venta);
		presupuesto -= venta.getValor();
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public Double getPresupuesto() {
		return presupuesto;
	}

	public void setPresupuesto(Double presupuesto) {
		this.presupuesto = presupuesto;
	}

	public TipoArticulo getTipoPreferido() {
		return tipoPreferido;
	}

	public void setTipoPreferido(TipoArticulo tipoPreferido) {
		this.tipoPreferido = tipoPreferido;
	}

}
