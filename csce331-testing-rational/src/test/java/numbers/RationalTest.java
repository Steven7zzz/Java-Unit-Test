package numbers;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;
import static org.junit.Assert.*;


/**
 * Unit test for simple App.
 */
public class RationalTest 
    extends TestCase
{
    /**
     * Create the test case
     *
     * @param testName name of the test case
     */
    public RationalTest( String testName )
    {
        super( testName );
    }

    /**
     * @return the suite of tests being tested
     */
    public static Test suite()
    {
        return new TestSuite( RationalTest.class );
    }

    /**
     * Rigourous Test :-)
     */
    public void testRational()
    {
        // Given no preconditions

        // When I create a default `Rational` value
        Rational value = new Rational();
        // Then the value should have numerator 0
        assertThat("the numerator should be 0", value.numerator(), is(0));
        // And the value should have denominator 1
        assertThat("the denominator should be 1", value.denominator(), is(1));
    }

    public void testRationalInt()
    {
        // Given that I have constructed a `Rational` value using the argument `2`
        Rational value = new Rational(2);
        // Then the value should have numerator `2`
        assertThat("the numerator should be 2", value.numerator(), is(2));
        // And the value should have denominator `1`
        assertThat("the denominator should be 1", value.denominator(), is(1));
    }

    public void testRationalIntInt()
    {
        // Given that I have created a Rational value using arguments `2`` and `3`
        Rational value = new Rational(2, 3);
        // Then the value should have numerator `2`
        assertThat("the numerator should be 2", value.numerator(), is(2));
        // And the value should have denominator `3`
        assertThat("the denominator should be 3", value.denominator(), is(3));
    }

    public void testRationalIntIntMore()
    {
        // Given I have created a `Rational` value using `48` and `-72`
        Rational value = new Rational(48, -72);
        // Then the value should have numerator `-2`
        assertThat("48 / -72 = -2 / 3", value.numerator(), is(-2));
        // And the value should have denominator `3`
        assertThat("48 / -72 = -2 / 3", value.denominator(), is(3));
    }

    public void testIntOne(){
        assertThrows(IllegalArgumentException.class, () -> new Rational(1, 0));
    }


    public void TestOne()
    {
        Rational value = new Rational(48, -72);
        assertThat("-48 / -72 = 2 / 3", value.numerator(), is(2));
        assertThat("-48 / -72 = 2 / 3", value.denominator(), is(3));
    }

    public void TestTwo()
    {
        Rational value = new Rational(48, -72);
        assertThat("-48 / 72 = -2 / 3", value.numerator(), is(-2));
        assertThat("-48 / 72 = -2 / 3", value.denominator(), is(3));
    }

    public void TestThree()
    {
        Rational value = new Rational(1, 2);
        assertThat("1 / 2 = 1 / 2", value.numerator(), is(1));
        assertThat("1 / 2 = 1 / 2", value.denominator(), is(2));
    }

    public void TestFour()
    {
        Rational value = new Rational(2, 1);
        assertThat("2 / 1 = 2", value.numerator(), is(2));
        assertThat("2 / 1 = 2", value.denominator(), is(1));
    }

    public void TestFive()
    {
        Rational value = new Rational(2, 2);
        assertThat("2 / 2 = 1", value.numerator(), is(1));
        assertThat("2 / 2 = 1", value.denominator(), is(1));
    }
    
    public void testDefaultConstructor() {
        Rational r = new Rational();
        assertEquals(0, r.numerator());
        assertEquals(1, r.denominator());
    }


    public void testSingleParameterConstructor() {
        Rational r = new Rational(5);
        assertEquals(5, r.numerator());
        assertEquals(1, r.denominator());
    }


    public void testTwoParameterConstructor() {
        Rational r = new Rational(3, 5);
        assertEquals(3, r.numerator());
        assertEquals(5, r.denominator());
    }


    public void testCopyConstructor() {
        Rational original = new Rational(2, 3);
        Rational copy = new Rational(original);
        assertEquals(original.numerator(), copy.numerator());
        assertEquals(original.denominator(), copy.denominator());
    }


    public void testReciprocal() {
        Rational r = new Rational(3, 4);
        Rational reciprocal = r.reciprocal();
        assertEquals(4, reciprocal.numerator());
        assertEquals(3, reciprocal.denominator());
    }


    public void testPlus() {
        Rational r1 = new Rational(1, 2);
        Rational r2 = new Rational(1, 3);
        Rational result = r1.plus(r2);
        assertEquals(5, result.numerator());
        assertEquals(6, result.denominator());
    }


    public void testToString() {
        Rational r = new Rational(2, 3);
        assertEquals("2/3", r.toString());
    }


    public void testGCD() {
        Rational r = new Rational(6, 8);
        assertEquals(2, r.gcd(6, 8));
    }


    public void testIsZero() {
        Rational r = new Rational(0, 7);
        assertTrue(r.isZero());
    }


    public void testIsOne() {
        Rational r = new Rational(5, 5);
        assertTrue(r.isOne());
    }

    public void testIsMinusOne() {
        Rational r = new Rational(-7, 7);
        assertTrue(r.isMinusOne());
    }

    public void testNew() {
        // Given that I have created the `Rational` value `2/3`
        Rational original = new Rational(2, 3);
        // When I create a `Rational` value as a copy of the original `Rational` value
        Rational value = new Rational(original);
        // Then the copy's value should have numerator 2
        assertThat("the numerator should be 2", value.numerator(), is(2));
        // And the copy's value should have denominator 3
        assertThat("the denominator should be 3", value.denominator(), is(3));
    }

    public void testOpp() {
        Rational value = new Rational(2, 3);
        Rational opposite = value.opposite();
        assertThat("the opposite of 2 is -2", opposite.numerator(), is(-2));
        assertThat("the denominator should be 3", opposite.denominator(), is(3));
    }

    public void testMore() {
        Rational value = new Rational(2, 3);
        Rational reciprocal = value.reciprocal();
        assertThat("the numerator should be 3", reciprocal.numerator(), is(3));
        assertThat("the denominator should be 2", reciprocal.denominator(), is(2));
    }

    public void testSad() {
        Rational value = new Rational(0);
        assertThrows(IllegalArgumentException.class, value::reciprocal);
    }

    public void testTimes() {
        Rational p = new Rational(2, 3);
        Rational q = new Rational(5, 7);
        Rational result = p.times(q);
        assertThat("2 * 5 = 10", result.numerator(), is(10));
        assertThat("3 * 7 = 21", result.denominator(), is(21));
    }

    public void testDivision() {
        Rational numerator = new Rational(5, 2);
        Rational denominator = new Rational(3, 4);
        Rational result = numerator.dividedBy(denominator);
        assertThat("5/2 divided by 3/4 = 10/3", result.numerator(), is(10));
        assertThat("5/2 divided by 3/4 = 10/3", result.denominator(), is(3));
    }

    public void testPlusTwo() {
        Rational r1 = new Rational(7, 3);
        Rational r2 = new Rational(2, 5);
        Rational result = r1.plus(r2);
        assertThat("7/3 plus 2/5 = (35+6)/15 = 41/15", result.numerator(), is(41));
        assertThat("7/3 plus 2/5 = (35+6)/15 = 41/15", result.denominator(), is(15));
    }

    public void testOppositeTwo() {
        Rational r = new Rational(2, 5);
        Rational opposite = r.opposite();
        assertThat("Opposite of 2/5 is -2/5", opposite.numerator(), is(-2));
        assertThat("Opposite of 2/5 is -2/5", opposite.denominator(), is(5));
    }

    public void testSubtraction() {
        Rational r1 = new Rational(7, 3);
        Rational r2 = new Rational(2, 5);
        Rational result = r1.minus(r2);
        assertThat("7/3 minus 2/5 = 29/15", result.numerator(), is(29));
        assertThat("7/3 minus 2/5 = 29/15", result.denominator(), is(15));
    }

    public void testEquality() {
        Rational value1 = new Rational(3, 5);
        Rational value2 = new Rational(6, 10);
        assertTrue("3/5 should be equal to 6/10", value1.equals(value2));
    }

    public void testInequality() {
        Rational value1 = new Rational(2, 3);
        Rational value2 = new Rational(4, 5);
        assertFalse("2/3 should not be equal to 4/5", value1.equals(value2));
    }

    public void testPower() {
        Rational base = new Rational(2, 3);
        int exponent = 4;
        Rational result = base.raisedToThePowerOf(exponent);
        assertThat("(2/3)^4 = 16/81", result.numerator(), is(16));
        assertThat("(2/3)^4 = 16/81", result.denominator(), is(81));
    }

    public void testRaisedToThePowerOfZeroExponent() {
        Rational base = new Rational(5, 2);
        int exponent = 0;
        Rational result = base.raisedToThePowerOf(exponent);
        assertThat("(5/2)^0 = 1", result.numerator(), is(1));
        assertThat("(5/2)^0 = 1", result.denominator(), is(1));
    }


    public void testRaisedToThePowerOfNegativeExponentNonZeroBase() {
        Rational base = new Rational(3, 4);
        int exponent = -2;
        Rational result = base.raisedToThePowerOf(exponent);
        assertThat("(3/4)^-2 = 16/9", result.numerator(), is(16));
        assertThat("(3/4)^-2 = 16/9", result.denominator(), is(9));
    }

    public void testRaisedToThePowerOfNegativeExponentZeroBase() {
        Rational base = new Rational(0);
        int exponent = -3;
        assertThrows(IllegalArgumentException.class, () -> base.raisedToThePowerOf(exponent));
    }


    public void testComparison() {
        Rational a = new Rational(3, 4);
        Rational b = new Rational(5, 6);
        assertFalse(a.greaterThan(b));
        assertTrue(a.lessThan(b));
        assertFalse(a.equals(b));
    }

    public void testIntValue() {
        Rational rational = new Rational(7, 2);
        int result = rational.intValue();
        assertEquals(3, result);
    }

    public void testLongValue() {
        Rational rational = new Rational(7, 2);
        long result = rational.longValue();
        assertEquals(3L, result);
    }

    public void testFloatValue() {
        Rational rational = new Rational(7, 2);
        float result = rational.floatValue();
        assertEquals(3.5f, result, 0.0001);
    }

    public void testDoubleValue() {
        Rational rational = new Rational(7, 2);
        double result = rational.doubleValue();
        assertEquals(3.5, result, 0.0001);
    }

    public void testComparisonTo() {
        Rational a = new Rational(3, 4);
        Rational b = new Rational(5, 6);
        assertEquals(-1, a.compareTo(b));
        assertEquals(1, b.compareTo(a));
        assertEquals(0, a.compareTo(new Rational(6, 8)));
    }

    public void testEquals() {
        Rational r1 = new Rational(3, 5);
        Rational r2 = new Rational(6, 10);
        Rational r3 = new Rational(1, 2);

        assertEquals(r1, r2); 
        assertNotEquals(r1, r3);
    }

    public void testGreaterThanLessThan() {
        Rational r1 = new Rational(3, 5);
        Rational r2 = new Rational(2, 3);

        assertTrue(r2.greaterThan(r1)); 
        assertFalse(r1.greaterThan(r2)); 
        assertTrue(r1.lessThan(r2)); 
        assertFalse(r2.lessThan(r1));
    }

    public void testIsZeroOneMinusOne() {
        Rational zero = new Rational(0);
        Rational one = new Rational(3, 3);
        Rational minusOne = new Rational(-1);

        assertTrue(zero.isZero()); 
        assertTrue(one.isOne()); 
        assertTrue(minusOne.isMinusOne()); 
    }

    public void testToStringTwo() {
        Rational r1 = new Rational(4, 2);
        Rational r2 = new Rational(7, 1);

        assertEquals("2", r1.toString()); 
        assertEquals("7", r2.toString()); 
    }

    public void testEqualsSameObject() {
        Rational r1 = new Rational(3, 4);
        assertTrue(r1.equals(r1));
    }

    public void testEqualsNullObject() {
        Rational r1 = new Rational(3, 4);
        assertFalse(r1.equals(null));
    }

    public void testEqualsDifferentClass() {
        Rational r1 = new Rational(3, 4);
        Object obj = new Object();
        assertFalse(r1.equals(obj));
    }

    public void testEqualsDifferentNumerator() {
        Rational r1 = new Rational(3, 4);
        Rational r2 = new Rational(5, 4);
        assertFalse(r1.equals(r2));
    }

    public void testEqualsDifferentDenominator() {
        Rational r1 = new Rational(3, 4);
        Rational r2 = new Rational(3, 5);
        assertFalse(r1.equals(r2));
    }

    public void testEqualsSameValues() {
        Rational r1 = new Rational(3, 4);
        Rational r2 = new Rational(3, 4);
        assertTrue(r1.equals(r2));
    }

    public void testIsMinusOneTrue() {
        Rational r1 = new Rational(-1, 1);
        assertTrue(r1.isMinusOne());
    }

    public void testIsMinusOneFalseDifferentValues() {
        Rational r1 = new Rational(1, 2);
        assertFalse(r1.isMinusOne());
    }

    public void testIsMinusOneFalseNumeratorZero() {
        Rational r1 = new Rational(0, 1);
        assertFalse(r1.isMinusOne());
    }

    public void testIsMinusOneFalseDifferentDenominator() {
        Rational r1 = new Rational(-1, 2);
        assertFalse(r1.isMinusOne());
    }

    public void testIsMinusOneFalsePositiveNumerator() {
        Rational r1 = new Rational(1, 1);
        assertFalse(r1.isMinusOne());
    }

    public void testIsZeroTrue() {
        Rational r1 = new Rational(0, 1);
        assertTrue(r1.isZero());
    }

    public void testIsZeroFalsePositiveNumerator() {
        Rational r1 = new Rational(1, 1);
        assertFalse(r1.isZero());
    }

    public void testIsZeroFalseNegativeNumerator() {
        Rational r1 = new Rational(-1, 1);
        assertFalse(r1.isZero());
    }

    public void testIsZeroFalseNonZeroDenominator() {
        Rational r1 = new Rational(1, 2);
        assertFalse(r1.isZero());
    }

    public void testIsOneTrue() {
        Rational r1 = new Rational(2, 2);
        assertTrue(r1.isOne());
    }

    public void testIsOneFalseNumeratorNotEqualDenominator() {
        Rational r1 = new Rational(1, 2);
        assertFalse(r1.isOne());
    }

    public void testIsOneFalseZeroNumerator() {
        Rational r1 = new Rational(0, 1);
        assertFalse(r1.isOne());
    }

    public void testIsOneFalseNonZeroDenominator() {
        Rational r1 = new Rational(1, 2);
        assertFalse(r1.isOne());
    }


    public void testGreaterThanWithDouble() {
        Rational rational = new Rational(-1, 3);
        Double doubleValue = -0.5;

        assertTrue(rational.greaterThan(doubleValue));
    }


    public void testGreaterThanWithZero() {
        Rational rational = new Rational(0, 1);
        Integer zero = 0;

        assertFalse(rational.greaterThan(zero));
    }

    public void testLessThanWithDouble() {
        Rational rational = new Rational(-1, 3);
        Double doubleValue = 0.5;

        assertTrue(rational.lessThan(doubleValue));
    }


    public void testLessThanWithZero() {
        Rational rational = new Rational(0, 1);
        Integer zero = 0;

        assertFalse(rational.lessThan(zero));
    }

}
