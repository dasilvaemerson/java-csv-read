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
                    
                    //System.out.print(array[i[0]]);
                    
                    //Increment value of i
                    i[0] = i[0] + 1;
                    // if i maior que i, substituir o i pelo outro. BUUUUUUM
				}
                i[0] = 0;
				//System.out.println();
			}

            // closes and open the file again
            reader.close();
            reader = new BufferedReader(new FileReader(FilePath));

            // Counter for the loop iterations
			// int count = 0;
            
            int count2 = 0;
            while((line = reader.readLine()) != null) {
				// Prints horizontal line after the header.
                int[] count = {0};
                
                if (count2 == 1) {
					myMethod(array[0]);
                    myMethod(array[1]);
                    myMethod(array[2]);
                    myMethod(array[3]);
                    System.out.println();
				}
                
				String[] row = line.split(";");
				
				// HERE: Count the length of each data.
				
				// "For Each" Statement
				for(String index : row) {
					
                    // "%-20s" is a way to format the output. s for String. 17 is Space. - means Left Justified.
                    System.out.printf("%-" + array[count[0]] + "s|", index);
                    count[0] = count[0] + 1;
				}
				System.out.println();
                count2++;
                
				
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

    static void myMethod(int number) {
        // code to be executed
        String str = "-";
        int n=0;
        n = number;
        String horizontalLine = new String(new char[n]).replace("\0", str);
        System.out.print(horizontalLine);
        System.out.print("+");
        
      }
}
