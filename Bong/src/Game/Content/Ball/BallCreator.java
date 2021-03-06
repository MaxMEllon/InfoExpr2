package Game.Content.Ball;

public class BallCreator {
    public static final int BALL_TYPE = 3;

    public static Ball create(int ballId) {
        Ball ball = null;
        switch (ballId) {
        case 0:
            // 標準
            ball = new Ball();
            break;
        case 1:
            // 高速
            ball = new FastBall();
            break;
        case 2:
            // 重力
            ball = new GrvBall();
            break;
        case 3:
            // 粘着
            break;
        case 4:
            // ランダム
            break;
        default:
            ball = null;
        }
        return ball;
    }
}
