  /* BinaryTree.java */

package dict;

/**
 *  BinaryTree implements a Dictionary as a binary tree (unbalanced).  Multiple
 *  entries with the same key are permitted.
 *
 *  DO NOT CHANGE ANY PROTOTYPES IN THIS FILE.
 *
 *  @author Jonathan Shewchuk
 **/
public class BinaryTree implements Dictionary {

  /** 
   *  size is the number of items stored in the dictionary.
   *  root is the BinaryTreeNode that serves as root of the tree.
   *  If there are no items, size is zero and root is null.
   **/
  protected int size;
  protected BinaryTreeNode root;

  /**
   *  Construct an empty binary tree.
   **/
  public BinaryTree() {
    makeEmpty();
  }

  /**
   *  makeEmpty() removes all the entries from the dictionary.
   */
  public void makeEmpty() {
    size = 0;
    root = null;
  }

  /** 
   *  size() returns the number of entries stored in the dictionary.
   *
   *  @return the number of entries stored in the dictionary.
   **/
  public int size() {
    return size;
  }

  /** 
   *  isEmpty() tests if the dictionary is empty.
   *
   *  @return true if the dictionary has no entries; false otherwise.
   **/
  public boolean isEmpty() {
    return size == 0;
  }

  /** 
   *  insert() constructs and inserts a new Entry object, consisting of
   *  a (key, value) pair, into the dictionary, and returns a reference to the
   *  new Entry.  Multiple entries with the same key (or even the same key and
   *  value) can coexist in the dictionary.
   *
   *  @param key the key by which the entry can be retrieved.  Must be of
   *  a class that implements java.lang.Comparable.
   *  @param value an arbitrary object associated with the key.
   *  @return an Entry object referencing the key and value.
   **/
  public Entry insert(Object key, Object value) {
    Entry entry = new Entry(key, value);
    if (root == null) {
      root = new BinaryTreeNode(entry);
    } else {
      insertHelper(entry, (Comparable) key, root);
    }

    size++;
    return entry;
  }

  /**
   *  insertHelper() recursively does the work of inserting a new Entry object
   *  into the dictionary.
   *
   *  @param entry the Entry object to insert into the tree.
   *  @param key the key by which the entry can be retrieved.
   *  @param node the root of a subtree in which the new entry will be
   *         inserted.
   **/
  private void insertHelper(Entry entry, Comparable key, BinaryTreeNode node) {
    if (key.compareTo(node.entry.key()) <= 0) {
      if (node.leftChild == null) {
	node.leftChild = new BinaryTreeNode(entry, node);
      } else {
	insertHelper(entry, key, node.leftChild);
      }
    } else {
      if (node.rightChild == null) {
	node.rightChild = new BinaryTreeNode(entry, node);
      } else {
	insertHelper(entry, key, node.rightChild);
      }
    }
  }

  /** 
   *  find() searches for an entry with the specified key.  If such an entry is
   *  found, it returns the Entry object; otherwise, it returns null.  If more
   *  than one entry has the key, one of them is chosen arbitrarily and
   *  returned.
   *
   *  @param key the search key.  Must be of a class that implements
   *         java.lang.Comparable.
   *  @return an Entry referencing the key and an associated value, or null if
   *          no entry contains the specified key.
   **/
  public Entry find(Object key) {
    BinaryTreeNode node = findHelper((Comparable) key, root);
    if (node == null) {
      return null;
    } else {
      return node.entry;
    }
  }

  /**
   *  Search for a node with the specified key, starting from "node".  If
   *  a matching key is found (meaning that key1.compareTo(key2) == 0), return
   *  a node containing that key.  Otherwise, return null.
   *
   *  Be sure this method returns null if node == null.
   **/

  private BinaryTreeNode findHelper(Comparable key, BinaryTreeNode node) {

  	if(node == null){
  		return null;
  	}

  	else{
  		int compare = key.compareTo(node.entry.key());

	    if(compare == 0){
	    	return node;
	    }

	    else if(compare < 0){
	    	return findHelper(key, node.leftChild);
	    }

	    else{
	 		return findHelper(key, node.rightChild);
	    }
	}

  }

  /** 
   *  remove() searches for an entry with the specified key.  If such an entry
   *  is found, it removes the Entry object from the Dictionary and returns it;
   *  otherwise, it returns null.  If more than one entry has the key, one of
   *  them is chosen arbitrarily, removed, and returned.
   *
   *  @param key the search key.  Must be of a class that implements
   *         java.lang.Comparable.
   *  @return an Entry referencing the key and an associated value, or null if
   *          no entry contains the specified key.
   **/
  public Entry remove(Object key) {
    // Replace the following line with your solution.
    BinaryTreeNode node = findHelper((Comparable) key, root);
    if(node == null){//not found
      return null;
    }else{//found
        //if n is a leaf
        if(node.leftChild == null && node.rightChild == null){
          BinaryTreeNode parent = node.parent;
          if(parent != null){
            if(parent.leftChild == node){
              parent.leftChild = null;
            }else{
              parent.rightChild = null;
            } 
          }else{
            root = null;
          }
          size--;
        }

        //if n has one child
        else if(node.leftChild!=null && node.rightChild==null){
          BinaryTreeNode parent = node.parent;
          BinaryTreeNode child = node.leftChild;
          child.parent = parent;
          if (parent != null) { //CHANGED! bc you know, you don't know whether this node is left or right :) so you gotta assign the child properly
              if (node == parent.leftChild) //if left child, assign the child as the NEW left child of the parent.
                parent.leftChild = child;
              else
                parent.rightChild = child;  //Same goes for the right
          } else
            root = child;
          size--; //CHANGED! decrement the size. also, recursion
        }
        else if(node.leftChild==null && node.rightChild!=null){
          BinaryTreeNode parent = node.parent;
          BinaryTreeNode child = node.rightChild;
          child.parent = parent;
          if (parent != null) { //CHANGED! bc you know, you don't know whether this node is left or right :) so you gotta assign the child properly
              if (node == parent.leftChild) 
                parent.leftChild = child; // same reason as above please check ayy
              else
                parent.rightChild = child;
          }
          else
            root = child;
          size--; //CHANGED! decrement the size. also, recursion
        }

        //if n has two children
        /*
        else{
          BinaryTreeNode parent = node.parent;
          BinaryTreeNode left = node.leftChild;
          BinaryTreeNode right = node.rightChild;

          if(parent!=null){
          	if(node == parent.leftChild){
          		parent.leftChild = left;
          		left.parent = parent;

          		while(left.rightChild != null){
          			left = left.rightChild;
          		}

          		left.rightChild = right;
          		right.parent = left;
          	}

          	else{
          		left.parent = parent;
          		parent.rightChild = left;

          		while(left.rightChild != null){
          			left = left.rightChild;
          		}

          		left.rightChild = right;
          	}
          }

          else{
          	root = left;
          	left.parent = null;

          	while(left.rightChild!=null){
          		left = left.rightChild;
          	}

          	left.rightChild = right;

          }
        } */

        else {
          BinaryTreeNode parent = node.parent;
          BinaryTreeNode left = node.leftChild;
          BinaryTreeNode right = node.rightChild;
          BinaryTreeNode replace = node.rightChild; //this variable will replace the current node

          while (replace.leftChild != null) {   //kato imong giingon na kuan pinakaleft na node sa right leaf
            replace = replace.leftChild;
          }

          if(parent != null) {
            node.entry = remove(replace.entry.key()); //assign the leftmost node of the right leaf to the current place
                                                      //and remove it at the same time (that's why we call the remove)

          } else {
            root.entry = remove(replace.entry.key()); //assign the leftmost node of the right leaf to the root bc no parent = it's a root
                                                      //and remove it at the same time (that's why we call the remove)
          }
        }
    }
    //size--;
    return node.entry;
  }

  /**
   *  Convert the tree into a string.
   **/

  public String toString() {
    if (root == null) {
      return "";
    } else {
      return root.toString();
    }
  }

  /* Tests the binary search tree. */
  public static void main(String[] args) {
    BinaryTree tree = new BinaryTree();

    System.out.println("Inserting 1A, 6V, 3K, 2Z, 5L, 9L:");
    tree.insert(new Integer(1), "A");
    tree.insert(new Integer(6), "V");
    tree.insert(new Integer(3), "K");
    tree.insert(new Integer(2), "Z");
    tree.insert(new Integer(5), "L");
    tree.insert(new Integer(9), "L");
    System.out.println("The tree is:  " + tree);
    System.out.println("Size:  " + tree.size());

    System.out.println("\nTesting find() ...");
    tree.testFind(1, "A");
    tree.testFind(9, "L");
    tree.testFind(5, "L");
    tree.testFind(4, null);
    tree.testFind(6, "V");
    tree.testFind(3, "K");

    System.out.println("\nTesting remove() (for nodes with < 2 children) ...");
    tree.testRemove(5, "1A(((2Z)3K)6V(9L))");
    tree.testRemove(3, "1A((2Z)6V(9L))");
    tree.testRemove(1, "(2Z)6V(9L)");
    tree.insert(new Integer(7), "S");
    tree.insert(new Integer(8), "X");
    tree.insert(new Integer(10), "B");
    System.out.println("After inserting 7S, 8X, 10B:  " + tree);
    System.out.println("Size:  " + tree.size());
    if (tree.size() != 6) {
      System.out.println("  SHOULD BE 6.");
    }

    System.out.println("\nTesting remove() (for nodes with 2 children) ...");
    tree.testRemove(6, "(2Z)7S((8X)9L(10B))");
    tree.testRemove(9, "(2Z)7S((8X)10B)");
    System.out.println("Size:  " + tree.size());
    if (tree.size() != 4) {
      System.out.println("  SHOULD BE 4.");
    }
  }

 private void testRemove(int n, String shouldBe) {
    Integer key = new Integer(n);
    System.out.print("After remove(" + n + "):  ");
    remove(key);
    System.out.println(this);
    if (!toString().equals(shouldBe)) {
      System.out.println("  SHOULD BE " + shouldBe);
    }
  }

  private void testFind(int n, Object truth) {
    Integer key = new Integer(n);
    Entry entry = find(key);
    System.out.println("Calling find() on " + n);
    if (entry == null) {
      System.out.println("  returned null.");
      if (truth != null) {
        System.out.println("  SHOULD BE " + truth + ".");
      }
    } else {
      System.out.println("  returned " + entry.value() + ".");
      if (!entry.value().equals(truth)) {
        if (truth == null) {
          System.out.println("  SHOULD BE null.");
        } else {
          System.out.println("  SHOULD BE " + truth + ".");
        }
      }
    }
  }
  
}
