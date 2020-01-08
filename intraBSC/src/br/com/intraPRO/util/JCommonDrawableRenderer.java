// Decompiled by Jad v1.5.8e2. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://kpdus.tripod.com/jad.html
// Decompiler options: packimports(3) 
// Source File Name:   JCommonDrawableRenderer.java

package br.com.intraPRO.util;

import java.awt.Graphics2D;
import java.awt.geom.Rectangle2D;
import net.sf.jasperreports.engine.JRAbstractSvgRenderer;
import org.jfree.ui.Drawable;

public class JCommonDrawableRenderer extends JRAbstractSvgRenderer
{

    private double altura;

	public JCommonDrawableRenderer(Drawable drawable)
    {
        this.drawable = null;
        this.drawable = drawable;
        this.altura = 1;
       
    }

	public JCommonDrawableRenderer(Drawable drawable, double altura)
    {
        this.drawable = null;
        this.drawable = drawable;
        this.altura = altura;
    }

    public void render(Graphics2D grx, Rectangle2D rectangle)
    {
    	rectangle.setRect(rectangle.getX(),rectangle.getY(),rectangle.getWidth(),altura);
        if(drawable != null)
            drawable.draw(grx, rectangle);
        
    }

    private Drawable drawable;
}
