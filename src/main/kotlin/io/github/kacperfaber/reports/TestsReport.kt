package io.github.kacperfaber.reports

@Suppress("unused")
class TestsReport {
    var infections: Int = 0
    var deaths: DeathReport? = null
    var recovered: Int = 0
    var tests: CovidTestsReport? = null
}