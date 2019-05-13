package com.fogfore.algorithm.utils;

import java.util.concurrent.ThreadLocalRandom;

public class TreeUtils {
    public static final int DEFAULT_NODE_NUM = 50;


    public <T> TreeNode<T> generateTree(Class<T> clazz) {
        return generateTree(clazz, DEFAULT_NODE_NUM);
    }

    public <T> TreeNode<T> generateTree(Class<T> clazz, int nodeNum) {
        if (nodeNum < 1) {
            return null;
        }
//        random.next
        return null;
    }

}
