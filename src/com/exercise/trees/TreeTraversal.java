package com.exercise.trees;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class TreeTraversal {

    public List<Integer> preOrder(TreeNode root) {

        if (root == null)
            return new ArrayList<>();

        ArrayList<Integer> ret = new ArrayList<>();

        return recPreOrder(ret, root);
    }

    private ArrayList<Integer> recPreOrder(ArrayList<Integer> res, TreeNode root) {

        res.add(root.val);

        if (root.left != null)
            recPreOrder(res, root.left);

        if (root.right != null)
            recPreOrder(res, root.right);

        return res;
    }

    public List<Integer> inOrder(TreeNode root) {

        if (root == null)
            return new ArrayList<>();

        ArrayList<Integer> ret = new ArrayList<>();

        return recInOrder(ret, root);
    }

    private ArrayList<Integer> recInOrder(ArrayList<Integer> res, TreeNode root) {

        if (root.left != null) {
            recInOrder(res, root.left);
        }

        res.add(root.val);

        if (root.right != null)
            recInOrder(res, root.right);

        return res;
    }


    public List<Integer> postOrder(TreeNode root) {

        if (root == null)
            return new ArrayList<>();

        ArrayList<Integer> ret = new ArrayList<>();

        return recPostOrder(ret, root);
    }

    private ArrayList<Integer> recPostOrder(ArrayList<Integer> res, TreeNode root) {

        if (root.left != null) {
            recPostOrder(res, root.left);
        }

        if (root.right != null) {
            recPostOrder(res, root.right);
        }

        res.add(root.val);

        return res;
    }

    public static void main(String[] args) {
        TreeTraversal traversal = new TreeTraversal();

        TreeNode t0 = null;
        List<Integer> preOrderT0 = traversal.preOrder(t0);
        List<Integer> inOrderT0 = traversal.inOrder(t0);
        List<Integer> postOrderT0 = traversal.postOrder(t0);
        assertTreeOrder(new ArrayList<>(), preOrderT0, "PreOrder - t1");
        assertTreeOrder(new ArrayList<>(), inOrderT0, "InOrder - t1");
        assertTreeOrder(new ArrayList<>(), postOrderT0, "PostOrder - t1");

        TreeNode t1 = new TreeNode(1);
        List<Integer> preOrderT1 = traversal.preOrder(t1);
        List<Integer> inOrderT1 = traversal.inOrder(t1);
        List<Integer> postOrderT1 = traversal.postOrder(t1);
        assertTreeOrder(Collections.singletonList(1), preOrderT1, "PreOrder - t1");
        assertTreeOrder(Collections.singletonList(1), inOrderT1, "InOrder - t1");
        assertTreeOrder(Collections.singletonList(1), postOrderT1, "PostOrder - t1");

        TreeNode t2 = new TreeNode(1, new TreeNode(2), null);
        List<Integer> preOrderT2 = traversal.preOrder(t2);
        List<Integer> inOrderT2 = traversal.inOrder(t2);
        List<Integer> postOrderT2 = traversal.postOrder(t2);
        assertTreeOrder(Arrays.asList(1, 2), preOrderT2, "PreOrder - t2");
        assertTreeOrder(Arrays.asList(2, 1), inOrderT2, "InOrder - t2");
        assertTreeOrder(Arrays.asList(2, 1), postOrderT2, "PostOrder - t2");

        TreeNode t3 = new TreeNode(1, null, new TreeNode(2));
        List<Integer> preOrderT3 = traversal.preOrder(t3);
        List<Integer> inOrderT3 = traversal.inOrder(t3);
        List<Integer> postOrderT3 = traversal.postOrder(t3);
        assertTreeOrder(Arrays.asList(1, 2), preOrderT3, "PreOrder - t3");
        assertTreeOrder(Arrays.asList(1, 2), inOrderT3, "InOrder - t3");
        assertTreeOrder(Arrays.asList(2, 1), postOrderT3, "PostOrder - t3");

        TreeNode t4 = new TreeNode(1, new TreeNode(2, new TreeNode(3), null), null);
        List<Integer> preOrderT4 = traversal.preOrder(t4);
        List<Integer> inOrderT4 = traversal.inOrder(t4);
        List<Integer> postOrderT4 = traversal.postOrder(t4);
        assertTreeOrder(Arrays.asList(1, 2, 3), preOrderT4, "PreOrder - t4");
        assertTreeOrder(Arrays.asList(3, 2, 1), inOrderT4, "InOrder - t4");
        assertTreeOrder(Arrays.asList(3, 2, 1), postOrderT4, "PostOrder - t4");

        TreeNode t5 = new TreeNode(1, null, new TreeNode(2, null, new TreeNode(3)));
        List<Integer> preOrderT5 = traversal.preOrder(t5);
        List<Integer> inOrderT5 = traversal.inOrder(t5);
        List<Integer> postOrderT5 = traversal.postOrder(t5);
        assertTreeOrder(Arrays.asList(1, 2, 3), preOrderT5, "PreOrder - t5");
        assertTreeOrder(Arrays.asList(1, 2, 3), inOrderT5, "InOrder - t5");
        assertTreeOrder(Arrays.asList(3, 2, 1), postOrderT5, "PostOrder - t5");

        TreeNode t6 = new TreeNode(1, new TreeNode(2), new TreeNode(3));
        List<Integer> preOrderT6 = traversal.preOrder(t6);
        List<Integer> inOrderT6 = traversal.inOrder(t6);
        List<Integer> postOrderT6 = traversal.postOrder(t6);
        assertTreeOrder(Arrays.asList(1, 2, 3), preOrderT6, "PreOrder - t6");
        assertTreeOrder(Arrays.asList(2, 1, 3), inOrderT6, "InOrder - t6");
        assertTreeOrder(Arrays.asList(2, 3, 1), postOrderT6, "PostOrder - t6");

    }

    private static void assertTreeOrder(List<Integer> expected, List<Integer> actual, String testInfo) {
        if (expected.size() != actual.size()) {
            System.out.println("FAIL " + testInfo + " - size difference. exp=" + expected.size() + ", actual=" + actual.size());
            return;
        }
        for (int i = 0; i < expected.size(); i++) {
            if (expected.get(i) != actual.get(i)) {
                System.out.println("FAIL " + testInfo + " - node difference. exp=" + expected.get(i) + ", actual=" + actual.get(i) + ", listExpected=" + expected + ", listActual=" + actual);
                break;
            }
        }
    }
}
