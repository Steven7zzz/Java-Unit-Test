package numbers;

import java.lang.Comparable;

public class Rational extends Number implements Comparable<Number> {
    private int numerator;
    private int denominator;

    // Constructors
    public Rational() {
        this(0, 1);
    }

    public Rational(int a) {
        this(a, 1);
    }

    public Rational(int a, int b) {
        if (b == 0) {
            throw new IllegalArgumentException("Denominator cannot be zero");
        }
        int gcd = gcd(Math.abs(a), Math.abs(b));
        this.numerator = a / gcd;
        this.denominator = b / gcd;
        if (b < 0) {
            this.numerator = -this.numerator;
            this.denominator = -this.denominator;
        }
    }

    public Rational(Rational r) {
        this(r.numerator, r.denominator);
    }

    // Methods
    public int numerator() {
        return this.numerator;
    }

    public int denominator() {
        return this.denominator;
    }

    public Rational opposite() {
        return new Rational(-this.numerator, this.denominator);
    }

    public Rational reciprocal() {
        if (this.numerator == 0) {
            throw new IllegalArgumentException("Cannot take reciprocal of zero");
        }
        return new Rational(this.denominator, this.numerator);
    }

    public Rational plus(Rational r) {
        int newNumerator = this.numerator * r.denominator + r.numerator * this.denominator;
        int newDenominator = this.denominator * r.denominator;
        return new Rational(newNumerator, newDenominator);
    }

    public Rational minus(Rational r) {
        return this.plus(r.opposite());
    }

    public Rational times(Rational r) {
        int newNumerator = this.numerator * r.numerator;
        int newDenominator = this.denominator * r.denominator;
        return new Rational(newNumerator, newDenominator);
    }

    public Rational dividedBy(Rational r) {
        return this.times(r.reciprocal());
    }

    public Rational raisedToThePowerOf(int exponent) {

        if (exponent < 0) {
            if (numerator == 0) {
                throw new IllegalArgumentException("Cannot raise zero to a negative power.");
            }
            return new Rational((int) Math.pow(denominator, -exponent), (int) Math.pow(numerator, -exponent));
        } 
        return new Rational((int) Math.pow(numerator, exponent), (int) Math.pow(denominator, exponent));
    }

    @Override
    public boolean equals(Object o) {
        if (o instanceof Rational) {
            Rational r = (Rational) o;
            return this.numerator == r.numerator && this.denominator == r.denominator;
        }
        return false;
    }

    @Override
    public int compareTo(Number o) {
        if (o instanceof Rational) {
            Rational r = (Rational) o;
            // Compare this Rational to another Rational
            double diff = (double) this.numerator / this.denominator - (double) r.numerator / r.denominator;
            return Double.compare(diff, 0);
        } else {
            // Compare this Rational to another Number
            double diff = (double) this.numerator / this.denominator - o.doubleValue();
            return Double.compare(diff, 0);
        }
    }

    public boolean greaterThan(Number n) {
        return compareTo(n) > 0;
    }

    public boolean greaterThan(Rational r) {
        return compareTo(r) > 0;
    }

    public boolean lessThan(Number n) {
        return compareTo(n) < 0;
    }

    public boolean lessThan(Rational r) {
        return compareTo(r) < 0;
    }

    public boolean isZero() {
        return this.numerator == 0;
    }

    public boolean isOne() {
        return this.numerator == this.denominator;
    }

    public boolean isMinusOne() {
        return this.numerator == -this.denominator;
    }

    @Override
    public String toString() {
        if (denominator == 1) {
            return Integer.toString(numerator);
        } else {
            return numerator + "/" + denominator;
        }
    }

    // Implement the abstract methods from Number
    @Override
    public int intValue() {
        return this.numerator / this.denominator;
    }

    @Override
    public long longValue() {
        return this.numerator / this.denominator;
    }

    @Override
    public float floatValue() {
        return (float) this.numerator / this.denominator;
    }

    @Override
    public double doubleValue() {
        return (double) this.numerator / this.denominator;
    }

    // Helper method to calculate greatest common divisor (GCD)
    public int gcd(int a, int b) {
        while (b != 0) {
            int temp = b;
            b = a % b;
            a = temp;
        }
        return Math.abs(a);
    }
}
