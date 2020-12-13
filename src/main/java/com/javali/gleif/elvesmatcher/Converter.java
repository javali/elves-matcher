package com.javali.gleif.elvesmatcher;

/**
 * @author javali on 13.12.2020.
 */
public class Converter {

    private Reader reader;

    public Converter() {
        this.reader = new Reader();
    }

    /**
     * Convert a legalForm to an ELF-code.
     *
     * @param countryCode the country code (ISO 3166-1, Alpha-2)
     * @param legalForm the string representation  of the abbreviation
     * @return the ELF-code.
     */
    public String convert(String countryCode, String legalForm) {

        ELF foundElfCode = reader.getElfCodes().stream()
                .filter(elfCode -> elfCode.getCountryCode() != null)
                .filter(elfCode -> elfCode.getAbbreviationsLocalLanguage() != null)
                .filter(elfCode -> countryCode.equals(elfCode.getCountryCode()))
                .filter(elfCode -> elfCode.getAbbreviationsLocalLanguage().contains(legalForm))
                .findFirst()
                .orElseThrow(NullPointerException::new);

        // TODO Read serialized object

        return foundElfCode.getElfcode();
    }

}
