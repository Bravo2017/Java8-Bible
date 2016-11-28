package com.example.lambda;

import java.util.List;
import java.util.Map;
import java.util.function.Function;

/**
 *
 * @author MikeW
 */
public class Test01ForEach {
  
  public static void main(String[] args) {
    
    List<Person> pl = Person.createShortList();
    
    System.out.println("\n=== Western Phone List ===");
    pl.forEach(p -> { 
      p.printl(p.getPrintStyle("westernNameAgePhone"));
    });
    
    System.out.println("\n=== Gangnam Phone List ===");
    pl.forEach(p -> { 
      p.printl(p.getPrintStyle("gangnamNameAgePhone"));
    });
    
  }

}
