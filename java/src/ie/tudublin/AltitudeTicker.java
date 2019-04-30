package ie.tudublin;

import java.text.DecimalFormat;

public class AltitudeTicker extends UiObject
{
    DecimalFormat df = new DecimalFormat("#.#");
    private String altFormat;
    
    private float yValues[] = { 0, 0, 0};

    private float climbRate;

    public AltitudeTicker(UI ui,float x,float y,float size, float rotation)
    {
        super(ui,x,y,size,rotation);

        for(int i = 0; i < yValues.length ; i++)
        {
            yValues[i] = UI.map(i, 0, 2, 280, 400);
        }

        altFormat = df.format( ui.getAltitude());
    }


    public void render()
    {
        ui.fill(255);
        ui.textSize(9);
        ui.stroke(255);
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
        ui.text(altFormat, position.x - 15, position.y);  
    }

    public void update()
    {
        altFormat = df.format( ui.getAltitude() );

        climbRate = ui.getVelocity() / 60 * ui.getPitch() / 60;

        ui.setAltitude( ui.getAltitude() - climbRate );

        if( climbRate < 0 )
        {
            for(int i = 0; i < yValues.length ; i++)
            {
                if( yValues[i] == 460 )
                {
                    yValues[i] = 280;
                }
                else
                {
                    yValues[i] += 1;
                }
            }
        }

        if( climbRate > 0 )
        {
            for(int i = 0; i < yValues.length ; i++)
            {
                if( yValues[i] == 280 )
                {
                    yValues[i] = 460;
                }
                else
                {
                    yValues[i] -= 1;
                }
            }
        }
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
}