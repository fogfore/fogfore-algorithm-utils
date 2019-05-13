package com.fogfore.algorithm.utils;

import java.util.concurrent.ThreadLocalRandom;

public class RandomUtils {
    private final ThreadLocalRandom RANDOM = ThreadLocalRandom.current();

    @SuppressWarnings("unchecked")
    public <T> T getRandomValue(Class<T> clazz) {
        if (clazz == Integer.class || clazz == int.class) {
            return (T) Integer.valueOf(RANDOM.nextInt());

        }
        return null;
    }
}
