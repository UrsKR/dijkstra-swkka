import spock.lang.Specification

public class PersonSpec extends Specification {

  def alex = new Person()
  def bettina = new Person()
  def carsten = new Person()
  def doris = new Person()

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

  def "people have more than one friend"() {
    when:
      alex.befriend bettina
      alex.befriend carsten
    then:
      alex.knows bettina
  }

  def "people are linked to their friends"() {
    when:
      alex.befriend bettina
    then:
      alex.isLinkedTo bettina
  }

  def "people you know link you to other people"() {
    when:
      alex.befriend bettina
      bettina.befriend carsten
    then:
      alex.isLinkedTo carsten
  }

  def "a dead end does not hinder a link"() {
    when:
      alex.befriend bettina
      bettina.befriend carsten
      bettina.befriend doris
    then:
      alex.isLinkedTo doris
  }

  def "circular links don't crash the evaluation"(){
    when:
      alex.befriend bettina
      bettina.befriend alex
      bettina.befriend carsten
      carsten.befriend doris
    then:
      alex.isLinkedTo doris
  }
}