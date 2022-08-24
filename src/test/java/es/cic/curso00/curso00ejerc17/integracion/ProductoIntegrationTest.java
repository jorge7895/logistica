package es.cic.curso00.curso00ejerc17.integracion;

import static org.hamcrest.Matchers.is;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

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

import es.cic.curso00.curso00ejerc17.model.Producto;
import es.cic.curso00.curso00ejerc17.util.TestUtil;

@SpringBootTest
@AutoConfigureMockMvc
@Transactional
class ProductoIntegrationTest {

	@Autowired
	private MockMvc mvc;

	@PersistenceContext
	private EntityManager em;
	
	private Producto producto1;
	private Producto producto2;
	private TestUtil testUtil;
	
	@BeforeEach
	void setUp() throws Exception {
		
		testUtil = new TestUtil();
		
		producto1 = testUtil.getProducto1();
		em.persist(producto1);
		producto2 = testUtil.getProducto2();
		em.persist(producto2);
	}

	@Test
	void testReporteProducto() throws JsonProcessingException, Exception {
				
		mvc.perform(get("/api/v1/producto/totales"))
				.andExpect(status().is2xxSuccessful())
				.andExpect(content().contentType(MediaType.APPLICATION_JSON))
				.andExpect(jsonPath("$.content.length()",is(2)))
				.andExpect(jsonPath("$.content[0].nombre",is("Balón de fútbol")))
				.andExpect(jsonPath("$.content[1].nombre",is("Balón de baloncesto")))
				.andDo(print());
	}

}
