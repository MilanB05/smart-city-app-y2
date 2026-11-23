/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package recyclingtrackeraa;

/**
 *
 * @author Home-PC
 */
public class RecyclingRecord {
    
    protected int recordId;
    protected String materialType;
    protected double weight;
    protected String date;
    
    public RecyclingRecord(int recordId,String materialType, double weight, String date){
        this.recordId = recordId;
        this.materialType = materialType;
        this.weight = weight;
        this.date = date;
        
    }
    public int recordId(){
        return recordId;
    }

    public void setRecordId(int recordId) {
        this.recordId = recordId;
    }

    public void setMaterialType(String materialType) {
        this.materialType = materialType;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getMaterialType() {
        return materialType;
    }

    public double getWeight() {
        return weight;
    }

    public String getDate() {
        return date;
    }
    public int getRecordId(){
        return recordId;
    }
    @Override
    public String toString(){
        return "RecordId: " + recordId + ", Material" + materialType+ ", Weight: " + " kg" + ", Date: " + date;
    }
    
}
