package ie.tudublin;

import processing.core.PVector;

public class Star extends UiObject{


    public Star(UI ui, float x, float y, float size, float rotation)
    {
        super(ui, x, y, size, rotation);
    }

    public void render()
    {
        ui.stroke(255);
        ui.ellipse(position.x, position.y, size, size);
    }

    public void update()
    {
        if(ui.checkKey('w'))
        {
            position.y -= 1;
        }

        if(ui.checkKey('s'))
        {
            position.y += 1;
        }

        if(ui.checkKey('a'))
        {
            position.x -= 1;
        }

        if(ui.checkKey('d'))
        {
            position.x += 1;
        }
    }

}