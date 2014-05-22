/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package drawing;

/**
 *
 * @author matra4214
 */
public class Collision {
    
    private double collAngle(double diffX, double diffY){
        return Math.atan2(diffY, diffX);
    }
    
    private boolean doTheMath(Point point1, Point point2){
        double V2xsubV1x = (point2.getDx()-point1.getDx());
        double V2ysubV1y = (point2.getDy()-point1.getDy());
        
        double X2xsubX1x = (point2.getX()-point1.getX());
        double X2ysubX1y = (point2.getY()-point1.getY());
        
        double dotProduct = (V2xsubV1x*X2xsubX1x)+(V2ysubV1y*X2ysubX1y);
        if (dotProduct < 0){
            return true;
        }else{
            return false;
        }
    }
    private double dotProduct (Point point1, Point point2){
        return (point1.getX()*point2.getX())+(point1.getY()*point2.getY());
    }
    
    public void Coll(Point point1, Point point2){
        
        double diffX = point1.getX()-point2.getX();
        double diffY = point1.getY()-point2.getY();
        
        double cAngle = collAngle(diffX, diffY);
        
        double massDiff1 = point1.getMass()-point2.getMass();
        double massDiff2 = point2.getMass()-point1.getMass();
        
        if (doTheMath(point1, point2)){
            double velocity1x = (2*point2.getMass())/(point1.getMass()+point2.getMass());
            double velocity1y;
            double V1xsubV2x = (point1.getDx()-point2.getDx());
            double V1ysubV2y = (point1.getDy()-point2.getDy());
            double X1xsubX2x = (point1.getX()-point2.getX());
            double X1ysubX2y = (point1.getY()-point2.getY());
            double magX1squared = Math.pow(X1xsubX2x,2)+Math.pow(X1ysubX2y,2);

            double velocity2x = (2*point1.getMass())/(point1.getMass()+point2.getMass());
            double velocity2y;
            double V2xsubV1x = (point2.getDx()-point1.getDx());
            double V2ysubV1y = (point2.getDy()-point1.getDy());
            double X2xsubX1x = (point2.getX()-point1.getX());
            double X2ysubX1y = (point2.getY()-point1.getY());
            double magX2squared = Math.pow(X2xsubX1x,2)+Math.pow(X2ysubX1y,2);

            velocity1x *= ((V1xsubV2x*X1xsubX2x+V1ysubV2y*X1ysubX2y)/magX1squared);

            velocity2x *= ((V2xsubV1x*X2xsubX1x+V2ysubV1y*X2ysubX1y)/magX2squared);

            velocity1y = velocity1x;
            velocity2y = velocity2x;

            velocity1x *= X1xsubX2x;
            velocity1y *= X1ysubX2y;

            velocity2x *= X2xsubX1x;
            velocity2y *= X2ysubX1y;

            velocity1x = point1.getDx()-velocity1x;
            velocity1y = point1.getDy()-velocity1y;

            velocity2x = point2.getDx()-velocity2x;
            velocity2y = point2.getDy()-velocity2y;


            //System.out.println(point1.getVelocity()*point1.getMass()+point2.getVelocity()*point2.getMass());
            point1.setDx(velocity1x);
            point1.setDy(velocity1y);
            point2.setDx(velocity2x);
            point2.setDy(velocity2y);
            //System.out.println(point1.getVelocity()*point1.getMass()+point2.getVelocity()*point2.getMass());
        }
    }
        
    
    
}
