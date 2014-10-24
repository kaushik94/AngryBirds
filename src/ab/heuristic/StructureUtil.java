package ab.heuristic;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

import ab.utils.ABUtil;
import ab.vision.ABObject;
import ab.vision.Vision;

public class StructureUtil {
	public static List<Structure> getDistinctStructures(Vision vision){
		List<ABObject> blocks = vision.findBlocksMBR();
		if(blocks!=null){
			Collections.sort(blocks, new Comparator<ABObject>() {
				@Override
				public int compare(ABObject o1, ABObject o2) {
					return o1.y - o2.y;
				}
			});
			List<Structure> structures = new ArrayList<Structure>();
			while(!blocks.isEmpty()){
				Structure newStructure = new Structure(blocks.remove(0));
				Queue<ABObject> supportersQueue = new LinkedList<ABObject>();
				supportersQueue.add(newStructure.getBlocks().get(0));
				while(!supportersQueue.isEmpty()){
					List<ABObject> supporters = ABUtil.getSupporters(supportersQueue.poll(), blocks);
					for(ABObject supporter : supportersQueue)
						newStructure.reAssignParameters(
							Math.min(newStructure.x, supporter.x),
							Math.min(newStructure.y, supporter.y),
							Math.max(newStructure.getX2(), supporter.x + supporter.width) - newStructure.x,
							Math.max(newStructure.getY2(), supporter.y + supporter.height) - newStructure.y
						);
					newStructure.getBlocks().addAll(supporters);
					supportersQueue.addAll(supporters);
					blocks.removeAll(supporters);
				}
				structures.add(newStructure);
			}
			return structures;
		}
		return null;
	}
}
