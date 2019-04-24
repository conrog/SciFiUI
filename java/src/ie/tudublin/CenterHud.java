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
        ui.translate(position.x, position.y);
        ui.stroke(255,255,255);
        ui.noFill();
        
        //Bottom Arc
        ui.arc(0, 0, circleDiameter, circleDiameter , 0.1309f, 1.439897f); //Right Side
        ui.arc(0, 0, circleDiameter, circleDiameter , 1.701696f, 3.010693f); //Left Side

        ui.line( UI.cos(0.1309f) * circleRadius, UI.sin(0.1309f) * circleRadius ,  circleRadius - 15 , 25 ); //Right Side Indent
        ui.line( UI.cos(3.010693f) * circleRadius, UI.sin(3.010693f) * circleRadius , - circleRadius + 15   , 25 ); //Left Side Indent

        ui.line( UI.cos(1.439897f) * circleRadius, UI.sin(1.439897f) * circleRadius ,  25 ,   circleRadius - 15 ); //Bottom Right Side Indent
        ui.line( UI.cos(1.701696f) * circleRadius, UI.sin(1.701696f) * circleRadius ,  - 25 ,   circleRadius - 15 ); //Bottom Left Side Indent

        //Top Arc
        ui.arc(0, 0, circleDiameter, circleDiameter , 3.2724923f,  4.5814893f);//Left Side
        ui.arc(0, 0, circleDiameter, circleDiameter , 4.8432887f,  6.1522856f);//Right Side

        ui.line( UI.cos(6.1522856f) * circleRadius, UI.sin(6.1522856f) * circleRadius ,  circleRadius - 15 , -25 ); //Right Side Indent
        ui.line( UI.cos(3.2724923f) * circleRadius, UI.sin(3.2724923f) * circleRadius , - circleRadius + 15   , -25 ); //Left Side Indent

        ui.line( UI.cos(4.5814893f) * circleRadius, UI.sin(4.5814893f) * circleRadius ,  - 25 ,  - circleRadius + 15); //Top Left Side Indent
        ui.line( UI.cos(4.8432887f) * circleRadius, UI.sin(4.8432887f) * circleRadius ,   25 ,  - circleRadius + 15); //Top Right Side Indent

        //Joining Lines
        ui.line(circleRadius - 15, 25, circleRadius - 15, -25); //Right Side Indent
        ui.line( - circleRadius + 15, 25, - circleRadius + 15, -25); //Left Side Indent
        ui.line( - 25 ,  - circleRadius + 15,  25 ,  - circleRadius + 15); //Top Indent
        ui.line( 25 ,   circleRadius - 15 ,  - 25 ,   circleRadius - 15 ); //Bottom Indent

        //Text
        ui.textAlign(UI.CENTER,UI.CENTER);
        ui.textSize(12);
        ui.fill(255);

        //Pitch Yaw and Roll
        ui.text("R", - (circleRadius * 0.98f), -16);
        ui.text(ui.getRoll(), - (circleRadius * 0.85f), -16);
        ui.text("Y", - (circleRadius * 0.98f), 0);
        ui.text(ui.getYaw(), - (circleRadius * 0.85f), 0);
        ui.text("P", - (circleRadius * 0.98f), 16);
        ui.text(ui.getPitch(), - (circleRadius * 0.85f), 16);

        //Roll
        ui.text("ROLL", 0, - (circleRadius * 0.99f));
        
        //Yaw
        ui.text("YAW", 0,  (circleRadius * 0.97f));

        //Pitch
        char[] pitch = {'P','I','T','C','H'};
        for( int i = 0; i < 5 ; i++)
        {
            ui.text(pitch[i] , (circleRadius * 0.98f),  -24 + (i * 11) );
        }
        ui.popMatrix();
    }

    public void update()
    {
        if(ui.checkKey('w'))
        {
            ui.setPitch( ui.getPitch() + 0.1f);
        }

        if(ui.checkKey('s'))
        {
            ui.setPitch( ui.getPitch() - 0.1f);
        }

        if(ui.checkKey('a'))
        {
            ui.setRoll( ui.getRoll() - 0.1f);
        }

        if(ui.checkKey('d'))
        {
            ui.setRoll( ui.getRoll() + 0.1f);
        }


        if(ui.checkKey('q'))
        {   
            ui.setYaw( ui.getYaw() - 0.1f);
        }

        if(ui.checkKey('e'))
        {
            ui.setYaw( ui.getYaw() + 0.1f);
        }
    }
}