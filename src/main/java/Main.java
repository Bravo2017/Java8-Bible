import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

class Main {
    public static void main(String[] args) {
        List<String> vals = new ArrayList<>();
        vals.add("dog");
        vals.add("cat");
        vals.add("fish");
        vals.add("elephant");



//        RegexBasedGroupingFunction defaults = new RegexBasedGroupingFunction(null);
        System.out.println("Groups all items in 'default' if uncategorized.");
      //  System.out.println(vals.stream().collect(Collectors.groupingBy(defaults)));


        System.out.println("\n\n");

        System.out.println("Group by arbitrary regex expressions");
        Map<String,String> groupToRegex = new HashMap<>();
        groupToRegex.put("3letters",".{3}");
        groupToRegex.put("4letters",".{4}");

        RegexBasedGroupingFunction<String> f = new RegexBasedGroupingFunction(groupToRegex);

        System.out.println(vals.stream().collect(Collectors.groupingBy(f)));
 System.out.println(vals.stream().collect(
              Collectors.groupingBy(name -> name.length(),
              Collectors.mapping(name -> name.substring(0, 1), Collectors.toList())
          )));
    }
}