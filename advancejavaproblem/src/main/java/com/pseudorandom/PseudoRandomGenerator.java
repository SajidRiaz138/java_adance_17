package com.pseudorandom;

import java.util.random.RandomGeneratorFactory;
import java.util.stream.IntStream;

public class PseudoRandomGenerator
{
    public static void main(String... args)
    {

        IntStream stream = getPseudorandom("L64X256MixRandom");
        stream.forEach(System.out::println);
    }

    public static IntStream getPseudorandom(String algorithm)
    {
        return RandomGeneratorFactory
                .of(algorithm)
                .create()
                .ints(12, 0, 100);
    }
}
