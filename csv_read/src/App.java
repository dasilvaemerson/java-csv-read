import java.io.*;

public class App {
    public static void main(String[] args) {

		String FilePath = "src\\daten.csv";
		String line="";
		
		BufferedReader reader = null;
		
		try {
			// Pass in the CSV file to the file reader
			reader = new BufferedReader(new FileReader(FilePath));
            
            //Create array with 4 values to store the length of the columns
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
                    i[0] = i[0] + 1;
				}
                i[0] = 0;
			}

            // closes and open the file again
            reader.close();
            reader = new BufferedReader(new FileReader(FilePath));

            // Counter for the loop while iterations throught the lines of the CSV
            int lineCount = 0;
            while((line = reader.readLine()) != null) {
				
                // Counter for the 
                int[] count = {0};

                // Prints horizontal line after the header.
                if (lineCount == 1) {
					HorizontalLinePrint(array[0]);
                    HorizontalLinePrint(array[1]);
                    HorizontalLinePrint(array[2]);
                    HorizontalLinePrint(array[3]);
                    System.out.println();
				}
                
				String[] row = line.split(";");
				
                // Iterates trought each line and prints it contents with spacing.
				for(String index : row) {
                    System.out.printf("%-" + array[count[0]] + "s|", index);
                    count[0] = count[0] + 1;
				}
				System.out.println();
                lineCount++;
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

    static void HorizontalLinePrint(int number) {
        // Char to print
        String str = "-";

        //Defines n. It is the number of times the charater will be printed.
        int n=0;
        n = number;

        String horizontalLine = new String(new char[n]).replace("\0", str);
        System.out.print(horizontalLine);
        System.out.print("+");
      }
}
