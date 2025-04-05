package jdk17;


import java.util.random.RandomGenerator;
import java.util.random.RandomGeneratorFactory;

/**
 * 特性:增强的伪随机数生成器
 * JDK 17 之前，我们可以借助 Random、ThreadLocalRandom和SplittableRandom来生成随机数。不过，这 3 个类都各有缺陷，且缺少常见的伪随机算法支持。
 * Java 17 为伪随机数生成器 （pseudorandom number generator，PRNG，又称为确定性随机位生成器）增加了新的接口类型和实现，使得开发者更容易在应用程序中互换使用各种 PRNG 算法。
 *PRNG 用来生成接近于绝对随机数序列的数字序列。
 * 一般来说，PRNG 会依赖于一个初始值，也称为种子，来生成对应的伪随机数序列。
 * 只要种子确定了，PRNG 所生成的随机数就是完全确定的，因此其生成的随机数序列并不是真正随机的。
 *
 *
 */
public class Jdk17_RandomGeneratorFactory {
    public static void main(String[] args) {
        RandomGeneratorFactory<RandomGenerator> l128X256MixRandom = RandomGeneratorFactory.of("L128X256MixRandom");
        // 使用时间戳作为随机数种子
        RandomGenerator randomGenerator = l128X256MixRandom.create(System.currentTimeMillis());
        // 生成随机数
        randomGenerator.nextInt(10);
        System.out.println(randomGenerator);

    }
}
