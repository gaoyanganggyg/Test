package com.sort.test;

/**
 * 二叉树查找，插入，删除
 * @author Administrator
 *
 */
public class BinaryTreeSearch {
	
	public static void main(String[] args) {
		long start = System.currentTimeMillis();
		int array[] = {62,88,58,47,35,73,51,99,37,93};
		BinaryTreeSearch binaryTreeSearch = new BinaryTreeSearch();
		BiTreeNode root = null;
		for (int i = 0; i < array.length; i++) {
			root = binaryTreeSearch.insert(root, array[i]);
		}
		BiTreeNode par = null;
		BiTreeNode pos = null;
		System.out.println(binaryTreeSearch.search(root, 88, par, pos));
		System.out.println(pos);
		
		System.out.println(binaryTreeSearch.delete(root, 88));
		
		System.out.println( "search time used: "+ (System.currentTimeMillis() - start));
	}
	
	/**
	 * 查找
	 * @param node
	 * @param key
	 * @param pos
	 * @return
	 */
	BiTreeNode search(BiTreeNode node, int key, BiTreeNode par , BiTreeNode pos){
		if(null == node){
			pos = par;
			return pos;
		}else {
			if(node.data == key){
				pos = node;
				return pos;
			}else if (node.data < key) {
				return search(node.right, key, node, pos);
			}else {
				return search(node.left, key, node, pos);
			}
		}
	}
	
	/**
	 * 插入 
	 * @param node
	 * @param value
	 * @return
	 */
	BiTreeNode temp;
	BiTreeNode insert(BiTreeNode node, int value){
		BiTreeNode pos = new BiTreeNode();
		pos = search(node, value, null, pos);
		if(null == pos){
			temp = new BiTreeNode();
			temp.data = value;
			if(null == node){
				node = temp;
			}else {
				if(value < pos.data){
					pos.left = temp;
				}else {
					pos.right = temp;
				}
			}
			return node;
		}else {
			return null;
		}
	}
	
	/**
	 * 删除1
	 * @param node
	 * @param value
	 * @return
	 */
	boolean delete(BiTreeNode node, int value){
		if(null == node){
			return false;
		}else {
			if(node.data == value){
				return delete1(node);
			}else if (node.data < value) {
				return delete(node.right, value);
			}else {
				return delete(node.left, value);
			}
		}
	}
	/**
	 * 删除结点
	 * @param node
	 * @return
	 */
	boolean delete1(BiTreeNode node){
		if(null == node.left){
			node = node.right;
			return true;
		}else if (null == node.right) {
			node = node.left;
			return true;
		}else {
			BiTreeNode temp = node;
			BiTreeNode temp1 = node.left;
			while(null != temp1.right){
				temp = temp1;
				temp1 = temp1.right;
			}
			node.data = temp1.data;
			if(temp != node){
			 	temp.right = temp1.left;
			}else {
				temp.left = temp1.left;
			}
			return true;
		}
	}
}

class BiTreeNode{
	int data;
	BiTreeNode left, right;
}
