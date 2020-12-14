package com.list.linked;

/**
 * Dobre uma lista ligada 
 * Problema 
 * 
 * Dobre uma lista encadeada de forma que o
 * último elemento se torne o segundo elemento, o último mas um elemento se
 * torne o 4º elemento e assim por diante. Por exemplo, lista vinculada de
 * entrada: 1-> 2-> 3-> 4-> 5-> 6-> 7-> 8-> 9-> lista vinculada de saída 1-> 9->
 * 2-> 8-> 3- > 7-> 4-> 6-> 5-> 
 * 
 * Solução 
 * 
 * Encontre o meio da lista vinculada. Você
 * pode fazer isso por abordagem de ponteiro lento e rápido. Comece duas dicas
 * da cabeça. Avança um ponteiro a uma taxa de um nó por iteração. Vamos
 * chamá-lo de ponteiro lento. Avance outro ponteiro a uma taxa de dois nós por
 * iteração. Vamos chamá-lo de ponteiro rápido. Quando o ponteiro rápido chegar
 * ao final da lista vinculada, o ponteiro lento estará no meio da lista
 * vinculada. Depois de encontrar o nó do meio, invertemos a metade direita. em
 * seguida, fazemos uma fusão no local das duas metades da lista vinculada.
 * 
 * @author skopo
 *
 */
public class FoldLinkedList {
	
	public static void main(String[] args) {
	  Node a = new Node(1);
	  Node b = new Node(2);
	  Node c = new Node(3);
	  Node d = new Node(4);
	  Node e = new Node(5);
	  Node f = new Node(6);
	  Node g = new Node(7);
	  Node h = new Node(8);
	  Node i = new Node(9);
	  
	  a.next = b;
	  b.next = c;
	  c.next = d;
	  d.next = e;
	  e.next = f;
	  f.next = g;
	  g.next = h;
	  h.next = i;
	  
	  a.printLinkedList();
	  foldLinkedList(a);
	  a.printLinkedList();
	 }

	public static void foldLinkedList(Node head) {
		Node slowPointer = head;
		Node fastPointer = head;

		while (fastPointer != null) {
			slowPointer = slowPointer.next;
			fastPointer = fastPointer.next;

			if (fastPointer != null)
				fastPointer = fastPointer.next;
		}

		Node middlePointer = slowPointer;
		Node reverseLastHalf = reverseLinkedList(slowPointer);

		while (reverseLastHalf != null && head != middlePointer) {
			Node tempHead = head.next;
			Node tempReverse = reverseLastHalf.next;
			reverseLastHalf.next = head.next;
			head.next = reverseLastHalf;
			head = tempHead;
			reverseLastHalf = tempReverse;
		}

		if (reverseLastHalf != null)
			reverseLastHalf.next = null;
		else
			head.next = null;
	}

	public static Node reverseLinkedList(Node head) {
		if (head.next == null)
			return head;
		
		Node newHead = reverseLinkedList(head.next);
		head.next.next = head;
		head.next = null;
		
		return newHead;
	}
}