import java.io.*;

public class App {
    public static void main(String[] args) {

		String FilePath = "src\\daten.csv";
		String line="";
		
		BufferedReader reader = null;
		
		try {
			// Pass in the CSV file to the file reader
			reader = new BufferedReader(new FileReader(FilePath));
			
			// Counter for the loop iterations
			int count = 0;
			
			// Continue reading to the next line. If there is no line, it breaks out of the loop.
			while((line = reader.readLine()) != null) {
				// Prints horizontal line after the header.
				if (count == 1) {
					System.out.printf("%-17s+", "-----------------");
					System.out.printf("%-17s+", "-----------------");
					System.out.printf("%-17s+", "-----------------");
					System.out.printf("%-17s+", "-----------------");
					System.out.println();
				}
				
				String[] row = line.split(";");
				
				// HERE: Count the length of each data.
				
				// "For Each" Statement
				for(String index : row) {
					// "%-20s" is a way to format the output. s for String. 17 is Space. - means Left Justified.
					System.out.printf("%-17s|", index);	
				}
				System.out.println();
				count++;
			}
		} 
		catch(Exception e) {
			// Display error if something goes wrong
			e.printStackTrace();
		} 
		finally {
			try {
				reader.close();
			}
			catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
}
