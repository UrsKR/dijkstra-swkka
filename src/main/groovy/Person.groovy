class Person {

  private final List<Person> friends = []

  void befriend(person) {
    friends << person
  }

  boolean knows(person) {
    (this == person) || (friends.contains(person))
  }

  boolean isLinkedTo(person) {
    def checkedPersons = []
    knows(person) || isLinkedTo(person, checkedPersons)
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
}