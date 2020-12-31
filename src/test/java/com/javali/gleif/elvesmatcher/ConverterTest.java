package com.javali.gleif.elvesmatcher;

import com.javali.gleif.elvesmatcher.model.ELF;
import com.javali.gleif.elvesmatcher.util.Converter;
import com.javali.gleif.elvesmatcher.util.Reader;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.when;

/**
 * @author javali on 13.12.2020.
 */
@SpringBootTest
class ConverterTest {

    @Mock
    private Reader reader;

    @InjectMocks
    private Converter converter;

    @Test
    void testCreationOfElfCodes_isNotEmpty() {

        List<ELF> elfListMock = new ArrayList<>();
        ELF elfElement = new ELF();
        elfElement.setElfcode("2HBR");
        elfElement.setCountryCode("DE");
        elfElement.setAbbreviationsLocalLanguage(new ArrayList<>());
        elfElement.getAbbreviationsLocalLanguage().add("GmbH");
        elfListMock.add(elfElement);
        when(reader.getElfCodes()).thenReturn(elfListMock);

        String convert = converter.convert("DE", "GmbH");

        Assertions.assertNotNull(convert);
        Assertions.assertEquals("2HBR", convert);

    }

}