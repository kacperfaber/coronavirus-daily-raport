package io.github.kacperfaber

import com.jcraft.jsch.JSch
import org.springframework.beans.factory.annotation.Value
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

@Configuration
open class SshTunnelBean {
    @Value("\${ssh.forwardingPort}")
    var forwardingPort: Int = -1

    @Value("\${ssh.port:22}")
    var port: Int = -1

    @Value("\${ssh.host}")
    lateinit var host: String

    @Value("\${ssh.username}")
    lateinit var username: String

    @Value("\${ssh.password}")
    lateinit var password: String

    @Value("\${ssh.knownHostsFile}")
    lateinit var knownHostsFile: String

    @Value("\${ssh.privateKey}")
    lateinit var privateKey: String

    @Value("\${ssh.remotePort:3306}")
    var remotePort: Int = 3306

    @Bean
    open fun makeTunnel(): SshTunnel {
        val jsch = JSch()
        jsch.setKnownHosts(knownHostsFile)
        jsch.addIdentity(privateKey)
        val sess = jsch.getSession(username, host, port)
        sess.setPassword(password)
        sess.connect()
        val forwardingL = sess.setPortForwardingL(forwardingPort, host, remotePort)
        return SshTunnel()
    }
}