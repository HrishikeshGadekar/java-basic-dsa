package org.javadsa.basicDataStructures;

public class SinglyLinkedListImpl {

    static class Node {
        private int value;
        private Node nextNode;

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
    }

    Node head;

    public SinglyLinkedListImpl() {
    }

    public SinglyLinkedListImpl(Node head) {
        this.head = head;
    }

    public SinglyLinkedListImpl insertElement(SinglyLinkedListImpl linkedList, int value) {
        Node nodeToInsert = new Node(value, null);
        if (linkedList.head == null) {
            linkedList.head = nodeToInsert;
        } else {
            Node currentNode = linkedList.head;
            while (currentNode.getNextNode() != null) {
                currentNode = currentNode.getNextNode();
            }
            currentNode.setNextNode(nodeToInsert);
        }
        return linkedList;
    }

    public SinglyLinkedListImpl removeElement(SinglyLinkedListImpl linkedList, int value) {
        if (this.searchElement(linkedList, value)) {
            Node currentNode = linkedList.head;
            Node previousNode = null;
            while (currentNode != null) {
                if (currentNode.getValue() == value) {
                    if (previousNode == null) {
                        linkedList.head = currentNode.getNextNode();
                    } else {
                        previousNode.setNextNode(currentNode.getNextNode());
                    }
                    return linkedList;
                }
                previousNode = currentNode;
                currentNode = currentNode.getNextNode();
            }
        }
        return linkedList;
    }

    public void printLinkedList(SinglyLinkedListImpl linkedList) {
        Node currentNode = linkedList.head;
        System.out.print("The Linked List is: ");
        while (currentNode != null) {
            System.out.print(currentNode.getValue() + " ");
            currentNode = currentNode.getNextNode();
        }
        System.out.println();
    }

    public boolean searchElement(SinglyLinkedListImpl linkedList, int value) {
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
        SinglyLinkedListImpl linkedList = new SinglyLinkedListImpl();
        linkedList = linkedList.insertElement(linkedList, 1);
        linkedList = linkedList.insertElement(linkedList, 2);
        linkedList = linkedList.insertElement(linkedList, 3);
        linkedList = linkedList.insertElement(linkedList, 4);
        linkedList = linkedList.insertElement(linkedList, 5);
        linkedList = linkedList.insertElement(linkedList, 6);
        linkedList.printLinkedList(linkedList);
        linkedList = linkedList.removeElement(linkedList, 2);
        linkedList.printLinkedList(linkedList);
        linkedList = linkedList.removeElement(linkedList, 6);
        linkedList.printLinkedList(linkedList);
        linkedList = linkedList.removeElement(linkedList, 1);
        linkedList.printLinkedList(linkedList);
        linkedList = linkedList.removeElement(linkedList, 9);
        linkedList.printLinkedList(linkedList);
        System.out.println(linkedList.searchElement(linkedList, 1));
        System.out.println(linkedList.searchElement(linkedList, 4));
        System.out.println(linkedList.searchElement(linkedList, 2));
    }
}
