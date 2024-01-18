public class StringCalculator {
    public int Add(String numbers) {
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
                    int x = Integer.valueOf(split[i].trim());
                    total = total + x;
                }
            }
        }
        return total;
    }
}
