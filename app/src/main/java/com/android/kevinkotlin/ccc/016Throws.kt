package com.android.kevinkotlin.ccc

import com.android.kevinlibrary.JavaExample


/*


@Throws
抛出一个需要检查的指针异常，java金额kotlin有关异常检查的差异让@Throws注解给解决掉了，
在编写供java开发者调用的kotlin api时，要考虑使用@Throws注解，这样，用户就知道怎么正确处理任何异常了


 */


fun main() {
    JavaExample().extendHandInFriendship()
}