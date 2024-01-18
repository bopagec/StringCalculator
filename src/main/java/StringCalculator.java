public class StringCalculator {
    public int Add(String numbers) {
        int total = 0;
        if(numbers == null || numbers.isBlank()){
            return total;
        }
        else {
            String[] split = numbers.replace("\n", ",").replace("\r", ",").split(",");

            for(int i=0; i < split.length; i++){
                int x = Integer.valueOf(split[i].trim());
                total = total + x;
            }
        }
        return total;
    }
}
