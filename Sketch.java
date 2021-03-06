import processing.core.PApplet;

  /**
  * Description: Prints out a flower at a random location, depending on the location the background will change color, shows current time
  * @author: Aurora Chen
  */

public class Sketch extends PApplet {

    float centerX = random(0, 400);
    float centerY = random(0, 400);
    float centerSize = random(25, 150);
    float petalDistance = (float) (centerSize * 0.83); 
    float petalSize = (float) (centerSize * 1.17);
	
  public void settings() {
    size(400, 400);
  }

  public void setup() {
    // if the flower appears at the upper left or bottom right corners, the background will be green. If not, the background will be blue
    boolean isCorners = ((centerX <= 200) && (centerY <= 200)) || (centerX >= 200) && (centerY >= 200);

    if (isCorners){
      background(210, 255, 173);
    }
    else {
      background(158, 221, 255);
    }
  
  }

  public void draw() {
	
    // top petal
    stroke(240, 89, 229);
    fill(255, 201, 251);
    ellipse(centerX, centerY - petalDistance, petalSize, petalSize);

    // top right petal 
    ellipse(centerX + petalDistance, centerY - (float) (petalDistance * 0.2), petalSize, petalSize);

    // top left petal
    ellipse(centerX - petalDistance, centerY - (float) (petalDistance * 0.2), petalSize, petalSize);

    // bottom right petal
    ellipse(centerX + (float) (petalDistance * 0.6), centerY + petalDistance, petalSize, petalSize);

    // bottom left petal
    ellipse(centerX - (float) (petalDistance * 0.6), centerY + petalDistance, petalSize, petalSize);
  
    // center petal
    stroke(255, 202, 25);
    fill(255, 236, 173);
    ellipse(centerX, centerY, centerSize, centerSize);

    // time
    String strTime = (hour() + ":" + minute() + ":" + second());
    fill (0);
    textSize(20);
    text (strTime, 320, 390);
 
  }
}