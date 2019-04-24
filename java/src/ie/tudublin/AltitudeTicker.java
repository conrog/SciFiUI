package ie.tudublin;

public class AltitudeTicker extends UiObject{

    public AltitudeTicker(UI ui,float x,float y,float size, float rotation)
    {
        super(ui,x,y,size,rotation);
    }


    public void render()
    {
        ui.fill(255);
        ui.text("ALTITUDE",position.x, position.y);
    }

    public void update()
    {

    }
}