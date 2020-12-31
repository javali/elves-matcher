package com.javali.gleif.elvesmatcher.util;

import com.javali.gleif.elvesmatcher.model.ELF;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author javali on 13.12.2020.
 */
@Service
public class Converter {

    private final Reader reader;

    @Autowired
    public Converter(Reader reader) {
        this.reader = reader;
    }

    /**
     * Convert a legalForm to an ELF-code.
     *
     * @param countryCode the country code (ISO 3166-1, Alpha-2)
     * @param legalForm the string representation  of the abbreviation
     * @return the ELF-code.
     */
    public String convert(String countryCode, String legalForm) {
        ELF foundElfCode = getElf(countryCode, legalForm);
        return foundElfCode.getElfcode();
    }

    /**
     * Get an ELF object.
     *
     * @param countryCode the country code
     * @param legalForm the legal form abbreviation
     * @return the {@link ELF}
     */
    public ELF getElf(String countryCode, String legalForm) {
        return reader.getElfCodes().stream()
                .filter(elfCode -> elfCode.getCountryCode() != null)
                .filter(elfCode -> elfCode.getAbbreviationsLocalLanguage() != null)
                .filter(elfCode -> countryCode.equals(elfCode.getCountryCode()))
                .filter(elfCode -> elfCode.getAbbreviationsLocalLanguage().contains(legalForm))
                .findFirst()
                .orElseThrow(NullPointerException::new);
    }

}
