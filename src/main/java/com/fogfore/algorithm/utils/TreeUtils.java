package com.fogfore.algorithm.utils;


import java.util.StringJoiner;
import java.util.concurrent.ThreadLocalRandom;

public class TreeUtils {
    private static final ThreadLocal<Integer> index = new ThreadLocal<>();

    public static String toStringByPreOrder(TreeNode root) {
        StringJoiner joiner = new StringJoiner(",", "[", "]");
        toStringByPreOrder(root, joiner);
        return joiner.toString();
    }

    private static void toStringByPreOrder(TreeNode root, StringJoiner joiner) {
        if (root == null) {
            return;
        }
        toStringByPreOrder(root.getLeft(), joiner);
        joiner.add(String.valueOf(root.getValue()));
        toStringByPreOrder(root.getRight(), joiner);
    }

    public static void fill(TreeNode root, int[] array) {
        index.set(0);
        fillByPreOrder(root, array);
    }

    private static void fillByPreOrder(TreeNode root, int[] array) {
        if (root == null) {
            return;
        }
        fillByPreOrder(root.getLeft(), array);
        root.setValue(array[index.get()]);
        index.set(index.get()+ 1);
        fillByPreOrder(root.getRight(), array);
    }
}
