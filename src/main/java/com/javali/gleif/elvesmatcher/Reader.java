package com.javali.gleif.elvesmatcher;

import com.opencsv.bean.CsvToBeanBuilder;

import java.io.*;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Stream;

/**
 * Read
 *
 * @author javali on 13.12.2020.
 */
public class Reader {

  /**
   * Retrieve all elf codes from the csv file.
   *
   * @return a {@link List< ELF >}.
   */
  public List<ELF> getElfCodes() {

    String fileName = null;
    try {
      fileName = getCsvFileName();
    } catch (IOException e) {
      e.printStackTrace();
    }

    ClassLoader classLoader = this.getClass().getClassLoader();
    URL resource = classLoader.getResource(fileName);
    if (resource == null) {
      throw new NullPointerException();
    }
    File file = new File(resource.getFile());

    FileReader fileReader = null;
    try {
      fileReader = new FileReader(file);
    } catch (FileNotFoundException e) {
      e.printStackTrace();
    }

    if (fileReader == null) {
      throw new NullPointerException();
    }
    return new CsvToBeanBuilder<ELF>(fileReader)
            .withType(ELF.class)
            .withSkipLines(1)
            .build()
            .parse();
  }

  /**
   * Find the current csv in /src/main/resources.
   * @return the filename String representation
   * @throws IOException if more than one of no entries are found
   */
  private String getCsvFileName() throws IOException {
    Path resourceDirectory = Paths.get("src", "main", "resources");
    try (Stream<Path> paths = Files.walk(resourceDirectory)) {

      return paths
          .filter(Files::isRegularFile)
          .findFirst()
          .orElseThrow(FileNotFoundException::new)
          .getFileName()
          .toFile()
          .getName();
    }

  }
}
