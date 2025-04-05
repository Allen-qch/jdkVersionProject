package jdk11;

/**
 *  HTTP Client (Standard)（标准HTTP客户端）
 *
 *  将JDK9引进并孵化的HTTP客户端API作为标准，即HTTP/2 Client。它定义了一个全新的实现了HTTP/2和WebSocket的HTTP客户端API，并且可以取代HttpURLConnection。
 * 动机
 * 已经存在的HttpURLConnection有如下问题:
 * 在设计时考虑了多种协议，但是现在几乎所有协议现已不存在。
 * API早于HTTP/1.1并且太抽象；
 * 使用很不友好；
 * 只能以阻塞模式工作；
 * 非常难维护；
 *
 * Java 11 引入的标准 HttpClient
 * 是一个支持同步、异步、HTTP/1.1 和 HTTP/2 的现代 HTTP 客户端 API，替代老旧的 HttpURLConnection。
 *
 * 所在包：
 * import java.net.http.*;
 * import java.net.URI;
 */
public class Jdk11_Http {
}
