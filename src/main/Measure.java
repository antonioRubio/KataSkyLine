package main;

public abstract class Measure {
	public static final int NUM_OF_PARAMETERS = 3;
	private static final int NO_HEIGHT = 0;
	private int start;
	private int height;
	private int end;
	
	public Measure(int start, int height, int end) {
		this.start = start;
		this.height = height;
		this.end = end;
	}
	
	public int[] toArray() {
		return new int[] {start, height, end};
	}
	
	public boolean isZeroHeight() {
		return height == NO_HEIGHT;
	}
}
