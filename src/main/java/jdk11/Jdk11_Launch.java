package jdk11;

/**
 * Launch Single-File Source-Code Programs（启动单一文件的源代码程序）
 * 增强Java启动器支持运行单个Java源代码文件的程序。
 *
 * 动机
 * 单文件程序是指整个程序只有一个源码文件，通常是早期学习Java阶段，或者写一个小型工具类。以HelloWorld.java为例，运行它之前需要先编译。我们希望Java启动器能直接运行这个源码级的程序：
 *
 * java HelloWorld.java
 * 等价于：
 *
 * javac -d <memory> HelloWorld.java
 * java -cp <memory> helloWorld
 * java Factorial.java 3 4 5
 * 等价于：
 *
 * javac -d <memory> Factorial.java
 * java -cp <memory> Factorial 3 4 5
 * 到JDK10为止，Java启动器能以三种方式运行：
 *
 * 启动一个class文件；
 * 启动一个JAR中的main方法类；
 * 启动一个模块中的main方法类；
 * JDK11再加一个，即第四种方式：启动一个源文件申明的类。
 */
public class Jdk11_Launch {
}
