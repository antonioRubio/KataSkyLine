package main;

import java.util.ArrayList;
import java.util.List;

public class SkyLine {
	
	private static final int EMPTY = -1;
	private static final int NO_HEIGHT_BUILDING = 0;
	private static final int START_POSITION_BUILDING = 0;
	private static final int HEIGHT_POSITION_BUILDING = 1;
	private static final int END_POSITION_BUILDING = 2;
	
	private List<Measure> skyLinesList;
	private int[][] buildingMeasures;
	private int[] heights;
	private int maxPosition = EMPTY;
	
	public void setBuildingMeasures(int[][] buildingMeasures) {
		this.buildingMeasures = buildingMeasures;
	}

	public int[][] getSkyLineArray() {
		if (skyLinesList == null)
			createSkyLines();
		return skyLinesToArray();
	}
	
	private int[][] skyLinesToArray() {
		int numSkyLines = skyLinesList.size();
		int[][] skyLinesArray = new int[numSkyLines][Measure.NUM_OF_PARAMETERS];
		for (int skyLinePosition = 0; skyLinePosition < numSkyLines; skyLinePosition++) {
			Measure skyLine = skyLinesList.get(skyLinePosition);
			skyLinesArray[skyLinePosition] = skyLine.toArray();
		}
		return skyLinesArray;
	}

	private void createSkyLines() {
		setMaxPosition();
		initializeHeights();
		createHeightsByMeasures();
		generateSkyLinesByHeights();
	}

	private void setMaxPosition() {
		int numBuildings = buildingMeasures.length;
		if (numBuildings == 0) return;
		int[] measures = buildingMeasures[0];
		int maxBuildingPosition = measures[END_POSITION_BUILDING];
		maxPosition = maxBuildingPosition;
		for (int position = 1; position < numBuildings; position++) {
			measures = buildingMeasures[position];
			maxBuildingPosition = measures[END_POSITION_BUILDING];
			if (maxBuildingPosition > maxPosition)
				maxPosition = maxBuildingPosition;
		}
		
	}
	
	private void initializeHeights() {
		heights = new int[maxPosition];
		for (int position = 0; position < maxPosition; position++)
			heights[position] = NO_HEIGHT_BUILDING;
	}
	
	private void createHeightsByMeasures() {
		int numBuildings = buildingMeasures.length;
		for (int numBuild = 0; numBuild < numBuildings; numBuild++) {
			int[] measures = buildingMeasures[numBuild];
			int startBuildingPosition = measures[START_POSITION_BUILDING];
			int endBuildingPosition = measures[END_POSITION_BUILDING];
			int heightBuilding = measures[HEIGHT_POSITION_BUILDING];
			for (int position = startBuildingPosition; position < endBuildingPosition;
					position++) {
				if (heights[position] < heightBuilding)
					heights[position] = heightBuilding;
			}
		}
	}
	
	private void generateSkyLinesByHeights() {
		skyLinesList = new ArrayList<Measure>();
		int position = 0;
		int heightBuilding = NO_HEIGHT_BUILDING;
		int startBuildingPosition = 0; 
		while (position < heights.length) {
			heightBuilding = heights[position];
			while ((position + 1 < heights.length) && (heightBuilding == heights[position + 1]))
				position++;
			position++;
			Measure line = new Line(startBuildingPosition, heightBuilding, position);
			if (!line.isZeroHeight())
				skyLinesList.add(line);
			startBuildingPosition = position;
		}
	}
}
