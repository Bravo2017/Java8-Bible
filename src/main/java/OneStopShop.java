/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author mukadder

public class OneStopShop {
    main()
    
    Arrays.asList("EPS-DX04", "EPS-SX04", "EPS-AP-DX04", "D3-M-DX04-C")
    .stream()
    .filter(name -> name.matches("^.*DX04$")
    .forEach(System.out::println); // => EPS-DX04 EPS-AP-DX04

//ラムダ式を変数化すると
Predicate<String> regex = name -> name.matches("^.*DX04$");
Arrays.asList("EPS-DX04", "EPS-SX04", "EPS-AP-DX04", "D3-M-DX04-C")
    .stream()
    .filter(regex)
    .forEach(System.out::println);
} 
}Arrays.asList("EPS-DX04", "EPS-DX04-A", "EPS-DX03")
    .stream()
    .filter(name -> name.matches("^.*DX04$"))
    .forEach(System.out::println); // => EPS-DX04 EPS-AP-DX04

//ラムダ式を変数化すると
final Consumer print = n -> System.out.println(n);
Arrays.asList("EPS-DX04", "EPS-DX04-A", "EPS-DX03")
    .stream()
    .filter(name -> name.matches("^.*DX04$"))
    .forEach(print);
}Arrays.asList("EPS-DX04", "EPS-DX04-A", "EPS-DX03")
    .stream()
    .map(n -> n.length())
    .forEach(System.out::println); // => 8 10 8    
final Function<String, Integer> length = n -> n.length();
Arrays.asList("EPS-DX04", "EPS-DX04-A", "EPS-DX03")
    .stream()
    .map(length)
    .forEach(System.out::println);
}Arrays.asList("EPS-DX04", "EPS-DX04-A", "EPS-DX03")
    .stream()
    .filter(name -> name.matches("^.*DX04$"))
    .flatMap(name -> Arrays.stream(name.split("-"))) //splitで新しいリストを生成
    .distinct() //重複排除
    .forEach(System.out::println); // => EPS DX04
    * final Function<String, Stream<String>> words = n -> Arrays.stream(n.split("-"));
Arrays.asList("EPS-DX04", "EPS-DX04-A", "EPS-DX03")
    .stream()
    .filter(name -> name.matches("^.*DX04$"))
    .flatMap(words)
    .distinct()
    .forEach(System.out::println);
    * Arrays.asList("EPS-DX04", "EPS-DX04-A", "EPS-DX03")
    .stream()
    .filter(name -> name.matches("^.*DX04$"))
    .map(name -> Arrays.stream(name.split("-")))
    .collect(Collectors.toList); // => List<Stream<String>> が戻る
    * FileSystems.getDefault().getPath("input.txt");

Map<String, Long> wordCountMap = Files.lines(path)
    .flatMap(line -> Arrays.stream(line.split(" "))) //空白を単語の区切りと見なす
    .collect(Collectors.groupingBy(s -> s, Collectors.counting())); 
    * System.out.println(Arrays.asList(1, 2, 3, 4)
                         .stream()
                         .reduce((i, j) -> i + j) // Optionalが返る
                         .get()); // => 10
                         * products.stream()
    .sorted((o1, o2) -> o1.price.compareTo(o2.price))
    .forEach(System.out::println);

//メソッド参照がいい
products.stream()
    .sorted(Comparator.comparing(Product::getPrice))
    .forEach(System.out::println);
    * products.stream()
    .sorted(Comparator.comparing(Product::getPrice).reversed())
    .forEach(System.out::println);
    * products.stream()
    .sorted(Comparator.comparing(Product::getPrice).thenComparing(Product::getName))
    .forEach(System.out::println);
    * Arrays.asList("a", "b", "c", "d", "e")
        .stream()
        .limit(3)
        .skip(1)
        .forEach(System.out::println); // b c
        * //toSet
final Set<String> set =
    Arrays.asList("EPS-DX04",
                  "EPS-DX04",
                  "EPS-DX03",
                  "EPS-DX03")
          .stream()
          .collect(Collectors.toSet()); // => [EPS-DX03, EPS-DX04]

//toList
final List<String> list =
    Arrays.asList("EPS-DX04",
                  "EPS-DX04",
                  "EPS-DX03",
                  "EPS-DX03")
          .stream()
          .collect(Collectors.toList()); // => [EPS-DX04, EPS-DX04, EPS-DX03, EPS-DX03]

//toMap
final List<String, Integer> map =
    Arrays.asList("EPS-DX04",
                  "EPS-DX04",
                  "EPS-DX03",
                  "EPS-DX03")
          .stream()
          //重複除外しておかないとエラーになるよ
          .distinct()
          //toMapの第一引数がKey、第二引数がValueに当たる
          .collect(Collectors.toMap(v -> v, v -> v.length())); // => {EPS-DX03=8, EPS-DX04=8}
          * final Map<Integer, List<String>> map =
    Arrays.asList("EPS-DX04", "EPS-DX04-A", "EPS-DX03")
        .stream()
        .collect(Collectors.groupingBy(name -> name.length())); // => {8=[EPS-DX04, EPS-DX03], 10=[EPS-DX04-A]}

//ラムダ式を変数化すると
final Function<String, Integer> length = n -> n.length();
final Map<Integer, List<String>> map =
    Arrays.asList("EPS-DX04", "EPS-DX04-A", "EPS-DX03")
        .stream()
        .collect(Collectors.groupingBy(length));

    public Map<Field, List<Annotation>> getFieldAnnotationsMap() {
        return Arrays.asList(getClass().getDeclaredFields())
                .stream()
                        .collect(Collectors.toMap(field -> field,
                                                    field -> Arrays.asList(field.getAnnotations())));
    }
final Map<String, List<String>> map =
    Arrays.asList("EPS-DX04", "EPS-DX04-A", "EPS-DX03")
        .stream()
        .collect(Collectors.groupingBy(name -> {
            if(name.indexOf("DX04") != -1) return "DX04";
            if(name.indexOf("DX03") != -1) return "DX03";
            return "UNKNOWN";
        })); // => {DX03=[EPS-DX03], DX04=[EPS-DX04, EPS-DX04-A]}

//ラムダ式を変数化すると
final Function<String, String> type = name -> {
    if (name.indexOf("DX04") != -1) { return "DX04"; }
    if (name.indexOf("DX03") != -1) { return "DX03"; }
    return "UNKNOWN";
};
final Map<String, List<String>> map =
    Arrays.asList("EPS-DX04", "EPS-DX04-A", "EPS-DX03")
        .stream()
        .collect(Collectors.groupingBy(type));
        * 
        * final Map<Integer, Long> map = 
    Arrays.asList("EPS-DX04", "EPS-DX04-A", "EPS-DX03")
        .stream()
        .collect(
            Collectors.groupingBy(name -> name.length(),
            Collectors.counting()
        )); // => {8=2, 10=1}

//平均値
final Map<String, List<String>> map =
    Arrays.asList("EPS-DX04", "EPS-DX04-A", "EPS-DX03")
        .stream()
        .collect(
            Collectors.groupingBy(name -> {
                if(name.indexOf("DX04") != -1) return "DX04";
                if(name.indexOf("DX03") != -1) return "DX03";
                return "UNKNOWN";
            },
            Collectors.averageingInt(name -> name.length())
        )); // => {DX03=8.0, DX04=9.0}

//valueリストの変換
final Map<Integer, List<String>> map =
    Arrays.asList("EPS-DX04", "EPS-DX04-A", "EPS-DX03")
          .stream()
          .collect(
              Collectors.groupingBy(name -> name.length(),
              Collectors.mapping(name -> name.substring(0, 1), Collectors.toList())
          )); // => {8=[E, E], 10=[E]}
          * 
          * final List<Integer> keys = map.entrySet()
    .stream()
    .map(Entry::getKey) //mapのキー要素だけを抽出（entry -> entry.getKey() のメソッド参照）
    .collect(Collectors.toList());
    * map.entrySet()
    .stream()
    .forEach((k, v) -> System.out.println(k + ":" + v));
    * final Map<String, List<String>> map =
    Arrays.asList("EPS-DX04", "EPS-DX04-A", "EPS-DX03", "EPS-DX03-A")
        .stream()
        .collect(Collectors.groupingBy(name -> {
            if(name.indexOf("DX04") != -1) return "DX04";
            if(name.indexOf("DX03") != -1) return "DX03";
            return "UNKNOWN";
        })); // => {DX03=[EPS-DX03, EPS-DX03-A], DX04=[EPS-DX04, EPS-DX04-A]}

final Map<String, Long> map2 =
    map.entrySet()
        .stream()
        .collect(Collectors.toMap(
            Entry::getKey,
            entry -> entry.getValue()
                .stream()
                .filter(name -> name.matches("^.*-A$"))
                .count())); // => {DX03=1, DX04=1}
                * final Map<Integer, String> map = new HashMap<Integer, String>() {
    { put(1, "fooVal"); }
    { put(2, "barVal"); }
};

map.forEach((k, v) -> {
    //型推論もしてくれる
    System.out.println(String.format("%s:%s", k, v));
});
final Map<Integer, String> map = new HashMap<Integer, String>() {
    { put(1, "fooVal"); }
    { put(2, "barVal"); }
};

final String string = map.getOrDefault(3, "").toUpperCase();
* list1.stream().collect(
        () -> new HashMap<Integer, Integer>(),
        (map, item) -> map.merge(item.getKey(), item.getValue(), (x, y) -> x + y),
        (left, right) -> left.putAll(right))
    .forEach((k, v) -> System.out.println(k + ":" + v));

 */