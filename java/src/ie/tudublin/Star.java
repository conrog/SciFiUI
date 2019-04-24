package ie.tudublin;


public class Star extends UiObject{


    public Star(UI ui, float x, float y, float size, float rotation)
    {
        super(ui, x, y, size, rotation);

        position.x = ui.random(0,ui.width);
        position.y = ui.random(0,ui.height);
    }

    public void render()
    {   
        ui.stroke(255);

        ui.ellipse(position.x, position.y, size, size);

    }

    public void update()
    {
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
            position.y -= 1;
        }

        if(ui.checkKey('s'))
        {
            position.y += 1;
        }

        if(ui.checkKey('q'))
        {
            position.x -= 1;
        }

        if(ui.checkKey('e'))
        {
            position.x += 1;
        }

        if( position.x < 0)
        {
            position.x = ui.width;
        }

        if( position.x > ui.width)
        {
            position.x = 0;
        }

        if ( position.y < 0 )
        {
            position.y = ui.height;
        }

        if ( position.y > ui.height)
        {
            position.y = 0;
        }
    }

}