class Person {

  private final List<Person> friends = []

  void befriend(person) {
    friends << person
  }

  boolean knows(person) {
    (this == person) || (friends.contains(person))
  }

  boolean isLinkedTo(person) {
    new SocialNetwork().areConnected(this, person)
  }

  void contributeTo(SocialNetwork socialNetwork) {
    friends.each { Person friend ->
      socialNetwork.connectTo(friend)
    }
  }
}