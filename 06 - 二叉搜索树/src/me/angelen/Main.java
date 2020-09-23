package me.angelen;

import java.util.Comparator;

import me.angelen.printer.BinaryTrees;

public class Main {

	public static void main(String[] args) {

		tesPreorderTraversal();
	}
	
    static void tesPreorderTraversal() {
        Integer data[] = new Integer[] { 7, 4, 2, 1, 3, 5, 9, 8, 11, 10, 12 };
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
        
        System.out.print("前序遍历：");
        bst.preorderTraversal();
        System.out.println();
        
        System.out.print("中序遍历：");
        bst.inorderTraversal();
        System.out.println();
        
        System.out.print("后序遍历：");
        bst.postorderTraversal();
        System.out.println();
        
        System.out.print("层序遍历：");
        bst.levelOrderTraversal();
        System.out.println();
    }
	
	static void test() {
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
