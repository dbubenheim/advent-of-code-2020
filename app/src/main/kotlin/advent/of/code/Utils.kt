package advent.of.code

class Utils {
}

fun String.toURL(): String  {
    return Day04::class.java.classLoader.getResource(this).file
}