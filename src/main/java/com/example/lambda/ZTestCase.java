package com.example.lambda;

import java.util.List;
import java.util.function.Predicate;

/**
 *
 * @author MikeW
 */
public class ZTestCase {
  
  public static void main(String[] args) {
    List<Person> pl = Person.createShortList();
    
    TestCriteria search = TestCriteria.getInstance();
    Predicate<Person> allDraftees = search.getSearchMap().get("allDraftees");
    
    
    System.out.println("\n=== Western Pilot Phone List ===");
    
    pl.stream().filter(allDraftees)
      .forEach(p -> { 
        p.printl(p.getPrintStyle("westernNameAgePhone"));
    });
    
    /*
    System.out.println("\n=== Gangnam Draftee Phone List ===");
    pl.stream().filter(search.getSearchMap().get("allDraftees"))
      .forEach(p -> { 
        p.printl(p.getPrintMap().get("gangnamNameAgePhone"));
      });
    
    */
    
  }

}
