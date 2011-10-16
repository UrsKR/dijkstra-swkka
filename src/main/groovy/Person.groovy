class Person {

  private final def name
  private def friend

  Person(name) {
    this.name = name
  }

  void befriend(Person person) {
    friend = person
  }

  boolean knows(Person person) {
    (this == person) || (friend == person)
  }

  boolean isLinkedTo(Person person) {
    knows person
  }
}