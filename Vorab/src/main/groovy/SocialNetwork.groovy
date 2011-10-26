class SocialNetwork {

  def people = []

  void connectTo(Person person) {
    if (people.contains(person)) {
      return
    }
    people << person
    person.contributeTo this
  }

  boolean areConnected(Person origin, Person destination) {
    origin.contributeTo(this);
    people.contains destination
  }
}