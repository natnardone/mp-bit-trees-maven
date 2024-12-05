package edu.grinnell.csc207.main;

import java.io.PrintWriter;

import edu.grinnell.csc207.util.BrailleAsciiTables;

/**
 * A class for converting between Braille, ASCII, and Unicode through command line inputs.
 * @author Natalie Nardone
 */
public class BrailleASCII {
  // +------+--------------------------------------------------------
  // | Main |
  // +------+

  /**
   * Takes two command line arguments and performs the corresponding translation.
   * @param args
   *   The command-line arguments, where the first argument is the target character
   *   set and the second is the source characters.
   */
  public static void main(String[] args) {
    PrintWriter pen = new PrintWriter(System.out, true);

    String target = args[0];
    String source = args[1];

    if (target.equals("braille")) {
      for (int i = 0; i < source.length(); i++) {
        char current = source.charAt(i);
        if ((current != ' ') && (!Character.isAlphabetic(current))) {
          pen.println();
          pen.print("No corresponding Braille character.");
          break;
        } else {
          pen.print(BrailleAsciiTables.toBraille(current));
        } // if/else
      } // for
    } else if (target.equals("ascii")) {
      if ((source.length() % 6) != 0) {
        pen.print("Invalid length of bit string.");
      } else {
        for (int i = 0; i <= source.length() - 6; i = i + 6) {
          String current = source.substring(i, i + 6);
          pen.print(BrailleAsciiTables.toAscii(current));
        } // for
      } // if/else
    } else if (target.equals("unicode")) {
      // call tobraille then tounicode
      for (int i = 0; i < source.length(); i++) {
        char current = source.charAt(i);
        if ((current != ' ') && (!Character.isAlphabetic(current))) {
          pen.println();
          pen.print("No corresponding character.");
          break;
        } else {
          pen.print(BrailleAsciiTables.toUnicode(BrailleAsciiTables.toBraille(current)));
        } // if/else
      } // for
    } else {
      pen.println();
      pen.print("Invalid command.");
    } // if/else
    pen.println();
    pen.close();
  } // main(String[])

} // class BrailleASCII
