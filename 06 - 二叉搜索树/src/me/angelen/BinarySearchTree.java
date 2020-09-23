package me.angelen;

import java.util.Comparator;

import me.angelen.printer.BinaryTreeInfo;

public class BinarySearchTree<E> implements BinaryTreeInfo {
	private int size;
	private Node<E> root;
	private Comparator<E> comparator; // 外界传入比较器（直接使用官方的咯）
	
	public BinarySearchTree(Comparator<E> comparator) {
		this.comparator = comparator;
	}
	
	public int size() {
		return size;
	}
	
	public boolean isEmpty() {
		return size == 0;
	}
	
	public void clear() {
		
	}
	
	public void add(E element) {
		elementNotNullCheck(element);
		
		if (root == null) {
			// 如果根节点为空，则此时添加第一个节点
			root = new Node<>(element, null);
			size++;
			return;
		}
		
		// 添加的不是第一个节点

		// 1. 找到父节点
		Node<E> node = root; // 要比较的节点
		Node<E> parent = root; // 插入 element 元素的父节点
		int cmp = 0; // 保存比较结果，才能确定是插入到 parent 的左还是右节点
		while (node != null) {
			parent = node; // 在给 node 赋值之前保存，这就是 parent
			
			cmp = compare(element, node.element);
			if (cmp > 0) {
				// 传进来的 element 比较大，继续和 node 的 right 节点比较
				node = node.right;
			} else if (cmp < 0) {
				// 传进来的 element 比较小，继续和 node 的 left 节点比较
				node = node.left;
			} else {
				// 考虑到自定义对象，建议这里相等时，用新值覆盖
				node.element = element;
			}
		}
		
		// 确定 element 插到哪里
		if (cmp > 0) {
			parent.right = new Node<>(element, parent);
		} else if (cmp < 0) {
			parent.left = new Node<>(element, parent);
		}
		size++;
	}
	
	public void remove(E element) {
		
	}
	
	public boolean contains(E element) {
		return true;
	}
	
	private int compare(E e1, E e2) {
		return comparator.compare(e1, e2);
	}
	
	// 检查 element 是否为空
	private void elementNotNullCheck(E element) {
		if (element == null) {
			throw new IllegalArgumentException("element 不能为空");
		}
	}
	
	private static class Node<E> {
		E element;
		Node<E> left;
		Node<E> right;
		Node<E> parent;
		
		// 创建一个节点，必然是有父节点（如果没有，说明是根节点），而左右节点不一定会有（叶子节点就是）
		public Node(E element, Node<E> parent) {
			this.element = element;
			this.parent = parent;
		}
	}

	@Override
	public Object root() {
		return root;
	}

	@Override
	public Object left(Object node) {
		return ((Node<E>)node).left;
	}

	@Override
	public Object right(Object node) {
		return ((Node<E>)node).right;
	}

	@Override
	public Object string(Object node) {
		Node<E> _node = (Node<E>)node;
		String p = "null"; // 调试的时候可把父节点也打印
		if (_node.parent != null) {
			p = _node.parent.element.toString();
		}
		return _node.element.toString() + "(p:" + p + ")";
	}
}
