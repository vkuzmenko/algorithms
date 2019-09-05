import java.util.*;
import java.util.stream.Collectors;
import helpers.Ticket;

public class GoogleFlights {

    /*
    Input:

    SAN - SFO
    DEN - SAN
    DEN - LAX

    Output:

    SFO -> SAN -> DEN -> LAX
    LAX -> DEN -> SAN -> SFO
     */

    private static List<String> getTrip(List<Ticket> ticketList) {
        List<String> trip = new ArrayList<>();

        String startCity = getStartCity(ticketList);

        Map<String, Set<String>> cityDescs = getCitiesDestionations(ticketList);

        PriorityQueue<String> queue = new PriorityQueue<>();
        queue.add(startCity);
        while(!queue.isEmpty()) {

            String city = queue.poll();
            if (!trip.contains(city)) {
                trip.add(city);
            }

            Set<String> destinations = cityDescs.get(city);
            queue.addAll(destinations);
        }

        return trip;
    }

    private static String getStartCity(List<Ticket> ticketList) {
        Map<String, Integer> cityFreq = new HashMap<>();
        for (Ticket ticket : ticketList) {
            if (cityFreq.containsKey(ticket.firstCity)) {
                Integer count = cityFreq.get(ticket.firstCity);
                cityFreq.put(ticket.firstCity, count + 1);
            } else {
                cityFreq.put(ticket.firstCity, 1);
            }
            if (cityFreq.containsKey(ticket.secondCity)) {
                Integer count = cityFreq.get(ticket.secondCity);
                cityFreq.put(ticket.secondCity, count + 1);
            } else {
                cityFreq.put(ticket.secondCity, 1);
            }
        }

        List<String> startEndCities = cityFreq.entrySet().stream()
                .filter(x-> x.getValue() == 1)
                .map(x -> x.getKey())
                .collect(Collectors.toList());

        return startEndCities.get(0);
    }

    private static Map<String, Set<String>> getCitiesDestionations(List<Ticket> ticketList) {
        Map<String, Set<String>> citiesDestinations = new HashMap<>();
        for (Ticket ticket : ticketList) {
            if (citiesDestinations.containsKey(ticket.firstCity)) {
                Set<String> destinationsList = citiesDestinations.get(ticket.firstCity);
                destinationsList.add(ticket.secondCity);
            }
            if (citiesDestinations.containsKey(ticket.secondCity)) {
                Set<String> destinationsList = citiesDestinations.get(ticket.secondCity);
                destinationsList.add(ticket.firstCity);
            }
        }
        return citiesDestinations;
    }

    public static void main(String[] args) {
        List<Ticket> tickets = new ArrayList<>();
        tickets.add(Ticket.valueOf("SAN", "SFO"));
        tickets.add(Ticket.valueOf("DEN", "SAN"));
        tickets.add(Ticket.valueOf("DEN", "LAX"));

        List<String> trip = GoogleFlights.getTrip(tickets);

        for (String city : trip) {
            System.out.print(city + " -> ");
        }
        System.out.println();
    }
}
