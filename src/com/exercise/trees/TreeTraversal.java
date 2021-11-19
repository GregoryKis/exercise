package com.exercise.trees;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class TreeTraversal {

    public List<Integer> preorder(TreeNode root) {

        if (root == null)
            return new ArrayList<>();

        ArrayList<Integer> ret = new ArrayList<>();

        return recPreorder(ret, root);
    }

    private ArrayList<Integer> recPreorder(ArrayList<Integer> res, TreeNode root) {

        res.add(root.val);

        if (root.left != null)
            recPreorder(res, root.left);

        if (root.right != null)
            recPreorder(res, root.right);

        return res;
    }

    public static void main(String[] args) {
        TreeTraversal traversal = new TreeTraversal();

        TreeNode t0 = null;
        List<Integer> preorderT0 = traversal.preorder(t0);
        assertTreeOrder(new ArrayList<>(), preorderT0, "t1");

        TreeNode t1 = new TreeNode(1);
        List<Integer> preorderT1 = traversal.preorder(t1);
        assertTreeOrder(Collections.singletonList(1), preorderT1, "t1");

        TreeNode t2 = new TreeNode(1, new TreeNode(2), null);
        List<Integer> preorderT2 = traversal.preorder(t2);
        assertTreeOrder(Arrays.asList(1, 2), preorderT2, "t2");

        TreeNode t3 = new TreeNode(1, null, new TreeNode(2));
        List<Integer> preorderT3 = traversal.preorder(t3);
        assertTreeOrder(Arrays.asList(1, 2), preorderT3, "t3");

        TreeNode t4 = new TreeNode(1, new TreeNode(2, new TreeNode(3), null), null);
        List<Integer> preorderT4 = traversal.preorder(t4);
        List<Integer> resArrT4 = Arrays.asList(1, 2, 3);
        assertTreeOrder(resArrT4, preorderT4, "t4");

        TreeNode t5 = new TreeNode(1, null, new TreeNode(2, null, new TreeNode(3)));
        List<Integer> preorderT5 = traversal.preorder(t5);
        List<Integer> resArrT5 = Arrays.asList(1, 2, 3);
        assertTreeOrder(resArrT5, preorderT5, "t5");

        TreeNode t6 = new TreeNode(3, new TreeNode(1), new TreeNode(2));
        List<Integer> preorderT6 = traversal.preorder(t6);
        List<Integer> resArrT6 = Arrays.asList(3, 1, 2);
        assertTreeOrder(resArrT6, preorderT6, "t6");

    }

    private static void assertTreeOrder(List<Integer> expected, List<Integer> actual, String testInfo) {
        if (expected.size() != actual.size()) {
            System.out.println("FAIL " + testInfo + " - size difference. exp=" + expected.size() + ", actual=" + actual.size());
            return;
        }
        for (int i = 0; i < expected.size(); i++) {
            if (expected.get(i) != actual.get(i)) {
                System.out.println("FAIL " + testInfo + " - node difference. exp=" + expected.get(i) + ", actual=" + actual.get(i));
            }
        }
    }
}
