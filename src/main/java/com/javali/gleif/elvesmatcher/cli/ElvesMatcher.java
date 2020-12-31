package com.javali.gleif.elvesmatcher.cli;

import com.javali.gleif.elvesmatcher.util.Converter;
import com.javali.gleif.elvesmatcher.util.Reader;
import org.apache.commons.cli.*;

import java.util.HashMap;
import java.util.Map;

/** @author javali on 30.12.2020. */
public class ElvesMatcher {

  private static final Converter converter = new Converter(new Reader());
  public static final String LEGISLATION = "legislation";
  public static final String CONVERT = "convert";

  public static void main(String[] args) throws ParseException {
    Options commandLineOptions = createCommandLineOptions();
    if (args.length < 2) {
      HelpFormatter formatter = new HelpFormatter();
      formatter.printHelp("ElvesMatcher.jar", commandLineOptions);
      System.exit(0);
    }
    Map<String, String> convertMap = createConvertMap(commandLineOptions, args);
    String elfCode = converter.convert(convertMap.get(LEGISLATION), convertMap.get(CONVERT));
    System.out.println(elfCode);
  }

  private static Options createCommandLineOptions() {

    Options options = new Options();
    Option legislationOption =
        Option.builder()
            .argName(LEGISLATION)
            .hasArg()
            .required(true)
            .desc("legislation of the abbreviation")
            .longOpt(LEGISLATION)
            .build();
    Option convertOption =
        Option.builder()
            .argName(CONVERT)
            .hasArg()
            .required(true)
            .desc("local abbreviation to convert")
            .longOpt(CONVERT)
            .build();
    options.addOption(legislationOption);
    options.addOption(convertOption);
    return options;
  }

  private static Map<String, String> createConvertMap(Options commandLineOptions, String[] args)
      throws ParseException {
    CommandLineParser parser = new DefaultParser();
    Map<String, String> convertMap = new HashMap<>();
    CommandLine commandLine = parser.parse(commandLineOptions, args);
    convertMap.put(
        commandLineOptions.getOption(LEGISLATION).getArgName(),
        commandLine.getOptionValue(LEGISLATION));
    convertMap.put(
        commandLineOptions.getOption(CONVERT).getArgName(), commandLine.getOptionValue(CONVERT));
    return convertMap;
  }
}
