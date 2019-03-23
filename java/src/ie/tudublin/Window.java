package ie.tudublin;

public class Window
{
    UI ui;
    private float velocity;
    private float altitude;

    private float width;
    private float height;

    private float topGap;
    private float sideGap;
    private float indent;
    private float indentGap;

    public Window(UI ui,float width,float height)
    {
        this.ui = ui;
        this.velocity = 7000f;
        this.altitude = 430.f;

        this.width = width;
        this.height = height;

        sideGap = width * 0.2f;
        topGap = height * 0.05f;
        indent = topGap;
        indentGap = (height - topGap) * 0.4f;

    }


    public void render()
    {       
        ui.stroke(0,255,0);
        ui.line(sideGap, topGap, width-sideGap, topGap); //Top

        ui.line(sideGap, topGap, sideGap, indentGap); //Left Top
        ui.line(sideGap, indentGap, sideGap + indent, indentGap + indent);
        ui.line(sideGap + indent, indentGap + indent,sideGap + indent, height - indentGap - indent);
        ui.line(sideGap, height - indentGap, sideGap + indent, height - indentGap - indent);
        ui.line(sideGap, height - topGap, sideGap, height - indentGap ); // Left Bottom

        ui.line(width - sideGap, topGap, width - sideGap, indentGap); //Right Top
        ui.line(width - sideGap, indentGap, width - sideGap - indent, indentGap + indent);
        ui.line(width - sideGap - indent, indentGap + indent, width - sideGap - indent, height - indentGap - indent);
        ui.line(width - sideGap, height - indentGap, width - sideGap - indent, height - indentGap - indent);
        ui.line(width - sideGap, height - topGap, width - sideGap, height - indentGap ); // Right Bottom

        ui.line(sideGap, height-topGap, width-sideGap, height - topGap); //Bottom

        ui.text(velocity, sideGap * 0.9f, height/2);
        ui.text(altitude, width - sideGap, height/2);

    }

    public void update()
    {
        if(ui.checkKey(38))
        {

            velocity += 0.05f;
        }

        if(ui.checkKey(40))
        {
            velocity -= 0.05f;
        }
    }


}