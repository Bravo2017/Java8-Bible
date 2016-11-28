package com.example.lambda;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Predicate;

/**
 *
 * @author MikeW
 */
public class TestCriteria {

  private final Map<String, Predicate> searchMap = new HashMap<>();

  private TestCriteria() {
    super();
    initSearchMap();
  }

  private void initSearchMap() {
    Predicate<Person> allDrivers = p -> p.getAge() >= 16;
    Predicate<Person> allDraftees = p -> p.getAge() >= 18 && p.getAge() <= 25 && p.getGender() == Gender.MALE;
    Predicate<Person> allPilots = p -> p.getAge() >= 23 && p.getAge() <= 65;

    searchMap.put("allDrivers", allDrivers);
    searchMap.put("allDraftees", allDraftees);
    searchMap.put("allPilots", allPilots);

  }

  public Map<String, Predicate> getSearchMap() {
     return Collections.unmodifiableMap(searchMap);
  }

  public static TestCriteria getInstance() {
    return new TestCriteria();
  }
}
