package controller.buttonHandler;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;

public class HandlerSalir implements EventHandler<ActionEvent> {


    @Override
    public void handle(ActionEvent actionEvent) {
        System.exit(0);
    }
}
