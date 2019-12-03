package work.lince.project.service

import spock.lang.Ignore
import spock.lang.Specification
import spock.lang.Unroll
import work.lince.project.repository.ProjectRepository
@Ignore
class ProjectServiceSpec extends Specification {

    ProjectService service;

    def setup() {
        service = Spy(ProjectService)
        service.repository = Mock(ProjectRepository)
    }

    @Unroll
    def "verify with #value"() {
        given:
            service.repository.findByValue(_) >> {
                Optional.empty()
            }

        when:
            def result = service.analyze(value)

        then:
            result == expected

        where:
            value      || expected
            "{"        || -1
            "{{}"      || -1
            "}"        || -1
            "}}{"      || -1
            "{}}"      || -1
            "{ }"      || -1
            "{}a"      || -1
            "{} "      || -1
            ""         || 0
            "{}"       || 0
            "{}{}"     || 0
            "{{}}"     || 0
            "{{}{}}"   || 0
            "}}"       || 1
            "{{{}"     || 1
            "{{{{{}"   || 2
            "{{{{"     || 2
            "}}}}"     || 2
            "}{}{}{}{" || 2
            "}{"       || 2
            "}{{{"     || 3
            "}{{{{{"   || 4

    }

}