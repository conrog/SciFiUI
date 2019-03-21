package ie.tudublin;

import processing.core.PApplet;

public class CenterHud{
    UI ui;

    private float x;
    private float y;
    private float PI;
    private float circleDiameter;
    private float circleRadius;

    private float pitch;
    private float yaw;
    private float roll;

    public CenterHud (UI ui, float x, float y, float circleDiameter,float PI)
    {
        this.ui = ui;
        this.x = x;
        this.y = y;
        this.circleDiameter = circleDiameter;
        this.circleRadius = circleDiameter / 2f;
        this.PI = PI;

        this.pitch = 0.0f;
        this.yaw = 0.0f;
        this.roll = 0.0f;
    }

    public void render()
    {   
        ui.stroke(0,255,0);
        ui.ellipse(x,y,circleDiameter,circleDiameter);
        ui.translate(x, y);
        ui.text("R" +"   "+roll, - (circleRadius * 0.98f), -15);
        ui.text("Y" +"   "+yaw, - (circleRadius * 0.98f), 0);
        ui.text("P" +"   "+ pitch, - (circleRadius * 0.98f), 15);
    }

    public void update()
    {

    }
}