package ie.tudublin;

public class TrusterIndicator extends UiObject
{
    private int yawLeft;
    private int yawRight;

    private int pitchUp;
    private int pitchDown;

    private int rollLeft;
    private int rollRight;


    public TrusterIndicator(UI ui,float x,float y,float size, float rotation)
    {
        super(ui, x, y, size, rotation);

        yawLeft = 0;
        yawRight = 0;

        pitchUp = 0;
        pitchDown = 0;

        rollLeft = 0;
        rollRight = 0;
    }

    public void render()
    {
        ui.stroke(255);

        ui.pushMatrix();

        ui.fill(40);
        ui.translate(position.x, position.y);

        ui.ellipse(0, 0, (float) size, (float) size);
        ui.ellipse(0, 0, size/2.25f , size/2.25f);

        //Inner Circle
        //Top Side
        ui.fill(120 + getPitchUp() );
        ui.ellipse(-10,10,size/20,size/20);
        ui.ellipse(10,10,size/20,size/20);
        //Bottom Side
        ui.fill(120 + getPitchDown() );
        ui.ellipse(10,-10,size/20,size/20);
        ui.ellipse(-10,-10,size/20,size/20);

        //Outer Circle
        //Right Side
        ui.fill(120 + getYawLeft() );
        ui.ellipse(30,-30,size/20,size/20);
        ui.ellipse(30,30,size/20,size/20);
        //Left Side
        ui.fill(120 + getYawRight() );
        ui.ellipse(-30,30,size/20,size/20);
        ui.ellipse(-30,-30,size/20,size/20);


        ui.popMatrix();
    }

    public void update()
    {
        if( ui.checkKey('e') )
        {
            setYawLeft(135);
        }
        else
        {
            setYawLeft(0);
        }

        if( ui.checkKey('q') )
        {
            setYawRight(135);
        }
        else
        {
            setYawRight(0);
        }

        if( ui.checkKey('s') )
        {
            setPitchDown(135);
        }
        else
        {
            setPitchDown(0);
        }

        if( ui.checkKey('w') )
        {
            setPitchUp(135);
        }
        else
        {
            setPitchUp(0);
        }
    }

    /**
     * @return the yawLeft
     */
    public int getYawLeft() {
        return yawLeft;
    }

    /**
     * @param yawLeft the yawLeft to set
     */
    public void setYawLeft(int yawLeft) {
        this.yawLeft = yawLeft;
    }

    /**
     * @return the yawRight
     */
    public int getYawRight() {
        return yawRight;
    }

    /**
     * @param yawRight the yawRight to set
     */
    public void setYawRight(int yawRight) {
        this.yawRight = yawRight;
    }

    /**
     * @return the pitchUp
     */
    public int getPitchUp() {
        return pitchUp;
    }

    /**
     * @param pitchUp the pitchUp to set
     */
    public void setPitchUp(int pitchUp) {
        this.pitchUp = pitchUp;
    }

    /**
     * @return the pitchDown
     */
    public int getPitchDown() {
        return pitchDown;
    }

    /**
     * @param pitchDown the pitchDown to set
     */
    public void setPitchDown(int pitchDown) {
        this.pitchDown = pitchDown;
    }

    /**
     * @return the rollLeft
     */
    public int getRollLeft() {
        return rollLeft;
    }

    /**
     * @param rollLeft the rollLeft to set
     */
    public void setRollLeft(int rollLeft) {
        this.rollLeft = rollLeft;
    }

    /**
     * @return the rollRight
     */
    public int getRollRight() {
        return rollRight;
    }

    /**
     * @param rollRight the rollRight to set
     */
    public void setRollRight(int rollRight) {
        this.rollRight = rollRight;
    }

}