package com.fogfore.algorithm.utils;

import org.apache.commons.lang3.Validate;

import java.util.StringJoiner;
import java.util.concurrent.ThreadLocalRandom;

public class TreeFactory {
    public static final int DEFAULT_NODE_NUM = 50;
    public static final int MAX_VALUE = 100;

    private static final ThreadLocalRandom RANDOM = ThreadLocalRandom.current();

    public static TreeNode getBinaryTree() {
        return getBinaryTree(DEFAULT_NODE_NUM, MAX_VALUE);
    }

    public static TreeNode getBinaryTree(int nodeNum) {
        return getBinaryTree(nodeNum, MAX_VALUE);
    }

    public static TreeNode getBinaryTree(int nodeNum, int maxValue) {
        if (nodeNum < 1) {
            return null;
        }
        nodeNum--;
        TreeNode root = new TreeNode(RANDOM.nextInt(maxValue + 1));
        if (RANDOM.nextBoolean()) {
            root.setLeft(getBinaryTree(nodeNum, maxValue));
        }
        if (RANDOM.nextBoolean()) {
            root.setRight(getBinaryTree(nodeNum, maxValue));
        }
        return root;
    }

    public static TreeNode getBinarySearchTree(int nodeNum, int minValue, int maxValue) {
        Validate.inclusiveBetween(0, maxValue - 1, minValue);
        Validate.inclusiveBetween(minValue + 1, Integer.MAX_VALUE - 1, maxValue);
        if (nodeNum < 1 || maxValue - (minValue + nodeNum - 1) < 0) {
            return null;
        }
        TreeNode root = getBinaryTree(nodeNum, maxValue);
        int[] values = ArrayFactory.getOrderUnrepeatedArray(nodeNum, minValue, maxValue);
        TreeUtils.fill(root, values);
        return root;
    }
}
