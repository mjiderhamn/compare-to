/*
   Copyright 2012 Mattias Jiderhamn

   Licensed under the Apache License, Version 2.0 (the "License");
   you may not use this file except in compliance with the License.
   You may obtain a copy of the License at

       http://www.apache.org/licenses/LICENSE-2.0

   Unless required by applicable law or agreed to in writing, software
   distributed under the License is distributed on an "AS IS" BASIS,
   WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
   See the License for the specific language governing permissions and
   limitations under the License.
 */
package se.jiderhamn;

import java.math.BigDecimal;

/**
 * Utility class that provides more readable syntax for {@link java.lang.Comparable#compareTo(Object)}.
 * 
 * Examples:
 * <code>
 *   import static se.jiderhamn.CompareTo.is;
 *
 *...
 *
 *  boolean oneIsZero = is(1).equalTo(0);
 *  boolean aIsNotZero = is(a).notEqualTo(0);
 *  boolean bIsZero = is(b).zero();
 *  boolean value1LessThanValue2 = is(value1).lessThan(value2);
 *    
 *  if(is(a).lessThanOrEqualTo(b)) {
 *    ...
 *  }
 *
 *  boolean date1AfterDate2 = is(date1).greaterThan(date2);
 *
 *  if(is(a).greaterThanOrEqualTo(b)) {
 *    ...
 *  }
 *
 *  // Abbreviated syntax 
 *
 *  boolean oneIsZero = is(1).eq(0);
 *  boolean aIsNotZero = is(a).ne(0);
 *  boolean value1LessThanValue2 = is(value1).lt(value2);
 *
 *  if(is(a).le(b)) {
 *    ...
 *  }
 *
 *  boolean date1AfterDate2 = is(date1).gt(date2);
 *
 *  if(is(a).ge(b)) {
 *    ...
 *  }
 *
 * </code>
 * @author Mattias Jiderhamn
 */

public class CompareTo<T extends Comparable<T>> {
  
  private final Comparable<T> comparable;

  private CompareTo(Comparable<T> comparable) {
    this.comparable = comparable;
  }
  
  /** Create new instance that allows for chained comparison */
  public static <C extends Comparable<C>> CompareTo<C> is(C comparable) {
    return new CompareTo<C>(comparable);
  }
  
  //////////////////////////////////////////////////////////////////////////////////////////////////////////////////
  // Equality
  
  /** 
   * Is the owner equal to the argument?
   * Note specifically that null equals null, but not non-null.
   */
  public boolean equalTo(T that) {
    if(this.comparable == null) {
      return (that == null);
    }
    else if(that == null)
      return false; // Since this was non-null
    
    return this.comparable.compareTo(that) == 0;
  }
  
  /** 
   * Is the owner equal to the argument?
   * Note specifically that null equals null, but not non-null.
   */
  public boolean eq(T that) {
    return equalTo(that);
  }
  
  /** 
   * Is the owner not equal to the argument?
   * Note specifically that null equals null, but not non-null.
   */
  public boolean notEqualTo(T that) {
    return ! equalTo(that);
  }

  /** 
   * Is the owner not equal to the argument?
   * Note specifically that null equals null, but not non-null.
   */
  public boolean ne(T that) {
    return ! equalTo(that);
  }

  //////////////////////////////////////////////////////////////////////////////////////////////////////////////////
  // Less
  
  /** Is the owner less than the argument? */
  public boolean lessThan(T that) {
    return this.comparable.compareTo(that) < 0;
  }

  /** Is the owner less than or equal to the argument? */
  public boolean lessThanOrEqualTo(T that) {
    return this.comparable.compareTo(that) <= 0;
  }

  /** Is the owner less than the argument? */
  public boolean lt(T that) {
    return this.comparable.compareTo(that) < 0;
  }

  /** Is the owner less than or equal to the argument? */
  public boolean le(T that) {
    return this.comparable.compareTo(that) <= 0;
  }
  
  /** Is the owner before the argument? Same as {@link #lessThan(Comparable)} */
  public boolean before(T that) {
    return this.comparable.compareTo(that) < 0;
  }

  //////////////////////////////////////////////////////////////////////////////////////////////////////////////////
  // Greater
  
  /** Is the owner greater than the argument? */
  public boolean greaterThan(T that) {
    return this.comparable.compareTo(that) > 0;
  }

  /** Is the owner greater than or equal to the argument? */
  public boolean greaterThanOrEqualTo(T that) {
    return this.comparable.compareTo(that) >= 0;
  }

  /** Is the owner greater than the argument? */
  public boolean gt(T that) {
    return this.comparable.compareTo(that) > 0;
  }

  /** Is the owner greater than or equal to the argument? */
  public boolean ge(T that) {
    return this.comparable.compareTo(that) >= 0;
  }

  /** Is the owner after the argument? Same as {@link #greaterThan(Comparable)} */
  public boolean after(T that) {
    return this.comparable.compareTo(that) > 0;
  }

  //////////////////////////////////////////////////////////////////////////////////////////////////////////////////
  // Zero

  /** 
   * Is the owner equal to zero (regardless of scale)? Supported types are Integer, Long, Short, Byte, Float, Double
   * and BigDecimal.
   * @throws IllegalArgumentException for any non-numeric owner type.
   * */
  public boolean zero() {
    if(! Number.class.isInstance(this.comparable)) {
      throw new IllegalArgumentException("zero() can only be used on " + Number.class.getName() + " subclasses");
    }

    if(Integer.class.isInstance(this.comparable)) {
      Comparable<Integer> c = (Comparable<Integer>) this.comparable;
      return c.compareTo(0) == 0;
    }

    if(Long.class.isInstance(this.comparable)) {
      Comparable<Long> c = (Comparable<Long>) this.comparable;
      return c.compareTo(0L) == 0;
    }

    if(Float.class.isInstance(this.comparable)) {
      Comparable<Float> c = (Comparable<Float>) this.comparable;
      return c.compareTo(0f) == 0;
    }

    if(Double.class.isInstance(this.comparable)) {
      Comparable<Double> c = (Comparable<Double>) this.comparable;
      return c.compareTo(0D) == 0;
    }

    if(BigDecimal.class.isInstance(this.comparable)) {
      Comparable<BigDecimal> c = (Comparable<BigDecimal>) this.comparable;
      return c.compareTo(BigDecimal.ZERO) == 0;
    }

    if(Short.class.isInstance(this.comparable)) {
      Comparable<Short> c = (Comparable<Short>) this.comparable;
      return c.compareTo((short) 0) == 0;
    }

    if(Byte.class.isInstance(this.comparable)) {
      Comparable<Byte> c = (Comparable<Byte>) this.comparable;
      return c.compareTo((byte) 0) == 0;
    }

    throw new IllegalArgumentException("Unsupported " + Number.class.getName() + " subclass");
  }
}