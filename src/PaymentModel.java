import java.util.UUID;


public class PaymentModel {
    double price;
    UUID id;
    String toWhom;

    public PaymentModel(double price, UUID id, String toWhom) {
        this.price = price;
        this.id = id;
        this.toWhom = toWhom;
        
    }

    public double getPrice() {
        return price;
    }

    public UUID getId() {
        return id;
    }

    public String getToWhom() {
        return toWhom;
    }

    
    
}
