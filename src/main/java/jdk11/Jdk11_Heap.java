package jdk11;

/**
 * Low-Overhead Heap Profiling（低开销的 Heap Profiling）
 * 提供一种低开销的Java堆分配采样方法，得到堆分配的Java对象信息，可通过JVMTI访问。希望达到的目标如下：
 *
 * 足够低的开销，可以默认且一直开启；
 * 能通过定义好的程序接口访问；
 * 能采样所有分配；
 * 能给出生存和死亡的Java对象信息；
 * 动机
 * 对用户来说，了解它们堆里的内存是很重要的需求。目前有一些已经开发的工具，允许用户窥探它们的堆，比如：Java Flight Recorder, jmap, YourKit, 以及VisualVM tools.。但是这工具都有一个很大的缺点：无法得到对象的分配位置。headp dump以及heap histo都没有这个信息，但是这个信息对于调试内存问题至关重要。因为它能告诉开发者，他们的代码发生（尤其是坏的）分配的确切位置。
 */
public class Jdk11_Heap {
}
