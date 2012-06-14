package test;

import static org.junit.Assert.*;

import main.SkyLine;

import org.junit.Test;

public class SkyLineTest {

	@Test
	public void oneMeasureTest() {
		SkyLine skyLine = new SkyLine();
		int[][] buildingMeasures = {{1, 3, 2}};
		skyLine.setBuildingMeasures(buildingMeasures);
		int[][]actuals = skyLine.getSkyLineArray();
		assertArrayEquals(buildingMeasures, actuals);
	}
	
	@Test
	public void twoNonOverlapMeasureTest() {
		SkyLine skyLine = new SkyLine();
		int[][] buildingMeasures = {{1, 3, 2}, {2, 4, 6}};
		skyLine.setBuildingMeasures(buildingMeasures);
		int[][]actuals = skyLine.getSkyLineArray();
		assertArrayEquals(buildingMeasures, actuals);
	}
	
	@Test
	public void twoNonOverlapSameHightMeasureTest() {
		SkyLine skyLine = new SkyLine();
		int[][] buildingMeasures = {{1, 3, 2}, {2, 3, 6}};
		int[][] expected = {{1, 3, 6}};
		skyLine.setBuildingMeasures(buildingMeasures);
		int[][]actuals = skyLine.getSkyLineArray();
		assertArrayEquals(expected, actuals);
	}
	
	@Test
	public void solveetTest() {
		SkyLine skyLine = new SkyLine();
		int[][] buildingMeasures = {{1, 3, 2}, {1, 2, 4}, {3, 3, 5}, {4, 4, 6}};
		int[][] expected = {{1, 3, 2}, {2, 2, 3}, {3, 3, 4}, {4, 4, 6}};
		skyLine.setBuildingMeasures(buildingMeasures);
		int[][]actuals = skyLine.getSkyLineArray();
		assertArrayEquals(expected, actuals);
	}
}
