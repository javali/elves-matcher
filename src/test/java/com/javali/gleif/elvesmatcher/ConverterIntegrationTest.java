package com.javali.gleif.elvesmatcher;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.javali.gleif.elvesmatcher.model.ELF;
import com.javali.gleif.elvesmatcher.model.LegalForm;
import jdk.internal.org.objectweb.asm.Handle;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;

import java.util.*;

@SpringBootTest(
    classes = ElvesMatcherRestApplication.class,
    webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class ConverterIntegrationTest {

  @LocalServerPort private int port;
  @Autowired private TestRestTemplate restTemplate;
  private Map<String, List<String>> testObjects = createMap();

  @Test
  void testRunWithMultipleRequests() {

    testObjects
        .keySet()
        .forEach(
            legislation -> {
              testObjects
                  .get(legislation)
                  .forEach(
                      abbreviation -> {
                        LegalForm legalForm = new LegalForm();
                        legalForm.setLegislation(legislation);
                        legalForm.setAbbreviation(abbreviation);

                        String url = "http://localhost:" + port + "/convert";
                        ELF elf = this.restTemplate.postForObject(url, legalForm, ELF.class);

                        Assertions.assertNotNull(elf);
                      });
            });
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
