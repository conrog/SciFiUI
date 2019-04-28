package ie.tudublin;

import processing.core.PVector;

public class Star extends UiObject {

    public PVector pitch;
    public PVector yaw;

    public Star(UI ui, float x, float y, float size, float rotation)
    {
        super(ui, x, y, size, rotation);

        pitch = new PVector();
        yaw = new PVector();

        position.x = ui.random( 0, ui.width );
        position.y = ui.random( 0, ui.height);
    }

    public void render()
    {   
        ui.stroke(255);
        ui.pushMatrix();
        ui.translate(ui.width/2,ui.height/2);
        ui.rotate(rotation);
        ui.ellipse(position.x , position.y, size, size);  
        //ui.line(0,0,position.x,position.y);
        ui.popMatrix();
    }

    public void update()
    {
        pitch.x = (float) Math.sin(rotation);
        pitch.y = (float) Math.cos(rotation);

        yaw.x = -(float) Math.cos(rotation);
        yaw.y =  (float) Math.sin(rotation);


        if(ui.checkKey('a'))
        {
            rotation += 0.01f;
        }

        if(ui.checkKey('d'))
        {
            rotation -= 0.01f;
        }

        if(ui.checkKey('w'))
        {
            position.x += pitch.x;
            position.y += pitch.y;
        }

        if(ui.checkKey('s'))
        {
            position.x -= pitch.x;
            position.y -= pitch.y;
        }

        if(ui.checkKey('q'))
        {
            position.x -= yaw.x;
            position.y -= yaw.y;
        }

        if(ui.checkKey('e'))
        {
            position.x += yaw.x;
            position.y += yaw.y;
        }

        if( position.x < 0)
        {
            position.x = ui.width;
        }

        if( position.x > ui.width)
        {
            position.x = 0;
        }

        if ( position.y < - ui.height/2f )
        {
            position.y = ui.height/2f;
        }

        if ( position.y > ui.height/2f)
        {
            position.y = - ui.height/2f;
        }
    }

}