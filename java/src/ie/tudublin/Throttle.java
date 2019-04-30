package ie.tudublin;


public class Throttle extends UiObject
{  
    private float lenght;
    private float width;

    private float dy;
    private float gap;

    public Throttle(UI ui,float x,float y,float size, float rotation)
    {
        super(ui, x, y, size, rotation);

        lenght = size;
        gap = 10;
        width = 25;
        dy = position.y + gap + lenght/2 - 12.5f;
    }

    public void render()
    {
        ui.fill(255);
        ui.fill(30);

        //Throttle
        ui.rect(position.x - width, position.y + gap, width, lenght); 
        ui.line(position.x - width, 240, position.x, 240); // Forward Line
        ui.line(position.x - width, 285, position.x, 285); // Reverse Line
        ui.rect(position.x - width * 1.5f , dy ,50 , 25); //Moveable Rectangle

    }

    public void update()
    {
        if(ui.mousePressed)
        {   
            if( ui.mouseY <= position.y + gap + lenght - 25 && ui.mouseY >= position.y + gap)
            {
                dy =  ui.mouseY;
            }
        }

        if(dy < 240 && ui.frameCount % 60 == 0)
        {
            ui.setVelocity( ui.getVelocity() + 1 );
        }

        if(dy > 285 && ui.frameCount % 60 == 0)
        {
            ui.setVelocity( ui.getVelocity() - 1 );
        }

        if(dy > 285)
        {
            ui.setReverse(1);
        }
        else
        {
            ui.setReverse(0);
        }

        if(dy < 240)
        {
            ui.setForward(1);
        }
        else
        {
            ui.setForward(0);
        }
    }

}