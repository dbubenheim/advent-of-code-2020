package advent.of.code

fun String.toURL() = ClassLoader.getSystemResource(this).file

inline fun <reified T : Enum<T>> enumContains(name: String?): Boolean {
    return enumValues<T>().any { it.name == name}
}