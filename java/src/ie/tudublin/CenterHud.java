package ie.tudublin;


public class CenterHud extends UiObject{

    private float circleDiameter;
    private float circleRadius;

    private float pitch;
    private float yaw;
    private float roll;

    public CenterHud (UI ui, float x, float y, float size, float rotation)
    {
        super(ui, x, y, size, rotation);
        this.circleDiameter = size;
        this.circleRadius = circleDiameter / 2f;

        this.pitch = 0.0f;
        this.yaw = 0.0f;
        this.roll = 0.0f;
    }

    public void render()
    {   
        ui.pushMatrix();
        ui.stroke(0,255,0);
        ui.ellipse(position.x,position.y,circleDiameter,circleDiameter);
        ui.translate(position.x, position.y);
        ui.text("R" +"   "+roll, - (circleRadius * 0.98f), -15);
        ui.text("Y" +"   "+yaw, - (circleRadius * 0.98f), 0);
        ui.text("P" +"   "+ pitch, - (circleRadius * 0.98f), 15);
        ui.popMatrix();
    }

    public void update()
    {

    }
}