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

import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static se.jiderhamn.CompareTo.is;

/**
 * Test cases for {@link se.jiderhamn.CompareTo}
 * @author Mattias Jiderhamn
 */
public class CompareToTest {
  
  //////////////////////////////////////////////////////////////////////////////////////////////////////////////////
  // Equality

  @Test
  public void equalTo() {
    // Integers
    assertTrue(is(1).equalTo(1));
    assertFalse(is(1).equalTo(0));
    assertFalse(is(1).equalTo(2));
    
    // BigDecimal
    assertTrue(is(new BigDecimal(1)).equalTo(new BigDecimal("1.0000000000")));
    
    // null
    assertFalse(is(0).equalTo(null));
    assertFalse(is((Integer) null).equalTo(0));
    assertTrue(is((Integer) null).equalTo(null));
  }
  
  @Test
  public void eq() {
    assertTrue(is(1).eq(1));
    assertFalse(is(1).eq(0));
    assertFalse(is(1).eq(2));

    // null
    assertFalse(is(0).eq(null));
    assertFalse(is((Integer) null).eq(0));
    assertTrue(is((Integer) null).eq(null));
  }

  //////////////////////////////////////////////////////////////////////////////////////////////////////////////////
  // Non-equality

  @Test
  public void notEqualTo() {
    // Integers
    assertFalse(is(1).notEqualTo(1));
    assertTrue(is(1).notEqualTo(0));
    assertTrue(is(1).notEqualTo(2));
    
    // BigDecimal
    assertFalse(is(new BigDecimal(1)).notEqualTo(new BigDecimal("1.0000000000")));
    
    // null
    assertTrue(is(0).notEqualTo(null));
    assertTrue(is((Integer) null).notEqualTo(0));
    assertFalse(is((Integer) null).notEqualTo(null));
  }
  
  @Test
  public void ne() {
    assertFalse(is(1).ne(1));
    assertTrue(is(1).ne(0));
    assertTrue(is(1).ne(2));

    // null
    assertTrue(is(0).ne(null));
    assertTrue(is((Integer) null).ne(0));
    assertFalse(is((Integer) null).ne(null));
  }

  //////////////////////////////////////////////////////////////////////////////////////////////////////////////////
  // Less
  
  @Test
  public void lessThan() {
    assertFalse(is(0).lessThan(-1));
    assertFalse(is(0).lessThan(0));
    assertTrue(is(0).lessThan(1));

    assertFalse(is(BigDecimal.ZERO).lessThan(BigDecimal.ZERO.subtract(BigDecimal.ONE)));
    assertFalse(is(BigDecimal.ZERO).lessThan(BigDecimal.ZERO));
    assertTrue(is(BigDecimal.ZERO).lessThan(BigDecimal.ONE));
  }

  @Test
  public void lessThanOrEqualTo() {
    assertFalse(is(0).lessThanOrEqualTo(-1));
    assertTrue(is(0).lessThanOrEqualTo(0));
    assertTrue(is(0).lessThanOrEqualTo(1));

    assertFalse(is(BigDecimal.ZERO).lessThanOrEqualTo(BigDecimal.ZERO.subtract(BigDecimal.ONE)));
    assertTrue(is(BigDecimal.ZERO).lessThanOrEqualTo(BigDecimal.ZERO));
    assertTrue(is(BigDecimal.ZERO).lessThanOrEqualTo(BigDecimal.ONE));
  }

  @Test
  public void lt() {
    assertFalse(is(0).lt(-1));
    assertFalse(is(0).lt(0));
    assertTrue(is(0).lt(1));

    assertFalse(is(BigDecimal.ZERO).lt(BigDecimal.ZERO.subtract(BigDecimal.ONE)));
    assertFalse(is(BigDecimal.ZERO).lt(BigDecimal.ZERO));
    assertTrue(is(BigDecimal.ZERO).lt(BigDecimal.ONE));
  }

  @Test
  public void le() {
    assertFalse(is(0).le(-1));
    assertTrue(is(0).le(0));
    assertTrue(is(0).le(1));

    assertFalse(is(BigDecimal.ZERO).le(BigDecimal.ZERO.subtract(BigDecimal.ONE)));
    assertTrue(is(BigDecimal.ZERO).le(BigDecimal.ZERO));
    assertTrue(is(BigDecimal.ZERO).le(BigDecimal.ONE));
  }
  
  @Test
  public void before() {
    assertFalse(is(0).before(-1));
    assertFalse(is(0).before(0));
    assertTrue(is(0).before(1));

    assertFalse(is(BigDecimal.ZERO).before(BigDecimal.ZERO.subtract(BigDecimal.ONE)));
    assertFalse(is(BigDecimal.ZERO).before(BigDecimal.ZERO));
    assertTrue(is(BigDecimal.ZERO).before(BigDecimal.ONE));
  }
  
  //////////////////////////////////////////////////////////////////////////////////////////////////////////////////
  // Greater
  
  @Test
  public void greaterThan() {
    assertTrue(is(0).greaterThan(-1));
    assertFalse(is(0).greaterThan(0));
    assertFalse(is(0).greaterThan(1));

    assertTrue(is(BigDecimal.ZERO).greaterThan(BigDecimal.ZERO.subtract(BigDecimal.ONE)));
    assertFalse(is(BigDecimal.ZERO).greaterThan(BigDecimal.ZERO));
    assertFalse(is(BigDecimal.ZERO).greaterThan(BigDecimal.ONE));
  }

  @Test
  public void greaterThanOrEqualTo() {
    assertTrue(is(0).greaterThanOrEqualTo(-1));
    assertTrue(is(0).greaterThanOrEqualTo(0));
    assertFalse(is(0).greaterThanOrEqualTo(1));

    assertTrue(is(BigDecimal.ZERO).greaterThanOrEqualTo(BigDecimal.ZERO.subtract(BigDecimal.ONE)));
    assertTrue(is(BigDecimal.ZERO).greaterThanOrEqualTo(BigDecimal.ZERO));
    assertFalse(is(BigDecimal.ZERO).greaterThanOrEqualTo(BigDecimal.ONE));
  }

  @Test
  public void gt() {
    assertTrue(is(0).gt(-1));
    assertFalse(is(0).gt(0));
    assertFalse(is(0).gt(1));

    assertTrue(is(BigDecimal.ZERO).gt(BigDecimal.ZERO.subtract(BigDecimal.ONE)));
    assertFalse(is(BigDecimal.ZERO).gt(BigDecimal.ZERO));
    assertFalse(is(BigDecimal.ZERO).gt(BigDecimal.ONE));
  }

  @Test
  public void ge() {
    assertTrue(is(0).ge(-1));
    assertTrue(is(0).ge(0));
    assertFalse(is(0).ge(1));

    assertTrue(is(BigDecimal.ZERO).ge(BigDecimal.ZERO.subtract(BigDecimal.ONE)));
    assertTrue(is(BigDecimal.ZERO).ge(BigDecimal.ZERO));
    assertFalse(is(BigDecimal.ZERO).ge(BigDecimal.ONE));
  }

  @Test
  public void after() {
    assertTrue(is(0).after(-1));
    assertFalse(is(0).after(0));
    assertFalse(is(0).after(1));

    assertTrue(is(BigDecimal.ZERO).after(BigDecimal.ZERO.subtract(BigDecimal.ONE)));
    assertFalse(is(BigDecimal.ZERO).after(BigDecimal.ZERO));
    assertFalse(is(BigDecimal.ZERO).after(BigDecimal.ONE));
  }
   
  //////////////////////////////////////////////////////////////////////////////////////////////////////////////////
  // Zero

  @Test
  public void zero() {
    assertFalse(is(null).zero());
    
    // Integer
    assertFalse(is(1).zero());
    assertFalse(is(-1).zero());
    assertTrue(is(0).zero());

    // Long
    assertFalse(is(1L).zero());
    assertFalse(is(-1L).zero());
    assertTrue(is(0L).zero());

    // Short
    assertFalse(is((short) 1).zero());
    assertFalse(is((short) -1L).zero());
    assertTrue(is((short) 0L).zero());

    // Byte
    assertFalse(is((byte) 1).zero());
    assertFalse(is((byte) -1L).zero());
    assertTrue(is((byte) 0L).zero());

    // Float
    assertFalse(is(1f).zero());
    assertFalse(is(-1f).zero());
    assertTrue(is(0f).zero());

    // Double
    assertFalse(is(1D).zero());
    assertFalse(is(-1D).zero());
    assertTrue(is(0D).zero());

    // BigDecimal
    assertFalse(is(BigDecimal.ONE).zero());
    assertFalse(is(new BigDecimal("-1")).zero());
    assertTrue(is(BigDecimal.ZERO).zero());
    assertTrue(is(new BigDecimal("0.000000")).zero());
  }

  @Test(expected = IllegalArgumentException.class) // Does not work for strings
  public void zeroString() {
    is("foo").zero();
  }
}