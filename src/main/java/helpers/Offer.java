package helpers;

public class Offer {
    private Integer offerId;
    private Double price;

    private Offer(Integer offerId, Double price) {
        this.offerId = offerId;
        this.price = price;
    }

    public static Offer valueOf(Integer offerId, Double price) {
        return new Offer(offerId, price);
    }

    public Integer getOfferId() {
        return this.offerId;
    }

    public Double getPrice() {
        return this.price;
    }
}
