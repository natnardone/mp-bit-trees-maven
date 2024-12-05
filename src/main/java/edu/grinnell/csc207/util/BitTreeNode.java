package edu.grinnell.csc207.util;

/**
 * Interface for nodes of a bit tree.
 */
public interface BitTreeNode {
  
  public void setZero(BitTreeNode node);
  public void setOne(BitTreeNode node);
  public void setValue(String value);
  public BitTreeNode getZero();
  public BitTreeNode getOne();
  public String getValue();

} // interface BitTreeNode
