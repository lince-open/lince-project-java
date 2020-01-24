package work.lince.project

import groovyx.net.http.ContentType
import groovyx.net.http.RESTClient
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.boot.web.server.LocalServerPort
import spock.lang.Shared
import spock.lang.Specification
import spock.lang.Unroll

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class LinceBasicFunctionalSpec extends Specification {

    @Shared
    RESTClient client

    @LocalServerPort
    int port;

    def setup() {
        client = new RESTClient("http://localhost:${port}/internal")
        client.contentType = ContentType.JSON
    }

    @Unroll
    def "health Success user: #user"() {

        when:
            def result = client.get(path: "internal/health", headers: ["lince.user.name": user])

        then:
            result != null
            result.data.status == "UP"


        where:
            user       | expectedUser
            null       | "anonymous"
            "zzz"      | "zzz"
            "asdf1234" | "asdf1234"

    }

    @Unroll
    def "info Success user: #user"() {

        when:
            def result = client.get(path: "internal/info", headers: ["lince.user.name": user])

        then:
            result != null
            result.data.hostName == expectedHost
            result.data.now != null
            result.data.startupDate != null
            result.data.user == expectedUser

            result.headers.'host-name' == expectedHost

        where:
            user       || expectedUser | expectedHost
            null       || "anonymous"  | 'lince-test-host'
            "zzz"      || "zzz"        | 'lince-test-host'
            "asdf1234" || "asdf1234"   | 'lince-test-host'

    }


}