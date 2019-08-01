import helpers.Offer;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ProductOffersApiDesign {

    Map<Integer, List<Offer>> productOffers = new HashMap<>();

    void add(Integer productId, Integer offerId, Double price) {
        List<Offer> offers = productOffers.containsKey(productId) ? productOffers.get(productId) : new ArrayList<>();
        offers.add(Offer.valueOf(offerId, price));
        productOffers.put(productId, offers);
    }

    void delete(Integer productId, Integer offerId) {
        if (productOffers.containsKey(productId)) {
            List<Offer> offers = productOffers.get(productId);
            offers.removeIf(offer -> offer.getOfferId().equals(offerId));
            productOffers.put(productId, offers);
        }
    }

    int findClosestOfferPrice(Integer productId, Double price) {
        int closestOfferId = -1;

        if (productOffers.containsKey(productId)) {
            List<Offer> offers = productOffers.get(productId);

            Double bestPrecision = Double.POSITIVE_INFINITY;
            for (Offer offer : offers) {
                Double currentPrecision = Math.abs(offer.getPrice() - price);
                if (currentPrecision < bestPrecision) {
                    bestPrecision = currentPrecision;
                    closestOfferId = offer.getOfferId();
                }
            }
        }

        return closestOfferId;
    }

    public static void main(String args[]) {
        ProductOffersApiDesign t = new ProductOffersApiDesign();
        t.add(1,1,2.5);
        t.add(1,2,3.0);
        t.add(1,3,4.0);
        t.add(1,4,5.0);
        t.add(1,5,6.0);
        t.add(1,6, 99.0);
        t.delete(1,6);

        System.out.println(t.findClosestOfferPrice(1,3.32));
    }
}
