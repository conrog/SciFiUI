package ie.tudublin;

public class PitchTicker extends UiObject
{
    private float yValues[] = { 0, 0 };

    public PitchTicker(UI ui,float x,float y,float size, float rotation)
    {
        super(ui, x, y, size, rotation);

        for(int i = 0; i < yValues.length ; i++)
        {
            yValues[i] = UI.map(i, 0, 2, 0, ui.height*0.13f);
        }
    }

    public void render()
    {
        //Top
        ui.line(position.x - 90, 25 ,position.x - 80, 90); //Left Line
        ui.line(position.x + 90, 25 ,position.x + 80, 90); //Right Line

        for(int i = 0; i < yValues.length; i++)
        {
            ui.line(position.x -20, yValues[i] , position.x - 25, yValues[i] -10); //Left Flick
            ui.line(position.x -20, yValues[i], position.x + 20, yValues[i]);   //Center Line
            ui.line(position.x + 20, yValues[i] , position.x + 25, yValues[i] -10); //Right Flick

        }

        //Bottom
        ui.line(position.x - 90, ui.height - 25 ,position.x - 80, ui.height - 90); //Left Line
        ui.line(position.x + 90, ui.height - 25 ,position.x + 80, ui.height - 90); //Right Line
        
        for(int i = 0; i < yValues.length; i++)
        {
            ui.line(position.x -20, ui.height * 0.87f + yValues[i] , position.x - 25,ui.height * 0.87f + yValues[i] + 10); //Left Flick
            ui.line(position.x -20, ui.height * 0.87f + yValues[i], position.x + 20, ui.height * 0.87f + yValues[i]);   //Center Line
            ui.line(position.x +20, ui.height * 0.87f + yValues[i] , position.x + 25,ui.height * 0.87f + yValues[i] + 10); //Right Flick
        }
    }

    public void update()
    {
        if(ui.checkKey('w'))
        {
            for(int i = 0; i < yValues.length; i++)
            {
                if(yValues[i] > ui.height*0.13f )
                {
                    yValues[i] = 0;
                }
                else
                {
                    yValues[i] += 1;
                }

            }
        }

        if(ui.checkKey('s'))
        {
            for(int i = 0; i < yValues.length; i++)
            {
                if(yValues[i] < 0 )
                {
                    yValues[i] = ui.height*0.13f;
                }
                else
                {
                    yValues[i] -= 1;
                }

            }
        }

    }

}