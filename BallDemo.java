import java.awt.Color;
import java.util.Random;
import java.util.ArrayList;
/**
 * Class BallDemo - a short demonstration showing animation with the 
 * Canvas class. 
 *
 * @author Michael KÃ¶lling and David J. Barnes
 * @version 2011.07.31
 */

public class BallDemo   
{
    private Canvas myCanvas;

    /**
     * Create a BallDemo object. Creates a fresh canvas and makes it visible.
     */
    public BallDemo()
    {
        myCanvas = new Canvas("Ball Demo", 600, 500);
    }

    /**
     * Simulate two bouncing balls
     */
    public void bounce(int nBalls)
    {
        int ground = 400;   // position of the ground line

        myCanvas.setVisible(true);

        // draw the ground
        myCanvas.drawLine(50, ground, 550, ground);
        
        ArrayList<BouncingBall> arrayBalls = new ArrayList<>();
        
        // create and show the balls
        BouncingBall ball = new BouncingBall(50, 50, 16, Color.BLUE, ground, myCanvas);
        for(int i = 0; i < nBalls; i++)
        {
            Random rnd = new Random();
            int radio = rnd.nextInt(100);
            
            int red = rnd.nextInt(256);
            int green = rnd.nextInt(256);
            int blue = rnd.nextInt(256);
            
            int x = rnd.nextInt(240);
            int y = rnd.nextInt(400);
            
            ball = new BouncingBall(x, y, radio, new Color(red,green,blue), ground, myCanvas);
            arrayBalls.add(ball);
            ball.draw();
        }
        

        // make them bounce
        boolean finished =  false;
        while(!finished) {
            myCanvas.wait(50);           // small delay
            for(BouncingBall element : arrayBalls)
            {
                element.move();
                // stop once ball has travelled a certain distance on x axis
                if(element.getXPosition() >= 550) {
                    finished = true;
                }
            }
        }
    }
    
    /**
     * Método que crea un rectángulo dentro de el cual se crearán un número de bolas indicado por el parámetro.
     * Después, esas bolas se mueven por el rectángulo rebotando en los bordes del rectángulo.
     * @param numeroBolas: numero de bolas que se quieren crear.
     */
    public void boxBounce(int numeroBolas)
    {
        int ground = 450;
        myCanvas.fillRectangle(10,10,550,450);
        myCanvas.setVisible(true);
        
        ArrayList<BoxBall> arrayBalls = new ArrayList<>();
        
        for(int i = 0; i < numeroBolas; i++)
        {
            Random rnd = new Random();
            int radio = rnd.nextInt(100);
            
            int red = rnd.nextInt(256);
            int green = rnd.nextInt(256);
            int blue = rnd.nextInt(256);
            
            int x = rnd.nextInt(550);
            int y = rnd.nextInt(430);
            
            BoxBall bola = new BoxBall(x, y, 1, 1, radio, new Color(red,green,blue), ground, myCanvas);
            arrayBalls.add(bola);
            bola.draw();
        }
        boolean finished =  false;
        while(!finished) {
            myCanvas.wait(50);           // small delay
            for(BoxBall element : arrayBalls)
            {
                element.move();
            }
        }
    }
}
