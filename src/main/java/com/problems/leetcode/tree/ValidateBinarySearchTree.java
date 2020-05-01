package com.problems.leetcode.tree;

import java.util.ArrayList;
import java.util.List;

/*98. Validate Binary Search Tree

Given a binary tree, determine if it is a valid binary search tree (BST).

Assume a BST is defined as follows:

The left subtree of a node contains only nodes with keys less than the node's key.
The right subtree of a node contains only nodes with keys greater than the node's key.
Both the left and right subtrees must also be binary search trees.
 

Example 1:

    2
   / \
  1   3

Input: [2,1,3]
Output: true
Example 2:

    5
   / \
  1   4
     / \
    3   6

Input: [5,1,4,null,null,3,6]
Output: false
Explanation: The root node's value is 5 but its right child's value is 4.

* if the INORDER traversal of a   tree will be sorted then the tree  is a binary search tree.
* 
*/

public class ValidateBinarySearchTree {

public boolean isValidBST(TreeNode root) {
        
        
        List<Integer> output = new ArrayList<Integer>();
        inOrder(root,output);
        
        for(int i=0;i<output.size()-1;i++) {
            
             int a = output.get(i);
            int b  = output.get(i+1);
            if (a>=b) {
                return false;
            }
        }
        return true;
    }
    
    public List<Integer> inOrder(TreeNode root,List<Integer> output) {
        
        if (root != null) {
            
            if(root.left != null) {
                inOrder(root.left,output);
            }
            
                output.add(root.val);
            
            if (root.right != null) {
                inOrder(root.right,output);
            }
        
        }
        return output;
        
    }
}
