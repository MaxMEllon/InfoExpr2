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
            ball = new Ball();                //�ʏ�
            break;
        case 1:
            ball = new FastBall();  //����
            break;
        case 2:             //�ᑬ
        case 3:             //�d��
        case 4:             //�S��
        case 5:             //���˕Ԃ���������_��
        default: 
            ball = null;
            
        }
        return ball;
	}

}
