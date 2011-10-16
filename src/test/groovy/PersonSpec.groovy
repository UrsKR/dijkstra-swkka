import spock.lang.Specification

public class PersonSpec extends Specification {

  def urs = new Person(name: "Urs")
  def sandra = new Person(name: "Sandra")

  def "everyone knows himself"() {
    expect:
     urs.knows urs
  }

  def "people remember their friends"() {
    when:
     urs.befriend sandra
    then:
     urs.knows sandra
  }

  def "people are linked to their friends"() {
    when:
     urs.befriend sandra
    then:
      urs.isLinkedTo sandra
  }
}