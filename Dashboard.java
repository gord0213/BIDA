/**
 * 
 */
package Assignment1;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.math.BigInteger;
import java.text.DecimalFormat;
import java.util.StringTokenizer;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.stage.Stage;

/**
 * @author mike
 *
 */
@SuppressWarnings({"restriction"})
public class Dashboard extends Application {

	public static String csvFile ;
	public static String[] cols;// = new ArrayList<>();
	public static ObservableList<Double> PropertyValue = FXCollections.observableArrayList();
	public static ObservableList<Integer> avgHouseAge  = FXCollections.observableArrayList();
	public static double testDouble;
	public static int testInt;
	public double calculatedAvgPropertyValue;
	public double calculatesAvgHouseAge;
	public static BufferedReader reader;
	public static String strLine;
	public static int lineNum = 1;
	
	
	public void getCSV(String fileName) throws IOException{
		try {
			reader = new BufferedReader(new FileReader(fileName));
		}catch (FileNotFoundException e){ e.printStackTrace(); }
	
		while((strLine = reader.readLine()) != null){
			try {
				System.out.println(lineNum++);
				cols = strLine.split(",(?=([^\"]*\"[^\"]*\")*[^\"]*$)");
				System.out.println("Column 19: " + cols[19]);
				System.out.println("Column 25: " + cols[24]);

				testDouble = Double.parseDouble(cols[19]);
				PropertyValue.add(testDouble);
/*-------------------------------------------------------------------------------------------*/
				testInt = Integer.parseInt(cols[24]);
				avgHouseAge.add(testInt);
				
			}catch (NumberFormatException e) {
//				try {
//				Thread.sleep(500);
//			} catch (InterruptedException e1) {
//				// TODO Auto-generated catch block
//				e1.printStackTrace();
//			} 
			}//System.out.println(e); }
		}
		
			
		
		calculateAvgPropertyValue();
		calculateHouseAge();
	}
	
	public void calculateAvgPropertyValue(){
		System.out.println(PropertyValue);	
		for (int i = 0; i < PropertyValue.size(); i++){
			try{
				calculatedAvgPropertyValue += PropertyValue.get(i);
				System.out.println("passed");
				//System.out.println("Next number " + i);
			}catch(NumberFormatException e){  
				System.out.println(e);
			}catch(NullPointerException e){
				 System.out.println(e);
			}
			
		}

		System.out.println(calculatedAvgPropertyValue/PropertyValue.size());
	}
	
	public void calculateHouseAge() {
		System.out.println(avgHouseAge);
		for (int i = 0; i < avgHouseAge.size(); i++){
			try{
				calculatesAvgHouseAge += avgHouseAge.get(i);
				System.out.println("passed");

			}catch(NumberFormatException e){
				e.getMessage();
				try {
					Thread.sleep(200);
				} catch (InterruptedException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}catch(NullPointerException e){
				e.getMessage();
				try {
					Thread.sleep(200);
				} catch (InterruptedException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		}
	}
	
	@Override
	public void start(Stage primaryStage) throws Exception {
		csvFile = "C:\\Users\\mike\\workspace\\Fall16-Lab1-BIDA\\src\\Assignment1\\property_tax_report.csv";
		getCSV(csvFile);
		
		
	}
	
	public static void main(String args[]) throws IOException{
		launch(args);
	}

}
