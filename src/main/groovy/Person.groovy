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
    (this == person) || (friends.contains (person))
  }

  boolean isLinkedTo(Person person) {
    (knows (person)) || friends[0].knows(person)
  }
}