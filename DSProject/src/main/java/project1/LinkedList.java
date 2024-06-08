package project1;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
/**
 *
 * @author mbera
 */
public class LinkedList<T>
{

	Node<T> head;

	//The linked list implementation provides an add() method for adding new nodes to the list.
	void add(Node<T> newNode)
	{
		Node<T> firstTemp;
		Node<T> secondTemp;
		boolean done;
		
		if (head == null) { //If the linked list is empty (head == null), the new node becomes the head of the list.
			head = newNode;
			return;
		}
		//Otherwise, the method iterates through the list to find the correct position to insert the new node.
		if (head.column != 1 && head.column > newNode.column) {
			newNode.next = head;
			head = newNode;
		} else {
			firstTemp = head;
			done = false;
			while (firstTemp != null) {
				if (firstTemp.column == newNode.column) { //If the new node has the same column value as an existing node in the list, the method checks if the two nodes have the same data value.
					while (firstTemp.up != null) { //If they do, the data values are added together and assigned to the existing node.
						firstTemp = firstTemp.up;
					}
					if (firstTemp.data == newNode.data) {
						firstTemp.data = firstTemp.data + newNode.data;
						while (firstTemp.down != null) {
							if (firstTemp.down.data == firstTemp.data) { // If the node below the existing node also has the same data value, the values are added together,- 
								firstTemp.down.data += firstTemp.data; //-the upper node is removed, and the process is repeated until no further nodes have the same data value.
								firstTemp.down.up = null;
							}
							firstTemp = firstTemp.down;
						}
					} else {
						firstTemp.up = newNode; // If the two nodes do not have the same data value, the new node is added as an upper node to the existing node.
						newNode.down = firstTemp;
					}
					done = true;
					break;
				}
				firstTemp = firstTemp.next;
			}
			if (done == false) { // If the new node does not have the same column value as any existing nodes,- 
				secondTemp = head; //- the method iterates through the list to find the correct position to insert the new node based on its column value.
				while (secondTemp.next != null && newNode.column < secondTemp.next.column) { //Once found, the new node is inserted into the list.
					secondTemp = secondTemp.next;
				}
				newNode.next = secondTemp.next;
				secondTemp.next = newNode;
			}
		}
	}
}
