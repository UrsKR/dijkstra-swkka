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
    knows(person) || friends[0].isLinkedTo(person, checkedPersons) || friends[1].isLinkedTo(person, checkedPersons)
  }
}