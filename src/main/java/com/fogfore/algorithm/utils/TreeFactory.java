package com.fogfore.algorithm.utils;

import java.util.concurrent.ThreadLocalRandom;

public class TreeFactory {
    public static final int DEFAULT_NODE_NUM = 50;
    public static final int MAX_VALUE = 100;

    private static final ThreadLocalRandom RANDOM = ThreadLocalRandom.current();

    public static TreeNode generateTree() {
        return generateTree(DEFAULT_NODE_NUM, MAX_VALUE);
    }

    public static TreeNode generateTree(int nodeNum) {
        return generateTree(nodeNum, MAX_VALUE);
    }

    public static TreeNode generateTree(int nodeNum, int maxValue) {
        if (nodeNum < 1) {
            return null;
        }
        nodeNum--;
        TreeNode root = new TreeNode(RANDOM.nextInt(maxValue + 1));
        if (RANDOM.nextBoolean()) {
            root.setLeft(generateTree(nodeNum, maxValue));
        }
        if (RANDOM.nextBoolean()) {
            root.setRight(generateTree(nodeNum, maxValue));
        }
        return root;
    }
}
