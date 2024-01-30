package MyTestCasses;

import java.util.Random;

public class parametares {
	Random rand = new Random();
    String[] firstnames = {"Alice", "Bob", "Charlie", "David", "Emma", "Frank", "Grace", "Henry", "Ivy", "Jack"};
    String[] lastnames = {"Anderson", "Brown", "Clark", "Davis", "Evans", "Fisher", "Green", "Harris", "Irwin", "Johnson"};
    String commonPassword ="1234@SSS";
    
    int randomindex = rand.nextInt(10);
    int randomEmilId = rand.nextInt(9999);
    
    String EmailId = firstnames[randomindex] + lastnames[randomindex] + randomEmilId + "@gmail.com" ;



}
