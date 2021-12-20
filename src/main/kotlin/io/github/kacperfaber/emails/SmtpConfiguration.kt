package io.github.kacperfaber.emails

data class SmtpConfiguration(var host: String, var port: Int, var username: String, var password: String)