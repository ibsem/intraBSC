package br.com.intraBSC.util;



import java.awt.Graphics2D;
import java.awt.geom.Rectangle2D;
import net.sf.jasperreports.engine.JRAbstractSvgRenderer;
import org.jfree.ui.Drawable;

public class JCommonDrawableRenderer extends JRAbstractSvgRenderer
{

    public JCommonDrawableRenderer(Drawable drawable)
    {
        this.drawable = null;
        this.drawable = drawable;
    }

    public void render(Graphics2D grx, Rectangle2D rectangle)
    {
        if(drawable != null)
            drawable.draw(grx, rectangle);
    }

    private Drawable drawable;
}
