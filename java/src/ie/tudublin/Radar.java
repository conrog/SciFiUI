package ie.tudublin;

public class Radar extends UiObject
{
    private float radius;

    public Radar(UI ui, float x, float y, float size, float rotation){
        super(ui, x, y, size, rotation);
        this.radius = size/2f;
    }

    public void render()
    {
        ui.stroke(0,255,0);
        ui.noFill();

        ui.pushMatrix();
        ui.translate(position.x, position.y);
        ui.rotate(rotation);
        ui.ellipse(0, 0, size, size);
        ui.line(0,0,radius,0);
        ui.popMatrix();
    }

    public void update()
    {
        rotation += 0.1f;
    }


}