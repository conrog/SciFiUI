package ie.tudublin;

import processing.core.PApplet;
import processing.core.PImage;

public class UI extends PApplet
{
    //Button b;
    //MovingCircle mc;
    Radar r;
    CenterHud chud;
    Window w;

    boolean[] keys = new boolean[1024];

    public void keyPressed()
    {
        keys[keyCode] = true;
    }
    
    public void keyReleased()
    {
        keys[keyCode] = false;
    }

    public boolean checkKey(int c)
    {
        return keys[c] || keys [Character.toUpperCase(c)];
    }
    

    public void settings()
    {
        //1920 x 1279
        size(800,800);
        // Use fullscreen instead of size to make your interface fullscreen
        //fullScreen(); 
    }


    public PImage img;
    public void setup()
    {
        //b = new Button(this, 50, 50, 100, 50, "I am a button");
        //mc = new MovingCircle(this, width / 2, height / 2, 50);
        r = new Radar(this, width * 0.9f, height * 0.9f, width * 0.1f);
        chud = new CenterHud(this, width/2, height/2, width * 0.4f);
        w = new Window(this,width,height);
        img = loadImage("space.jpg");
        img.resize(800, 800);
    }


    public void draw()
    {   
        background(img);
        w.render();
        w.update();
        r.render();
        r.update();

        chud.render();

        if (checkKey(LEFT))
        {
            System.out.println("Left arrow key pressed");
        }
    }
}

