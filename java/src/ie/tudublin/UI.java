package ie.tudublin;

import java.util.ArrayList;

import processing.core.PApplet;

public class UI extends PApplet
{
    Window w;
    Star s;

    boolean[] keys = new boolean[1024];

    public ArrayList<UiObject> uiObjects = new ArrayList<UiObject>();

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
        size(1280,720);
        // Use fullscreen instead of size to make your interface fullscreen
        //fullScreen(); 
    }


    public void setup()
    {
        //uiObjects.add( new Radar(this, width * 0.9f, height * 0.9f , height * 0.1f, 0) );
        uiObjects.add( new CenterHud(this, width/2f, height/2f, width * 0.4f, 0) );
        uiObjects.add( new VelocityTicker(this, width * 0.15f, height/2 , 0, 0) );
        uiObjects.add( new AltitudeTicker(this, width * 0.85f, height/2 , 0, 0) );
        uiObjects.add( new Window(this, width * 0.15f, 0, width *  0.6f, 0) );
        
        //Adding Stars in the background
        
        for(int i = 0; i < 500; i ++)
        {
            uiObjects.add( new Star(this, 0, 0, 2, 0 ) );
        }
        
    }


    public void draw()
    {   
        background(0);

        for(int i = uiObjects.size() - 1; i >= 0; i--)
        {
            UiObject a = uiObjects.get(i);
            a.render();
            a.update();
        }


    }
}

