package ie.tudublin;

import java.text.DecimalFormat;

public class CenterHud extends UiObject {

    //For formatting floats to 1 decimal places
    DecimalFormat df = new DecimalFormat("#.#");
    private String roll;
    private String pitch;
    private String yaw;

    private float circleDiameter;
    private float circleRadius;

    public CenterHud (UI ui, float x, float y, float size, float rotation)
    {
        super(ui, x, y, size, rotation);
        this.circleDiameter = size;
        this.circleRadius = circleDiameter / 2f;

        roll = df.format(ui.getRoll());
        pitch = df.format(ui.getPitch());
        yaw = df.format(ui.getYaw());
    }

    public void render()
    {   
        ui.pushMatrix();
        ui.translate(position.x, position.y);
        ui.stroke(255,255,255);
        ui.noFill();
        
        //Bottom Arc
        ui.arc(0, 0, circleDiameter, circleDiameter , UI.radians(7.5f), UI.radians(82.5f)); //Right Side
        ui.arc(0, 0, circleDiameter, circleDiameter , UI.radians(97.5f), UI.radians(172.5f)); //Left Side

        ui.line( UI.cos(UI.radians(7.5f)) * circleRadius, UI.sin(UI.radians(7.5f)) * circleRadius ,  circleRadius - 15 , 25 ); //Right Side Indent
        ui.line( UI.cos(UI.radians(172.5f)) * circleRadius, UI.sin(UI.radians(172.5f)) * circleRadius , - circleRadius + 15   , 25 ); //Left Side Indent

        ui.line( UI.cos(UI.radians(82.5f)) * circleRadius, UI.sin(UI.radians(82.5f)) * circleRadius ,  25 ,   circleRadius - 15 ); //Bottom Right Side Indent
        ui.line( UI.cos(UI.radians(97.5f)) * circleRadius, UI.sin(UI.radians(97.5f)) * circleRadius ,  - 25 ,   circleRadius - 15 ); //Bottom Left Side Indent

        //Top Arc
        ui.arc(0, 0, circleDiameter, circleDiameter , UI.radians(187.5f),  UI.radians(262.5f));//Left Side
        ui.arc(0, 0, circleDiameter, circleDiameter , UI.radians(277.5f),  UI.radians(352.5f));//Right Side

        ui.line( UI.cos(UI.radians(352.5f)) * circleRadius, UI.sin(UI.radians(352.5f)) * circleRadius ,  circleRadius - 15 , -25 ); //Right Side Indent
        ui.line( UI.cos(UI.radians(187.5f)) * circleRadius, UI.sin(UI.radians(187.5f)) * circleRadius , - circleRadius + 15   , -25 ); //Left Side Indent

        ui.line( UI.cos(UI.radians(262.5f)) * circleRadius, UI.sin(UI.radians(262.5f)) * circleRadius ,  - 25 ,  - circleRadius + 15); //Top Left Side Indent
        ui.line( UI.cos(UI.radians(277.5f)) * circleRadius, UI.sin(UI.radians(277.5f)) * circleRadius ,   25 ,  - circleRadius + 15); //Top Right Side Indent

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
        ui.text("Y", - (circleRadius * 0.98f), 0);
        ui.text("P", - (circleRadius * 0.98f), 16);
        
        ui.textAlign(UI.LEFT,UI.CENTER);
        ui.text(roll, - (circleRadius * 0.92f), -16);
        ui.text(yaw, - (circleRadius * 0.92f), 0);
        ui.text(pitch, - (circleRadius * 0.92f), 16);

        //Roll
        ui.textAlign(UI.CENTER,UI.CENTER);
        ui.fill(255);
        ui.text("ROLL", 0, - (circleRadius * 0.99f));
        ui.fill(0,255,0);
        ui.text(roll, 0, - (circleRadius * 0.90f));
        
        //Yaw
        ui.fill(255);
        ui.text("YAW", 0,  (circleRadius * 0.97f));
        ui.fill(0,255,0);
        ui.text(yaw, 0,  (circleRadius * 0.90f));

        //Pitch
        ui.fill(255);
        char[] pitchString = {'P','I','T','C','H'};
        for( int i = 0; i < 5 ; i++)
        {
            ui.text(pitchString[i] , (circleRadius * 0.98f),  -24 + (i * 11) );
        }
        ui.fill(0,255,0);
        ui.text(pitch, (circleRadius * 0.88f) , 0);
        ui.popMatrix();
    }

    public void update()
    {
        roll = df.format( UI.abs( ui.getRoll() ) );
        pitch = df.format( UI.abs( ui.getPitch() ) );
        yaw = df.format( UI.abs( ui.getYaw() ) );

        if(ui.getRoll() > 360 )
        {
            ui.setRoll(0);
        }

        if(ui.getYaw() > 360 )
        {
            ui.setYaw(0);
        }

        if(ui.getPitch() > 180 )
        {
            ui.setPitch(0);
        }

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