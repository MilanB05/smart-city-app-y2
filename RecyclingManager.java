/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package recyclingtrackeraa;

import java.util.ArrayList;

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
}