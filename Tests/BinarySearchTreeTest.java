import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BinarySearchTreeTest {

    @Test
    void contains() {
        BinarySearchTree<Integer> tree = new BinarySearchTree<>();
        BinarySearchTree<Integer> treeEmpty = new BinarySearchTree<>();
        BinarySearchTree<Integer> tree1 = new BinarySearchTree<>();

        tree.insert(5);
        tree.insert(18);
        tree.insert(6);
        tree.insert(3);
        tree.insert(9);

        tree1.insert(6);

        boolean expected = false;
        boolean actual = tree.containsRecur(90);

        assertEquals(expected, actual);
    }
}