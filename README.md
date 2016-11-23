Added new Java-8
======

Source code for exploring the new features of Java 8.  Over time this repo will contain all the source code as I blog about the new
features in Java 8 and explore the API.
Added new Proton pack library 

https://github.com/poetix/protonpack
https://github.com/amaembo/streamex  it is a great library you can use 
https://github.com/mukadder/java8-code-kata great code for practice 
https://github.com/hgwood/java8-streams-and-exceptions - a library for exceptions
https://github.com/benjiman/expressions Is another good library for checked exceptions
This is branch for testing




# Java8 Code Kata
[![Build Status](https://travis-ci.org/konohiroaki/java8-code-kata.svg?branch=master)](https://travis-ci.org/konohiroaki/java8-code-kata)

☝ It's failing because tests are not solved yet! :blush:

## What is Code Kata?

According to [www.codekatas.org](http://www.codekatas.org/)
> Code Kata is a term coined by Dave Thomas, co-author of the book The Pragmatic Programmer, in a bow to the Japanese concept of kata in the martial arts. A code kata is an exercise in programming which helps a programmer hone their skills through practice and repetition.


Also refer [codekata.com](http://codekata.com/)

## What is Java8 Code Kata?

The _Java8 Code Kata_ is created to walk-through java8 new API functions. I hope this helps you learn Java8 and get used to it. Repeating exercises will definitely upgrade your skills.

## Usage
* Resolve dependencies.

```
$ pwd
/path/to/java8-code-kata

$ ./mvnw dependency:resolve
-> will download the dependent jar files in your .m2 directory.
```

* Edit the unit tests to pass them by following its description.

Test sample.

```java
@Easy @Test
public void simpleAddition() {
    /**
     * Get an addition result of 1 and 2 by using an operator "+".
     */
    Integer added = null;

    assertThat(added, is(3));
}
```

You need to edit the program under the comment.

Solution sample.

```java
@Easy @Test
public void simpleAddition() {
    /**
     * Get an addition result of 1 and 2 by using an operator "+".
     */
    Integer added = 1 + 2;

    assertThat(added, is(3));
}
```

Most tests are annotated with `@Easy` which means those tests only requires basic knowledge.

Tests annotated with `@Difficult` expect you to think a lot :grin:

## Where are the answers?

Check the 'solution' branch, but please try to solve by yourself at first.

## Modules

### collection-interfaces

+ Exercise1Test.java

`Iterable#forEach`, `Collection#removeIf`, `List#replaceAll`, `List#sort`, `Collection#stream` and `Collection#parallelStream`

+ Exercise2Test.java

`Map#getOrDefault`, `Map#putIfAbsent`, `Map#merge` and `Map#computeIfPresent`

### stream-api

+ Exercise1Test.java

`Stream#filter` and `Stream#map`

+ Exercise2Test.java

`Stream#sorted`, `Stream#distinct`, `Stream#limit` and `Stream#flatMap`

+ Exercise3Test.java

`Stream#count`, `Stream#max` and `Stream#min`

+ Exercise4Test.java

`Stream#findFirst`, `Stream#allMatch`, `Stream#anyMatch` and `Stream#noneMatch`

+ Exercise5Test.java

`Stream#collect` and `Collectors`

+ Exercise6Test.java

`Stream#of` and `Stream#iterate`

+ Exercise7Test.java

`IntStream`, `LongStream` and `DoubleStream`

+ Exercise8Test.java

Advanced problems

+ Exercise9Test.java

`Collector`

### date-and-time-api

+ Exercise1Test.java

`LocalDate#of`, `LocalDate#parse`, `LocalDate#with`, `LocalDate#plus`, `LocalDate#minus`, `LocalDate#isAfter`, `LocalDate#isBefore` and `LocalDate#until`

+ Exercise2Test.java

`LocalTime#of`, `LocalTime#parse`, `LocalTime#with`, `LocalTime#plus`, `LocalTime#minus`, `LocalTime#isAfter`, `LocalTime#isBefore` and `LocalTime#truncatedTo`

+ Exercise3Test.java

`LocalDateTime#of`, `LocalDateTime#parse`, `LocalDateTime#format`, `LocalDateTime#toLocalDate`, `LocalDateTime#toLocalTime`, `LocalDate#atTime` and `LocalTime#atDate`

+ Exercise4Test.java

`ZonedDateTime#of`, `ZonedDateTime#parse`, `ZonedDateTime#format`, `LocalDateTime#atZone`, `ZonedDateTime#withZoneSameInstant` and `ZonedDateTime#withZoneSameLocal`

+ Exercise5Test.java

`LocalDateTime` to `java.sql.Timestamp`, `LocalDate` to `java.sql.Date`,  and vice versa
