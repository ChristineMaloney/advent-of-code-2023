import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

class Main {
    public static void main(String[] args) {
      
        String filePath = "input.txt";

        int runningTotal =0;

        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String entry;

            while ((entry = br.readLine()) != null) {
                String currentAnswer = calculatePerEntry(entry);
                runningTotal = runningTotal + Integer.parseInt(currentAnswer);
            }
          
            System.out.print("Answer: "+ runningTotal);
        } catch (IOException e) {
        }
    }

    public static String calculatePerEntry(String entry) {
          Pattern pattern = Pattern.compile("\\d+");
          Matcher matcher = pattern.matcher(entry);
  
          String firstNumber = ""; 
  
          if (matcher.find()) {
              firstNumber = matcher.group();
              firstNumber = firstNumber.substring(0,1);
          }

          matcher.reset();
      
          String lastNumber = "";
  
          while (matcher.find()) {
               lastNumber = matcher.group().substring(matcher.group().length() - 1);
          }
  
          return firstNumber + lastNumber;
    }
}
