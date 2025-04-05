package jdk11;

import java.util.ArrayList;
import java.util.List;

/**
 * Local-Variable Syntax for Lambda Parameters（用于 Lambda 参数的局部变量语法）
 * 在声明隐式类型的lambda表达式的形参时允许使用var。
 * 动机
 * lamdba表达式可能是隐式类型的，它形参的所有类型全部靠推到出来的。隐式类型lambda表达式如下：
 * <p>
 * 在 Lambda 表达式的参数中，可以使用 var 关键字，从而让 Lambda 的参数看起来更像“普通局部变量”，也允许加注解。
 * Java 11 开始，Lambda 表达式参数支持 var 关键字，这不仅统一了语法风格，还允许添加注解，让 Lambda 更灵活、更现代。
 */
public class Jdk11_Var {
    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        list.add("11");
        list.add("22");
        list.forEach((String s) -> System.out.println(s)); // 显式类型
        list.forEach(s -> System.out.println(s));          // 推断类型
        // jdk11支持下面这个写法
       // list.forEach((var s) -> System.out.println(s));    // 新功能✅ OK！
    }
}
