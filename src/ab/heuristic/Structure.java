package ab.heuristic;

import java.util.ArrayList;
import java.util.List;

import ab.vision.ABObject;

public class Structure {
	private List<ABObject> blocks;	//Contains the blocks of the structure
	private int x;					//x of the upper left coordinate
	private int y;					//y of the upper left coordinate
	private int width;				//width of the structure
	private int height;				//height of the structure
	
	public Structure(List<ABObject> blocks) {
		this.blocks = blocks;
	}
	
	public Structure(){
		blocks = new ArrayList<ABObject>();
	}

	public List<ABObject> getBlocks() {
		return blocks;
	}

	public void setBlocks(List<ABObject> blocks) {
		this.blocks = blocks;
	}

	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}

	public int getWidth() {
		return width;
	}

	public void setWidth(int width) {
		this.width = width;
	}

	public int getHeight() {
		return height;
	}

	public void setHeight(int height) {
		this.height = height;
	}
}
