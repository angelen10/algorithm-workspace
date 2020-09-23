package me.angelen;

import java.util.Comparator;

import me.angelen.printer.BinaryTrees;

public class Main {

	public static void main(String[] args) {

		Integer data[] = new Integer[] { 7, 4, 9, 2, 5, 8, 11, 3 };

		// 比较器使用匿名类，类似 iOS 中的 block，js 的闭包（function）
		BinarySearchTree<Integer> bst = new BinarySearchTree<>(new Comparator<Integer>() {

			@Override
			public int compare(Integer o1, Integer o2) {
				return o1 - o2;
			}
		});

		for (int i = 0; i < data.length; i++) {
			bst.add(data[i]);
		}
		BinaryTrees.println(bst);
		
		// 添加 12 和 1 后的二叉搜索树
		bst.add(12);
		bst.add(1);
		bst.add(9);
		BinaryTrees.println(bst);
	}
}
