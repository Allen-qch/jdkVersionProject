package jdk11;

/**
 * Epsilon: A No-Op Garbage Collector（Epsilon — 一个无操作的垃圾收集器）
 *
 * Epsilon GC（JEP 318） 是 Java 11 引入的一个实验性垃圾收集器，它的特点就是：
 * ✅ 只分配内存，不回收内存！
 * 它是一个 "No-Op GC"（无操作 GC），只负责对象分配，不进行任何形式的垃圾回收。
 *
 *
 *  1. 性能基准测试
 * 用来评估应用的 GC-free 性能上限
 * 排除 GC 影响的基准测试非常方便
 * ✅ 2. 极短生命周期应用
 * 比如 批处理程序、测试用例、一次性运行的分析工具
 * 程序跑完前不需要 GC，那就直接关闭 GC，节省开销
 * ✅ 3. GC 开发对比基准
 * GC 开发人员可以用 Epsilon 来测试其他 GC 的行为基线
 */
public class Jdk11_noOpgc {
}
