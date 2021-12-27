package io.github.kacperfaber.thymeleaf.tests

import io.github.kacperfaber.thymeleaf.SignedImageElement
import org.jsoup.Jsoup
import org.jsoup.safety.Safelist
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertDoesNotThrow
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.CsvSource
import org.junit.jupiter.params.provider.ValueSource
import java.util.*
import kotlin.test.assertEquals
import kotlin.test.assertNotEquals
import kotlin.test.assertTrue

@DisplayName("SignedImageElement.render()")
class SignedImageElement_render_Tests {
    fun exec(e: SignedImageElement) = e.render()
    
    @Test
    fun doesNotThrow() {
        val e = SignedImageElement("", "", 600, 400)
        assertDoesNotThrow { exec(e) }
    }

    @Test
    fun notEmpty() {
        val e = SignedImageElement("", "", 600, 400)
        assertNotEquals("", exec(e))
    }

    @Test
    fun htmlIsValid() {
        val res = exec(SignedImageElement("", "", 600, 400))
        Jsoup.isValid(res, Safelist.basic())
    }

    @ParameterizedTest
    @ValueSource(strings = ["width", "height", "src"])
    fun imgElementHasAttributes(attr: String) {
        val res = exec(SignedImageElement("", "", 600, 400))
        Jsoup.parse(res).getElementsByTag("img").hasAttr(attr)
    }

    @ParameterizedTest
    @CsvSource("img, width, 600", "img, height, 400", "img, src, hello-world")
    fun hasAttributesWithValue(tagName: String, attr: String, value: Any) {
        val res = exec(SignedImageElement("", "hello-world", 600, 400))
        assertEquals(value, Jsoup.parse(res).getElementsByTag("img").attr(attr))
    }

    @ParameterizedTest
    @ValueSource(strings = ["img", "h3"])
    fun hasElements(tag: String) {
        val res = exec(SignedImageElement("", "", 600, 400))
        assertTrue(Jsoup.parse(res).getElementsByTag(tag).isNotEmpty())
    }

    @Test
    fun h3ElementHasInnerTextEqualsToTitle() {
        val expected = UUID.randomUUID().toString()
        val res = exec(SignedImageElement(expected, "", 600, 400))
        val text = Jsoup.parse(res).tagName("h3").text()
        assertEquals(expected, text)
    }
}