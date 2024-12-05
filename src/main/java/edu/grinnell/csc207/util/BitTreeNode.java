package edu.grinnell.csc207.util;

public class BitTreeNode {

  // Fields
  BitTreeNode zeroSubTree;
  BitTreeNode oneSubTree;
  String value;

  // Constructors

  public BitTreeNode() {
    zeroSubTree = null;
    oneSubTree = null;
    this.value = null;
  } // BitTreeInteriorNode

  public BitTreeNode(String val) {
    this.value = val;
    this.zeroSubTree = null;
    this.oneSubTree = null;
  } // BitTreeLeaf(String)

  // Methods

  public BitTreeNode getZero() {
    return this.zeroSubTree;
  }

  public BitTreeNode getOne() {
    return this.oneSubTree;
  }


  public void setZero(BitTreeNode n) {
    this.zeroSubTree = n;
  }

  public void setOne(BitTreeNode n) {
    this.oneSubTree = n;
  }

  public String getValue() {
    return this.value;
  } // getValue

  public void setValue(String value) {
    this.value = value;
  }
  
}
