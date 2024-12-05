package edu.grinnell.csc207.util;

import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Trees intended to be used in storing mappings between fixed-length
 * sequences of bits and corresponding values.
 *
 * @author Natalie Nardone
 */
public class BitTree {
  // +--------+------------------------------------------------------
  // | Fields |
  // +--------+

  // root/starting node and size

  /**
   * The root node of the tree.
   */
  BitTreeNode root;

  /**
   * The size (number of levels) of the tree.
   */
  int size;

  // +--------------+------------------------------------------------
  // | Constructors |
  // +--------------+

  /**
   * Creates a new BitTree with size n.
   * @param n
   *   The size of the tree.
   */
  public BitTree(int n) {
    this.root = new BitTreeNode();
    this.size = n;
  } // BitTree(int)

  // +---------------+-----------------------------------------------
  // | Local helpers |
  // +---------------+

  // +---------+-----------------------------------------------------
  // | Methods |
  // +---------+

  /**
   * Set the node at the end of the specified path to the specified value.
   * @param bits
   *   The binary path to follow in the tree.
   * @param value
   *   The value to set at the end of the path.
   */
  public void set(String bits, String value) {
    // Checks that bits is correct for this size of tree
    int len = bits.length();
    if (len != size) {
      throw new IndexOutOfBoundsException();
    } // if

    BitTreeNode curNode = root;
    char curChar;

    // Loops through the path until the last character, updating the current node
    for (int i = 0; i < len - 1; i++) {
      curChar = bits.charAt(i);
      if (curChar == '0') {
        if (curNode.getZero() == null) {
          curNode.setZero(new BitTreeNode());
        } // if
        curNode = curNode.getZero();
      } else if (curChar == '1') {
        if (curNode.getOne() == null) {
          curNode.setOne(new BitTreeNode());
        } // if
        curNode = curNode.getOne();
      } else {
        throw new IndexOutOfBoundsException();
      } // if/else
    } // for

    // Sets/creates the leaf in the appropriate subtree
    if (bits.charAt(len - 1) == '0') {
      if (curNode.getZero() == null) {
        curNode.setZero(new BitTreeNode(value));
      } else {
        curNode.getZero().setValue(value);
      } // if/else
    } else if (bits.charAt(len - 1) == '1') {
      if (curNode.getOne() == null) {
        curNode.setOne(new BitTreeNode(value));
      } else {
        curNode.getOne().setValue(value);
      } // if/else
    } else {
      throw new IndexOutOfBoundsException();
    } // if/else
  } // set(String, String)

  /**
   * Gets the value at the end of the specified path.
   * @param bits
   *   The path to find the value of.
   * @return the value at the end of the path.
   */
  public String get(String bits) {
    // Checks that bits is correct for this size of tree
    int len = bits.length();
    //if (len != size) {
    //  throw new IndexOutOfBoundsException();
    //} // if

    BitTreeNode curNode = root;
    char curChar;

    // Loops through path, updating current node
    for (int i = 0; i < len; i++) {
      curChar = bits.charAt(i);
      if (curChar == '0') {
        if (curNode.getZero() == null) {
          throw new IndexOutOfBoundsException();
        } //if
        curNode = curNode.getZero();
      } else if (curChar == '1') {
        if (curNode.getOne() == null) {
          throw new IndexOutOfBoundsException();
        } // if
        curNode = curNode.getOne();
      } else {
        throw new IndexOutOfBoundsException();
      } // if/else
    } // for

    // At end of path, returns value of node
    if (curNode.getValue() == null) {
      throw new IndexOutOfBoundsException();
    } else {
      return curNode.getValue();
    } // if/else
  } // get(String, String)

  /**
   * Prints all of the paths in the tree.
   * @param pen
   *   The pen to print with.
   */
  public void dump(PrintWriter pen) {
    this.dumpHelper(pen, root, "");
  } // dump(PrintWriter)

  /**
   * Recursive helper function for printing all paths.
   * @param pen
   *   The pen to print with.
   * @param current
   *   The current node.
   * @param path
   *   The path to the current node from the root.
   */
  public void dumpHelper(PrintWriter pen, BitTreeNode current, String path) {
    // If we are at a leaf, add value to path and print
    if ((current != null) && (current.getValue() != null)) {
      path.concat("," + current.getValue());
      pen.println(path);
    } else if (current != null) {
      // Otherwise, recurse on both subtrees, updating value of path
      this.dumpHelper(pen, current.getZero(), path.concat("0"));
      this.dumpHelper(pen, current.getOne(), path.concat("1"));
    } // if/else
  } // dumpHelper(PrintWriter, BitTreeNode, String)

  /**
   * Loads a source InputStream of appropriate formatting into a bit tree.
   * @param source
   *   The source InputStream with the text to set up the tree.
   */
  public void load(InputStream source) {
    BufferedReader eyes = new BufferedReader(new InputStreamReader(source));
    String current;
    try {
      // Loop through the input
      while ((current = eyes.readLine()) != null) {
        // For each line, split into bits and value and add to tree
        String[] parts = current.split(",");
        this.set(parts[0], parts[1]);
      } // while
      eyes.close();
    } catch (IOException e) {
      System.err.println("IOException");
    } // try/catch
  } // load(InputStream)

} // class BitTree
