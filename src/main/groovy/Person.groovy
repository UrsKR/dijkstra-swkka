class Person {

  private final List<Person> friends = []

  void befriend(Person person) {
    friends << person
  }

  boolean knows(Person person) {
    (this == person) || (friends.contains(person))
  }

  boolean isLinkedTo(Person person) {
    def checkedPersons = []
    knows(person) || isLinkedTo(person, checkedPersons)
  }

  private boolean isLinkedTo(Person person, checkedPersons) {
    if (checkedPersons.contains(this)) {
      return false
    }
    checkedPersons << this
    knows(person) || hasAFriendWhoIsLinkedTo(person, checkedPersons)
  }

  private def hasAFriendWhoIsLinkedTo(Person person, checkedPersons) {
    friends.any {Person friend ->
      friend.isLinkedTo(person, checkedPersons)
    }
  }
}