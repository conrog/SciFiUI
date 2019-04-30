package ie.tudublin;

public class AttitudeIndicator extends UiObject
{
    private float diff = 0;

    public AttitudeIndicator(UI ui,float x,float y,float size, float rotation)
    {
        super(ui,x,y,size,rotation);
    }

    public void render()
    {   
        ui.stroke(255);
        ui.pushMatrix();
        ui.translate(position.x, position.y);
        ui.rotate(rotation);
        
        //Top Half
        ui.fill(150);
        ui.arc(0f, 0f, (float) size, (float) size, UI.radians(180) - diff, UI.radians(360) + diff, UI.CHORD);

        //Bottom Half
        ui.fill(0);
        ui.arc(0f, 0f, (float) size, (float) size, UI.radians(0) + diff, UI.radians(180) - diff, UI.CHORD);
        ui.popMatrix();

        //Ship
        ui.stroke(255,0,0);
        ui.strokeWeight(2);
        ui.line(position.x, position.y + 5, position.x-10, position.y-5);
        ui.line(position.x - 10, position.y -5, position.x - 15 , position.y - 5);
        ui.line(position.x, position.y + 5, position.x + 10, position.y - 5);
        ui.line(position.x + 10, position.y - 5 ,position.x + 15 , position.y - 5);
        ui.strokeWeight(1);
    }

    public void update()
    {
        if(ui.checkKey('d'))
        {
            rotation += UI.radians(1) / 10;
        }

        if(ui.checkKey('a'))
        {
            rotation -= UI.radians(1) / 10;
        }

        if(ui.checkKey('s') )
        {
            diff += UI.radians(1) / 11.5;
        }

        if(ui.checkKey('w'))
        {

            diff -= UI.radians(1) / 11.5;
        }
    }
}