package tdd.vendingMachine;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Function;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;
import java.util.stream.Stream;
 
public class FlatMapTest {
 /*
    The documentation of flatMap was not easy to understand but there are two streams that are mixed – the source stream and the regular expression pattern stream. I am applying the regular expressions one by one on the source lines to get what I want. So here I am able to get the first value(2359296) from the line
The problem with this approach is this. The result of the first regex match is this line.
Current Usage : init:2359296, used:13913536, committed:13959168, max:50331648|
The second regex should be applied on this line. Not on the original line. But that is how this code works. Moreover it does not give me all the values returned by looping over Matcher::find
    */
    public static void main( String... argv ){
 
        List<String> source = new ArrayList<String>();
        source.add( "Peak Usage    : init:2359296, used:13914944, committed:13959168, max:50331648Current Usage : init:2359296, used:13913536, committed:13959168, max:50331648|------------------| committed:13.31Mb+---------------------------------------------------------------------+|//////////////////|                                                  | max:48Mb+---------------------------------------------------------------------+|------------------| used:13.27Mb");
        source.add( "Peak Usage    : init:2359296, used:13916608, committed:13959168, max:50331648Current Usage : init:2359296, used:13915200, committed:13959168, max:50331648|------------------| committed:13.31Mb+---------------------------------------------------------------------+|//////////////////|                                                  | max:48Mb+---------------------------------------------------------------------+|------------------| used:13.27Mb");
 
        List<Pattern> patterns = Arrays.asList(Pattern.compile("Current.*?[/|]"), Pattern.compile("[0-9]+(/,|/|)"));
 
        //Style 1
        patterns.stream()
                .flatMap(new Function<Pattern, Stream<String>>() {
                    @Override
                    public Stream<String> apply(Pattern p) {
                        return source.stream()
                                .map(p::matcher)
                                .filter(Matcher::find)
                                .map(Matcher::group);
                    }
                })
                .forEach(System.out::println);
 
        //Style 2
        patterns.stream().flatMap(( Pattern p1 ) -> source.
                stream().
                map(p1::matcher).
                filter(Matcher::find).map(matcher -> matcher.group())).forEach(x -> System.out.println(x));
 
    }
}