/*
    AUTHOR: KAUSHIK
 */

package ab.Records;

import ab.Records.record;
import ab.vision.ABObject;

import java.util.List;
import java.util.ArrayList;
import java.io.File;
import java.awt.Point;

public class learner{

    public List<record> Table = new ArrayList<record>();
    private int count;
    private int alphaX = 0;
    private int alphaY = 0;

    private int good;
    public learner(int _X, int _Y){
        count = 0;
        alphaX = _X;
        alphaY = _Y;
    }

    public void LoadTable(){
        File f = new File("output.txt");
        if(f.exists() && !f.isDirectory()){
            /* More rote learning */
        }
    }

    public ABObject explore(List<record> data){
        if(Table != null && data != null)
        for(record prev: Table) {
            Point _p = prev.p;
            for (record R : data) {
                if (_p.x <= R.p.x + alphaX && _p.x >= R.p.x - alphaX) {
                    if (_p.y <= R.p.y + alphaY && _p.y >= R.p.y - alphaY)
                        //if (R.ack == 1) {
                            System.out.println("found match. Fuck Yeah !!");
                            return R.pig;
                        //}
                }
            }
        }
        return null;
    }

    public void exploit(Point _p, ABObject _pig){
        /*create a record and add this to it.*/
        record R = new record();
        R.add(_pig, _p);
        Table.add(R);
        count++;
        System.out.println(Table);
    }

    public void exploit(record _record){
        /*overloading : add it directly*/
        Table.add(_record);
        count ++;
    }
}