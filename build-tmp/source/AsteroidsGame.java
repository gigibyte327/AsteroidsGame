import processing.core.*; 
import processing.data.*; 
import processing.event.*; 
import processing.opengl.*; 

import java.util.HashMap; 
import java.util.ArrayList; 
import java.io.File; 
import java.io.BufferedReader; 
import java.io.PrintWriter; 
import java.io.InputStream; 
import java.io.OutputStream; 
import java.io.IOException; 

public class AsteroidsGame extends PApplet {

SpaceShip spacey;
Stars[] starsey;
Asteroids[] asters;
public void setup() 
{
  size(400,400);
  background(0);
  asters = new Asteroids[10];
  spacey = new SpaceShip();
  starsey= new Stars [100];
  for (int i=0; i<starsey.length; i++){
    starsey[i]=new Stars();
  }
  for (int i=0;i<asters.length;i++){
    asters[i]=new Asteroids((int)(Math.random()*5)-3);
    asters[i].setDirectionX(Math.random()*2-1);
    asters[i].setDirectionY(Math.random()*2-1);
    
  }
}
public void draw() 
{
  background(0);
/*  noStroke();
  for(int j=0;j<400;j++){
    for (int i=0;i<400;i++){
      fill(i*0.1,j*0.2,i*4);
      rect(i*10,j*10,20,20);
      fill(i*0.1,j*0.2,i*4,100);
      rect(i*11,j*11,22,22);
    }
  }*/

  for (int i=0; i<starsey.length; i++){
    starsey[i].show();
  }
  for (int i = 0; i<asters.length;i++){
    asters[i].move();
    asters[i].show();
  }
  spacey.move();
  spacey.show();

}
public void keyPressed(){
  if(key == 'h'){
    spacey.setX((int)(Math.random()*300)+30);
    spacey.setY((int)(Math.random()*300)+30);
    spacey.setPointDirection((int)(Math.random()*360));
    spacey.setDirectionX(0);
    spacey.setDirectionY(0);
  }
  if(key == 'a'){
    spacey.accelerate(-1);
  }
  if(key== 'd'){
    spacey.accelerate(0.9f);
  }
  if(key == 'w'){
    spacey.rotate(-15);
  }
  if(key == 's'){
    spacey.rotate(14);
  }

}
class Stars extends Floater{
  public Stars(){
    corners = 10;
    xCorners = new int [corners];
    yCorners = new int [corners];
    xCorners[0]=0;
    yCorners[0]=-3;
    xCorners[1]=3;
    yCorners[1]=-1;
    xCorners[2]=2;
    yCorners[2]=0;
    xCorners[3]=1;
    yCorners[3]=-1;
    xCorners[4]=2;
    yCorners[4]=3;
    xCorners[5]=0;
    yCorners[5]=2;
    xCorners[6]=-2;
    yCorners[6]=3;
    xCorners[7]=-1;
    yCorners[7]=-1;
    xCorners[8]=-3;
    yCorners[8]=0;
    xCorners[9]=-1;
    yCorners[9]=-1;
    myColor=255;
    myDirectionX=0;
    myDirectionY=0;
    myPointDirection=0;
    myCenterX=(int)(Math.random()*400+10);
    myCenterY=(int)(Math.random()*400+10);
  }
  public void setX(int x){myCenterX=x;}  
  public int getX(){return (int)myCenterX;}   
  public void setY(int y){myCenterY=y;}   
  public int getY(){return (int)myCenterY;}   
  public void setDirectionX(double x){myDirectionX=x;}   
  public double getDirectionX() {return myDirectionX;}
  public void setDirectionY(double y){myDirectionY=y;}   
  public double getDirectionY(){return myDirectionY;}
  public void setPointDirection(int degrees){myPointDirection=degrees;}   
  public double getPointDirection(){return myPointDirection;}
}
class Asteroids extends Floater{
  private int rotSpeed;
  public Asteroids(int rsp){
    rotSpeed=rsp;
    corners = 9;
    xCorners = new int [corners];
    yCorners = new int [corners];
    xCorners[0]=3;
    yCorners[0]=4;
    xCorners[1]=4;
    yCorners[1]=3;
    xCorners[2]=6;
    yCorners[2]=0;
    xCorners[3]=5;
    yCorners[3]=-6;
    xCorners[4]=0;
    yCorners[4]=-5;
    xCorners[5]=-5;
    yCorners[5]=-5;
    xCorners[6]=-6;
    yCorners[6]=-4;
    xCorners[7]=-6;
    yCorners[7]=4;
    xCorners[8]=-3;
    yCorners[8]=3;
    myColor=127;
    myCenterX=(int)(Math.random()*400+10);
    myCenterY=(int)(Math.random()*400+10);
  }
  public void move(){
    rotate(rotSpeed);
    super.move();
  }
  public void setX(int x){myCenterX=x;}  
  public int getX(){return (int)myCenterX;}   
  public void setY(int y){myCenterY=y;}   
  public int getY(){return (int)myCenterY;}   
  public void setDirectionX(double x){myDirectionX=x;}   
  public double getDirectionX() {return myDirectionX;}
  public void setDirectionY(double y){myDirectionY=y;}   
  public double getDirectionY(){return myDirectionY;}
  public void setPointDirection(int degrees){myPointDirection=degrees;}   
  public double getPointDirection(){return myPointDirection;}
}
class SpaceShip extends Floater  
{   
  public SpaceShip(){
    corners = 4;
    xCorners = new int [corners];
    yCorners = new int [corners];
    xCorners[0]=5;
    yCorners[0]=0;
    xCorners[1]=-8;
    yCorners[1]=-8;
    xCorners[2]=-5;
    yCorners[2]=0;
    xCorners[3]=-8;
    yCorners[3]=8;
    myColor=255;
    myCenterX=200;
    myCenterY=200;
    myDirectionX=0;
    myDirectionY=0;
    myPointDirection=0;
  }
  public void setX(int x){myCenterX=x;}  
  public int getX(){return (int)myCenterX;}   
  public void setY(int y){myCenterY=y;}   
  public int getY(){return (int)myCenterY;}   
  public void setDirectionX(double x){myDirectionX=x;}   
  public double getDirectionX() {return myDirectionX;}
  public void setDirectionY(double y){myDirectionY=y;}   
  public double getDirectionY(){return myDirectionY;}
  public void setPointDirection(int degrees){myPointDirection=degrees;}   
  public double getPointDirection(){return myPointDirection;}
}
abstract class Floater //Do NOT modify the Floater class! Make changes in the SpaceShip class 
{   
  protected int corners;  //the number of corners, a triangular floater has 3   
  protected int[] xCorners;   
  protected int[] yCorners;   
  protected int myColor;   
  protected double myCenterX, myCenterY; //holds center coordinates   
  protected double myDirectionX, myDirectionY; //holds x and y coordinates of the vector for direction of travel   
  protected double myPointDirection; //holds current direction the ship is pointing in degrees    
  abstract public void setX(int x);  
  abstract public int getX();   
  abstract public void setY(int y);   
  abstract public int getY();   
  abstract public void setDirectionX(double x);   
  abstract public double getDirectionX();   
  abstract public void setDirectionY(double y);   
  abstract public double getDirectionY();   
  abstract public void setPointDirection(int degrees);   
  abstract public double getPointDirection(); 

  //Accelerates the floater in the direction it is pointing (myPointDirection)   
  public void accelerate (double dAmount)   
  {          
    //convert the current direction the floater is pointing to radians    
    double dRadians =myPointDirection*(Math.PI/180);     
    //change coordinates of direction of travel    
    myDirectionX += ((dAmount) * Math.cos(dRadians));    
    myDirectionY += ((dAmount) * Math.sin(dRadians));       
  }   
  public void rotate (int nDegreesOfRotation)   
  {     
    //rotates the floater by a given number of degrees    
    myPointDirection+=nDegreesOfRotation;   
  }   
  public void move ()   //move the floater in the current direction of travel
  {      
    //change the x and y coordinates by myDirectionX and myDirectionY       
    myCenterX += myDirectionX;    
    myCenterY += myDirectionY;     

    //wrap around screen    
    if(myCenterX >width)
    {     
      myCenterX = 0;    
    }    
    else if (myCenterX<0)
    {     
      myCenterX = width;    
    }    
    if(myCenterY >height)
    {    
      myCenterY = 0;    
    }   
    else if (myCenterY < 0)
    {     
      myCenterY = height;    
    }   
  }   
  public void show ()  //Draws the floater at the current position  
  {             
    fill(myColor);   
    stroke(myColor);    
    //convert degrees to radians for sin and cos         
    double dRadians = myPointDirection*(Math.PI/180);                 
    int xRotatedTranslated, yRotatedTranslated;    
    beginShape();         
    for(int nI = 0; nI < corners; nI++)    
    {     
      //rotate and translate the coordinates of the floater using current direction 
      xRotatedTranslated = (int)((xCorners[nI]* Math.cos(dRadians)) - (yCorners[nI] * Math.sin(dRadians))+myCenterX);     
      yRotatedTranslated = (int)((xCorners[nI]* Math.sin(dRadians)) + (yCorners[nI] * Math.cos(dRadians))+myCenterY);      
      vertex(xRotatedTranslated,yRotatedTranslated);    
    }   
    endShape(CLOSE);  
  }   
} 

  static public void main(String[] passedArgs) {
    String[] appletArgs = new String[] { "AsteroidsGame" };
    if (passedArgs != null) {
      PApplet.main(concat(appletArgs, passedArgs));
    } else {
      PApplet.main(appletArgs);
    }
  }
}
