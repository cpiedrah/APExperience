package CSVTesting;
import java.io.FileNotFoundException;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class CSVTest {
    public static void main(String [] args){

        String path = "C:\\Users\\piedrahitaclan\\Downloads\\CSVFilePractice.csv";
        String line = "";

        try{
            BufferedReader br = new BufferedReader(new FileReader(path));

            while((line = br.readLine()) != null){
                String [] values = line.split(",");
                System.out.println(values);
            }
        }
        catch(FileNotFoundException e){
            e.printStackTrace();
        }
        catch(IOException e){
            e.printStackTrace();
        }

    }
}
