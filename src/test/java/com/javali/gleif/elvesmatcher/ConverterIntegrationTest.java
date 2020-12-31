package com.javali.gleif.elvesmatcher;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.javali.gleif.elvesmatcher.controller.ConverterController;
import com.javali.gleif.elvesmatcher.model.LegalForm;
import com.javali.gleif.elvesmatcher.util.Converter;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(ConverterController.class)
class ConverterIntegrationTest {

	@Autowired
	private WebApplicationContext context;

	@MockBean
	private Converter converter;

	protected MockMvc mockMvc;

	private static ObjectMapper objectMapper = new ObjectMapper();

	@BeforeEach
	public void setup() {
		this.mockMvc = MockMvcBuilders
				.webAppContextSetup(this.context)
				.build();
	}

	@Test
	void testControllerResponds() throws Exception {

		LegalForm legalForm = new LegalForm();
		legalForm.setLegislation("DE");
		legalForm.setAbbreviation("GmbH");
		this.mockMvc
				.perform(post("/convert")
						.contentType(MediaType.APPLICATION_JSON_UTF8_VALUE)
						.content(objectMapper.writeValueAsString(legalForm)))
				.andExpect(status().isOk());

	}


	private Map<String, List<String>> createMap() {
		Map<String, List<String>> map = new HashMap<>();
		map.put("DE", new ArrayList<>());
		map.get("DE").add("VVaG");
		map.get("DE").add("GmbH");
		map.get("DE").add("PartG mbB");
		map.get("DE").add("OHG");
		map.get("DE").add("OHG mbH");
		map.get("DE").add("GmbH & Co. OHG");
		map.get("DE").add("AG & Co. OHG");
		map.get("DE").add("GmbH UG");
		map.get("DE").add("UG (haftungsbeschränkt)");
		map.get("DE").add("AG");
		map.get("DE").add("PartG");
		map.get("DE").add("KG");
		map.get("DE").add("GmbH & Co. KG");
		map.get("DE").add("UG (haftungsbeschränkt) & Co. KG AG & Co. KG");
		map.get("DE").add("KGaA & Co. KG");
		map.get("DE").add("Stiftung & Co. KG");
		map.get("DE").add("REIT-AG");
		map.get("DE").add("eG");
		map.get("DE").add("GbR");
		map.get("DE").add("InvAG");
		map.get("DE").add("EWIV");
		map.get("DE").add("e. K.");
		map.get("DE").add("eK");
		map.get("DE").add("e. Kfm.");
		map.get("DE").add("e. Kffr");
		map.get("DE").add("e.V.");
		map.get("DE").add("eV");
		map.get("DE").add("gGmbH");
		map.get("DE").add("SE");
		map.get("DE").add("SCE");
		map.get("DE").add("KGaA");
		map.get("DE").add("GmbH & Co. KGaA");
		map.get("DE").add("AG & Co. KGaA");
		map.get("DE").add("Stiftung & Co. KGaA");
		map.get("DE").add("eG");
		map.get("DE").add("e.G.");
		map.get("DE").add("gAG");
		return map;
	}
}
