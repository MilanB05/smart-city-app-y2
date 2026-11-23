/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package recyclingtrackeraa;

/**
 *
 * @author Home-PC
 */
public class plasticRecycling extends RecyclingRecord {
    
    private String plasticType;
    
    public plasticRecycling(int recordId, double weight, String date, String plasticType){
        
        super(recordId,"plastic",weight,date);
        
        this.plasticType = plasticType;
    
    
}

    public void setPlasticType(String plasticType) {
        this.plasticType = plasticType;
    }

    public String getPlasticType() {
        return plasticType;
    }
    
    @Override
    public String toString(){
        return super.toString()
                + ", Plastic Type: " + plasticType;
    }
}