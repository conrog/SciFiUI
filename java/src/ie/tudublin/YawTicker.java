package ie.tudublin;

public class YawTicker extends UiObject
{
    private float xValues[] = { 0, 0, 0, 0};
    private float gap;

    public YawTicker(UI ui,float x,float y,float size, float rotation)
    {
        super(ui, x, y, size, rotation);

        for(int i = 0; i < xValues.length ; i++)
        {
            xValues[i] = UI.map(i, 0, 3, ui.width*0.15f, ui.width*0.3f);
        }

        gap = xValues[1] - xValues[0];
    }

    public void render()
    {
        //Left Side
        ui.line(ui.width*0.15f, 225 ,ui.width * 0.275f , 250);
        ui.line(ui.width*0.15f, 495 ,ui.width * 0.275f , 470);

        for(int i = 0; i < xValues.length; i++)
        {
            ui.line(xValues[i], position.y, xValues[i] - 10, position.y - 10);
            ui.line(xValues[i], position.y, xValues[i] - 10, position.y + 10);
        }

        //Right Side
        ui.line(ui.width*0.85f, 225 ,ui.width*0.725f , 250);
        ui.line(ui.width*0.85f, 495 ,ui.width*0.725f , 470);

        for(int i = xValues.length - 1; i >= 0; i--)
        {
            ui.line(position.x + xValues[i] + gap, position.y, position.x + xValues[i] + 10 + gap, position.y - 10);
            ui.line(position.x + xValues[i] + gap, position.y, position.x + xValues[i] + 10 + gap, position.y + 10);
        }

    }

    public void update()
    {
        if( ui.checkKey('e') )
        {
            for(int i = 0; i < xValues.length ; i++)
            {
                if( xValues[i] == ui.width*0.3f )
                {
                    xValues[i] = ui.width*0.15f;
                }
                else
                {
                    xValues[i] += 1;
                }
            }
        }

        if( ui.checkKey('q') )
        {
            for(int i = 0; i < xValues.length ; i++)
            {
                if( xValues[i] == ui.width*0.15f )
                {
                    xValues[i] = ui.width*0.3f;
                }
                else
                {
                    xValues[i] -= 1;
                }
            }
        }
    }
}