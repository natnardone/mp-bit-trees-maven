package edu.grinnell.csc207.util;

/**
 * Nodes to be used in a BitTree.
 * @author Natalie Nardone
 */
public class BitTreeNode {

  // Fields

  /**
   * The subtree of the node associated with 0 (interior nodes only).
   */
  BitTreeNode zeroSubTree;

  /**
   * The subtree of the node associated with 1 (interior nodes only).
   */
  BitTreeNode oneSubTree;

  /**
   * The value of the node (leaves only).
   */
  String value;

  // Constructors

  /**
   * Creates an interior node with null subtrees.
   */
  public BitTreeNode() {
    zeroSubTree = null;
    oneSubTree = null;
    this.value = null;
  } // BitTreeNode

  /**
   * Creates a leaf node with the given value.
   * @param val
   *   The value of the node.
   */
  public BitTreeNode(String val) {
    this.value = val;
    this.zeroSubTree = null;
    this.oneSubTree = null;
  } // BitTreeNode(String)

  // Methods

  /**
   * Gets the 0-associated subtree of the node.
   * @return the 0-associated subtree.
   */
  public BitTreeNode getZero() {
    return this.zeroSubTree;
  } // getZero

  /**
   * Gets the 1-associated subtree of the node.
   * @return the 1-associated subtree.
   */
  public BitTreeNode getOne() {
    return this.oneSubTree;
  } // getOne

  /**
   * Gets the value of the node.
   * @return the value.
   */
  public String getValue() {
    return this.value;
  } // getValue

  /**
   * Sets the 0-associated subtree to the given tree.
   * @param n
   *   The tree to set the subtree to.
   */
  public void setZero(BitTreeNode n) {
    this.zeroSubTree = n;
  } // setZero(BitTreeNode)

  /**
   * Sets the 1-associated subtree to the given tree.
   * @param n
   *   The tree to set the subtree to.
   */
  public void setOne(BitTreeNode n) {
    this.oneSubTree = n;
  } // setOne(BitTreeNode)

  /**
   * Sets the value to the given value.
   * @param value
   *   The value to set.
   */
  public void setValue(String value) {
    this.value = value;
  } // setValue(String)

} // class BitTreeNode
