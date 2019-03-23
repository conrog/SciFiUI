package ie.tudublin;

import processing.core.PVector;

public class Star{
    UI ui;
    private PVector position;
    private float size;

    public Star(UI ui)
    {
        this.ui = ui;
        position = new PVector(ui.width/2,ui.height/2);
    }

    public void render()
    {
        ui.fill(255);
        ui.noStroke();
        ui.ellipse(position.x, position.y, 10, 10);
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