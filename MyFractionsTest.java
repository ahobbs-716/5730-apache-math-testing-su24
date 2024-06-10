
import static org.junit.Assert.*;

import org.apache.commons.math3.exception.MathArithmeticException;
import org.apache.commons.math3.exception.NullArgumentException;
import org.apache.commons.math3.fraction.Fraction;
import org.junit.Test;

import javax.swing.plaf.PanelUI;


public class MyFractionsTest {

	//null values
	@Test(expected=NullArgumentException.class)
	public void testF1NullF2Null() {
		MyFractions.addSub(null, null, false);
	}

	@Test(expected=NullArgumentException.class)
	public void testF1FirstNull() {
		MyFractions.addSub(Fraction.ONE_HALF, null, false);
	}

	@Test(expected=NullArgumentException.class)
	public void testF1SecondNull() {
		MyFractions.addSub(null, Fraction.ONE_HALF, false);
	}

	//Basic addition and subtraction
	@Test
	public void testBasicAddition() {
		Fraction f1 = Fraction.TWO_FIFTHS;
		Fraction f2 = Fraction.ONE_FIFTH;

		assertEquals(Fraction.THREE_FIFTHS, MyFractions.addSub(f1, f2, true));

	}
	@Test
	public void testBasicSubtraction() {
		Fraction f1 = Fraction.THREE_FIFTHS;
		Fraction f2 = Fraction.TWO_FIFTHS;

		assertEquals(Fraction.ONE_FIFTH, MyFractions.addSub(f1, f2, false));
	}

	//negative results
	@Test
	public void testAddToNegativeResult() {

		Fraction f1 = Fraction.FOUR_FIFTHS.negate();
		Fraction f2 = Fraction.ONE_FIFTH.negate();

		assertEquals(Fraction.ONE.negate(), MyFractions.addSub(f1, f2, true));

	}
	@Test
	public void testSubtractToNegativeResult() {
		Fraction f1 = Fraction.ONE_FIFTH;
		Fraction f2 = Fraction.THREE_FIFTHS;

		assertEquals(Fraction.TWO_FIFTHS.negate(), MyFractions.addSub(f1, f2, false));
	}

	//top heavy fractions
	@Test
	public void testAddTopHeavyFractions() {
		Fraction f1 = Fraction.THREE_FIFTHS;
		Fraction f2 = Fraction.THREE_FIFTHS;

		assertEquals(Fraction.getReducedFraction(6, 5), MyFractions.addSub(f1, f2, true));
	}
	@Test
	public void testSubtractTopHeavyFractions() {
		Fraction f1 = Fraction.getReducedFraction(8, 5);
		Fraction f2 = Fraction.ONE_FIFTH;

		assertEquals(Fraction.getReducedFraction(7, 5), MyFractions.addSub(f1, f2, false));
	}

	//zero denominators
	@Test (expected = NullArgumentException.class)
	public void testAddToZeroDenominator() {			//assume that an invalid fraction should be treated as null

		Fraction f1 = Fraction.getReducedFraction(8, 0);
		Fraction f2 = Fraction.ONE_FIFTH;

		assertEquals(Fraction.ONE_FIFTH, MyFractions.addSub(f1, f2, true));

	}

	@Test (expected = NullArgumentException.class)
	public void testSubtractFromZeroDenominator() {		//assume that an invalid fraction should be treated as null

		Fraction f1 = Fraction.getReducedFraction(8, 0);
		Fraction f2 = Fraction.ONE_FIFTH;

		assertEquals(Fraction.ONE_FIFTH.negate(), MyFractions.addSub(f1, f2, false));

	}

	//zero numerators
	@Test
	public void testAddToZeroNumerator() {

		Fraction f1 = Fraction.getReducedFraction(0, 5);
		Fraction f2 = Fraction.ONE_FIFTH;

		assertEquals(Fraction.ONE_FIFTH, MyFractions.addSub(f1, f2, true));

	}
	@Test
	public void testSubtractFromZeroNumerator() {

		Fraction f1 = Fraction.getReducedFraction(0, 5);
		Fraction f2 = Fraction.ONE_FIFTH;

		assertEquals(Fraction.ONE_FIFTH.negate(), MyFractions.addSub(f1, f2, false));

	}

	@Test
	public void testAdditionOfZeroNumeratorasF2() {

		Fraction f1 = Fraction.ONE_FIFTH;
		Fraction f2 = Fraction.getReducedFraction(0, 5);

		assertEquals(Fraction.ONE_FIFTH, MyFractions.addSub(f1, f2, true));

	}
	@Test
	public void testSubtractZeroNumeratorasF2() {

		Fraction f1 = Fraction.ONE_FIFTH;
		Fraction f2 = Fraction.getReducedFraction(0, 5);

		assertEquals(Fraction.ONE_FIFTH, MyFractions.addSub(f1, f2, false));

	}

	//simplifications
	@Test
	public void testAddMixedDenominators() {	//CHECK ACCURACY

		Fraction f2 = Fraction.ONE_THIRD;
		Fraction f1 = Fraction.ONE_FIFTH;

		assertEquals(Fraction.getReducedFraction(8, 15), MyFractions.addSub(f1, f2, true));

	}
	@Test
	public void testSubtractMixedDenominators() {	//CHECK ACCURACY

		Fraction f2 = Fraction.ONE_THIRD;
		Fraction f1 = Fraction.ONE_FIFTH;

		assertEquals(Fraction.getReducedFraction(2, 15), MyFractions.addSub(f1, f2, false));

	}
	@Test
	public void testReturnSimplifiedValues() {

		Fraction f2 = Fraction.ONE_QUARTER;
		Fraction f1 = Fraction.ONE_QUARTER;

		assertEquals(Fraction.ONE_HALF, MyFractions.addSub(f1, f2, true));

	}

}
