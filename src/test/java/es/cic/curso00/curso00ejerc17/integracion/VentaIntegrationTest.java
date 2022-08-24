package es.cic.curso00.curso00ejerc17.integracion;

import static org.hamcrest.Matchers.is;
import static org.junit.jupiter.api.Assertions.fail;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.time.LocalDate;
import java.time.Month;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import es.cic.curso00.curso00ejerc17.model.Compra;
import es.cic.curso00.curso00ejerc17.model.Producto;
import es.cic.curso00.curso00ejerc17.model.Venta;

@SpringBootTest
@AutoConfigureMockMvc
@Transactional
class VentaIntegrationTest {

	@Autowired
	private MockMvc mvc;

	@Autowired
	private ObjectMapper objectMapper;

	@PersistenceContext
	private EntityManager em;
	
	private Venta venta;
	private Producto producto;
	private Producto producto2;
	private Producto producto3;
	private LocalDate fecha;
	
	@BeforeEach
	void setUp() throws Exception {
		fecha = LocalDate.of(2022, Month.OCTOBER, 8);
		
		venta = new Venta();
		venta.setActiva(true);
		venta.setFechaVenta(fecha);
		
		producto = new Producto();
		producto.setActiva(true);
		producto.setCantidadComprada(5);
		producto.setVenta(venta);
		producto.setMarca("Micasa");
		producto.setNombre("Balón de fútbol");
		producto.setPrecioCompra(5.0f);
		
		producto2 = new Producto();
		producto2.setActiva(true);
		producto2.setCantidadComprada(10);
		producto2.setVenta(venta);
		producto2.setMarca("Micasa");
		producto2.setNombre("Balón de baloncesto");
		producto2.setPrecioCompra(3.0f);
		
		producto3 = new Producto();
		producto3.setActiva(true);
		producto3.setCantidadComprada(10);
		producto3.setVenta(venta);
		producto3.setMarca("Micasa");
		producto3.setNombre("Balón de balonmano");
		producto3.setPrecioCompra(2.0f);
	}

	@Test
	void testCreateVenta() throws JsonProcessingException, Exception {
		
		List<Producto> productos = new ArrayList<>();
		productos.add(producto);
		productos.add(producto2);
		productos.add(producto3);
		
		mvc.perform(post("/api/v1/venta")
				.accept(MediaType.APPLICATION_JSON)
				.contentType(MediaType.APPLICATION_JSON)
				.content(objectMapper.writeValueAsString(productos)))
				.andExpect(status().is2xxSuccessful())
				.andExpect(content().contentType(MediaType.APPLICATION_JSON))
				.andExpect(jsonPath("$.fechaVenta",is("2022-10-08")))
				.andExpect(jsonPath("$.importeTotal",is(0.0)))
				.andDo(print());
	}

}
