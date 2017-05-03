/**
 * 
 */
package simulator.model;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

/**
 * @author nishantrathi
 *
 */
public class LogGenerator {
	
	private static final String FILE_NAME = "logs_" + System.currentTimeMillis() + ".log";
	private static BufferedWriter bw = null;
	private static FileWriter fw = null;
	private static File file = null;

	static{
		try {
			file = new File(FILE_NAME);
			// if file doesnt exists, then create it
			if (!file.exists()) {
				file.createNewFile();
			}
			System.out.println(file.getAbsolutePath());
			// true = append file
			fw = new FileWriter(file.getAbsoluteFile(), true);
			bw = new BufferedWriter(fw);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	private static void writeToLogFile(String logString) {
		try {
			bw.write(logString);
			bw.flush();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
	
	public static void generateViewItemLog(User user){
		writeToLogFile("" + user.getId() + " \\item\\" + user.visitNextItem() + " " + user.getLocation() + " " + System.currentTimeMillis() + "\n");
	}
	
	public static void generateAddItemLog(User user){
		writeToLogFile("" + user.getId() + " \\addToCart\\" + user.addNextItemToCart() + " " + user.getLocation() + " " + System.currentTimeMillis() + "\n");
	}
	
	public static void generateOrderPlacedLog(User user){
		writeToLogFile("" + user.getId() + " \\placeOrder "  + user.getLocation() + " " + System.currentTimeMillis() + "\n");
	}
	
	public static void generateOrderSuccessLog(User user){
		writeToLogFile("" + user.getId() + " \\orderSuccess "  + user.getLocation() + " " + System.currentTimeMillis() + "\n");
	}
	
	public static void generateOrderFailureLog(User user){
		writeToLogFile("" + user.getId() + " \\orderFailure "  + user.getLocation() + " " + System.currentTimeMillis() + "\n");
	}
	
	public static void main(String[]args) {
		// TODO Auto-generated method stub
		writeToLogFile("test");
	}
}
