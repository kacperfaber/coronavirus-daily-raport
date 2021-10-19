package io.github.kacperfaber.api

interface EmailRepository {
    fun getEmailAddresses(): Array<String>
}