package org.javadsa.advancedDataStructures;

public class BinarySearchTreeImpl {

    static class Node {
        private int value = -1;
        private Node leftChild;
        private Node rightChild;

        public Node() {
        }

        public Node(int value, Node leftChild, Node rightChild) {
            this.value = value;
            this.leftChild = leftChild;
            this.rightChild = rightChild;
        }

        public Node(int value, Node rightChild) {
            this.value = value;
            this.rightChild = rightChild;
        }

        public Node(int value) {
            this.value = value;
        }

        public int getValue() {
            return value;
        }

        public void setValue(int value) {
            this.value = value;
        }

        public Node getRightChild() {
            return rightChild;
        }

        public void setRightChild(Node rightChild) {
            this.rightChild = rightChild;
        }

        public Node getLeftChild() {
            return leftChild;
        }

        public void setLeftChild(Node leftChild) {
            this.leftChild = leftChild;
        }
    }

    Node rootNode;

    public BinarySearchTreeImpl() {
    }

    public BinarySearchTreeImpl(Node rootNode) {
        this.rootNode = rootNode;
    }

    public Node getRootNode() {
        return rootNode;
    }

    public void setRootNode(Node rootNode) {
        this.rootNode = rootNode;
    }

    private Node insertHelper(Node currentRootNode, int valueToInsert) {
        Node nodeToInsert = new Node(valueToInsert);
        if (currentRootNode == null) {
            currentRootNode = nodeToInsert;
        } else if (valueToInsert < currentRootNode.getValue()) {
            currentRootNode.setLeftChild(insertHelper(currentRootNode.getLeftChild(), valueToInsert));
        } else if (valueToInsert > currentRootNode.getValue()) {
            currentRootNode.setRightChild(insertHelper(currentRootNode.getRightChild(), valueToInsert));
        }
        return currentRootNode;
    }

    private BinarySearchTreeImpl insert(BinarySearchTreeImpl binarySearchTree, int nodeValueToInsert) {
        binarySearchTree.setRootNode(insertHelper(binarySearchTree.getRootNode(), nodeValueToInsert));
        return binarySearchTree;
    }

    private Node deleteHelper(Node currentRootNode, int valueToDelete) {
        if (currentRootNode == null) {
            return null;
        } else if (valueToDelete < currentRootNode.getValue()) {
            currentRootNode.setLeftChild(deleteHelper(currentRootNode.getLeftChild(), valueToDelete));
        } else if (valueToDelete > currentRootNode.getValue()) {
            currentRootNode.setRightChild(deleteHelper(currentRootNode.getRightChild(), valueToDelete));
        } else {
            if (currentRootNode.getLeftChild() == null && currentRootNode.getRightChild() == null) {
                return null;
            } else if (currentRootNode.getLeftChild() == null) {
                return currentRootNode.getRightChild();
            } else if (currentRootNode.getRightChild() == null) {
                return currentRootNode.getLeftChild();
            } else {
                int minValue = this.minValue(currentRootNode.getRightChild());
                currentRootNode.setValue(minValue);
                currentRootNode.setRightChild(deleteHelper(currentRootNode.getRightChild(), minValue));
            }
        }
        return currentRootNode;
    }

    private int minValue(Node currentRoot) {
        int minValue = currentRoot.getValue();
        while (currentRoot.getLeftChild() != null) {
            minValue = currentRoot.getLeftChild()
                                  .getValue();
            currentRoot = currentRoot.getLeftChild();
        }
        return minValue;
    }

    private BinarySearchTreeImpl delete(BinarySearchTreeImpl binarySearchTree, int nodeValueToDelete) {
        binarySearchTree.setRootNode(deleteHelper(binarySearchTree.getRootNode(), nodeValueToDelete));
        return binarySearchTree;
    }

    private Node search(Node rootNode, int valueToSearch) {
        if (rootNode == null) {
            return new Node();
        }
        if (rootNode.getValue() == valueToSearch) {
            return rootNode;
        } else if (valueToSearch < rootNode.getValue()) {
            return search(rootNode.getLeftChild(), valueToSearch);
        }
        return search(rootNode.getRightChild(), valueToSearch);
    }

    private void breadthFirstSearch(BinarySearchTreeImpl binarySearchTree) {
        System.out.print("Breadth First Search: ");
        System.out.print(binarySearchTree.rootNode.getValue() + " ");
        breadthFirstSearchHelper(binarySearchTree.getRootNode());
        System.out.println();
    }

    private void breadthFirstSearchHelper(Node currentRootNode) {
        if (currentRootNode == null) {
            return;
        }
        if (currentRootNode.getLeftChild() != null) {
            System.out.print(currentRootNode.getLeftChild()
                                            .getValue() + " ");
        }
        if (currentRootNode.getRightChild() != null) {
            System.out.print(currentRootNode.getRightChild()
                                            .getValue() + " ");
        }
        breadthFirstSearchHelper(currentRootNode.getLeftChild());
        breadthFirstSearchHelper(currentRootNode.getRightChild());
    }

    private void depthFirstSearch(BinarySearchTreeImpl binarySearchTree) {
        System.out.println("----- Depth First Search ----- ");
        System.out.print("Pre-Order Traversal: ");
        depthFirstSearchHelper(binarySearchTree.getRootNode(), "Pre");
        System.out.print("\nIn-Order Traversal: ");
        depthFirstSearchHelper(binarySearchTree.getRootNode(), "In");
        System.out.print("\nPost-Order Traversal: ");
        depthFirstSearchHelper(binarySearchTree.getRootNode(), "Post");
        System.out.println();
    }

    private void depthFirstSearchHelper(Node currentRootNode, String traversalOrder) {
        if (currentRootNode == null) {
            return;
        }
        switch (traversalOrder) {
            case "Pre" -> {
                System.out.print(currentRootNode.getValue() + " ");
                depthFirstSearchHelper(currentRootNode.getLeftChild(), traversalOrder);
                depthFirstSearchHelper(currentRootNode.getRightChild(), traversalOrder);
            }
            case "In" -> {
                depthFirstSearchHelper(currentRootNode.getLeftChild(), traversalOrder);
                System.out.print(currentRootNode.getValue() + " ");
                depthFirstSearchHelper(currentRootNode.getRightChild(), traversalOrder);
            }
            default -> {
                depthFirstSearchHelper(currentRootNode.getLeftChild(), traversalOrder);
                depthFirstSearchHelper(currentRootNode.getRightChild(), traversalOrder);
                System.out.print(currentRootNode.getValue() + " ");
            }
        }
    }

    public static void main(String[] args) {
        BinarySearchTreeImpl binarySearchTree = new BinarySearchTreeImpl();
//           8
//         /  \
//        4    12
//       / \  /  \
//      1  7 9   14

        binarySearchTree = binarySearchTree.insert(binarySearchTree, 8);
        binarySearchTree = binarySearchTree.insert(binarySearchTree, 4);
        binarySearchTree = binarySearchTree.insert(binarySearchTree, 1);
        binarySearchTree = binarySearchTree.insert(binarySearchTree, 7);
        binarySearchTree = binarySearchTree.insert(binarySearchTree, 12);
        binarySearchTree = binarySearchTree.insert(binarySearchTree, 9);
        binarySearchTree = binarySearchTree.insert(binarySearchTree, 14);

        binarySearchTree.breadthFirstSearch(binarySearchTree);
        binarySearchTree.depthFirstSearch(binarySearchTree);

        System.out.println("Search 1 in the BST: " + binarySearchTree.search(binarySearchTree.rootNode, 1)
                                                                     .getValue());
        System.out.println("Search 12 in the BST: " + binarySearchTree.search(binarySearchTree.rootNode, 12)
                                                                      .getValue());
        binarySearchTree = binarySearchTree.delete(binarySearchTree, 12);
        System.out.println("Search 12 in the BST: " + binarySearchTree.search(binarySearchTree.rootNode, 12)
                                                                      .getValue());
        System.out.println("Search 10 in the BST: " + binarySearchTree.search(binarySearchTree.rootNode, 10)
                                                                      .getValue());


    }


}
