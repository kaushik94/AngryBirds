/*
    AUTHOR : KAUSHIK
 */

package ab.Records;

import ab.vision.ABObject;

import java.awt.Point;


public class record{

    ABObject pig;
    double distance;
    Point p = new Point();
    int score;
    int ack;


    public void addPig(ABObject _pig){
        pig = _pig;
    }

    public void addDistance(Point _p, double _distance){
        distance = _distance;
        p.x = _p.x;
        p.y = _p.y;
    }

    public void addAck(ABObject _pig, int _ack){
        pig = _pig;
        ack = _ack;
    }

    public void add(ABObject _pig, Point _p){
        {
            pig = _pig;
            p.x = _p.x;
            p.y = _p.y;
        }
    }

}