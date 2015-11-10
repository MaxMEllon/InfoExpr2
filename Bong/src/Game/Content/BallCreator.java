package Game.Content;

import java.awt.Color;
import Common.Point;
import Game.Bong;

public class BallCreator {
	public static Ball create(int ballID){
        Ball ball;
        Color color;
        
        switch (ballID){    
        case 0:  
            ball = new Ball();                //通常
            break;
        case 1:
            ball = new FastBall();  //高速
            break;
        case 2:             //低速
        case 3:             //重力
        case 4:             //粘着
        case 5:             //跳ね返り方をランダム
        default: 
            ball = null;
            
        }
        return ball;
	}

}
