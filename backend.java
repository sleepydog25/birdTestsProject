import java.io.*;
import java.nio.Buffer;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {

        List<String []> birdInfo = new ArrayList<>();
        String csvFile = "C:\\Users\\NTPU\\Downloads\\image_attributes.csv";
        String csvFilePath = "C:\\Users\\NTPU\\Downloads";
        String csvFileName = "image_attributes.csv";
        String splitBy = ";";

        try(BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(csvFile),"utf-8"))){
            String line;
            while((line = br.readLine())!=null){
                String[] values = line.split(splitBy);
                birdInfo.add(values);
            }

        }catch(IOException e){
            System.err.println(e);
        }

     //print out my data and see what it's like
        for(String[] row :birdInfo){
            for(String value : row){
                System.out.print(value + "\t");
            }
            System.out.println();
        }



// TA's code
//        List<String> listString = new ArrayList<>();
//        Path path = Paths.get(csvFilePath);
//
//        listString.add("question1");
//        listString.add("question2");

        //answer
        String answer;

        //Randomly select an option
        List<String> choices= List.of("Accipiter trivirgatus", "Pernis ptilorhynchus", "Spilornis cheela");
        Random random = new Random();
        int index = random.nextInt(choices.size());
        String randomChoice = choices.get(index);

//        System.out.println(randomChoice); /* print out the random choices*/

        //Calculate Score

        int maxScore = 0;
        int count = 0;

        Scanner s  = new Scanner(System.in);
        String input = s.nextLine();
        if (input.equals(answer)){
            count++;
            maxScore = count;
        }
        else{
            System.out.println("WA");
        }


    }


}

