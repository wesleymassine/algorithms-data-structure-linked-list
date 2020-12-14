package com.list.linked;

public class Directory {
	Node[] nodes;
	Node head;

	public Directory(int maxNumbers) {
		nodes = new Node[maxNumbers];

		for (int i = 0; i < maxNumbers; ++i) {
			nodes[i] = new Node(i);
			if (i != 0) {
				nodes[i].previous = nodes[i - 1];
				nodes[i - 1].next = nodes[i];
			}
		}

		nodes[maxNumbers - 1].next = nodes[0];
		nodes[0].previous = nodes[maxNumbers - 1];
		head = nodes[0];
	}

	public int getAvailableNumber() {

		if (head == null)
			return -1;

		int temp = head.number;
		head.available = false;

		if (head.next == head) {
			head = null;
		} else {
			head.previous.next = head.next;
			head.next.previous = head.previous;
			head = head.next;
		}
		return temp;
	}
	
	public boolean isAvailable(int number) {
		return nodes[number].available;
	}

	public void release(int number) {
		if (nodes[number].available == false) {
			nodes[number].available = true;

			if (head == null) {
				head = nodes[number];
				nodes[number].next = nodes[number];
				nodes[number].previous = nodes[number];
			} else {
				nodes[number].next = head.next;
				nodes[number].previous = head;
				head.next.previous = nodes[number];
				head.next = nodes[number];
			}
		}
	}
}
