package ab.heuristic;

import java.util.ArrayList;
import java.util.List;

import ab.vision.ABObject;

public class Structure {
	private List<ABObject> blocks;	//Contains the blocks of the structure
	public int x;					//x of the upper left coordinate
	public int y;					//y of the upper left coordinate
	public int width;				//width of the structure
	public int height;				//height of the structure
	
	public Structure(List<ABObject> blocks) {
		this.blocks = blocks;
	}
	
	public Structure(){
		blocks = new ArrayList<ABObject>();
	}
	
	public Structure(ABObject block){
		blocks = new ArrayList<ABObject>();
		blocks.add(block);
		this.x = block.x;
		this.y = block.y;
		this.width = block.width;
		this.height = block.height;
	}

	public List<ABObject> getBlocks() {
		return blocks;
	}
	
	//Returns the area of the rectangle formed by the structure
	public int getArea(){
		return this.height * this.width;
	}
	
	//Returns the x of bottom right coordinate of the structure
	public int getX2(){
		return this.x + this.width;
	}
	
	//Returns the y of the bottom right coordinate of the structure
	public int getY2(){
		return this.y + this.height;
	}
	
	//To reassign the member variables of the structure
	public void reAssignParameters(int x, int y, int width, int height){
		this.x = x;
		this.y = y;
		this.width= width;
		this.height = height;
	}
	
	//To print the details of the structure
	@Override
	public String toString(){
		return String.format("Structure : [ x = " + this.x + ", y = " + this.y+ ", width = " + this.width + ", height = " + this.height + ", blocks = " + this.blocks.size() + ", Area = " + this.getArea());
	}
}
