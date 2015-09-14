package com.offer.test;

/**
 * 重建二叉树
 * @author Administrator
 *
 */
public class RebuildBinTree {
	static int[] pre = {1,2,4,3,5,6};
	static int[] in = {4,2,1,5,3,6};
	public static void main(String[] args) {
		TreeNode root  = construct(pre, in);
		print(root);
	}

	static TreeNode construct(int[] pre, int[] in) {
		if(null != pre && null != in)
			return constructCore(0, pre.length - 1, 0, in.length - 1);
		return null;
	}

	static TreeNode constructCore(int preStart, int preEnd, int startIn, int EndIn) {
		//前序遍历的第一个数字是根节点的值
		int rootVal = pre[preStart];
		TreeNode root = new TreeNode(rootVal);
		root.left = root.right = null;
		
		if(preStart == preEnd){
			if(startIn == EndIn && pre[preStart] == in[startIn]) 
				return root;
			return null;
		}
		//在中序遍历找到根节点
		int InRootPos = startIn;
		while(InRootPos <= EndIn && in[InRootPos] != rootVal){
			InRootPos++;
		}

		int leftLength = InRootPos - startIn;
		int leftPreorderEnd = preStart + leftLength;
		if(leftLength > 0){
			//构建左子树
			root.left = constructCore(preStart + 1, leftPreorderEnd, startIn, InRootPos - 1);
			//构建右子树
			root.right = constructCore(leftPreorderEnd + 1, preEnd, InRootPos + 1, EndIn);
		}
		return root;
	}
	
	static void print(TreeNode root){
		if(null != root){
			System.out.println(root.val);
			print(root.left);
			print(root.right);
		}
	}

	private static class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		TreeNode(int x) {
			val = x;
		}
	}

}
