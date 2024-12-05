package edu.grinnell.csc207.util;

public class BitTreeLeaf implements BitTreeNode {
  
  // Fields
  String value;

  // Constructors

  public BitTreeLeaf(String val) {
    this.value = val;
  } // BitTreeLeaf(String)

  // Methods

  public String getValue() {
    return this.value;
  } // getValue

  public void setValue(String value) {
    this.value = value;
  }





  
  public BitTreeNode getZero() {
    return null;
  }
  public BitTreeNode getOne() {
    return null;
  }
  public void setZero(BitTreeNode node) {

  }
  public void setOne(BitTreeNode node) {

  }

} // class BitTreeLeaf
