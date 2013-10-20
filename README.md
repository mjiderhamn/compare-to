# Better compareTo() syntax

Improving readability for [`java.lang.Comparable.compareTo()`](http://docs.oracle.com/javase/7/docs/api/java/lang/Comparable.html#compareTo(T\))

Example usage - expressive syntax 
```java
import static se.jiderhamn.CompareTo.is;

...
  boolean oneIsZero = is(1).equalTo(0);
  boolean aIsNotZero = is(a).notEqualTo(0);
  boolean bIsZero = is(b).zero();
  boolean value1LessThanValue2 = is(value1).lessThan(value2);
    
  if(is(a).lessThanOrEqualTo(b)) {
    ...
  }

  boolean date1AfterDate2 = is(date1).greaterThan(date2);

  if(is(a).greaterThanOrEqualTo(b)) {
    ...
  }
```

Example usage - abbreviated syntax 
```java
import static se.jiderhamn.CompareTo.is;

...
  boolean oneIsZero = is(1).eq(0);
  boolean aIsNotZero = is(a).ne(0);
  boolean value1LessThanValue2 = is(value1).lt(value2);

  if(is(a).le(b)) {
    ...
  }

  boolean date1AfterDate2 = is(date1).gt(date2);

  if(is(a).ge(b)) {
    ...
  }
```

## Maven

The library is available in Maven Central with the following details:
```xml
<dependency>
  <groupId>se.jiderhamn</groupId>
  <artifactId>compare-to</artifactId>
  <version>1.1.0</version>
</dependency>
```
