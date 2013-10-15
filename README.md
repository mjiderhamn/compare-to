# Better compareTo() syntax

Improving readability for [`java.lang.Comparable.compareTo()`](http://docs.oracle.com/javase/7/docs/api/java/lang/Comparable.html#compareTo(T\))

Example usage - expressive syntax 
```java
import static se.jiderhamn.CompareTo.is;

...
  boolean oneIsZero = is(1).equalTo(0);
  ...
    
  boolean value1LessThanValue2 = is(value1).lessThan(value2);
  ...
    
  if(is(a).lessThanOrEqualTo(b)) {
    ...
  }

  boolean date1AfterDate2 = is(date1).greaterThan(date2);
  ...

  if(is(a).greaterThanOrEqualTo(a)) {
    ...
  }
```

Example usage - short syntax 
```java
import static se.jiderhamn.CompareTo.is;

...
  boolean oneIsZero = is(1).eq(0));
  ...

  boolean value1LessThanValue2 = is(value1).lt(value2);
  ...

  if(is(a).le(b)) {
    ...
  }

  boolean date1AfterDate2 = is(date1).gt(date2);
  ...

 if(is(a).ge(a)) {
    ...
  }
```