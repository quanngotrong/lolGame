package org.teamGame.util;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import org.teamGame.Game;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Utils {


    /* load file fxml and return parent */
    public static Parent loadFXML(String fxml) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(Utils.class.getResource("/fxml/"+fxml + ".fxml"));
        return fxmlLoader.load();
    }

    /*transform string to number */
    public static int parseInt(String number) {
        try {
            return Integer.parseInt(number);
        } catch (NumberFormatException e) {
            e.printStackTrace();
            return 0;
        }
    }

    /*load map in string
    * */
    public static String loadFileAsString(String path){
        StringBuilder builder = new StringBuilder();
        try{
            BufferedReader br = new BufferedReader(new FileReader(path));
            String line;
            while ((line = br.readLine()) != null)
                builder.append(line).append("\n");
            br.close();
        } catch (IOException e){
            e.printStackTrace();
        }

        return builder.toString();
    }


}
