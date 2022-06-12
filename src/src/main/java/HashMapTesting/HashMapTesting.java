package HashMapTesting;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.io.FileNotFoundException;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;


public class HashMapTesting {
    public static void main(String [] args){


        List<List<String>> records = new ArrayList<>();
        String path ="C:\\Users\\piedrahitaclan\\Downloads\\EmployeeAvailSchedule1.csv";
        String line = "";
        HashMap<String, List<List<String>>> availSchedule = new HashMap<String,List<List<String>>>();
        try (BufferedReader br = new BufferedReader(new FileReader(path))) {
            while ((line = br.readLine()) != null) {
                String[] values = line.split(",");
                records.add(Arrays.asList(values));
            }
        }
        catch(FileNotFoundException e){
            e.printStackTrace();
        }
        catch(IOException e){
            e.printStackTrace();
        }
        availSchedule.put("Emp1", records);
        for(String i : availSchedule.keySet()){
            System.out.println("key: " + i + " value: " + availSchedule.get(i));
        }


    }
}
