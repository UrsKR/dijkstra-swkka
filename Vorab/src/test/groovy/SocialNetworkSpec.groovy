import spock.lang.Specification

class SocialNetworkSpec extends Specification {

  def network = new SocialNetwork()

  def alex = new Person()
  def bettina = new Person()
  def carsten = new Person()
  def doris = new Person()

  def "connects all members"() {
    given:
      network.connectTo alex
      network.connectTo bettina
    expect:
      network.areConnected alex, bettina
  }

   def "forces people to give up their friends"() {
    given:
      alex.befriend bettina
      bettina.befriend carsten
      network.connectTo alex
    expect:
      network.areConnected alex, carsten
  }

   def "knows who is not a member"() {
    given:
      alex.befriend bettina
      bettina.befriend carsten
      network.connectTo alex
    expect:
      !network.areConnected (alex, doris)
  }

  def "breaks up circles"() {
    given:
      alex.befriend bettina
      bettina.befriend alex
      network.connectTo alex
    expect:
     network.areConnected alex, bettina
  }

   def "connects people on first contact"() {
    given:
      alex.befriend bettina
    expect:
      network.areConnected alex, bettina
  }
}