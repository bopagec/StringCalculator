import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class StringCalculator {
    public int Add(String numbers) {
        List<Integer> negatives = new ArrayList<>();
        int unknownNumbers = 0;

        int total = 0;
        if(numbers == null || numbers.isBlank()){
            return total;
        }
        else {
            String delimiter = ",";

            if(numbers.startsWith("//")){
                delimiter = numbers.substring(2,3);
                numbers = numbers.substring(3, numbers.length());
            }

            String[] split = numbers.replace("\n", delimiter).replace("\r", delimiter).split(delimiter);

            for(int i=0; i < split.length; i++){
                if(split[i].length() > 0){
                    try{
                        int x = Integer.valueOf(split[i].trim());

                        if(x < 0 ) {
                            negatives.add(x);
                        }
                        else if(x <= 1000){
                            total = total + x;
                        }
                    }
                    catch (NumberFormatException e){
                        unknownNumbers++;
                    }

                }
            }
        }
        System.out.println("unknown numbers: " + unknownNumbers);
        if(negatives.size() == 0){
            return total;
        }
        else{
            String str = negatives.stream()
                    .map(i -> String.valueOf(i))
                    .collect(Collectors.joining(","));
            throw new RuntimeException("Negatives not allowed:" + str);
        }
    }
}
