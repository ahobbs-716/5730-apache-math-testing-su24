
import static org.junit.Assert.*;

import org.apache.commons.math3.exception.MathArithmeticException;
import org.apache.commons.math3.exception.NullArgumentException;
import org.apache.commons.math3.fraction.Fraction;
import org.junit.Test;

import javax.swing.plaf.PanelUI;


public class MyFractionsTest {

	@Test(expected=NullArgumentException.class)
	public void testF1NullF2Null() {
		MyFractions.addSub(null, null, false);
	}

	@Test(expected=NullArgumentException.class)
	public void testF1FirstNull() {
		MyFractions.addSub(Fraction.ONE_HALF, null, false);
	}

	@Test(expected=NullArgumentException.class)
	public void testF1SecondNUll() {
		MyFractions.addSub(null, Fraction.ONE_HALF, false);
	}

	@Test
	public void testAddSubSubtractionSign() {
		Fraction f1 = Fraction.THREE_FIFTHS;
		Fraction f2 = Fraction.TWO_FIFTHS;

		assertEquals(Fraction.ONE_FIFTH, MyFractions.addSub(f1, f2, false));
	}

	@Test
	public void testAddSubAdditionSign() {
		Fraction f1 = Fraction.TWO_FIFTHS;
		Fraction f2 = Fraction.ONE_FIFTH;

		assertEquals(Fraction.THREE_FIFTHS, MyFractions.addSub(f1, f2, true));

	}

	@Test
	public void testAddSubNegativeFractionsUsingSubtract() {
		Fraction f1 = Fraction.ONE_FIFTH;
		Fraction f2 = Fraction.THREE_FIFTHS;

		assertEquals(Fraction.TWO_FIFTHS.negate(), MyFractions.addSub(f1, f2, false));
	}

	@Test
	public void testAddSubNegativeFractionsUsingAdd() {

		Fraction f1 = Fraction.ONE_FIFTH.negate();
		Fraction f2 = Fraction.THREE_FIFTHS.negate();

		assertEquals(Fraction.FOUR_FIFTHS.negate(), MyFractions.addSub(f1, f2, true));

	}


	@Test
	public void testAddSubTopHeavyFractions() {
		Fraction f1 = Fraction.THREE_FIFTHS;
		Fraction f2 = Fraction.THREE_FIFTHS;

		assertEquals(Fraction.getReducedFraction(6, 5), MyFractions.addSub(f1, f2, false));
	}


	@Test
	public void testAddSubTopHeavyFractionsUsingSubtract() {
		Fraction f1 = Fraction.getReducedFraction(8, 5);
		Fraction f2 = Fraction.ONE_FIFTH;

		assertEquals(Fraction.getReducedFraction(7, 5), MyFractions.addSub(f1, f2, false));
	}

	@Test
	public void testAddSubZeroDenominator() {

		Fraction f1 = Fraction.getReducedFraction(8, 0);
		Fraction f2 = Fraction.ONE_FIFTH;

		assertEquals(Fraction.ONE_FIFTH, MyFractions.addSub(f1, f2, true));

	}

	@Test
	public void testAddSubZeroNumerator() {

		Fraction f1 = Fraction.getReducedFraction(0, 5);
		Fraction f2 = Fraction.ONE_FIFTH;

		assertEquals(Fraction.ONE_FIFTH, MyFractions.addSub(f1, f2, true));

	}

	@Test
	public void testAddSubZeroSubtractNumerator() {	//CHECK ACCURACY

		Fraction f1 = Fraction.getReducedFraction(0, 5);
		Fraction f2 = Fraction.ONE_FIFTH;

		assertEquals(Fraction.ONE_FIFTH, MyFractions.addSub(f1, f2, false));

	}

	@Test
	public void testAddSubSecondZeroNumerator() {	//CHECK ACCURACY

		Fraction f2 = Fraction.getReducedFraction(0, 5);
		Fraction f1 = Fraction.ONE_FIFTH;

		assertEquals(Fraction.ONE_FIFTH, MyFractions.addSub(f1, f2, false));

	}

	@Test
	public void testAddSubGreatestCommonDivisor() {	//CHECK ACCURACY

		Fraction f2 = Fraction.ONE_THIRD;
		Fraction f1 = Fraction.ONE_FIFTH;

		assertEquals(Fraction.ONE_FIFTH, MyFractions.addSub(f1, f2, false));

	}
	//simplifying?

}
