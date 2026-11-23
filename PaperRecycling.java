/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package recyclingtrackeraa;

/**
 *
 * @author Home-PC
 */
public class PaperRecycling extends RecyclingRecord{
    
    private String paperType;
    
    public PaperRecycling(int recordId,double weight,String date, String paperType){
        
        super(recordId, "paper", weight, date);
        
        this.paperType = paperType;
    }

    public void setPaperType(String paperType) {
        this.paperType = paperType;
    }

    public String getPaperType() {
        return paperType;
    }
    
    @Override
    public String toString(){
        return super.toString()
                + ", paper Type: " + paperType;
    }
    
    
}
