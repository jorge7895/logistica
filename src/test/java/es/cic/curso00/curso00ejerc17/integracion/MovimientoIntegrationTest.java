package es.cic.curso00.curso00ejerc17.integracion;

import static org.hamcrest.Matchers.is;
import static org.junit.jupiter.api.Assertions.fail;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.transaction.annotation.Transactional;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import es.cic.curso00.curso00ejerc17.model.Movimiento;
import es.cic.curso00.curso00ejerc17.model.Producto;
import es.cic.curso00.curso00ejerc17.util.TestUtil;
import es.cic.curso00.curso00ejerc17.util.TipoMovimiento;

@SpringBootTest
@AutoConfigureMockMvc
@Transactional
class MovimientoIntegrationTest {

	@Autowired
	private MockMvc mvc;

	@Autowired
	private ObjectMapper objectMapper;
	
	@PersistenceContext
	private EntityManager em;
	
	private Movimiento movimiento;
	private Producto producto1;
	private Producto producto2;
	private Producto producto3;
	private TestUtil testUtil;
	
	@BeforeEach
	void setUp() throws Exception {
		
		testUtil = new TestUtil();
		
		movimiento = testUtil.getMovimiento();
		
		producto1 = testUtil.getProducto1();
		producto1.setMovimiento(movimiento);
		producto2 = testUtil.getProducto2();
		producto2.setMovimiento(movimiento);
		producto3 = testUtil.getProducto3();
		producto3.setMovimiento(movimiento);
	}
	
	@Test
	void testMovimiento() throws JsonProcessingException, Exception {
				
		List<Producto> productos = new ArrayList<>();
		productos.add(producto1);
		productos.add(producto2);
		productos.add(producto3);

		
		mvc.perform(post("/api/v1/movimiento")
				.accept(MediaType.APPLICATION_JSON)
				.contentType(MediaType.APPLICATION_JSON)
				.content(objectMapper.writeValueAsString(productos)))
				.andExpect(status().is2xxSuccessful())
				.andExpect(content().contentType(MediaType.APPLICATION_JSON))
				.andExpect(jsonPath("$.fecha",is("2022-10-08")))
				.andExpect(jsonPath("$.importeTotal",is(100.0)))
				.andDo(print());
	}

	@Disabled
	@Test
	void testReporteCompra() throws JsonProcessingException, Exception {
		
		em.persist(movimiento);
		
		mvc.perform(get("/api/v1/movimiento/compra"))
				.andExpect(status().is2xxSuccessful())
				.andExpect(content().contentType(MediaType.APPLICATION_JSON))
				.andExpect(jsonPath("$.content.length()",is(1)))
				.andExpect(jsonPath("$.content[0].fechaCompra",is("2022-10-08")))
				.andDo(print());
	}
}
