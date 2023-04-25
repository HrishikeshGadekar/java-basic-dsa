package org.javadsa.basicDataStructures;

public class QueueLinkedListImpl {
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

    public QueueLinkedListImpl enqueue(QueueLinkedListImpl queueLinkedList, int elementToEnqueue) {
        Node currentNode = queueLinkedList.head;
        Node nodeToEnqueue = new Node(elementToEnqueue);
        if (currentNode == null) queueLinkedList.head = nodeToEnqueue;
        else {
            while (currentNode.getNextNode() != null) {
                currentNode = currentNode.getNextNode();
            }
            currentNode.setNextNode(nodeToEnqueue);
        }
        return queueLinkedList;
    }

    public QueueLinkedListImpl dequeue(QueueLinkedListImpl queueLinkedList) {
        Node currentNode = queueLinkedList.head;
        if (currentNode == null) {
            System.out.println("Queue Underflow error!");
            return queueLinkedList;
        }
        queueLinkedList.head = currentNode.getNextNode();
        return queueLinkedList;
    }

    public void printQueue(QueueLinkedListImpl queueLinkedList) {
        Node currentNode = queueLinkedList.head;
        System.out.print("The Queue is: ");
        while (currentNode != null) {
            System.out.print(currentNode.getValue() + " ");
            currentNode = currentNode.getNextNode();
        }
        System.out.println();
    }


    public static void main(String[] args) {
        QueueLinkedListImpl queueLinkedList = new QueueLinkedListImpl();
        queueLinkedList = queueLinkedList.enqueue(queueLinkedList, 11);
        queueLinkedList = queueLinkedList.enqueue(queueLinkedList, 12);
        queueLinkedList = queueLinkedList.enqueue(queueLinkedList, 13);
        queueLinkedList = queueLinkedList.enqueue(queueLinkedList, 14);
        queueLinkedList = queueLinkedList.enqueue(queueLinkedList, 15);
        queueLinkedList = queueLinkedList.enqueue(queueLinkedList, 16);
        queueLinkedList.printQueue(queueLinkedList);
        queueLinkedList.dequeue(queueLinkedList);
        queueLinkedList = queueLinkedList.enqueue(queueLinkedList, 17);
        queueLinkedList.printQueue(queueLinkedList);
        queueLinkedList.dequeue(queueLinkedList);
        queueLinkedList = queueLinkedList.enqueue(queueLinkedList, 18);
        queueLinkedList.printQueue(queueLinkedList);
        queueLinkedList.dequeue(queueLinkedList);
        queueLinkedList = queueLinkedList.enqueue(queueLinkedList, 19);
        queueLinkedList.printQueue(queueLinkedList);

    }


}
