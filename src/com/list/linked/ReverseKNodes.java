package com.list.linked;

/**
 * Reverter k nós na lista vinculada Problema Reverta cada k nós em uma lista
 * encadeada e retorne o cabeçalho apropriadamente.
 * 
 * Solução Usaremos uma função reversa que reverte k nós da cabeça e retorna o
 * k-ésimo nó como cabeça. Usaremos esta função recursivamente para reverter
 * todos os k nós.
 * 
 * @author skopo
 *
 */
public class ReverseKNodes {

	public static void main(String[] args) {
		int[] arr = { 4, 5, 3, 6, 8, 3, 5, 7, 3, 7, 9, 4, 6 };
		
		Node head = createLinkedList(arr);
		printLinkedList(head);
		head = reverse(head, 4);
		printLinkedList(head);
	}
	
	static Node reverse(Node head, int k) {
		Node current = head;
		Node next = null;
		Node prev = null;
		int count = 0;

		while (current != null && count < k) {
			next = current.next;
			current.next = prev;
			prev = current;
			current = next;
			count++;
		}

		if (next != null) {
			head.next = reverse(next, k);
		}

		return prev;
	}

	private static void printLinkedList(Node head) {
		while (head != null) {
			System.out.print(head.value + "->");
			head = head.next;
		}
		System.out.println();
	}
	
	private static Node createLinkedList(int[] arr) {
		Node head = null;
		Node current = null;
		
		for (int element : arr) {
			if (head == null) {
				head = new Node(element);
				current = head;
			} else {
				current.next = new Node(element);
				current = current.next;
			}
		}
		return head;
	}
}
