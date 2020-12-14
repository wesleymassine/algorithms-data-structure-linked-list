package com.list.linked;

/**
 * Forma em Y de lista vinculada 
 * 
 * Problema
 * 
 * Dadas duas listas encadeadas, descubra se elas convergem para uma única lista
 * encadeada ou não; em caso afirmativo, encontre o ponto de convergência.
 * 
 * Solução
 * 
 * Se as listas vinculadas forem convergentes, seu último nó será o mesmo.
 * Assim, percorremos os dois nós e encontramos o último nó de cada lista
 * vinculada. Se eles forem iguais, eles são convergentes. Para encontrar o
 * ponto de convergência, primeiro encontramos seus comprimentos correspondentes
 * e encontramos sua diferença. Em seguida, percorremos o maior número de nós da
 * lista vinculada igual à diferença. Depois disso, se atravessarmos os dois nós
 * simultaneamente, encontraremos um nó comum que é o nó de convergência.
 */
public class LinkedListYShape {

	public static void main(String[] args) {
		Node head1 = new Node(1);
		Node middle1 = head1.append(2).append(3).append(4);
		middle1.append(6).append(7).append(8).append(9);

		Node head2 = new Node(10);
		Node middle2 = head2.append(3).append(5).append(6).append(11).append(24);
		middle2.next = middle1;
		
		findIntersection(head1, head2);
	}

	private static void findIntersection(Node head1, Node head2) {
		int count1 = 0;
		int count2 = 0;
		Node ptr1 = head1;
		Node ptr2 = head2;
		
		while (true) {
			if (ptr1.next == null)
				break;
			ptr1 = ptr1.next;
			count1++;
		}
		
		while (true) {
		   if (ptr2.next == null)
			   break;
		   ptr2 = ptr2.next;
		   count2++;
		}
		
		boolean isMerged = ptr1 == ptr2;
		
		if (isMerged) {
			System.out.println("The linked lists are merged");
			Node longer = head1;
			Node shorter = head2;
			
			if (count1 < count2) {
				longer = head2;
				shorter = head1;
			}
			
			int diff = Math.abs(count1 - count2);
			
			while (diff-- > 0) {
				longer = longer.next;
			}
			
			while (longer != shorter) {
				longer = longer.next;
				shorter = shorter.next;
			}
			
			System.out.println("Common Node = " + longer.value);
		} else {
			System.out.println("The linked lists are NOT merged");
		}
	}
}
