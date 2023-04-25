package org.javadsa.basicDataStructures;

public class DoublyLinkedListImpl {

    static class Node {
        private int value;
        private Node previousNode;
        private Node nextNode;

        public Node(int value, Node previousNode, Node nextNode) {
            this.value = value;
            this.previousNode = previousNode;
            this.nextNode = nextNode;
        }

        public Node(int value, Node nextNode) {
            this.value = value;
            this.nextNode = nextNode;
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

        public Node getNextNode() {
            return nextNode;
        }

        public void setNextNode(Node nextNode) {
            this.nextNode = nextNode;
        }

        public Node getPreviousNode() {
            return previousNode;
        }

        public void setPreviousNode(Node previousNode) {
            this.previousNode = previousNode;
        }
    }

    Node head;

    public DoublyLinkedListImpl() {
    }

    public DoublyLinkedListImpl(Node head) {
        this.head = head;
    }

    public DoublyLinkedListImpl insertElement(DoublyLinkedListImpl linkedList, int value) {
        Node nodeToInsert = new Node(value);
        if (linkedList.head == null) {
            linkedList.head = nodeToInsert;
        } else {
            Node currentNode = linkedList.head;
            while (currentNode.getNextNode() != null) {
                currentNode = currentNode.getNextNode();
            }
            currentNode.setNextNode(nodeToInsert);
            nodeToInsert.setPreviousNode(currentNode);
        }
        return linkedList;
    }

    public DoublyLinkedListImpl removeElement(DoublyLinkedListImpl linkedList, int value) {
        if (this.searchElement(linkedList, value)) {
            Node currentNode = linkedList.head;
            Node previousNode = currentNode.getPreviousNode();
            while (currentNode != null) {
                if (currentNode.getValue() == value) {
                    if (previousNode == null) {
                        linkedList.head = currentNode.getNextNode();
                    } else {
                        Node nextNodeAfterRemoval = currentNode.getNextNode();
                        if (nextNodeAfterRemoval != null) {
                            nextNodeAfterRemoval.setPreviousNode(previousNode);
                        }
                        previousNode.setNextNode(nextNodeAfterRemoval);
                    }
                    return linkedList;
                }
                previousNode = currentNode;
                currentNode = currentNode.getNextNode();
            }
        }
        return linkedList;
    }

    public void printLinkedList(DoublyLinkedListImpl linkedList) {
        Node currentNode = linkedList.head;
        System.out.print("The Linked List is: ");
        while (currentNode != null) {
            System.out.print(currentNode.getValue() + " ");
            currentNode = currentNode.getNextNode();
        }
        System.out.println();
    }

    public boolean searchElement(DoublyLinkedListImpl linkedList, int value) {
        Node currentNode = linkedList.head;
        while (currentNode != null) {
            if (currentNode.getValue() == value) {
                return true;
            }
            currentNode = currentNode.getNextNode();
        }
        return false;
    }


    public static void main(String[] args) {
        DoublyLinkedListImpl doublyLinkedList = new DoublyLinkedListImpl();
        doublyLinkedList = doublyLinkedList.insertElement(doublyLinkedList, 1);
        doublyLinkedList = doublyLinkedList.insertElement(doublyLinkedList, 2);
        doublyLinkedList = doublyLinkedList.insertElement(doublyLinkedList, 3);
        doublyLinkedList = doublyLinkedList.insertElement(doublyLinkedList, 4);
        doublyLinkedList = doublyLinkedList.insertElement(doublyLinkedList, 5);
        doublyLinkedList = doublyLinkedList.insertElement(doublyLinkedList, 6);
        doublyLinkedList.printLinkedList(doublyLinkedList);
        doublyLinkedList = doublyLinkedList.removeElement(doublyLinkedList, 2);
        doublyLinkedList.printLinkedList(doublyLinkedList);
        doublyLinkedList = doublyLinkedList.removeElement(doublyLinkedList, 6);
        doublyLinkedList.printLinkedList(doublyLinkedList);
        doublyLinkedList = doublyLinkedList.removeElement(doublyLinkedList, 1);
        doublyLinkedList.printLinkedList(doublyLinkedList);
        doublyLinkedList = doublyLinkedList.removeElement(doublyLinkedList, 9);
        doublyLinkedList.printLinkedList(doublyLinkedList);
        System.out.println(doublyLinkedList.searchElement(doublyLinkedList, 1));
        System.out.println(doublyLinkedList.searchElement(doublyLinkedList, 4));
        System.out.println(doublyLinkedList.searchElement(doublyLinkedList, 2));
    }
}
