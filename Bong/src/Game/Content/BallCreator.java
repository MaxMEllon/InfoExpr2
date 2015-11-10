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
            ball = new Ball();                //’Êí
            break;
        case 1:
            ball = new FastBall();  //‚‘¬
            break;
        case 2:             //’á‘¬
        case 3:             //d—Í
        case 4:             //”S’…
        case 5:             //’µ‚Ë•Ô‚è•û‚ğƒ‰ƒ“ƒ_ƒ€
        default: 
            ball = null;
            
        }
        return ball;
	}

}
