import java.util.UUID;


public class DeliveryModel {
    String ID;
    UUID id;
    String toWhom;

    public DeliveryModel(String ID, UUID id, String toWhom) {
        this.ID = ID;
        this.id = id;
        this.toWhom = toWhom;
        
    }

    public String getID() {
        return ID;
    }

    public UUID getId() {
        return id;
    }

    public String getToWhom() {
        return toWhom;
    }

    
    
}