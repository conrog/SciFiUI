package ie.tudublin;

public class VelocityTicker extends UiObject{

    public VelocityTicker(UI ui,float x,float y,float size, float rotation)
    {
        super(ui,x,y,size,rotation);
    }


    public void render()
    {
        ui.fill(255);
        ui.text("VELOCITY",position.x, position.y);
    }

    public void update()
    {

    }
}

