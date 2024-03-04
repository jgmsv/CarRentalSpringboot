package mindswap.porto.RentACar.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import mindswap.porto.RentACar.RentACarApplication;
import mindswap.porto.RentACar.model.Client;
import mindswap.porto.RentACar.repository.ClientRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.hamcrest.Matchers.hasSize;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;


@SpringBootTest (classes = RentACarApplication.class)
@AutoConfigureMockMvc
class RentACarApplicationTests {

	@Autowired
	private MockMvc mockMvc;
	@Autowired
	private ObjectMapper objectMapper;
	@Autowired
	private ClientRepository clientRepository;
	@BeforeEach
	public void init() {
		clientRepository.deleteAll();
		clientRepository.resetId();
	}
	@Test
	void otS() {
	}

	@Test
	@DisplayName("Test get all clients when no clients on db returns empty list")
	void testGetAllClientsWhenNoClientsOnDbReturnsEmptyList() throws Exception{
		mockMvc.perform(MockMvcRequestBuilders.get("http://localhost:8080/api/v1/client/"))
				.andExpect(status().isOk())
				.andExpect(content().contentType(MediaType.APPLICATION_JSON))
				.andExpect(jsonPath("$", hasSize(0)));
	}

	@Test
	@DisplayName("Test get all clients when 2 clients on database returns list with 2 clients")
	void TestGetAllClientsWhen2ClientsOnDatabaseReturnsListWith2() throws Exception{
		String stringJson1 =  "{\"name\": \"João\", \"nif\": \"123456789\", \"licence\": \"ABC123DEF\"," +
				" \"email\": \"joao@joao.pt\", \"birthDate\": \"1990-04-22\"}";
		String stringJson2 =  "{\"name\": \"José\", \"nif\": \"123456781\", \"licence\": \"ABC123DED\"," +
				" \"email\": \"jose@jose.pt\", \"birthDate\": \"1990-04-22\"}";

		mockMvc.perform(post("http://localhost:8080/api/v1/client/")
				.contentType(MediaType.APPLICATION_JSON)
				.content(stringJson1));
		mockMvc.perform(post("http://localhost:8080/api/v1/client/")
						.contentType(MediaType.APPLICATION_JSON)
						.content(stringJson2));
		mockMvc.perform(MockMvcRequestBuilders.get("http://localhost:8080/api/v1/client/"))
				.andExpect(status().isOk())
				.andExpect(content().contentType(MediaType.APPLICATION_JSON))
				.andExpect(jsonPath("$", hasSize(2)));
	}

	@Test
	@DisplayName("Test create a client when client returns status code 201")
	void testCreateClientReturnCreateAndGetIdEqualsTo1() throws Exception{
		String stringJson1 =  "{\"name\": \"Joao\", \"nif\": \"123456789\", \"licence\": \"ABC123DEF\"," +
				" \"email\": \"joao@joao.pt\", \"birthDate\": \"1990-04-22\"}";

		MvcResult mvcResult = mockMvc.perform(post("http://localhost:8080/api/v1/client/")
				.contentType(MediaType.APPLICATION_JSON)
				.content(stringJson1))
				.andExpect(status().isCreated())
				.andReturn();

		String responseContent = mvcResult.getResponse().getContentAsString();
		Client client = objectMapper.readValue(responseContent, Client.class);

		assertThat(client.getId()).isEqualTo(1L);
		assertThat(client.getName()).isEqualTo("Joao");
		assertThat(client.getNif()).isEqualTo(123456789);

	}
}
