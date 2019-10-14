/**
   This class implements a binary search tree whose
   nodes hold objects that implement the Comparable
   interface.
*/

public class BinarySearchTree<E extends Comparable<E>> {

   private Node root;

   private class Node {
      public E data;
      public Node left;
      public Node right;
   }

   public BinarySearchTree() {
      root = null;
   }

   public void insert(E e) {
      Node newNode = new Node();
      newNode.data = e;
      newNode.left = null;
      newNode.right = null;
      if (root == null)
         root = newNode;
      else
         insertSub(root, newNode);
   }

   private void insertSub(Node node, Node newNode) {
      int result = node.data.compareTo(newNode.data);
      if (result >= 0) {
         //go left
         if (node.left == null) {
            node.left = newNode;
         } else {
            insertSub(node.left, newNode);
         }
      } else {
         //go right
         if (node.right == null) {
            node.right = newNode;
         } else {
            insertSub(node.right, newNode);
         }
      }
   }

   public boolean contains(E element)
   {
      if(root == null)
         return false;

      Node node = root;
      int result = -1;


      while(result != 0)
      {
         result = node.data.compareTo(element);

         if(result > 0)
         {
            if(node.left == null)
               return false;
            else
               node = node.left;
         }
         else if(result < 0)
         {
            if(node.right == null)
               return false;
            else
               node = node.right;
         }
      }
      return true;
   }

   public boolean containsRecur(E element)
   {
      if(root == null)
         return false;
      else
         return containsRecurSub(root, element);
   }

   private boolean containsRecurSub(Node node, E element)
   {
      int result = node.data.compareTo(element);
      boolean matching = false;

      if(result == 0)
         matching = true;

      else if(result > 0)
      {
         if(node.left == null)
            matching = false;
         else
            matching = containsRecurSub(node.left, element);
      }

      else if(result < 0)
      {
         if(node.right == null)
            matching = false;
         else
            matching = containsRecurSub(node.right, element);
      }

      return matching;
   }
}