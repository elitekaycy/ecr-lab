package com.elitekaycy.ascii.core;

import com.github.lalyos.jfiglet.FigletFont;

public class AsciiGenerator {

  public static String generate(String input) {
    try {
      return FigletFont.convertOneLine(input);
    } catch (Exception e) {
      return "Error generating ASCII art.";
    }
  }
}
