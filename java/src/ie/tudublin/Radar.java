package ie.tudublin;

public class Radar{

    UI ui;
    private float x;
    private float y;
    private float diameter;
    private float radius;

    private float rotation;

    public Radar(UI ui, float x, float y, float diameter){
        this.ui = ui;
        this.x = x;
        this.y = y;
        this.diameter = diameter;
        this.radius = diameter/2f;

    }

    public void render()
    {
        ui.stroke(0,255,0);
        ui.noFill();

        ui.pushMatrix();
        ui.translate(x, y);
        ui.rotate(rotation);
        ui.ellipse(0, 0, diameter, diameter);
        ui.line(0,0,radius,0);
        ui.popMatrix();
    }

    public void update()
    {
        rotation += 0.1f;
    }


}