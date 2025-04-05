package jdk17;


import java.util.List;

/**
 * 特性:NullPointerException 增强（JDK 14+支持，但dk17是lts版本）
 * 空指针异常（NPE）一直是Java程序员的痛点，
 * 因为报错信息无法直观地指出哪个对象为空，只抛出一个 NullPointerException 和一堆堆栈信息，
 * 定位问题耗时且麻烦。尤其在遇到喜欢级联调用的代码时，逐行排查更是令人头疼。
 * Java17 终于在这方面取得了突破，提供了更详细的空指针异常信息，帮助开发者迅速定位问题源头。
 *
 *
 */
public class Jdk17_NullPointerEnhancedException {
    public static void main(String[] args) {
        try {
            //简单的空指针
            String str = null;
            str.length();
        } catch (Exception e) {
            e.printStackTrace();
        }

        System.out.println("***************************");
        System.out.println("***************************");
        System.out.println("***************************");
        try {
            //复杂一点的空指针
            var arr = List.of(null);
            String str = (String)arr.get(0);
            str.length();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
