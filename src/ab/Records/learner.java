/*
    AUTHOR: KAUSHIK
 */

package ab.Records;

import ab.Records.record;
import ab.vision.Vision;
import ab.vision.ABObject;
import ab.vision.VisionUtils;
import ab.planner.TrajectoryPlanner;

import java.util.List;
import java.util.ArrayList;
import java.io.File;
import java.awt.Point;
import java.awt.image.BufferedImage;
import java.awt.Rectangle;

public class learner{

    public List<record> Table = new ArrayList<record>();
    private int count;
    private int imageThreshold;
    private int angleThreshold;
    private int threshold;

    private int good;
    public learner(int _imageThreshold, int _angleThreshold, int _threshold){
            imageThreshold = _imageThreshold;
            angleThreshold = _angleThreshold;
            threshold = _threshold;
    }

    public void LoadTable(){
        File f = new File("output.txt");
        if(f.exists() && !f.isDirectory()){
            /* More rote learning */
        }
    }

    public double explore(BufferedImage image){
        if(Table != null && image != null)
            for(record prev: Table) {
                int dI = Math.abs(VisionUtils.numPixelsDifferent(prev.screenshot, image));
                System.out.println(dI);
                if(dI <= imageThreshold) {
                    if(prev.ack == 1)
                        return prev.angle;
                    if(prev.ack == -1){
                        System.out.println("fucked !!");
                        double x = -1*(prev.angle);
                        return x;
                    }
                }
            }
        return 0;
    }

    public Point getTarget(List<ABObject> pigs, BufferedImage image, Rectangle sling, TrajectoryPlanner tp){
            double idealAngle = explore(image);
            System.out.println(idealAngle);
            if(idealAngle == 0)
                return null;
            for(ABObject pig: pigs){
                Point _tpt = pig.getCenter();
                ArrayList<Point> pts = tp.estimateLaunchPoint(sling, _tpt);
                for(Point p: pts){
                    double releaseAngle = tp.getReleaseAngle(sling, p);
                    if(idealAngle >= 0) {
                        System.out.println("good angle found !!");
                        if (Math.abs(Math.abs(idealAngle) - releaseAngle) <= angleThreshold) {
                            return p;
                        }
                    }
                    if(idealAngle < 0) {
                        System.out.println("bad angle found !!");
                        if (Math.abs(Math.abs(idealAngle) - releaseAngle) > angleThreshold) {
                            return p;
                        }
                    }
                }
            }
        return null;
    }

    public void exploit(BufferedImage image, double _angle, Vision vision){
        /*create a record and add this to it.*/
        record R = new record();
        R.addImage(image);
        R.addAngle(_angle);
        Table.add(R);
        count++;
        //System.out.println(Table);
    }

    public void exploit(record _record){
        /*overloading : add it directly*/
        Table.add(_record);
        count ++;
    }

    public void exploit(BufferedImage image, Vision vision){

        if(!Table.isEmpty()) {
            record prev = Table.get(Table.size() - 1);
            int diff = VisionUtils.numPixelsDifferent(prev.screenshot, image);
            if (diff >= threshold) {
                System.out.println("updating a good record !!");
                prev.addAck(1);
            }
            else {
                System.out.println("updating a bad record !!");
                prev.addAck(-1);
            }
        }
        else
            System.out.println("This should not happen !!");
    }
}