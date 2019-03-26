package ie.tudublin;

public class Window extends UiObject
{
    private float velocity;

    public Window(UI ui,float x,float y,float size, float rotation)
    {
        super(ui, x, y, size, rotation);

        this.velocity = 0f;
    }


    public void render()
    {       
        ui.stroke(0,255,0);
        ui.rect(position.x, position.y, size, size);

    }

    public void update()
    {
        if(ui.checkKey(38))
        {

            velocity += 0.05f;
        }

        if(ui.checkKey(40) && velocity > 0)
        {
            velocity -= 0.05f;
        }
    }


}