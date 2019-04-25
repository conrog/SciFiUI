package ie.tudublin;

public class AttitudeIndicator extends UiObject
{
    public float diff = 0;

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
        
        //Top
        ui.fill(150);
        ui.arc(0f, 0f, (float) size, (float) size, UI.radians(180) - diff, UI.radians(360) + diff, UI.CHORD);
        //Bottom
        ui.fill(0);
        ui.arc(0f, 0f, (float) size, (float) size, UI.radians(0) + diff, UI.radians(180) - diff, UI.CHORD);

        ui.popMatrix();
    }

    public void update()
    {
        if(ui.checkKey('a'))
        {
            rotation += UI.radians(1);
        }

        if(ui.checkKey('d'))
        {
            rotation -= UI.radians(1);
        }

        if(ui.checkKey('s'))
        {
            diff += UI.radians(1) / 4;
        }

        if(ui.checkKey('w'))
        {
            diff -= UI.radians(1) / 4;
        }
    }
}