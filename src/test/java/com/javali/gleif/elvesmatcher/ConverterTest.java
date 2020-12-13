package com.javali.gleif.elvesmatcher;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * @author javali on 13.12.2020.
 */
class ConverterTest {

    @Test
    void testCreationOfElfCodes_isNotEmpty() {

        Converter converter = new Converter();
        String convert = converter.convert("DE", "GmbH");

        Assertions.assertNotNull(convert);
        Assertions.assertEquals("2HBR", convert);

    }

}