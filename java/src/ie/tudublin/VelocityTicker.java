package ie.tudublin;

public class VelocityTicker extends UiObject
{
    private float yValues[] = { 0, 0, 0};

    public VelocityTicker(UI ui,float x,float y,float size, float rotation)
    {
        super(ui,x,y,size,rotation);

        for(int i = 0; i < yValues.length ; i++)
        {
            yValues[i] = UI.map(i, 0, 2, 280, 400);
        }

        ui.setVelocity(0);
    }


    public void render()
    {
        ui.fill(255);
        ui.stroke(255);
        ui.textSize(9);
        ui.text("VELOCITY",position.x + 15, position.y - 100);

        for(int i = 0; i < yValues.length; i++)
        {
            ui.line(position.x + 15, yValues[i], position.x + 10, yValues[i]);
        }
        
        ui.noStroke();
        ui.fill(100);
        ui.rect(position.x - 5, position.y - 10, 45, 25);

        ui.fill(255);
        ui.textSize(12);
        ui.textAlign(UI.CENTER,UI.CENTER);
        ui.text(ui.getVelocity(), position.x + 15, position.y);
    }

    public void update()
    {
        if( ui.getForward() == 1 )
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

        if( ui.getReverse() == 1)
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

