import java.io.*;

public class App {
    public static void main(String[] args) {

		String FilePath = "src\\daten.csv";
		String line="";
		
		BufferedReader reader = null;
		
		try {
			// Pass in the CSV file to the file reader
			reader = new BufferedReader(new FileReader(FilePath));
            
            //Create array with 4 values
            int[] array = {0, 0, 0, 0};

			while((line = reader.readLine()) != null) { 
                
                int[] i = {0};
                
				String[] row = line.split(";");
                
                //Go through the lines and check the length of each word
				for(String index : row) {
					int number = index.length();
                    //If the length is bigger than the number of the index of the list, replace it
                    if (number > array[i[0]]) {
                        array[i[0]] = number;
                    }
                    
                    System.out.print(array[i[0]]);
                    
                    //Increment value of i
                    i[0] = i[0] + 1;
                    // if i maior que i, substituir o i pelo outro. BUUUUUUM
				}
                i[0] = 0;
				System.out.println();
			}

            // closes and open the file again
            reader.close();
            reader = new BufferedReader(new FileReader(FilePath));

            // Counter for the loop iterations
			int count = 0;

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
