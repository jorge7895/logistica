package es.cic.curso00.curso00ejerc17.integracion;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.support.TransactionCallbackWithoutResult;
import org.springframework.transaction.support.TransactionTemplate;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import es.cic.curso00.curso00ejerc17.model.Producto;
import es.cic.curso00.curso00ejerc17.repository.ProductoDAO;
import es.cic.curso00.curso00ejerc17.util.TestUtil;

@SpringBootTest
@AutoConfigureMockMvc
@Transactional
public class ProductoConstrainsIntegrationTest {

	@Autowired
	private MockMvc mvc;
	
	@Autowired
	private ObjectMapper objectMapper;

	@PersistenceContext
	private EntityManager em;
	
	private Producto producto1;
	private TestUtil testUtil;
	
	@Autowired
	private ProductoDAO productoDao;
	
    @Autowired
    private PlatformTransactionManager transactionManager;

    private TransactionTemplate transactionTemplate;
	
	@BeforeEach
	void setUp() throws Exception {
		
		testUtil = new TestUtil();
		
		transactionTemplate = new TransactionTemplate(transactionManager);
		
		transactionTemplate.execute(new TransactionCallbackWithoutResult() {
	        @Override
	        protected void doInTransactionWithoutResult(TransactionStatus status) {
	    		producto1 = testUtil.getProducto1();
	    		producto1.setNombre("Test");
	    		em.persist(producto1);
	        }
	        	
        });
	}
	
	@AfterEach
	void tearDown() throws Exception {
		productoDao.delete(producto1);
	}
	
	@Test
	@Transactional(propagation = Propagation.NOT_SUPPORTED)
	void testCrearProductoRepetido() throws JsonProcessingException, Exception {
		
		Producto producto = new Producto();
		producto.setActiva(true);
		producto.setNombre("Test");
		producto.setMarca("Micasa");
		
		mvc.perform(post("/api/v1/producto")
				.accept(MediaType.APPLICATION_JSON)
				.contentType(MediaType.APPLICATION_JSON)
				.content(objectMapper.writeValueAsString(producto)))
				.andExpect(status().is4xxClientError())
				.andDo(print());
	}
}
