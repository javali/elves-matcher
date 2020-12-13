package com.javali.gleif.elvesmatcher;

import java.util.Date;
import java.util.List;
import com.opencsv.bean.CsvBindAndSplitByPosition;
import com.opencsv.bean.CsvBindByPosition;
import com.opencsv.bean.CsvDate;
import lombok.Data;

/** @author javali on 13.12.2020. */
@Data
public class ELF {

  @CsvBindByPosition(position = 0)
  private String elfcode;

  @CsvBindByPosition(position = 1)
  private String countryOfFormation;

  //  (ISO 3166-1)
  @CsvBindByPosition(position = 2)
  private String countryCode;

  @CsvBindByPosition(position = 3)
  private String jurisdictionOfFormation;

  //  (ISO 3166-2)
  @CsvBindByPosition(position = 4)
  private String countrySubDivisionCode;

  @CsvBindByPosition(position = 5)
  private String entityLegalFormNameLocalName;

  @CsvBindByPosition(position = 6)
  private String language;

  //  (ISO 639-1)
  @CsvBindByPosition(position = 7)
  private String languageCode;

  //  (per ISO 01-140-10)
  @CsvBindByPosition(position = 8)
  private String entityLegalFormNameTransliteratedName;

  //@CsvBindByName(column = "Abbreviations Local language")
  @CsvBindAndSplitByPosition(position = 9, elementType = String.class, splitOn = ";")
  private List<String> abbreviationsLocalLanguage;

  @CsvBindByPosition(position = 10)
  private String abbreviationsTransliterated;

  //  YYYY-MM-DD (ISO 8601)
  @CsvBindByPosition(position = 11)
  @CsvDate("yyyy-MM-dd")
  private Date dateCreated;

  // ACTV/INAC
  @CsvBindByPosition(position = 12)
  private String elfStatus;

  @CsvBindByPosition(position = 13)
  private String modification;

  //  YYYY-MM-DD (ISO 8601)
  @CsvBindByPosition(position = 14)
  @CsvDate("yyyy-MM-dd")
  private Date modificationDate;

  @CsvBindByPosition(position = 15)
  private String reason;
}
