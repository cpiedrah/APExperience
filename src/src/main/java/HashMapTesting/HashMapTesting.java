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
        String path ="C:\\Users\\piedrahitaclan\\Downloads\\EmployeeAvailSchedule10.csv";
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

        List<List<String>> records2 = new ArrayList<>();
        String path2 ="C:\\Users\\piedrahitaclan\\Downloads\\EmployeeAvailSchedule11.csv";
        String line2 = "";
        HashMap<String, List<List<String>>> availSchedule2 = new HashMap<String,List<List<String>>>();
        try (BufferedReader br = new BufferedReader(new FileReader(path2))) {
            while ((line2 = br.readLine()) != null) {
                String[] values2 = line2.split(",");
                records2.add(Arrays.asList(values2));
            }
        }
        catch(FileNotFoundException e){
            e.printStackTrace();
        }
        catch(IOException e){
            e.printStackTrace();
        }


        String [][] assignedSchedule = new String[3][8];
        availSchedule.put("Emp1", records);
        availSchedule2.put("Emp2", records2);
        assignedSchedule[0][0] = "Name";
        assignedSchedule[0][1] = "FRI";
        assignedSchedule[0][2] = "SAT";
        assignedSchedule[0][3] = "SUN";
        assignedSchedule[0][4] = "MON";
        assignedSchedule[0][5] = "TUES";
        assignedSchedule[0][6] = "WED";
        assignedSchedule[0][7] = "THURS";

        assignedSchedule[1][0] = String.valueOf(availSchedule.keySet());
        assignedSchedule[2][0] = String.valueOf(availSchedule2.keySet());



        int j = 1;
        while(j<8) {
            for (int i = 0; i < records.size(); i++) {
                if (records.get(i).get(i).equals("Yes")) {
                    assignedSchedule[1][j] = "WORK";

                }
                if (records.get(i).get(i).equals("No")) {
                    assignedSchedule[1][j] = "OFF";

                }

            }
            j++;
        }






        for(int r = 0; r < assignedSchedule.length; r++){
            for (int c =0; c<assignedSchedule[0].length; c++){
                System.out.println(assignedSchedule[r][c]);
            }
        }


    }
}
