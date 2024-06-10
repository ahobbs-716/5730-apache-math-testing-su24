import static org.junit.Assert.*;

import org.apache.commons.math3.exception.DimensionMismatchException;
import org.apache.commons.math3.exception.NullArgumentException;
import org.junit.Test;


public class MySorterTest {

	//tests checking invalid inputs
	@Test(expected=NullArgumentException.class)
	public void testNullInputs() {
		MySorter.sortInPlace(null, MySorter.OrderDirection.DECREASING, (double[])null);
	}
	@Test (expected =NullArgumentException.class)
	public void testSortInPlaceHandlesInvalidX() {

		double[] yList = {2, 3, 4, 5};

		MySorter.sortInPlace(null, MySorter.OrderDirection.INCREASING, yList);
	}
	@Test (expected=NullArgumentException.class)		//assume that a fully null list should also be treated as a null argument
	public void testSortInPlaceHandlesInvalidYList() {

		double[] x = {2, 3, 4, 5};

		MySorter.sortInPlace(x, MySorter.OrderDirection.INCREASING, null);

	}
	@Test (expected=NullArgumentException.class)
	public void testSortInPlaceHandlesInvalidYListContents() {

		double[] x = {2, 3, 4, 5};

		MySorter.sortInPlace(x, MySorter.OrderDirection.INCREASING, (double[])null);

	}
	@Test		//assume that a null direction should imply no sorting, leave inputs as is
	public void testSortInPlaceHandlesInvalidOrderDirection() {

		double[] x = {2, 3, 4, 5};
		double[] yList = {2, 5, 7, 2};

		double[] xExpected = {2, 3, 4, 5};
		double[] yListExpected = {2, 5, 7, 2};

		MySorter.sortInPlace(x, null, yList);
		assertArrayEquals(xExpected, x, 0.0);
		assertArrayEquals(yListExpected, yList,0.0);

	}

	//test for dimension mismatches
	@Test (expected=DimensionMismatchException.class)
	public void testSortInPlaceHandlesDimensionMismatch() {

		double[] x = {2, 3, 4, 5};
		double[] yList = {2, 5, 7};

		MySorter.sortInPlace(x, MySorter.OrderDirection.INCREASING, yList);

	}

	//tests checking for x
	@Test
	public void testSortInPlaceSortsXIncreasing(){

		double[] x = {5, 3, 4};
		double[] yList = {7, 8, 9};

		double[] xExpected = {3, 4, 5};
		double[] yListExpected = {8, 9, 7};

		MySorter.sortInPlace(x, MySorter.OrderDirection.INCREASING, yList);
		assertArrayEquals(x, xExpected, 0.0);
		assertArrayEquals(yList, yListExpected, 0.0);
	}
	@Test (expected = NullArgumentException.class)
	public void testSortInPlaceNullYListSetUp() {

		double[] x = {5, 3, 4};
		double[] yList = null;

		MySorter.sortInPlace(x, MySorter.OrderDirection.INCREASING, yList);

	}
	@Test
	public void testSortInPlaceSortsXDecreasing(){

		double[] x = {5, 3, 4};
		double[] yList = {7, 8, 9};

		double[] xExpected = {5, 4, 3};
		double[] yListExpected = {7, 9, 8};

		MySorter.sortInPlace(x, MySorter.OrderDirection.DECREASING, yList);
		assertArrayEquals(x, xExpected, 0.0);
		assertArrayEquals(yList, yListExpected, 0.0);
	}
	@Test
	public void testSortInPlaceHandlesDuplicates( ){

		double[] x = {5, 3, 4};
		double[] yList = {7, 8, 7};

		double[] xExpected = {3, 4, 5};
		double[] yListExpected = {8, 7, 7};

		MySorter.sortInPlace(x, MySorter.OrderDirection.INCREASING, yList);
		assertArrayEquals(x, xExpected, 0.0);
		assertArrayEquals(yList, yListExpected, 0.0);

	}
	@Test
	public void testSortInPlaceHandlesNegatives() {

		double[] x = {5, 3, 4};
		double[] yList = {-7, 8, 9};

		double[] xExpected = {3, 4, 5};
		double[] yListExpected = {8, 9, -7};

		MySorter.sortInPlace(x, MySorter.OrderDirection.INCREASING, yList);
		assertArrayEquals(x, xExpected, 0.0);
		assertArrayEquals(yList, yListExpected, 0.0);
	}
	@Test
	public void testSortInPlaceHandlesDecimals() {

		double[] x = {5, 3, 4};
		double[] yList = {7, 8, 1.9};

		double[] xExpected = {3, 4, 5};
		double[] yListExpected = {8, 1.9, 7};

		MySorter.sortInPlace(x, MySorter.OrderDirection.INCREASING, yList);
		assertArrayEquals(x, xExpected, 0.0);
		assertArrayEquals(yList, yListExpected, 0.0);
	}
	@Test
	public void testSortInPlaceHandlesZero() {

		double[] x = {5, 3, 4};
		double[] yList = {7, 0, 9};

		double[] xExpected = {3, 4, 5};
		double[] yListExpected = {0, 9, 7};

		MySorter.sortInPlace(x, MySorter.OrderDirection.INCREASING, yList);
		assertArrayEquals(x, xExpected, 0.0);
		assertArrayEquals(yList, yListExpected, 0.0);
	}


}
