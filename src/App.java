import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.nio.charset.Charset;
import java.security.acl.Group;
import java.util.Scanner;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.WritableImage;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

public class App extends Application {
    static Node[] finalArray = new Node[128];
    static File mainFile;
    static int[] count_charArr = new int[128];

    public static void main(String[] args)  {
        mainFile = new File("C:/Users/asus/Desktop/words.txt");
        readFile();
        
        createFinalArray();
        
        // LinkedList list = new LinkedList();
        // for(int i =0;i<finalArray.length;i++){
        //     if(finalArray[i].freq!=0){
        //         list.sortedInsert(finalArray[i]);
        //     }
        // }
        // list.print();
        
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("Comprresion Program");

        Button choseFile  = new Button("choose");
        HBox forFile = new HBox(choseFile);
        Label fileName = new Label();
        fileName.setLabelFor(choseFile);
        fileName.setLayoutX(80);
        fileName.setLayoutY(5);
        FileChooser selectFile = new FileChooser();
        FileChooser.ExtensionFilter extfilter = new FileChooser.ExtensionFilter("TXT files (*.txt)","*.txt");
        selectFile.getExtensionFilters().add(extfilter);
        forFile.setPadding(new Insets(30,0,0,30));
        HBox.setMargin(fileName, new Insets(10));
        choseFile.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent arg0) {
                mainFile = selectFile.showSaveDialog(primaryStage);
                fileName.setText(mainFile.getName());
                forFile.getChildren().addAll(fileName);
                readFile();
                createFinalArray();
            }
        });

        BorderPane pane  = new BorderPane();
        pane.setLeft(forFile);
        primaryStage.setScene(new Scene(pane, 700, 550));
        primaryStage.show();
    }

    public static void readFile() {
        try (FileReader readFile = new FileReader(mainFile)) {
            int content;
            while ((content = readFile.read()) != -1) {
                if (content <= 128)
                    count_charArr[content]++;
            }

        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public static void createFinalArray() {

        for (int i = 0; i < count_charArr.length; i++) {

                finalArray[i] = new Node((char) i, count_charArr[i]);
        }

    }

}
