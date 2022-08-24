package es.cic.curso00.curso00ejerc17.integracion;

import static org.hamcrest.Matchers.is;
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

@SpringBootTest
@AutoConfigureMockMvc
@Transactional
class CompraIntegrationTests {

	@Autowired
	private MockMvc mvc;

	@Autowired
	private ObjectMapper objectMapper;

	@PersistenceContext
	private EntityManager em;
	
	private Compra compra;
	private Producto producto;
	private LocalDate fecha;
	
	@BeforeEach
	void setUp()  {
		
		fecha = LocalDate.of(2022, Month.OCTOBER, 8);
		
		compra = new Compra();
		compra.setActiva(true);
		compra.setFechaCompra(fecha);
		
		producto = new Producto();
		producto.setActiva(true);
		producto.setCantidadComprada(5);
		producto.setCompra(compra);
		producto.setMarca("Micasa");
		producto.setNombre("Balón de fútbol");
		producto.setPrecioCompra(5.0f);
	}
	
	@Test
	void testCompra() throws JsonProcessingException, Exception {

		List<Producto> productos = new ArrayList<>();
		productos.add(producto);
		
		mvc.perform(post("/api/v1/compra")
				.accept(MediaType.APPLICATION_JSON)
				.contentType(MediaType.APPLICATION_JSON)
				.content(objectMapper.writeValueAsString(productos)))
				.andExpect(status().is2xxSuccessful())
				.andExpect(content().contentType(MediaType.APPLICATION_JSON))
				.andExpect(jsonPath("$.[0].compra.fechaCompra",is("2022-10-08")))
				.andExpect(jsonPath("$.[0].compra.importeTotal",is(25.0)))
				.andDo(print());
	}

}
