package com.example.qianhua.demo;

import com.example.qianhua.entity.User;

/**
 *  字面量：包括文本字符串、声明为final的常量值等。例如，我们在代码中直接写的数字（如123）、字符串（如"hello"）、布尔值（如true或false）等都属于字面量。
 *
 *  符号引用：包括类和接口的全限定名、字段的名称和描述符、方法的名称和描述符等。它们所代表的具体含义需要等到类加载阶段后由Java虚拟机将符号引用替换为直接引用后才会确定。
 *
 *
 *  在上述代码中，字面量有三个，分别是：
 *
 * - `private static final String aa = "AA";` 中的 `"AA"`。
 * - `private String bb = "aaa";` 中的 `"aaa"`。
 * - `private static final String aa = "AA";` 中的 `private static final String aa`，这是一个常量字段声明，其字面量值为 `"AA"`。
 *
 * 符号引用有三个，分别是：
 *
 * - `private User user;` 中的 `User`，这是一个类的引用。
 * - `private String bb = "aaa";` 中的 `String`，这也是一个类的引用。
 * - `private String cc;` 中的 `String`，这也是一个类的引用。
 */
public class ClassFileDemo {
    private static final String aa = "AA";//字面量
    private User user;
    private String bb = "aaa";//字面量

    private String cc;

    private User[] users;
}
