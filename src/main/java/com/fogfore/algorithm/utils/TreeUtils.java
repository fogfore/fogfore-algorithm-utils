package com.fogfore.algorithm.utils;


import java.util.List;
import java.util.StringJoiner;
import java.util.concurrent.ThreadLocalRandom;

public class TreeUtils {
    private static final ThreadLocal<Integer> counter = new ThreadLocal<>();

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

    public static void fillByPreOrder(TreeNode root, List<Integer> values) {
        if (root == null) {
            return;
        }
        fillByPreOrder(root.getLeft(), values);
        root.setValue(values.remove(0));
        fillByPreOrder(root.getRight(), values);
    }
}
