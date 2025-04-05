package jdk17;


/**
 * 特性:文本块【Java 15 正式，17 通用】
 * 在没有这个特性之前，编写长文本非常痛苦。
 * 虽然 IDEA 等集成开发工具可以自动处理，但最终效果仍然丑陋，充满《拼接符号》。
 * 现在，通过字符串块，我们可以轻松编写JSON、HTML、SQL等内容，效果更清爽。
 *
 *
 */
public class Jdk17_NewHtml {
    public static void main(String[] args) {
        System.out.println(getHtmlJDK8());
        System.out.println("**************************");
        System.out.println(getHtmlJDK17());
    }

    /**
     * 使用JDK8返回HTML文本
     *
     * @return 返回HTML文本
     */
    public static final String getHtmlJDK8() {
        return "<html>\n" +
                " <body>\n" +
                " <p>Hello, world</p>\n" +
                " </body>\n" +
                "</html>";
    }
    /**
     * 使用JDK17返回HTML文本
     * @return 返回HTML文本
     */
    public static final String getHtmlJDK17() {
        return """
        <html>
        <body>
        <p>Hello, world</p>
        </body>
        </html>
        """;
    }

}
