package Helper;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.stage.Modality;
import javafx.stage.Stage;

//create custom dialog
public class MyDialog {
    public static void show(String message){
        Stage stage=new Stage();
        stage.initModality(Modality.WINDOW_MODAL);
        Button btn=new Button("OK");
        btn.setOnAction(event -> stage.close());
        Text text=new Text(message);
        VBox vBox=new VBox(text,btn);
        vBox.setAlignment(Pos.CENTER);
        vBox.setPadding(new Insets(15));
        Scene scene=new Scene(vBox);
        stage.setScene(scene);
        stage.show();
    }
}
