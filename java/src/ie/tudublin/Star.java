package ie.tudublin;


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

        if( position.x < ui.width * 0.2f)
        {
            position.x = ui.width * 0.8f;
        }

        if( position.x > ui.width * 0.8f)
        {
            position.x = ui.width * 0.2f;
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