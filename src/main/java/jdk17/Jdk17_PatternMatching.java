package jdk17;


/**
 * 特性:模式匹配（一种是instance of（16预览，17正式） 另一种是switch（17预览，21正式））
 * 在JDK 17中，模式匹配主要用于instanceof表达式。
 * 模式匹配增强了instanceof的语法和功能，使类型检查和类型转换更加简洁和高效。
 * 在传统的Java版本中，我们通常使用instanceof结合类型转换来判断对象类型并进行处理，这往往会导致冗长的代码。
 * <p>
 * 到了17无需再新申明一个对象后再调用
 */
public class Jdk17_PatternMatching {
    public static void main(String[] args) {
        matchByJDK8("ss");
        System.out.println("**************************");
        matchByJDK17("pp");
    }

    /**
     * 旧式写法
     *
     * @param value
     */
    public static void matchByJDK8(Object value) {
        if (value instanceof String) {
            String v = (String) value;// 需要显式类型转换
            System.out.println("遇到一个String类型" + v.toUpperCase());
        } else if (value instanceof Integer) {
            Integer v = (Integer) value;
            System.out.println("遇到一个整型类型" + v.longValue());
        }
    }

    /**
     * 转换并申请了一个新的变量，极大地方便了代码的编写
     *
     * @param value
     */
    public static void matchByJDK17(Object value) {
        if (value instanceof String v) {// v直接转换为String
            System.out.println("遇到一个String类型" + v.toUpperCase());
        } else if (value instanceof Integer v) {
            System.out.println("遇到一个整型类型" + v.longValue());
        }
    }

}
