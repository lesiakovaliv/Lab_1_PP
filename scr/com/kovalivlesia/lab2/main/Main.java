package com.kovalivlesia.lab2.main;

import com.kovalivlesia.lab2.train.Train;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Main {

    public static void main(String[] args) throws IOException {
        List<Train> trains = inputFromFile("scr/com/kovalivlesia/lab2/text.txt");
        System.out.println(trains);

        Scanner scanner = new Scanner(System.in);
        System.out.print("Введіть потрібний пункт призначення: ");
        String destination = scanner.next();
        System.out.println(filter(trains, destination));

        System.out.print("Введіть потрібну годину: ");
        System.out.println(filter(filter(trains, destination), LocalTime.parse(scanner.next())));

        System.out.println("Cписок поїздів, які відправляються до заданого пункту призначення та мають загальні місця:");
        System.out.println(filter(filter(trains, destination), true));
    }

    private static List<Train> filter(List<Train> trains, String destination) {
        return trains.stream()
                .filter(t -> t.getDestination().equals(destination))
                .collect(Collectors.toList());
    }

    private static List<Train> filter(List<Train> trains, Boolean hasTotalSeats) {
        return trains.stream()
                .filter(t -> hasTotalSeats.equals(t.getTotalSeats() > 0))
                .collect(Collectors.toList());
    }

    private static List<Train> filter(List<Train> trains, LocalTime time) {
        return trains.stream()
                .filter(t -> 0 > time.compareTo(t.getTime()))
                .collect(Collectors.toList());
    }

    private static List<Train> inputFromFile(String fileName) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new FileReader(fileName));

        List<Train> trains = new ArrayList<>();

        Train train = getTrain(bufferedReader);
        while (train != null) {
            trains.add(train);
            train = getTrain(bufferedReader);
        }
        return trains;
    }

    private static Train getTrain(BufferedReader bufferedReader) {
        Train train = new Train();
        try {
            train.setNumber(Integer.parseInt(bufferedReader.readLine()));
            train.setDestination(bufferedReader.readLine());
            train.setTime(LocalTime.parse(bufferedReader.readLine()));
            train.setTotalSeats(Integer.parseInt(bufferedReader.readLine()));
            train.setPlackartSeats(Integer.parseInt(bufferedReader.readLine()));
            train.setCupeSeats(Integer.parseInt(bufferedReader.readLine()));
            train.setLuxSeats(Integer.parseInt(bufferedReader.readLine()));
        } catch (Exception exception) {
            return null;
        }
        return train;
    }
}
