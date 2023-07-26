package ar.edu.unlam.pb2.test;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;

import ar.edu.unlam.pb2.src.*;

import org.junit.jupiter.api.Test;

class TestingClass {

	@Test
	public void testSugerirArticuloOCombo() {
		List<Articulo> articulos = new ArrayList<>();
		articulos.add(new Articulo("Jarrón Florero Oriental", "Lujoso en todos los aspectos", 3890.0, 10, TipoArticulo.ANTIGUEDAD));

		List<Combo> combos = new ArrayList<>();
		List<Articulo> articulosCombo1 = new ArrayList<>();
		articulosCombo1.add(new Articulo("Jarrón Florero Oriental", "Lujoso en todos los aspectos", 3890.0, 10, TipoArticulo.ANTIGUEDAD));
		articulosCombo1.add(new Articulo("Papiro Egipcio", "Escena de caza", 29000.0, 8, TipoArticulo.ANTIGUEDAD));
		combos.add(new Combo("Combo antigüedad", articulosCombo1, 0.25 * (3890 + 29000)));

		List<Cliente> clientes = new ArrayList<>();
		Cliente cliente1 = new Cliente("Yunnan", 10000.0, TipoArticulo.ANTIGUEDAD);
		clientes.add(cliente1);

		SistemaVenta sistema = new SistemaVenta(clientes, articulos, combos);

		Venta sugerencia = sistema.sugerirArticuloOCombo(cliente1);
		assertNotNull(sugerencia);
	}

	@Test
	public void testComprar() throws CreditosInsuficientesException {
		List<Articulo> articulos = new ArrayList<>();
		articulos.add(new Articulo("Jarrón Florero Oriental", "Lujoso en todos los aspectos", 3890.0, 10, TipoArticulo.ANTIGUEDAD));

		List<Combo> combos = new ArrayList<>();
		List<Articulo> articulosCombo1 = new ArrayList<>();
		articulosCombo1.add(new Articulo("Jarrón Florero Oriental", "Lujoso en todos los aspectos", 3890.0, 10, TipoArticulo.ANTIGUEDAD));
		articulosCombo1.add(new Articulo("Papiro Egipcio", "Escena de caza", 29000.0, 8, TipoArticulo.ANTIGUEDAD));
		combos.add(new Combo("Combo antigüedad", articulosCombo1, 0.25 * (3890 + 29000)));

		List<Cliente> clientes = new ArrayList<>();
		Cliente cliente1 = new Cliente("Yunnan", 10000.0, TipoArticulo.ANTIGUEDAD);
		clientes.add(cliente1);

		SistemaVenta sistema = new SistemaVenta(clientes, articulos, combos);
		cliente1 = clientes.get(0);
		Venta sugerencia = sistema.sugerirArticuloOCombo(cliente1);
		sistema.comprar(cliente1, sugerencia);

		assertTrue(cliente1.getCompras().contains(sugerencia));
	}

	@Test
	public void testBuscarCombosVigentes() {
		List<Articulo> articulos = new ArrayList<>();
		articulos.add(new Articulo("Jarrón Florero Oriental", "Lujoso en todos los aspectos", 3890.0, 10, TipoArticulo.ANTIGUEDAD));

		List<Combo> combos = new ArrayList<>();
		List<Articulo> articulosCombo1 = new ArrayList<>();
		articulosCombo1.add(new Articulo("Jarrón Florero Oriental", "Lujoso en todos los aspectos", 3890.0, 10, TipoArticulo.ANTIGUEDAD));
		articulosCombo1.add(new Articulo("Papiro Egipcio", "Escena de caza", 29000.0, 8, TipoArticulo.ANTIGUEDAD));
		combos.add(new Combo("Combo antigüedad", articulosCombo1, 0.25 * (3890 + 29000)));

		List<Cliente> clientes = new ArrayList<>();
		Cliente cliente1 = new Cliente("Yunnan", 10000.0, TipoArticulo.ANTIGUEDAD);
		clientes.add(cliente1);

		SistemaVenta sistema = new SistemaVenta(clientes, articulos, combos);

		cliente1 = clientes.get(0);
		List<Combo> combosVigentes = sistema.buscarCombosVigentes(cliente1);

		assertFalse(combosVigentes.isEmpty());
	}

	@Test
	public void testSugerirArticuloOCombo_SugerirArticulo() {
		// prueba la sugerencia de un articulo individual que coincida con preferencias y creditos
		List<Articulo> articulos = new ArrayList<>();
		articulos.add(new Articulo("Jarrón Florero Oriental", "Lujoso en todos los aspectos", 3890.0, 10, TipoArticulo.ANTIGUEDAD));

		List<Combo> combos = new ArrayList<>();
		List<Articulo> articulosCombo1 = new ArrayList<>();
		articulosCombo1.add(new Articulo("Jarrón Florero Oriental", "Lujoso en todos los aspectos", 3890.0, 10, TipoArticulo.ANTIGUEDAD));
		articulosCombo1.add(new Articulo("Papiro Egipcio", "Escena de caza", 29000.0, 8, TipoArticulo.ANTIGUEDAD));
		combos.add(new Combo("Combo antigüedad", articulosCombo1, 0.25 * (3890 + 29000)));

		List<Cliente> clientes = new ArrayList<>();
		Cliente cliente = new Cliente("Yunnan", 10000.0, TipoArticulo.ANTIGUEDAD);
		clientes.add(cliente);

		SistemaVenta sistema = new SistemaVenta(clientes, articulos, combos);

		sistema.getClientes().add(cliente);

		Venta sugerencia = sistema.sugerirArticuloOCombo(cliente);

		assertNotNull(sugerencia);
		assertTrue(sugerencia instanceof Articulo);
		assertEquals(TipoArticulo.ANTIGUEDAD, ((Articulo) sugerencia).getTipo());
		assertTrue(cliente.getPresupuesto() >= sugerencia.getValor());
	}

	@Test
	public void testSugerirArticuloOCombo_SugerirCombo() {
		// que sugerencia de un combo que coincida con las preferencias y creditos
		List<Articulo> articulos = new ArrayList<>();
		articulos.add(new Articulo("Jarrón Florero Oriental", "Lujoso en todos los aspectos", 3890.0, 10, TipoArticulo.ANTIGUEDAD));

		List<Combo> combos = new ArrayList<>();
		List<Articulo> articulosCombo1 = new ArrayList<>();
		articulosCombo1.add(new Articulo("Jarrón Florero Oriental", "Lujoso en todos los aspectos", 3890.0, 10, TipoArticulo.ANTIGUEDAD));
		articulosCombo1.add(new Articulo("Papiro Egipcio", "Escena de caza", 29000.0, 8, TipoArticulo.ANTIGUEDAD));
		combos.add(new Combo("Combo antigüedad", articulosCombo1, 0.25 * (3890 + 29000)));

		List<Cliente> clientes = new ArrayList<>();
		Cliente cliente = new Cliente("Guangxi", 200000.0, TipoArticulo.EXOTICO);
		clientes.add(cliente);

		SistemaVenta sistema = new SistemaVenta(clientes, articulos, combos);

		sistema.getClientes().add(cliente);

		Venta sugerencia = sistema.sugerirArticuloOCombo(cliente);

		assertNotNull(sugerencia);
		assertTrue(sugerencia instanceof Combo);
		assertTrue(cliente.getPresupuesto() >= sugerencia.getValor());
	}

	@Test
	public void testSugerirArticuloOCombo_SinSugerencia() {
		// cuando no hay ninguna sugerencia adecuad
		List<Articulo> articulos = new ArrayList<>();
		articulos.add(new Articulo("Jarrón Florero Oriental", "Lujoso en todos los aspectos", 3890.0, 10, TipoArticulo.ANTIGUEDAD));

		List<Combo> combos = new ArrayList<>();
		List<Articulo> articulosCombo1 = new ArrayList<>();
		articulosCombo1.add(new Articulo("Jarrón Florero Oriental", "Lujoso en todos los aspectos", 3890.0, 10, TipoArticulo.ANTIGUEDAD));
		articulosCombo1.add(new Articulo("Papiro Egipcio", "Escena de caza", 29000.0, 8, TipoArticulo.ANTIGUEDAD));
		combos.add(new Combo("Combo antigüedad", articulosCombo1, 0.25 * (3890 + 29000)));

		List<Cliente> clientes = new ArrayList<>();
		Cliente cliente = new Cliente("Schuan", 11000.0, TipoArticulo.LUJO);
		clientes.add(cliente);

		SistemaVenta sistema = new SistemaVenta(clientes, articulos, combos);

		sistema.getClientes().add(cliente);

		Venta sugerencia = sistema.sugerirArticuloOCombo(cliente);

		assertNotNull(sugerencia);
	}

	@Test
	public void testComprar_ArticuloValido() throws CreditosInsuficientesException {

		List<Articulo> articulos = new ArrayList<>();
		articulos.add(new Articulo("Jarrón Florero Oriental", "Lujoso en todos los aspectos", 3890.0, 10, TipoArticulo.ANTIGUEDAD));

		List<Combo> combos = new ArrayList<>();
		List<Articulo> articulosCombo1 = new ArrayList<>();
		articulosCombo1.add(new Articulo("Jarrón Florero Oriental", "Lujoso en todos los aspectos", 3890.0, 10, TipoArticulo.ANTIGUEDAD));
		articulosCombo1.add(new Articulo("Papiro Egipcio", "Escena de caza", 29000.0, 8, TipoArticulo.ANTIGUEDAD));
		combos.add(new Combo("Combo antigüedad", articulosCombo1, 0.25 * (3890 + 29000)));

		List<Cliente> clientes = new ArrayList<>();
		Cliente cliente = new Cliente("Huguang", 1900000.0, TipoArticulo.INVALUABLE);
		clientes.add(cliente);

		SistemaVenta sistema = new SistemaVenta(clientes, articulos, combos);

		sistema.getClientes().add(cliente);

		Venta itemToBuy = new Articulo("Sable Corvo", "Sable Corvo Facsímil San Martin", 98900.0, 7, TipoArticulo.INVALUABLE);

		sistema.comprar(cliente, itemToBuy);

		assertTrue(cliente.getCompras().contains(itemToBuy));
		assertEquals(1801100, cliente.getPresupuesto());
		assertEquals(6, itemToBuy.getCantidad());
	}

	@Test
	public void testComprar_ComboValido() throws CreditosInsuficientesException {
		List<Articulo> articulos = new ArrayList<>();
		articulos.add(new Articulo("Jarrón Florero Oriental", "Lujoso en todos los aspectos", 3890.0, 10, TipoArticulo.ANTIGUEDAD));

		List<Combo> combos = new ArrayList<>();
		List<Articulo> articulosCombo1 = new ArrayList<>();
		articulosCombo1.add(new Articulo("Jarrón Florero Oriental", "Lujoso en todos los aspectos", 3890.0, 10, TipoArticulo.ANTIGUEDAD));
		articulosCombo1.add(new Articulo("Papiro Egipcio", "Escena de caza", 29000.0, 8, TipoArticulo.ANTIGUEDAD));
		combos.add(new Combo("Combo antigüedad", articulosCombo1, 0.25 * (3890 + 29000)));

		List<Cliente> clientes = new ArrayList<>();
		Cliente cliente = new Cliente("Huguang", 1900000.0, TipoArticulo.INVALUABLE);
		clientes.add(cliente);

		SistemaVenta sistema = new SistemaVenta(clientes, articulos, combos);

		sistema.getClientes().add(cliente);

		Combo comboToBuy = new Combo("Combo invaluable", articulosCombo1, 0.0);

		sistema.comprar(cliente, comboToBuy);

		assertTrue(cliente.getCompras().contains(comboToBuy));
		assertEquals(1900000, cliente.getPresupuesto());
		assertEquals(9, comboToBuy.getArticulos().get(0).getCantidad()); 
	}

	@Test
	public void testComprar_ExcepcionCreditosInsuficientes() {
		// prueba cuando un cliente intenta comprar un articulo con creditos insuficientes
		List<Articulo> articulos = new ArrayList<>();
		articulos.add(new Articulo("Jarrón Florero Oriental", "Lujoso en todos los aspectos", 3890.0, 10, TipoArticulo.ANTIGUEDAD));

		List<Combo> combos = new ArrayList<>();
		List<Articulo> articulosCombo1 = new ArrayList<>();
		articulosCombo1.add(new Articulo("Jarrón Florero Oriental", "Lujoso en todos los aspectos", 3890.0, 10, TipoArticulo.ANTIGUEDAD));
		articulosCombo1.add(new Articulo("Papiro Egipcio", "Escena de caza", 29000.0, 8, TipoArticulo.ANTIGUEDAD));
		combos.add(new Combo("Combo antigüedad", articulosCombo1, 0.25 * (3890 + 29000)));

		List<Cliente> clientes = new ArrayList<>();
		Cliente cliente = new Cliente("Schuan", 11000.0, TipoArticulo.LUJO);
		clientes.add(cliente);

		SistemaVenta sistema = new SistemaVenta(clientes, articulos, combos);

		sistema.getClientes().add(cliente);

		Venta itemToBuy = new Articulo("Sofá sillón inglés", "Espectacular Sofá de 3 cuerpos estilo Colonial Inglés", 92999.0, 20, TipoArticulo.LUJO);

		assertThrows(CreditosInsuficientesException.class, () -> sistema.comprar(cliente, itemToBuy));
	}

	@Test
	public void testComprar_ItemYaComprado() {
		// cuando un cliente intenta comprar un articulo que ya ha sido comprado
	}
}
