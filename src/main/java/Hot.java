/*import java.net.URL;
import java.util.*;
import java.util.stream.*;

import java.util.function.Function;

class RegexBasedGroupingFunction<T> implements Function<T, String> {
    final Map<String, String> groupNameToRegex = new HashMap<>();

    public RegexBasedGroupingFunction(Map<String, String> groupNameToRegex) {
      if (groupNameToRegex != null) {
        this.groupNameToRegex.putAll(groupNameToRegex);
      }
    }

    @Override
    public String apply(T t) {
      return groupNameToRegex.entrySet()
          .stream()
          .filter(entry -> t.toString().matches(entry.getValue()))
          .map(entry -> entry.getKey())
          .findFirst()
          .orElse("default");
    }
}

class Main {
    public static void main(String[] args) {
        List<String> vals = new ArrayList<>();
        vals.add("dog");
        vals.add("cat");
        vals.add("fish");
        vals.add("elephant");
        
        
        
        RegexBasedGroupingFunction defaults = new RegexBasedGroupingFunction(null);
        System.out.println("Groups all items in 'default' if uncategorized.");
        System.out.println(vals.stream().collect(Collectors.groupingBy(defaults)));

        
        System.out.println("\n\n");
        
        System.out.println("Group by arbitrary regex expressions");
        Map<String,String> groupToRegex = new HashMap<>();
        groupToRegex.put("3letters",".{3}");
        groupToRegex.put("4letters",".{4}");
        
        RegexBasedGroupingFunction<String> f = new RegexBasedGroupingFunction(groupToRegex);
        
        System.out.println(vals.stream().collect(Collectors.groupingBy(f)));
        Group by arbitrary regex expressions
{default=[elephant], 3letters=[dog, cat], 4letters=[fish]}
    }
}*/