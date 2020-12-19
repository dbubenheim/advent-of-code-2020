package advent.of.code

fun String.toURL(): String  {
    return ClassLoader.getSystemResource(this).file
}

inline fun <reified T : Enum<T>> enumContains(name: String?): Boolean {
    return enumValues<T>().any { it.name == name}
}