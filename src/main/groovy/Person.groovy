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

  private boolean isLinkedTo(person, checkedPersons) {
    if (checkedPersons.contains(this)) {
      return false
    }
    checkedPersons << this
    knows(person) || hasAFriendWhoIsLinkedTo(person, checkedPersons)
  }

  private boolean hasAFriendWhoIsLinkedTo(person, checkedPersons) {
    friends.any {Person friend ->
      friend.isLinkedTo(person, checkedPersons)
    }
  }

  void contributeTo(SocialNetwork graphOfConnections) {
    friends.each { Person friend ->
      graphOfConnections.connectTo(friend)
    }
  }
}