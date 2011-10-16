import spock.lang.Specification

public class PersonSpec extends Specification {

    def "everyone knows himself"(){
      given:
           def urs = new Person(name: "Urs")
      expect:
          urs.knows urs
    }

    def "people remember their friends"() {
        given:
           def urs = new Person(name: "Urs")
           def sandra = new Person(name: "Sandra")
        when:
           urs.befriend sandra
        then:
          urs.knows sandra
    }
}
