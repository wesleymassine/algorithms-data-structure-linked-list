package com.list.linked;

import java.io.PrintStream;

public class Node {
	public  Node next;
	public int value;
	
	//As classes Directory e TelephoneDirectory usa essas propriedades abaixo
	boolean available = true;
	Node previous;
	int number;
	
	public Node(int value) {
		this.value = value;
	}
	
	public void printLinkedList() {
		Node head = this;
		
		while(head != null) {
			System.out.print(head.value + "->");
			head = head.next;
		}
		System.out.println();
	}

	public Node append(int value) {
		Node node = new Node(value);
		next = node;
   
		return node;
  }
}
