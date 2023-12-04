import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.ArrayList;
import java.util.List;

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
        //note: this wouldn't be acceptable fix if there were 3 string together.  Must be a better regex option.
        // String regex = "(?:\\d+|oneight|twone|threeight|fiveight|sevenine|eighthree|nineight|one|two|three|four|five|six|seven|eight|nine)";
        // Pattern pattern = Pattern.compile(regex);
        String newEntry = entry.replaceAll("one", "one1one")
            .replaceAll("two", "two2two")
            .replaceAll("three", "three3three")
            .replaceAll("four", "four4four")
            .replaceAll("five", "five5five")
            .replaceAll("six", "six6six")
            .replaceAll("seven", "seven7seven")
            .replaceAll("eight", "eight8eight")
            .replaceAll("nine", "nine9nine");


        Pattern pattern = Pattern.compile("\\d+");       
        Matcher matcher = pattern.matcher(newEntry);

        
        List<String> matches = new ArrayList<>();
        while (matcher.find()) {
            String match = matcher.group();
            matches.add(match);
        }

        String firstNumber = matches.get(0);
          // if(!isDigit(firstNumber)){
          //     firstNumber= getDigit(firstNumber);
          // }
          firstNumber = firstNumber.substring(0,1);
        
        String lastNumber = matches.get(matches.size() -1);

        // if(!isDigit(lastNumber)){
        //    lastNumber= getDigit(lastNumber);
        //    lastNumber = lastNumber.substring(lastNumber.length() - 1);
        //   } else {
            lastNumber = lastNumber.substring(lastNumber.length() - 1);

          // }
    
         return firstNumber + lastNumber;
    }
    //Below would be needed if better regex found
  /*  public static boolean isDigit(String input) {
        return input.matches("\\d+");
    }
    public static String getDigit(String firstNumber){
        Map<String, Integer> spelledOutMapping = createSpelledOutMapping();
        String lowercaseInput = firstNumber.toLowerCase();
        String digit = null;
        if(spelledOutMapping.get(lowercaseInput) != null){
            digit = spelledOutMapping.get(lowercaseInput).toString();
        }
        return digit;
        
    }

    public static Map<String, Integer> createSpelledOutMapping() {
        Map<String, Integer> map = new HashMap<>();
        map.put("one", 1);
        map.put("two", 2);
        map.put("three", 3);
        map.put("four", 4);
        map.put("five", 5);
        map.put("six", 6);
        map.put("seven", 7);
        map.put("eight", 8);
        map.put("nine", 9);
        // map.put("oneight", 18);
        // map.put("twone", 21);
        // map.put("threeight", 38);
        // map.put("fiveight",58);
        // map.put("sevenine",79);
        // map.put("eighthree",83);
        // map.put("nineight",98);

        return map;
    }*/
}