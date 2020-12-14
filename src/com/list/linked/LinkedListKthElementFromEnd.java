package com.list.linked;

/**
 * Encontre o k-ésimo nó do final na lista encadeada Problema
 * 
 * Dada uma lista encadeada, encontre o k-ésimo nó do final. 
 * 
 * Solução
 * 
 * Inicie um ponteiro na cabeça e mova-o k nós. Em seguida, pegue outro ponteiro
 * da cabeça e mova-os simultaneamente. Quando o ponteiro frontal chegar ao fim,
 * o próximo alcançará k nós do fim.
 * 
 * @author skopo
 *
 */
public class LinkedListKthElementFromEnd {

	public static void main(String[] args) {
		Node head = new Node(1);
		head.append(2).append(3).append(4).append(5).append(6).append(7).append(8).append(9);
		
		Node result = findKFromEnd(head, 3);
		System.out.println(result.value);
	}
	
	private static Node findKFromEnd(Node head, int k) {
		Node ahead = head;
		
		while(k-- > 0)
			ahead = ahead.next;
		
		while(ahead != null) {
			head = head.next;
			ahead = ahead.next;
		}
		return head;
	}

}
