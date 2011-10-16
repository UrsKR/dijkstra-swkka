class Person {

  private final def name
  private final def friends = []

  Person(name) {
    this.name = name
  }

  void befriend(Person person) {
    friends << person
  }

  boolean knows(Person person) {
    (this == person) || (friends.contains(person))
  }

  boolean isLinkedTo(Person person) {
    def handledpersons = [this]
    knows(person) || friends[0].isLinkedTo(person, handledpersons)
  }

  private boolean isLinkedTo(Person person, handledPersons) {
    if (handledPersons.contains(this)) {
      return false
    }
    handledPersons << this
    knows(person) || friends[0].isLinkedTo(person, handledPersons) || friends[1].isLinkedTo(person, handledPersons)
  }
}