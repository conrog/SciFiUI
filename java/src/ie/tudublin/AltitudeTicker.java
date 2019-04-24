package ie.tudublin;

public class AltitudeTicker extends UiObject
{
    private float dy;

    public AltitudeTicker(UI ui,float x,float y,float size, float rotation)
    {
        super(ui,x,y,size,rotation);

        dy = position.y - 100;
    }


    public void render()
    {
        ui.fill(255);
        ui.text("ALTITUDE",position.x, position.y - 100);

        ui.line(position.x, getDy(), position.x + 10, getDy() );

        
    }

    public void update()
    {

    }

    /**
     * @return the dy
     */
    public float getDy() {
        return dy;
    }

    /**
     * @param dy the dy to set
     */
    public void setDy(float dy) {
        this.dy = dy;
    }
}