package io.github.kacperfaber.reports.tests

import com.jcraft.jsch.JSch
import io.github.kacperfaber.reports.DefaultDateTimeWriter
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test
import java.time.LocalDate
import kotlin.random.Random

class DefaultDateTimeWriter_writeDate {
    fun exec(l: LocalDate): String {
        return DefaultDateTimeWriter().writeDate(l)
    }

    @Test
    fun doesNotThrow() {
        Assertions.assertDoesNotThrow { exec(LocalDate.of(2021, 10, 18)) }
    }

    @Test
    fun startsWithYear() {
        val year = Random.nextInt(2019, 2030)
        val res = exec(LocalDate.of(year, 10, 18))
        Assertions.assertTrue(res.startsWith(year.toString()))
    }

    @Test
    fun endsWithDay() {
        val day = Random.nextInt(0, 12)
        val res = exec(LocalDate.of(2021, 10, day))
        Assertions.assertTrue(res.endsWith(day.toString()))
    }

    @Test
    fun expected() {
        val day = Random.nextInt(1, 28)
        val month = Random.nextInt(12)
        val year = Random.nextInt(2019, 2030)
        val res = exec(LocalDate.of(year, month, day))
        Assertions.assertEquals("${year}-${month}-${day}", res)
    }

    @Test
    fun testDeleteIt() {
        val lport = 8055
        val jsch = JSch()
        jsch.setKnownHosts("C:\\Users\\kacperfaber\\known_hosts_file")
        jsch.addIdentity("C:\\Users\\kacperfaber\\.ssh\\id_rsa")
        val sess = jsch.getSession("kacperfaber", "s50.mydevil.net")
        sess.setConfig("StrictHostKeyChecking", "no");
        sess.setPassword("Florka2014")
        sess.connect()
        val forwardingL = sess.setPortForwardingL(lport, "s50.mydevil.net", 22)
    }
}