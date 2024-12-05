package edu.grinnell.csc207.util;

import java.io.InputStream;
import java.io.PrintWriter;

/**
 * Trees intended to be used in storing mappings between fixed-length 
 * sequences of bits and corresponding values.
 *
 * @author Your Name Here
 */
public class BitTree {
  // +--------+------------------------------------------------------
  // | Fields |
  // +--------+

  // root/starting node and size
  BitTreeNode root;
  int size;

  // +--------------+------------------------------------------------
  // | Constructors |
  // +--------------+

  /**
   *
   */
  public BitTree(int n) {
    this.root = new BitTreeInteriorNode();
    this.size = n;
  } // BitTree(int)

  // +---------------+-----------------------------------------------
  // | Local helpers |
  // +---------------+

  // +---------+-----------------------------------------------------
  // | Methods |
  // +---------+

  /**
   *
   */
  public void set(String bits, String value) {
    int len = bits.length();
    if (len != size) {
      throw new IndexOutOfBoundsException();
    }

    BitTreeNode curNode = root;
    char curChar;
    for (int i = 0; i < len-1; i++) {
      curChar = bits.charAt(i);
      if (curChar == '0') {
        if (curNode.getZero() == null) {
          curNode.setZero(new BitTreeInteriorNode());
        }
        curNode = curNode.getZero();
      } else if (curChar == '1') {
        if (curNode.getOne() == null) {
          curNode.setOne(new BitTreeInteriorNode());
        }
        curNode = curNode.getOne();
      } else {
        throw new IndexOutOfBoundsException();
      }
    }
    if (bits.charAt(len-1) == '0') {
      if (curNode.getZero() == null) {
        curNode.setZero(new BitTreeLeaf(value));
      } else {
        curNode.getZero().setValue(value);
      }
    } else if (bits.charAt(len-1) == '1') {
      if (curNode.getOne() == null) {
        curNode.setOne(new BitTreeLeaf(value));
      } else {
        curNode.getOne().setValue(value);
      }
    } else {
      throw new IndexOutOfBoundsException();
    }

  } // set(String, String)

  /**
   *
   */
  public String get(String bits) {
    int len = bits.length();
    if (len != size) {
      throw new IndexOutOfBoundsException();
    }

    BitTreeNode curNode = root;
    char curChar;
    for (int i = 0; i < len; i++) {
      curChar = bits.charAt(i);
      if (curChar == '0') {
        if (curNode.getZero() == null) {
          throw new IndexOutOfBoundsException();
        }
        curNode = curNode.getZero();
      } else if (curChar == '1') {
        if (curNode.getOne() == null) {
          throw new IndexOutOfBoundsException();
        }
        curNode = curNode.getOne();
      } else {
        throw new IndexOutOfBoundsException();
      }
    }
    return curNode.getValue();
  } // get(String, String)

  /**
   *
   */
  public void dump(PrintWriter pen) {
    // STUB
  } // dump(PrintWriter)

  /**
   *
   */
  public void load(InputStream source) {
    // STUB
  } // load(InputStream)

} // class BitTree
