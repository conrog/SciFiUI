package ie.tudublin;

public class AltitudeTicker extends UiObject
{
    private float yValues[] = { 0, 0, 0};
    private float altitude;

    public AltitudeTicker(UI ui,float x,float y,float size, float rotation)
    {
        super(ui,x,y,size,rotation);

        for(int i = 0; i < yValues.length ; i++)
        {
            yValues[i] = UI.map(i, 0, 2, 280, 400);
        }

        setAltitude(100.00f);
    }


    public void render()
    {
        ui.fill(255);
        ui.textSize(9);
        ui.text("ALTITUDE",position.x - 15, position.y - 100);

        for(int i = 0; i < yValues.length; i++)
        {
            ui.line(position.x - 15, yValues[i], position.x - 10, yValues[i]);
        }
        
        ui.noStroke();
        ui.fill(100);
        ui.rect(position.x - 40, position.y - 10, 45, 25);

        ui.fill(255);
        ui.textSize(12);
        ui.textAlign(UI.CENTER,UI.CENTER);
        ui.text(getAltitude(), position.x - 15, position.y);

        
    }

    public void update()
    {

    }

    /**
     * @return the yValues
     */
    public float[] getyValues() {
        return yValues;
    }

    /**
     * @param yValues the yValues to set
     */
    public void setyValues(float[] yValues) {
        this.yValues = yValues;
    }

    /**
     * @return the altitude
     */
    public float getAltitude() {
        return altitude;
    }

    /**
     * @param altitude the altitude to set
     */
    public void setAltitude(float altitude) {
        this.altitude = altitude;
    }
}