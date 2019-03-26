package ie.tudublin;

import processing.core.PVector;

public abstract class UiObject
{
    protected UI ui;
    protected PVector position;
    protected float size;
    protected float rotation;

    public UiObject(UI ui, float x, float y, float size, float rotation)
    {
        this.ui = ui;
        position = new PVector(x,y);
        this.size = size;
        this. rotation = rotation;
    }

    public abstract void update();

    public abstract void render();

    /**
     * @return the ui
     */
    public UI getUi() {
        return ui;
    }

    /**
     * @param ui the ui to set
     */
    public void setUi(UI ui) {
        this.ui = ui;
    }

    /**
     * @return the position
     */
    public PVector getPosition() {
        return position;
    }

    /**
     * @param position the position to set
     */
    public void setPosition(PVector position) {
        this.position = position;
    }

    /**
     * @return the size
     */
    public float getSize() {
        return size;
    }

    /**
     * @param size the size to set
     */
    public void setSize(float size) {
        this.size = size;
    }
}