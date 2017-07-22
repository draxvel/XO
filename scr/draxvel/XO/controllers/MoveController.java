package draxvel.XO.controllers;

import draxvel.XO.model.Field;
import draxvel.XO.model.Figure;
import draxvel.XO.model.exception.AlreadyOccupiedException;
import draxvel.XO.model.exception.InvalidPointException;

import java.awt.*;

public class MoveController {

    public void applyFigure(final Field field,
                            final Point point,
                            final Figure figure) throws AlreadyOccupiedException,
                                                        InvalidPointException {

        if(field.getFigure(point) != null){
            throw new AlreadyOccupiedException();
        }
        field.setFigure(point, figure);

    }
}
