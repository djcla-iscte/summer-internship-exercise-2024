package com.premiumminds.internship.teknonymy;

import com.premiumminds.internship.teknonymy.Person;

class TeknonymyService implements ITeknonymyService {

  /**
   * Method to get a Person Teknonymy Name
   * 
   * @param Person perspackage com.premiumminds.internship.teknonymy;

import java.time.LocalDateTime;

class TeknonymyService implements ITeknonymyService {

  /**
   * Method to get a Person Teknonymy Name
   * 
   * @param Person person
   * @return String which is the Teknonymy Name 
   * 
   *
   */
	
    private String[] oldest = { null };
    private LocalDateTime oldestBirth =  null ;
    private int distance =  -1 ;
    
    
  public String getTeknonymy(Person person) {
    if (person.children() == null || person.children().length == 0) {
      return "";
    }


    findName(person, 0, oldest, oldestBirth, distance);

    if (oldest[0] == null) {
      return "";
    }

    String teknonymy = "";
    switch (person.sex()) {
      case 'M':
        teknonymy = "father of " + oldest[0];
        break;
      case 'F':
        teknonymy = "mother of " + oldest[0];
        break;
      default:
        return "";
    }

    int generation = distance;
    if (generation > 1) {
      teknonymy = (person.sex() == 'M' ? "grandfather of " : "grandmother of ") + oldest[0];
      for (int i = 2; i < generation; i++) {
        teknonymy = "great-" + teknonymy;
      }
    }

    return teknonymy;
  }

  // usar de forma recursiva de modo a conseguir explorar a arvore
  private void findName(Person person, int currentDistance, String[] oldest, LocalDateTime oldestBirth,int distance) {
	  
    if (person.children() == null || person.children().length == 0 ) {
      return;
    }

    for (Person child : person.children()) {
      int childDistance = currentDistance + 1;

      if (distance < childDistance || (distance == childDistance && (oldestBirth == null || child.dateOfBirth().isBefore(oldestBirth)))) {
        this.oldest[0] = child.name();
        this.oldestBirth = child.dateOfBirth();
        this.distance = childDistance;
      }

      findName(child, childDistance, oldest, oldestBirth, distance);
    }
  }
}
on
   * @return String which is the Teknonymy Name 
   */
  public String getTeknonymy(Person person) {
    throw new RuntimeException("Not Implemented Yet");
  };
}
