/*
    AUTHOR : KAUSHIK
 */

package ab.Records;

import ab.demo.other.Shot;

public class record{

    Shot shot = new Shot();
    double angle;
    int score;
    int ack;

    public void addShot(Shot _shot){
        shot = _shot;
    }

    public void addAngle(double _angle){
        angle = _angle;
    }

    public void addScore(int _score, int _ack){
        score = _score ;
        ack = _ack;
    }

    public void add(Shot _shot, double _angle){
        {
            shot = _shot;
            angle = _angle;
        }
    }

}