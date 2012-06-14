package test;

import static org.junit.Assert.*;

import main.Line;
import main.Measure;

import org.junit.Test;

public class LineTest {

	@Test
	public void toArrayTest() {
		int start = 1;
		int height = 2;
		int end = 3;
		int[] expecteds = {start, height, end};
		Measure line = new Line(start, height, end);
		assertArrayEquals(expecteds, line.toArray());
	}
	
	@Test
	public void zeroHeightTest() {
		int start = 1;
		int height = 0;
		int end = 3;
		Measure line = new Line(start, height, end);
		assertTrue(line.isZeroHeight());
	}

}
