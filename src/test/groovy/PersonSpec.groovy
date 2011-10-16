import spock.lang.Specification

public class PersonSpec extends Specification {

  def alex = new Person(name: "Alex")
  def bettina = new Person(name: "Bettina")
  def carsten = new Person(name: "Carsten")

  def "everyone knows himself"() {
    expect:
     alex.knows alex
  }

  def "people remember their friends"() {
    when:
     alex.befriend bettina
    then:
     alex.knows bettina
  }

  def "people are linked to their friends"() {
    when:
     alex.befriend bettina
    then:
      alex.isLinkedTo bettina
  }

  /*def "people you know link you to other people"(){
    when:
      alex.befriend bettina
      bettina.befriend carsten
    then:
      alex.isLinkedTo carsten
  }  */
}