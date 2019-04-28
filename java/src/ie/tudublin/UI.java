package ie.tudublin;

import java.util.ArrayList;

import processing.core.PApplet;

public class UI extends PApplet
{
    boolean[] keys = new boolean[1024];

    public ArrayList<UiObject> uiObjects = new ArrayList<UiObject>();

    private float pitch = 0;
    private float yaw = 0;
    private float roll = 0;

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
        size(1280,720);
        // Use fullscreen instead of size to make your interface fullscreen
        //fullScreen(); 
    }


    public void setup()
    {
        uiObjects.add( new Radar(this, width * 0.925f, height * 0.2f , height * 0.2f, 2) );
        uiObjects.add( new Radar(this, width * 0.075f, height * 0.2f , height * 0.2f, 0) );
        
        uiObjects.add( new CenterHud(this, width/2f, height/2f, width * 0.4f, 0) );
        
        uiObjects.add( new VelocityTicker(this, width * 0.15f, height/2 , 0, 0) );
        uiObjects.add( new AltitudeTicker(this, width * 0.85f, height/2 , 0, 0) );

        uiObjects.add( new AttitudeIndicator(this, width * 0.925f, height * 0.8f , height * 0.2f, 0) );
        uiObjects.add( new TrusterIndicator(this, width * 0.075f, height * 0.8f , height * 0.2f, 0) );
        

        uiObjects.add( new Window(this, width * 0.15f, 0, width *  0.6f, 0) );
        
        //Adding Stars in the background
        for(int i = 0; i < 500; i ++)
        {
            uiObjects.add( new Star(this, 0, 0, 2, random(radians(0),radians(360))));
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

    /**
     * @return the pitch
     */
    public float getPitch() {
        return pitch;
    }

    /**
     * @param pitch the pitch to set
     */
    public void setPitch(float pitch) {
        this.pitch = pitch;
    }

    /**
     * @return the yaw
     */
    public float getYaw() {
        return yaw;
    }

    /**
     * @param yaw the yaw to set
     */
    public void setYaw(float yaw) {
        this.yaw = yaw;
    }

    /**
     * @return the roll
     */
    public float getRoll() {
        return roll;
    }

    /**
     * @param roll the roll to set
     */
    public void setRoll(float roll) {
        this.roll = roll;
    }
}

