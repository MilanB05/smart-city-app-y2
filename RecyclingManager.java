/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package recyclingtrackeraa;

import java.util.ArrayList;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.io.IOException;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileNotFoundException;

/**
 *
 * @author Home-PC
 */
public class RecyclingManager {
    // array stores all recyclign records
    private ArrayList<RecyclingRecord> records;
    
    public RecyclingManager(){
        // constuctor for empty array lost
        records = new ArrayList<>();
        
        // loads saved recycling records
        loadFromFile();
    }
    // adds new record to array
   public void addRecord(RecyclingRecord record){
       records.add(record);
   }
    // return all records
   public ArrayList<RecyclingRecord> getAllRecords(){
       return records;
   }
   
    public RecyclingRecord searchRecord(int recordId){
        for(RecyclingRecord record : records){
            // checks if record Id matches
            if(record.getRecordId() == recordId){
                return record;
        }
            
        }
            
        
    return null;
    
}   // deletes recycling record
    public boolean deleteRecord(int recordId){
        RecyclingRecord record = searchRecord(recordId);
        
        if(record != null){
            records.remove(record);
            return true;
        }
        return false;
    }
    public double CalculateTotalWeight(){
        double total = 0;
        
        for(RecyclingRecord record : records){
            total += record.getWeight();
        }
        return total;
    }
    public void DisplayRecords(){
        
        if(records.isEmpty()){
            System.out.println("There is not recycling records here");
            return;
        }
        for (RecyclingRecord record : records){
            System.out.println(record.toString());
       }
    }
    
    public boolean SaveToFile(){
        try(PrintWriter  writer =  new PrintWriter(new FileWriter("RecyclingRecord.txt"))){
            for(RecyclingRecord record: records){
                String detail = "";
                 if (record instanceof PaperRecycling){
                detail = ((PaperRecycling)record).getPaperType();
                    // gets plastic details
            }else if(record instanceof plasticRecycling){
                detail = ((plasticRecycling) record).getPlasticType();
       }
                 //writes record into txt file created
                 writer.println(record.getRecordId() + " , "+ record.getMaterialType() + " , " + detail.replace(", ", " ") + " , " + record.getWeight() + " , " +  record.getDate().replace(" , ", " "));
                 
            }
            return !writer.checkError();
     }catch(IOException e){
    System.out.println("Error saving Recyckling record");
    return false;
     }
    }
    //// loads saved recycling  records
    public void loadFromFile(){
         
        // cleares existing records/prevents double ups
        records.clear();
        
        try(BufferedReader reader = new BufferedReader(new FileReader("RecyclingRecord.txt"))){
            
            String line;
            
            //reads each line from the file
            while((line = reader.readLine()) != null ){
                
                String [] parts = line.split(",", -1);
                // checks of record has 5 values
                if(parts.length == 5){
                    int recordId = Integer.parseInt(parts[0].trim());
                    String material = parts[1].trim();
                    String detail = parts[2].trim();
                    double weight = Double.parseDouble(parts[3].trim());
                    String date = parts[4].trim();
                    
                    //paper recycling object
                    if(material.equalsIgnoreCase("paper")){
                        
                        records.add(new PaperRecycling(recordId,weight,date,detail));
                        
                        
                    }else if(material.equalsIgnoreCase("plastic")){
                        records.add(new plasticRecycling(recordId,weight,date,detail));
                }
                     
            }
        }
    }catch(FileNotFoundException e){
            System.out.println("There is no saved recycling records yet!!!");
    
    }catch(IOException | NumberFormatException e){
            System.out.println("Error laoding the records" + e.getMessage());
  }
    }
}

  
        
     