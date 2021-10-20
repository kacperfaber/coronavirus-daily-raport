package io.github.kacperfaber.emails

import org.springframework.stereotype.Component

@Component
class EmailClient {
    fun send(msg: EmailMessage) {

    }

    fun sendAll(messages: Array<EmailMessage>) {
        for (x in messages) send(x)
    }
}