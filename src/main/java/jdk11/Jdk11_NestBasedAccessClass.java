package jdk11;

/**
 * Nest-Based Access Control（基于嵌套的访问控制）
 *
 * 引入的一项语言层面的新机制，主要用于解决 嵌套类（Nested Class）之间访问私有成员 的安全和性能问题。
 *
 * 什么是嵌套类（Nested Class）嵌套类是写在另一个类里面的类
 * public class Outer {
 *     private int secret = 42;
 *
 *     class Inner {
 *         void printSecret() {
 *             System.out.println(secret);  // 访问外部类的私有字段
 *         }
 *     }
 * }
 *
 *
 * 在 Java 11 之前，为了让嵌套类访问彼此的 private 成员，编译器会生成桥接方法（synthetic methods） 来绕开 JVM 的访问控制。
 * // Java 编译器生成的代码（简化示例）：
 * int access$000(Outer outer) {
 *     return outer.secret;
 * }
 * 这种做法：
 * 会生成额外的字节码，增加体积
 * 安全上有风险（这些桥接方法是 public 的）
 * JVM 和工具（如反射）处理起来更麻烦
 *
 *
 * Java 11 开始：基于嵌套的访问控制（Nest-Based Access Control）
 * ✅ 定义
 * JVM 允许同一个 Nest（嵌套组）中的类直接访问彼此的 private 成员，不再需要生成桥接方法。
 * ✅ 组成一个 Nest 的条件：
 * 一组类在同一个 .java 文件中定义
 * 编译后属于 同一个 Nest 主类（Nest Host）
 *
 * 编译器会在字节码里加上：
 * NestHost 属性（主类）
 * NestMembers 属性（子类）
 * JVM 利用这些新属性决定是否允许访问 private 成员。
 *
 *
 *
 *
 */
public class Jdk11_NestBasedAccessClass {
    private int secret = 42;

    class Inner {
        void show() {
            System.out.println(secret); // 直接访问 outer 的 private 字段
        }
    }
}
