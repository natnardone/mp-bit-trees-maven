package edu.grinnell.csc207.util;

public class BitTreeInteriorNode implements BitTreeNode {

  // Fields

  BitTreeNode zeroSubTree;
  BitTreeNode oneSubTree;

  // Constructors
  public BitTreeInteriorNode() {
    zeroSubTree = null;
    oneSubTree = null;
  } // BitTreeInteriorNode

  public BitTreeInteriorNode(BitTreeNode zero, BitTreeNode one) {

  }

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




  
  public void setValue(String value) {

  }
  public String getValue() {
    return null;
  }

} // class BitTreeInteriorNode
