package io.github.kacperfaber.html.tests

import io.github.kacperfaber.html.ThymeleafFragment
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test
import java.util.*

class ThymeleafFragment_renderParameters_Tests {
    fun exec(f: ThymeleafFragment): String {
        return f.renderParameters()
    }

    @Test
    fun doesNotThrow() {
        Assertions.assertDoesNotThrow {
            exec(
                ThymeleafFragment(
                    "fragments",
                    "div",
                    HashMap<String, Any>().apply { put("name", "Kacper") })
            )
        }
    }

    @Test
    fun containsParameterName() {
        val name = UUID.randomUUID().toString()
        val res = exec(
            ThymeleafFragment(
                "fragments",
                "div",
                HashMap<String, Any>().apply { put(name, "Kacper") })
        )

        Assertions.assertTrue(res.contains(name))
    }

    @Test
    fun containsValue() {
        val value = UUID.randomUUID().toString()
        val res = exec(
            ThymeleafFragment(
                "fragments",
                "div",
                HashMap<String, Any>().apply { put("name", value) })
        )

        Assertions.assertTrue(res.contains(value))
    }

    @Test
    fun containsAllNames() {
        val name1 = UUID.randomUUID().toString()
        val name2 = UUID.randomUUID().toString()
        val name3 = UUID.randomUUID().toString()

        val res = exec(
            ThymeleafFragment(
                "fragments",
                "div",
                HashMap<String, Any>().apply {
                    put(name1, "")
                    put(name2, "")
                    put(name3, "")
                })
        )

        Assertions.assertTrue(res.contains(name1))
        Assertions.assertTrue(res.contains(name2))
        Assertions.assertTrue(res.contains(name3))
    }

    @Test
    fun containsAllValues() {
        val val1 = UUID.randomUUID().toString()
        val val2 = UUID.randomUUID().toString()
        val val3 = UUID.randomUUID().toString()

        val res = exec(
            ThymeleafFragment(
                "fragments",
                "div",
                HashMap<String, Any>().apply {
                    put("1", val1)
                    put("2", val2)
                    put("3", val3)
                })
        )

        Assertions.assertTrue(res.contains(val1))
        Assertions.assertTrue(res.contains(val2))
        Assertions.assertTrue(res.contains(val3))
    }

    @Test
    fun containsNameEqualQuotedValueExpression() {
        val value = UUID.randomUUID().toString()
        val name = UUID.randomUUID().toString()

        val res = exec(
            ThymeleafFragment(
                "fragments",
                "div",
                HashMap<String, Any>().apply {
                    put(name, value)
                })
        )

        Assertions.assertTrue(res.contains("${name}='${value}'"))
    }

    @Test
    fun containsParamsKeysMinusOneCommasCount() {
        val val1 = UUID.randomUUID().toString()
        val val2 = UUID.randomUUID().toString()
        val val3 = UUID.randomUUID().toString()

        val res = exec(
            ThymeleafFragment(
                "fragments",
                "div",
                HashMap<String, Any>().apply {
                    put("1", val1)
                    put("2", val2)
                    put("3", val3)
                })
        )

        Assertions.assertTrue(res.filter { x -> x == ',' }.count() == 2)
    }

    // TODO: expected() test
}