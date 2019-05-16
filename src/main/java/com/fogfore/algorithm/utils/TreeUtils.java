package com.fogfore.algorithm.utils;


import java.util.List;
import java.util.StringJoiner;
import java.util.concurrent.ThreadLocalRandom;

public class TreeUtils {
    private static final ThreadLocal<Integer> counter = new ThreadLocal<>();

    public static String toStringByInOrder(TreeNode root) {
        StringJoiner joiner = new StringJoiner(",", "[", "]");
        toStringByInOrder(root, joiner);
        return joiner.toString();
    }

    public static void fillByInOrder(TreeNode root, List<Integer> values) {
        if (root == null) {
            return;
        }
        fillByInOrder(root.getLeft(), values);
        root.setValue(values.remove(0));
        fillByInOrder(root.getRight(), values);
    }

    private static void toStringByInOrder(TreeNode root, StringJoiner joiner) {
        if (root == null) {
            return;
        }
        toStringByInOrder(root.getLeft(), joiner);
        joiner.add(String.valueOf(root.getValue()));
        toStringByInOrder(root.getRight(), joiner);
    }
}
