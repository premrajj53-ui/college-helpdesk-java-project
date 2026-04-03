import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;

public class Fileswork {

    public static  void studentsInfo(HashMap<String,String>studentInfoMap){
      try( BufferedReader reader = new BufferedReader(new FileReader("D:\\helpDesk-java-project\\college-helpdesk\\src\\Students-info.txt"))){
          String line;
          while ((line= reader.readLine())!=null){
              String[] parts = line.split(",");
              if (parts.length == 2 ){
                  studentInfoMap.put(parts[0].trim(),
                          parts[1].trim());
              }

          }

        }
      catch (IOException e){
          e.printStackTrace();
      }

    }
}
