package com.javali.gleif.elvesmatcher;

import com.javali.gleif.elvesmatcher.util.Converter;
import com.javali.gleif.elvesmatcher.util.Reader;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;

/**
 * @author javali on 13.12.2020.
 */
class ConverterTest {

    @Mock
    private Reader reader;

    @InjectMocks
    private Converter converter;

    @Test
    void testCreationOfElfCodes_isNotEmpty() {

        String convert = converter.convert("DE", "GmbH");

        Assertions.assertNotNull(convert);
        Assertions.assertEquals("2HBR", convert);

    }

}