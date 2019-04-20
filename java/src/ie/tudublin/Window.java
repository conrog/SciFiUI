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
        ui.stroke(0);
        ui.fill(255);
        ui.rect(0, position.y, position.x , ui.height);
        ui.rect(ui.width - position.x, position.y, position.x, ui.height);

        //Left Side : Velocity
        ui.quad(position.x, 200, 
                position.x + 40, 260, 
                position.x + 40, 460, 
                position.x, 520);

        //Right Side : Alitude
        ui.quad(- position.x + ui.width, 200, 
                - position.x + ui.width - 40, 260, 
                - position.x + ui.width - 40, 460, 
                - position.x + ui.width, 520);


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