package org.javadsa.basicDataStructures;

public class StackLinkedListImpl {

    static class Node {
        private int value;
        private Node previousNode;

        public Node(int value, Node previousNode) {
            this.value = value;
            this.previousNode = previousNode;
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

        public Node getPreviousNode() {
            return previousNode;
        }

        public void setPreviousNode(Node previousNode) {
            this.previousNode = previousNode;
        }
    }

    Node head;
    static final int MAX_SIZE = 10;

    public StackLinkedListImpl push(StackLinkedListImpl stackLinkedList, int value) {
        Node nodeToPush = new Node(value);
        Node currentNode = stackLinkedList.head;
        if (this.size(stackLinkedList) < MAX_SIZE) {
            stackLinkedList.head = nodeToPush;
            nodeToPush.setPreviousNode(currentNode);
        } else {
            System.out.println("Stack Overflow error!");
        }
        return stackLinkedList;
    }

    public StackLinkedListImpl pop(StackLinkedListImpl stackLinkedList) {
        if (this.size(stackLinkedList) == 0) {
            System.out.println("Stack Underflow error!");
        } else {
            Node currentNode = stackLinkedList.head;
            stackLinkedList.head = currentNode.getPreviousNode();
        }
        return stackLinkedList;
    }

    public Node top(StackLinkedListImpl stackLinkedList) {
        Node topElement = stackLinkedList.head;
        System.out.println("The top element is: " + topElement.getValue());
        return topElement;
    }

    public boolean search(StackLinkedListImpl stackLinkedList, int value) {
        Node currentNode = stackLinkedList.head;
        while (currentNode != null) {
            if (currentNode.getValue() == value) {
                return true;
            }
            currentNode = currentNode.getPreviousNode();
        }
        return false;
    }

    public int size(StackLinkedListImpl stackLinkedList) {
        int size = 0;
        Node currentNode = stackLinkedList.head;
        while (currentNode != null) {
            size++;
            currentNode = currentNode.getPreviousNode();
        }
        return size;
    }

    public void printStack(StackLinkedListImpl stackLinkedList) {
        Node currentNode = stackLinkedList.head;
        System.out.print("The Stack is: ");
        while (currentNode != null) {
            System.out.print(currentNode.getValue() + " ");
            currentNode = currentNode.getPreviousNode();
        }
        System.out.println();
    }

    public static void main(String[] args) {
        StackLinkedListImpl stackLinkedList = new StackLinkedListImpl();

        stackLinkedList = stackLinkedList.push(stackLinkedList, 11);
        stackLinkedList = stackLinkedList.push(stackLinkedList, 12);
        stackLinkedList = stackLinkedList.push(stackLinkedList, 13);
        stackLinkedList = stackLinkedList.push(stackLinkedList, 14);
        stackLinkedList = stackLinkedList.push(stackLinkedList, 15);
        stackLinkedList = stackLinkedList.push(stackLinkedList, 16);
        stackLinkedList = stackLinkedList.push(stackLinkedList, 17);
        stackLinkedList = stackLinkedList.push(stackLinkedList, 18);
        stackLinkedList = stackLinkedList.push(stackLinkedList, 19);
        stackLinkedList = stackLinkedList.push(stackLinkedList, 20);
        stackLinkedList = stackLinkedList.push(stackLinkedList, 21);
        stackLinkedList.printStack(stackLinkedList);
        System.out.println("Stack size is: " + stackLinkedList.size(stackLinkedList));

        stackLinkedList = stackLinkedList.pop(stackLinkedList);
        stackLinkedList.printStack(stackLinkedList);
        System.out.println("Stack size is: " + stackLinkedList.size(stackLinkedList));

        stackLinkedList = stackLinkedList.pop(stackLinkedList);
        stackLinkedList.printStack(stackLinkedList);
        System.out.println("Stack size is: " + stackLinkedList.size(stackLinkedList));

        stackLinkedList.top(stackLinkedList);
        System.out.println(stackLinkedList.search(stackLinkedList, 1));
        System.out.println(stackLinkedList.search(stackLinkedList, 10));

        for (int i = 0; i < 9; i++) {
            stackLinkedList = stackLinkedList.pop(stackLinkedList);
            stackLinkedList.printStack(stackLinkedList);
            System.out.println("Stack size is: " + stackLinkedList.size(stackLinkedList));
        }
    }

}
