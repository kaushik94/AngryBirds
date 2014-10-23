/*
    AUTHOR: KAUSHIK
 */

package ab.Records;

import ab.Records.record;
import ab.demo.other.Shot;

import java.util.List;
import java.io.File;

public class learner{

    private List<record> Table;
    private int count;
    private double alpha = 0;
    private double betaX = 0;
    private double betaY = 0;

    private int good;
    public learner(double AngleThreshold, int dx, int dy){
        count = 0;
        alpha = AngleThreshold;
        betaX = dx;
        betaY = dy;
    }

    public void LoadTable(){
        File f = new File("output.txt");
        if(f.exists() && !f.isDirectory()){
            /* More rote learning */
        }
    }

    public int explore(double angle, Shot shot){
            for(record R: Table /*each record in table check if it is close to the given shot ie within the range of given threshold*/){
                    if(R.angle <= angle+alpha && R.angle >= angle-alpha){
                        if(R.shot.getDx() <= 10 && R.shot.getDy() < 10){
                            if(R.ack == 1){
                                return 1;
                            }
                            else if(R.ack == -1){
                                return -1;
                            }
                        }
                    }
            }
        return 0;
    }

    public void exploit(double angle, Shot shot){
        /*create a record and add this to it.*/
        record R = new record();
        R.add(shot, angle);
        Table.add(R);
        count++;
    }

    public void exploit(record _record){
        /*overloading : add it directly*/
        Table.add(_record);
        count ++;
    }
}