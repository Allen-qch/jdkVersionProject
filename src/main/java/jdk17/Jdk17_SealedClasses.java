package jdk17;


/**
 * preview
 * Java 版本	    接口功能变化
 * Java 7	    传统接口：只能包含抽象方法和常量（public static final 字段）
 * Java 8	    重大变革：引入默认方法（default）、静态方法（static），支持函数式接口（lambda）
 * Java 9	    接口中支持 私有方法（private/private static）
 * Java 10~16	无新增接口特性，但与 lambda、var 等配合更灵活
 * Java 17	    sealed interface（密封接口）：可以限制哪些类可以实现这个接口（JEP 409）
 * Java 21+	    接口无重大新特性，但 sealed 更成熟，配合 record、pattern matching 更强大
 *
 *
 *
 * 特性:Sealed Classes（密封类）
 * Sealed Classes（密封类/接口） 是 Java 17 引入的一项重要特性（JEP 409），
 * 它允许开发者精确控制哪些类可以继承或实现某个类/接口，从而增强代码的安全性和可维护性。
 *
 * 1. 密封类的作用
 * 限制继承：明确指定哪些类可以继承当前类，防止随意扩展。
 * 增强封装性：适用于需要严格控制的类层次结构（如状态机、领域模型）。
 * 配合 instanceof 模式匹配：使编译器能更智能地检查类型覆盖。
 *
 */
public class Jdk17_SealedClasses {
    public static void main(String[] args) {
        System.out.println("**************************");
    }

    /**
     * final：不能再被继承（最严格）。
     *
     * sealed：可以继续限制子类。
     *
     * non-sealed：解除密封，允许自由继承。
     */
    public sealed class Shape permits Circle, Square, Rectangle {
        // 仅允许 Circle, Square, Rectangle 继承
    }
    public final class Circle extends Shape {}  // 禁止进一步继承

    public sealed class Square extends Shape permits ColoredSquare {}
    //此处发现如果要写出最后一个密封类，必须用final修饰该类才不会报错
    public final class ColoredSquare extends Square{}


    // 可继续密封（打破了之前的密封要求，再新写一个类时已经无需final修饰）
    public non-sealed class Rectangle extends Shape {} // 允许任意继承
    public  class RectangleSub extends Rectangle {}

    public sealed interface Animal permits Dog, Cat, Bird  {
        void makeSound();
    }
    // 此处Dog实现该密封接口,也需要用final修饰才行
    public final class Dog implements Animal {
        @Override public void makeSound() { System.out.println("Woof!"); }
    }
    // 此处Dog实现该密封接口,也需要用final修饰才行
    public sealed class Cat implements Animal permits CatSub{
        @Override public void makeSound() { System.out.println("Woof!"); }
    }
    // 同上，此处Cat又弄了一个密封类，此时，CatSub需要继续用final修饰才不会使Cat与CatSub报错
    public final class CatSub extends Cat {}

    // 允许任意继承，使用non-sealed打破了原来的final修饰，此时Bird可以被任意继承了
    public non-sealed class Bird implements Animal {
        @Override public void makeSound() { System.out.println("B*****!"); }
    }

    sealed interface TrafficLight permits RedLight, YellowLight, GreenLight {}

    final class RedLight implements TrafficLight {}
    final class GreenLight implements TrafficLight {}
    final class YellowLight implements TrafficLight {}

}
