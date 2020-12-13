package com.javali.gleif.elvesmatcher;


import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

/**
 * @author javali on 13.12.2020.
 */
class ReaderTest {

    @Test
    void testConverter_generatesObject() {
        Reader reader = new Reader();
        List<ELF> elfCodes = reader.getElfCodes();

        Assertions.assertNotNull(elfCodes);
    }
}