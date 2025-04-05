package jdk17;


/**
 * preview:
 *                  《表达式》                                 《语句》
 * 定义              会产生值的代码片段                           执行某个操作的完整代码
 * 是否有返回值        有                                        一般没有（或不是重点）
 * 示例               3 + 5, x > y, "Hello" + name             int a = 3 + 5;, if (...) { ... }
 * 是否以分号结束       否（但表达式语句需要）                       是（除了控制语句块）
 *
 *下面的两个方法不一样的地方显而易见：
 * 表达式直接return
 * 语句是借用新定义的变量作为返回值
 *
 *
 * 特性:全新的switch表达式（以前的是switch语句）【 JDK 14+支持，但jdk17是lts版本】
 * 在 Java12 的时候就引入了switch表达式，注意这里是《表达式》，而不是《语句》，原来的switch是语句。
 * 主要的差别就是就是表达式有返回值，而语句则没有。
 * 再配合模式匹配，以及yield和“->”符号的加入，全新的switch用起来爽到飞起来。
 *
 *
 */
public class Jdk17_NewSwitch {

    public static void main(String[] args) {
        System.out.println(getByJDK8(Week.TUESDAY));
        System.out.println("**************************");
        System.out.println(getByJDK17(Week.TUESDAY));
    }

    /**
     * 在JDK8中获取switch返回值方式
     *
     * @param week
     * @return
     */
    public static int getByJDK8(Week week) {
        int i = 0;
        switch (week) {
            case MONDAY, TUESDAY:
                i = 1;
                break;
            case WEDNESDAY:
                i = 3;
                break;
            case THURSDAY:
                i = 4;
                break;
            case FRIDAY:
                i = 5;
                break;
            case SATURDAY:
                i = 6;
                break;
            case SUNDAY:
                i = 7;
                break;
            default:
                i = 0;
                break;
        }

        return i;
    }

    /**
     * 在JDK17中获取switch返回值
     *
     * @param week
     * @return
     */
    public static int getByJDK17(Week week) {
        // 1, 现在的switch变成了表达式，可以返回值了，而且支持yield和->符号来返回值
        // 2, 再也不用担心漏写了break，而导致出问题了
        // 3, case后面支持写多个条件
        return switch (week) {
            case MONDAY -> 1;
            case TUESDAY -> 2;
            case WEDNESDAY -> 3;
            case THURSDAY -> {yield 4;}
            case FRIDAY -> 5;
            case SATURDAY, SUNDAY -> 6;
            default -> 0;
        };
    }

    private enum Week {
        MONDAY,
        TUESDAY,
        WEDNESDAY,
        THURSDAY,
        FRIDAY,
        SATURDAY,
        SUNDAY
    }
}
