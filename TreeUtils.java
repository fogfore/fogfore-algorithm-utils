package com.fogfore.algorithm.utils;


import java.util.concurrent.ThreadLocalRandom;

public class TreeUtils {
    public static final int DEFAULT_NODE_NUM = 50;
    public static final int MAX_VALUE = 100;

    private static final ThreadLocalRandom RANDOM = ThreadLocalRandom.current();

    public TreeNode generateTree() {
        return generateTree(DEFAULT_NODE_NUM);
    }

    public TreeNode generateTree(int nodeNum) {
        if (nodeNum < 1) {
            return null;
        }
        nodeNum--;
        TreeNode root = new TreeNode(RANDOM.nextInt(MAX_VALUE));
        if (RANDOM.nextBoolean()) {
            root.setLeft(generateTree(nodeNum));
        }
        if (RANDOM.nextBoolean()) {
            root.setRight(generateTree(nodeNum));
        }
        return root;
    }
}
