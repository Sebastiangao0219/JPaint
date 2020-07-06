package controller;

import model.Point;
import view.interfaces.PaintCanvasBase;

import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

/**
 * TODO:
 *
 * @Program:
 * @Pescription:
 * @Param:
 * @Return:
 * @Author: Sebastian Gao
 * @Date: 2020-07-06 01:06
 */

public class MyMouseListener extends MouseAdapter {

    private Point startPoint;
    private PaintCanvasBase paintCanvas;

    public MyMouseListener(PaintCanvasBase paintCanvas){
        this.paintCanvas = paintCanvas;
    }

    @Override
    public void mousePressed(MouseEvent e) {
        //e.getPoint();
        startPoint = new Point(e.getX(), e.getY());
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        Point endPoint = new Point(e.getX(), e.getY());

        // Filled in rectangle
        Graphics2D graphics2d = paintCanvas.getGraphics2D();
        graphics2d.setColor(Color.GREEN);
//        int width = -1, height = -1;
//        if(e.getX() > startPoint.getX()){
//            width = e.getX() - startPoint.getX();
//        } else {
//            width = startPoint.getX() - e.getX();
//        }

        int width = Math.abs(e.getX() - startPoint.getX());
//        if(e.getY() > startPoint.getY()){
//            height = e.getY() - startPoint.getY();
//        }else{
//            height = startPoint.getY() - e.getY();
//        }

        int height = Math.abs(e.getY() - startPoint.getY());
        //here passed in start point and end point coordinates
        graphics2d.fillRect(startPoint.getX(), startPoint.getY(), width, height);
    }
}