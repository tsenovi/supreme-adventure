package taxi;

import kotlin.ranges.IntRange;
import taxi.models.Driver;
import taxi.models.Passenger;
import taxi.models.Trip;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.*;

public class TaxiPark {

    public Set<Driver> allDrivers;
    public Set<Passenger> allPassengers;
    public List<Trip> trips;

    public TaxiPark(Set<Driver> allDrivers, Set<Passenger> allPassengers, List<Trip> trips) {
        this.allDrivers = allDrivers;
        this.allPassengers = allPassengers;
        this.trips = trips;
    }

    @Override
    public String toString() {
        return "TaxiPark{" +
               "allDrivers=" + allDrivers +
               ", allPassengers=" + allPassengers +
               ", trips=" + trips +
               '}';
    }

    // TASKS

    /*
     * Task #1. Find all the drivers who performed no trips.
     */
    public Set<Driver> findFakeDrivers() {
        Set<Driver> driversWithTrips = trips.stream()
                .map(trip -> trip.driver)
                .collect(Collectors.toSet());

        return allDrivers.stream()
                .filter(driver -> !driversWithTrips.contains(driver))
                .collect(Collectors.toSet());
    }

    /*
     * Task #2. Find all the clients who completed at least the given number of trips.
     */
    Set<Passenger> findFaithfulPassengers(int minTrips) {
        if (minTrips == 0) return allPassengers;

        Map<String, List<Passenger>> passengerMap =
                trips.stream()
                        .flatMap(trip -> trip.passengers.parallelStream())
                        .collect(groupingBy(passenger -> passenger.name));

        return passengerMap.values().stream()
                .filter(passengers -> passengers.size() >= minTrips)
                .map(passengers -> passengers.get(0))
                .collect(Collectors.toSet());
    }

    /*
     * Task #3. Find all the passengers, who were taken by a given driver more than once.
     */
    Set<Passenger> findFrequentPassengers(Driver driver) {
        Map<Passenger, Long> map = trips
                .stream()
                .filter(trip -> trip.driver.equals(driver))
                .flatMap(trip -> trip.passengers.stream())
                .collect(groupingBy(
                        Function.identity(), Collectors.counting()
                ));

        return map.entrySet()
                .stream()
                .filter(passengerLongEntry -> passengerLongEntry.getValue() > 1)
                .map(Map.Entry::getKey)
                .collect(Collectors.toSet());
    }

    /*
     * Task #4. Find the passengers who had a discount for majority of their trips.
     */
    Set<Passenger> findSmartPassengers() {
        Map<Passenger, Long> map = trips
                .stream()
                .filter(trip -> trip.discount != null)
                .flatMap(trip -> trip.passengers.stream())
                .collect(groupingBy(
                        Function.identity(), Collectors.counting()
                ));

        return map.entrySet()
                .stream()
                .filter(passengerLongEntry -> passengerLongEntry.getValue()
                                              > findTotalTripCountByPassenger(passengerLongEntry.getKey()) / 2)
                .map(Map.Entry::getKey)
                .collect(Collectors.toSet());
    }

    private long findTotalTripCountByPassenger(Passenger passenger) {
        return trips
                .stream()
                .flatMap(trip -> trip.passengers.stream())
                .filter(passenger1 -> passenger1.equals(passenger))
                .count();
    }

    /*
     * Task #5. Find the most frequent trip duration among minute periods 0..9, 10..19, 20..29, and so on.
     * Return any period if many are the most frequent, return `null` if there are no trips.
     */
    IntRange findTheMostFrequentTripDurationPeriod() {
        Map<IntRange, Long> intRangeCountMap =
                trips
                        .stream()
                        .map(trip -> getIntRange(trip.duration))
                        .collect(groupingBy(
                                Function.identity(), counting()
                        ));

        if (!intRangeCountMap.isEmpty()) {
            return Collections.max(intRangeCountMap.entrySet(), Map.Entry.comparingByValue()).getKey();
        }
        return null;
    }

    private IntRange getIntRange(int duration) {
        int rangeLow = (duration / 10) * 10;
        return new IntRange(rangeLow, rangeLow + 9);
    }

    /*
     * Task #6.
     * Check whether 20% of the drivers contribute 80% of the income.
     */
    Boolean checkParetoPrinciple() {
        if (trips.isEmpty()) return false;

        double totalIncome = trips.stream()
                .map(Trip::getCost)
                .mapToDouble(Double::doubleValue)
                .sum();

        List<Double> sortedDriversIncome = trips.stream()
                .collect(groupingBy(trip -> trip.driver))
                .values().stream()
                .map(trips -> trips.parallelStream()
                        .map(Trip::getCost)
                        .mapToDouble(Double::doubleValue).sum())
                .sorted(Collections.reverseOrder()).toList();

        int topDriversCount = (int) (allDrivers.size() * 0.2);

        double topDriversIncome = sortedDriversIncome.stream()
                .limit(topDriversCount)
                .mapToDouble(Double::doubleValue).sum();

        return topDriversIncome >= totalIncome * 0.8;
    }
}
