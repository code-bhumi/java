public class nested_loop {
    public static void main(String[] args){
        int weeks = 4;
        int days = 7;
        
        for (int i = 1; i <=weeks; i++) {
            System.out.println("week: " + i);

           for (int j = 1; j <+ days; j++){
              System.out.println("days: " + j);
           } 
        }
                   
    }
}
