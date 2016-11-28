package com.example.lambda;

import java.util.List;

/**
 *
 * @author MikeW
 */
public class Test02Filter {
  
  public static void main(String[] args) {

    List<Person> pl = Person.createShortList();
    
    SearchCriteria search = SearchCriteria.getInstance();
    
    System.out.println("\n=== Western Pilot Phone List ===");
    
    pl.stream().filter(search.getCriteria("allPilots"))
      .forEach(p -> { 
        p.printl(p.getPrintStyle("westernNameAgePhone"));
      });
    
    System.out.println("\n=== Gangnam Phone List ===");
    pl.forEach(p -> { 
      p.printl(p.getPrintStyle("gangnamNameAgePhone"));
    });
   
    System.out.println("\n=== Gangnam Draftee Phone List ===");
    pl.stream().filter(search.getCriteria("allDraftees"))
      .forEach(p -> { 
        p.printl(p.getPrintStyle("gangnamNameAgePhone"));
      });
    
  }
}
