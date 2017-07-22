package draxvel.XO.controllers;

import draxvel.XO.model.Field;
import draxvel.XO.model.Figure;
import draxvel.XO.model.exception.InvalidPointException;

import java.awt.*;

public class WinnerController {

    public Figure getWinner(final Field field) {
        try {
        //horizontal
        for(int i = 0; i <3; i++){
            if(check(field, new Point(i,0), p -> new Point(p.x,p.y+1 )))
                return field.getFigure(new Point(i,0));
        }

        //vertical
        for(int i = 0; i <3; i++){
            if(check(field, new Point(i,0), p -> new Point(p.x+1,p.y )))
                    return field.getFigure(new Point(0,1));
        }

        //diagonal1
        if(check(field, new Point(0,0), p -> new Point(p.x+1,p.y+1 )))
            return field.getFigure(new Point(0,0));

        //diagonal2
        if(check(field, new Point(0,2), p -> new Point(p.x+1,p.y-1 )))
            return field.getFigure(new Point(1,1));

        } catch (InvalidPointException e) {
            e.printStackTrace();
        }
        return null;
    }

    private boolean check(final Field field,
                          final Point currentPoint,
                          final IPointGenerator iPointGenerator) {
        final Figure currentFigure;
        final Figure nextFigure;
        final Point nextPoint = iPointGenerator.next(currentPoint);

        try {
            currentFigure = field.getFigure(currentPoint);
            nextFigure = field.getFigure(currentPoint);

        } catch (InvalidPointException e) {
            return true;
        }

        if(currentFigure == null) return false;
        if(currentFigure != nextFigure) return false;

        return check(field, nextPoint, iPointGenerator);
    }

    private interface IPointGenerator{
         Point next(final Point point);
    }
}
