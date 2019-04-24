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
        ui.noStroke();
        ui.fill(15);
        ui.rect(0, position.y, position.x , ui.height);
        ui.rect(ui.width - position.x, position.y, position.x, ui.height);

        //Left Side : Velocity
        ui.quad(position.x, 200, 
                position.x + 40, 260, 
                position.x + 40, 460, 
                position.x, 520);
        
        //Top Left Triangle
        ui.triangle(position.x, 25, position.x,  75 , position.x + 50,  25);
        
        //Bottom Left Triangle
        ui.triangle(position.x, ui.height - 25, position.x, ui.height - 75 , position.x + 50, ui.height - 25);

        //Right Side : Alitude
        ui.quad(- position.x + ui.width, 200, 
                - position.x + ui.width - 40, 260, 
                - position.x + ui.width - 40, 460, 
                - position.x + ui.width, 520);
        
        //Bottom Right Triangle
        ui.triangle(ui.width - position.x, ui.height - 25, ui.width - position.x, ui.height - 75 , ui.width - position.x - 50, ui.height - 25);
        
        //Top Right Triangle
        ui.triangle(ui.width - position.x, 25, ui.width - position.x,  75 , ui.width - position.x - 50,  25);

        //Top Rectangle
        ui.rect(position.x , 0 , ui.width - position.x, 25 );

        //Bottom Rectangle
        ui.rect(position.x, ui.height - 25, ui.width - position.x, 25);

        //Outline
        ui.stroke(255);

        //Left Side
        ui.line(position.x, 75, position.x + 50, 25);
        ui.line(position.x, 75, position.x, 200);
        ui.line(position.x, 200, position.x + 40, 260);
        ui.line(position.x + 40, 260, position.x + 40, 460);
        ui.line(position.x + 40, 460, position.x, 520);
        ui.line(position.x, 520, position.x, ui.height - 75);
        ui.line(position.x, ui.height - 75, position.x + 50, ui.height -25);

        //Right Side
        ui.line(ui.width - position.x, 75, ui.width - position.x - 50, 25);
        ui.line(ui.width - position.x, 75, ui.width - position.x, 200);
        ui.line(ui.width - position.x, 200, ui.width - position.x - 40, 260);
        ui.line(ui.width - position.x - 40, 260, ui.width - position.x - 40, 460);
        ui.line(ui.width - position.x - 40, 460, ui.width - position.x, 520);
        ui.line(ui.width - position.x, 520, ui.width - position.x, ui.height - 75);
        ui.line(ui.width - position.x, ui.height - 75, ui.width - position.x - 50, ui.height -25);

        //Top and Bottom
        ui.line(position.x + 50, 25, ui.width - position.x - 50, 25 );
        ui.line(position.x + 50, ui.height - 25, ui.width - position.x - 50, ui.height -25);
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