package jdk11;

/**
 * Dynamic Class-File Constants（动态类文件常量）
 * Java的类型文件格式将被拓展，支持一种新的常量池格式：CONSTANT_Dynamic，加载CONSTANT_Dynamic会将创建委托给bootstrap方法。
 * 目标
 * 其目标是降低开发新形式的可实现类文件约束带来的成本和干扰。
 *
 * 在 Java 中，每个 .class 文件中都包含一个常量池（constant pool），用于存储：
 * 字面量（如字符串、整数）
 * 类名、方法名、字段名
 * 方法/字段的描述符
 * 类型信息（如 CONSTANT_Class, CONSTANT_Methodref 等）
 * 传统上，这些常量都是 编译期静态写死的。
 *  让某些常量可以在运行时由引导方法（bootstrap method）计算得出，而不是在编译时静态写入。
 *
 */
public class Jdk11_DynamicClassFileConstants {

    //假设我们定义了一个“动态生成的字符串常量”：

    static final String MSG = "hello".toUpperCase();
   // 如果这个常量是通过 invokedynamic 的引导方法生成的，字节码中将不会看到 "HELLO" 的字面量,
   // 而是看到一个 CONSTANT_Dynamic，它会告诉 JVM;
   // 当我需要用这个常量时，请调用这个 bootstrap 方法，生成它。
}
