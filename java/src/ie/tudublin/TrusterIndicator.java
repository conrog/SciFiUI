package ie.tudublin;

public class TrusterIndicator extends UiObject
{
    public TrusterIndicator(UI ui,float x,float y,float size, float rotation)
    {
        super(ui, x, y, size, rotation);
    }

    public void render()
    {
        ui.stroke(255);

        ui.pushMatrix();

        ui.fill(40);
        ui.translate(position.x, position.y);

        ui.ellipse(0, 0, (float) size, (float) size);
        ui.ellipse(0, 0, size/2.25f , size/2.25f);

        ui.fill(120);
        //Inner Circle
        ui.ellipse(10,-10,size/20,size/20);
        ui.ellipse(10,10,size/20,size/20);
        ui.ellipse(-10,10,size/20,size/20);
        ui.ellipse(-10,-10,size/20,size/20);

        //Outer Circle
        ui.ellipse(30,-30,size/20,size/20);
        ui.ellipse(30,30,size/20,size/20);
        ui.ellipse(-30,30,size/20,size/20);
        ui.ellipse(-30,-30,size/20,size/20);


        ui.popMatrix();
    }

    public void update()
    {
        
    }
}