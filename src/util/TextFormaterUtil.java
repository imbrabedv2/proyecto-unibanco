package util;

import javafx.scene.control.TextFormatter.Change;

public class TextFormaterUtil {

    public static Change uppercaseFormat(Change change) {
        change.setText(change.getText().toUpperCase());
        return change;
    }

    public static Change integerFormat(Change change) {
        return(change.getText().matches("[0-9]*")) ? change:null;
    }

    public static Change doubleFormat(Change change) {
        return (change.getText().matches("[0-9]*\\.?[0-9]?$")) ? change:null;
    }
}
