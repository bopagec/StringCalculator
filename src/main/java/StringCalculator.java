public class StringCalculator {
    public int Add(String numbers) {
        int total = 0;
        if(numbers == null || numbers.isBlank()){
            return total;
        }
        else {
            String[] split = numbers.split(",");

            for(int i=0; i < split.length; i++){
                int x = Integer.valueOf(split[i]);
                total = total + x;
            }
        }
        return total;
    }
}
