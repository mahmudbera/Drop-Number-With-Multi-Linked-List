/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package project1;

/**
 *
 * @author mbera
 */
public class Node<T>
{
	int data;
	int column;
	Node<T> next;
	Node<T> up;
	Node<T> down;

	public Node(int data, int column)
	{
		this.data = data;
		this.next = null;
		this.up = null;
		this.down = null;
		this.column = column;
	}

	public int getData()
	{
		return data;
	}

	public Node<T> getNext()
	{
		return next;
	}

	public Node<T> getUp()
	{
		return up;
	}

	public Node<T> getDown()
	{
		return down;
	}

	public int getColumn()
	{
		return column;
	}

}
