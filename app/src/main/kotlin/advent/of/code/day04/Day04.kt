package advent.of.code.day04

import advent.of.code.enumContains
import advent.of.code.toURL
import com.google.common.base.Splitter
import java.io.File

class Day04 {

    companion object {

        @JvmStatic
        fun passportProcessing(validator : (Map<String, Any>) -> Validator) : Long {

            val splitter = Splitter.on(" ").withKeyValueSeparator(":")
            val map : MutableMap<String, String> = mutableMapOf()
            var count = 0L

            File("day04/input-day04.txt".toURL()).forEachLine { line ->
                if (line.isBlank()) {
                    val wrapper = validator(map)
                    if (wrapper.isValid()) count++
                    map.clear()
                } else {
                    map.putAll(splitter.split(line))
                }
            }
            return count
        }

        @JvmStatic
        fun main(args: Array<String>) {
            println(passportProcessing(::ValidatorPart1))
            println(passportProcessing(::ValidatorPart2))
        }
    }
}

class ValidatorPart1(fields: Map<String, Any?>) : Validator {

    private val defaultMap = fields.withDefault { null }

    private val byr : String? by defaultMap // (Birth Year)
    private val iyr : String? by defaultMap // (Issue Year)
    private val eyr : String? by defaultMap // (Expiration Year)
    private val hgt : String? by defaultMap // (Height)
    private val hcl : String? by defaultMap // (Hair Color)
    private val ecl : String? by defaultMap // (Eye Color)
    private val pid : String? by defaultMap // (Passport ID)
    private val cid : String? by defaultMap // (Country ID)

    override fun isValid() = byr != null
            && iyr != null
            && eyr != null
            && hgt != null
            && hcl != null
            && ecl != null
            && pid != null
}

class ValidatorPart2(fields: Map<String, Any?>) : Validator {

    private val defaultMap = fields.withDefault { null }

    private val byr : String? by defaultMap // (Birth Year)
    private val iyr : String? by defaultMap // (Issue Year)
    private val eyr : String? by defaultMap // (Expiration Year)
    private val hgt : String? by defaultMap // (Height)
    private val hcl : String? by defaultMap // (Hair Color)
    private val ecl : String? by defaultMap // (Eye Color)
    private val pid : String? by defaultMap // (Passport ID)
    private val cid : String? by defaultMap // (Country ID)

    private fun isValidByr() = byr?.toIntOrNull() in 1920..2002
    private fun isValidIyr() = iyr?.toIntOrNull()  in 2010..2020
    private fun isValidEyr() = eyr?.toIntOrNull()  in 2020..2030
    private fun isValidHcl() = hcl?.matches(Regex("#[0-9a-f]{6}")) ?: false
    private fun isValidEcl() = ecl != null && enumContains<EyeColor>(ecl)
    private fun isValidPid() = pid?.matches(Regex("[0-9a-f]{9}")) ?: false

    private fun isValidHgt(): Boolean {
        val temp = hgt ?: return false
        val unit = temp.takeLast(2)
        val height = temp.substring(0, temp.length - 2)
        when (unit) {
            "cm" -> return height.toInt() in 150..193
            "in" -> return height.toInt() in 59..76
        }
        return false
    }

    override fun isValid() = isValidByr()
            && isValidIyr()
            && isValidEyr()
            && isValidHgt()
            && isValidHcl()
            && isValidEcl()
            && isValidPid()
}

interface Validator {
    fun isValid(): Boolean
}

enum class EyeColor {
    amb,
    blu,
    brn,
    gry,
    grn,
    hzl,
    oth
}