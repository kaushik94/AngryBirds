/*
    AUTHOR : KAUSHIK
 */

package ab.Records;

import ab.vision.ABObject;

import java.awt.Point;
import java.awt.image.BufferedImage;

public class record{

    double angle;
    public BufferedImage screenshot;
    double score;
    int ack;

    public void addScore(int _score){
        score = _score;
    }

    public void addAck(int _ack){
        ack = _ack;
    }

    public void addImage(BufferedImage _screenshot){
        screenshot = _screenshot;
    }

    public void addAngle(double _angle){
        angle = _angle;
    }

    public void add(BufferedImage image, double _angle, int _ack){
        angle = _angle;
        screenshot = image;
        ack = _ack;
    }
}