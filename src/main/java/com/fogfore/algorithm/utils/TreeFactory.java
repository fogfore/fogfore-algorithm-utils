package com.fogfore.algorithm.utils;

import org.apache.commons.lang3.Validate;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.StringJoiner;
import java.util.concurrent.ThreadLocalRandom;

public class TreeFactory {
    public static final int DEFAULT_NUM = 50;
    public static final int MIN_VALUE = 0;
    public static final int MAX_VALUE = 100;

    private static final ThreadLocalRandom RANDOM = ThreadLocalRandom.current();

    public static TreeNode getBinaryTree() {
        return getBinaryTree(DEFAULT_NUM, MIN_VALUE, MAX_VALUE);
    }

    public static TreeNode getBinaryTree(int nodeNum) {
        return getBinaryTree(nodeNum, MIN_VALUE, MAX_VALUE);
    }

    public static TreeNode getBinaryTree(int nodeNum, int minValue, int maxValue) {
        if (nodeNum < 1) {
            return null;
        }
        nodeNum--;
        TreeNode root = new TreeNode(RANDOM.nextInt(minValue, maxValue + 1));
        int mid = RANDOM.nextInt(0, nodeNum + 1);
        root.setLeft(getBinaryTree(mid, minValue, maxValue));
        root.setRight(getBinaryTree(nodeNum - mid, minValue, maxValue));
        return root;
    }

    public static TreeNode getBinarySearchTree(int nodeNum, int minValue, int maxValue) {
        Validate.inclusiveBetween(0, maxValue - 1, minValue);
        Validate.inclusiveBetween(minValue + 1, Integer.MAX_VALUE - 1, maxValue);
        if (nodeNum < 1 || maxValue - (minValue + nodeNum - 1) < 0) {
            return null;
        }
        TreeNode root = getBinaryTree(nodeNum);
        int[] values = ArrayFactory.getOrderUnrepeatedArray(nodeNum, minValue, maxValue);
        LinkedList<Integer> list = new LinkedList<>();
        for (int value : values) {
            list.add(value);
        }
        TreeUtils.fillByInOrder(root, list);
        return root;
    }

    public static TreeNode getBalancedBinaryTree(int nodeNum, int minValue, int maxValue) {
        return null;
    }
}
