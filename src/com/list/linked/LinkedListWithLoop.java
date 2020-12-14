package com.list.linked;

/**
 * Encontrar loop na lista vinculada 
 * 
 * Problema
 * 
 * Dada uma lista vinculada, descubra se a lista está em loop ou não. Uma lista
 * encadeada é repetida quando um dos nós aponta para qualquer um de seus nós
 * anteriores ou para ele mesmo. Encontre também a duração e o ponto de partida
 * do loop. 
 * 
 * Solução
 * 
 * Pegamos dois ponteiros, um lento, que move um nó por vez, e outro rápido, que
 * move dois nós por vez. Ambos os indicadores começam da cabeça. Se a lista
 * vinculada não estiver em loop. o ponteiro rápido atingirá o ponteiro nulo. Se
 * eles se encontrarem, isso significa que a lista vinculada está em loop. Se
 * estiver em loop, ambos os ponteiros estarão em algum ponto do loop. Mantemos
 * um fixo e movemos outro ponteiro no loop até que os dois se encontrem
 * novamente. Desta forma, encontraremos o comprimento do loop. Agora levamos o
 * ponteiro para a cabeça e movemos o ponteiro rápido 'comprimento do loop' à
 * frente do ponteiro lento. Então, nós os movemos novamente um nó por vez até
 * que se encontrem. Como o ponteiro rápido tem 'comprimento de loop' à frente
 * do ponteiro lento, quando o ponteiro lento atinge o início do loop, o rápido
 * também o alcançará após completar um loop.
 * 
 * @author skopo
 *
 */
public class LinkedListWithLoop {
	
	public static void main(String[] args) {
		
		Node head = new Node(1);
		Node middle = head.append(2).append(3).append(4).append(5);
		Node tail = middle.append(6).append(7).append(8).append(9).append(10).append(11);
				
		tail.next = middle;
		findLoopInformation(head);
	}
	
	private static void findLoopInformation(Node head) {
		Node slowPointer = head;
		Node fastPointer = head;
		boolean isLooped = false;
		
		while(fastPointer != null && fastPointer.next != null) {
			slowPointer = slowPointer.next;
			fastPointer = fastPointer.next.next;
			
			if (slowPointer == fastPointer) {
				isLooped = true;
				break;
			}
		}
		
		if (isLooped) {
			System.out.println("Linkedlist is looped");
			fastPointer = fastPointer.next;
			int count = 1;
			
			while(slowPointer != fastPointer) {
				fastPointer = fastPointer.next;
				count++;
			}
			System.out.println("Loop length = " + count);
			slowPointer = head;
			fastPointer = head;
			
			while (count-- > 0) {
				fastPointer = fastPointer.next;
			}
			
			while (slowPointer != fastPointer) {
				slowPointer = slowPointer.next;
				fastPointer = fastPointer.next;
			}
			System.out.println("Loop starting point = " + slowPointer.value);
		} else {
			System.out.println("Linkedlist is NOT looped");
		}
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
