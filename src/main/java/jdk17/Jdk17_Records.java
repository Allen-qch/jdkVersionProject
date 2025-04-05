package jdk17;


/**
 * 特性:Records（记录类）【Java 14 引入，17 稳定】
 * 在Java中，POJO对象（如DO、PO、VO、DTO等）通常包含成员变量及相应的Getter和Setter方法。
 * 尽管可以通过工具或IDE生成这些代码，但修改和维护仍然麻烦。
 * Lombok 插件为此出现，能够在编译期间自动生成Getter、Setter、hashcode、equals和构造函数等代码，使用起来方便，但对团队有依赖要求。
 * 为此，Java引入了标准解决方案：Records。它通过简洁的语法定义数据类，大大简化了POJO类的编写，如下所示。
 * 虽然hashcode和equals方法仍需手动编写，但IDE能够自动生成。这一特性有效解决了模板代码问题，提升了代码整洁度和可维护性。
 *
 *
 *
 * 在 Java 17 中，record 是一种新的数据结构类型，首次在 Java 14 作为预览功能引入，后来在 Java 16 正式成为语言特性。record 主要用于定义不可变的数据载体（immutable data carrier），它类似于普通的类，但具有更多的简洁特性。
 *
 * 🚀 核心特点：
 * 自动生成方法：
 * toString()：自动生成字符串表示，包含所有字段。
 * equals() 和 hashCode()：基于所有字段自动生成，确保数据一致性。
 * getter 方法：为每个字段自动生成访问器，字段名即方法名。
 *
 * 不可变性：
 * 所有字段都是 final，一旦创建，值不能更改。
 * 不允许定义 setter 方法。
 *
 * 简洁的语法：
 * 不需要编写冗长的构造函数、getter、toString 等代码。
 */
public class Jdk17_Records {
    public static void main(String[] args) {

    }

    /**
     * @param stuId     学生ID
     * @param stuName   学生名称
     * @param stuAge    学生年龄
     * @param stuGender 学生性别
     * @param stuEmail  学生邮箱
     */
    public record StudentRecord(Long stuId,
                                String stuName,
                                int stuAge,
                                String stuGender,
                                String stuEmail) {
        public StudentRecord {
            System.out.println("构造函数");
        }

        public static void main(String[] args) {
            StudentRecord record = new StudentRecord(1L, "张三", 16, "男", "xxx@qq.com");
            System.out.println(record);
        }
    }

}
