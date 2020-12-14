package com.list.linked;

/**
 * Lista vinculada reversa iterativa
 * 
 * Problema 
 * Reverter uma lista vinculada 
 * 
 * Solução 
 * Acompanhe o nó anterior à
 * medida que avança. ligue esse nó na próxima iteração. Este código é
 * autoexplicativo.
 * 
 * @author skopo
 *
 */

public class ReverseLinkedListIterative {

	public static void main(String[] args) {
		Node a = new Node(4);
		Node b = new Node(6);
		Node c = new Node(2);
		Node d = new Node(9);
		Node e = new Node(5);
		Node f = new Node(3);
		Node g = new Node(6);
		Node h = new Node(2);

		a.next = b;
		b.next = c;
		c.next = d;
		d.next = e;
		e.next = f;
		f.next = g;
		g.next = h;
		a.printLinkedList();

		Node head = reverseLinkedList(a);
		head.printLinkedList();
	}

	public static Node reverseLinkedList(Node head) {
		Node prev = null;
		Node next = null;
		Node current = head;

		while (current != null) {
			next = current.next;
			current.next = prev;
			prev = current;
			current = next;
		}
		return prev;
	}
}
