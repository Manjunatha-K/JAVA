package com.basic.Java.streams;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class FindSumofTranscationAmountForEachDay {
    private static void FindSumOfTranscationsForEachDay(List<Transcation> transcationList) {
        Map<LocalDate, Double> sum = transcationList.stream().
                collect(Collectors.groupingBy(Transcation::getTranscationDate,
                        Collectors.summingDouble(Transcation::getAmount)));
        sum.forEach(((date, aDouble) -> System.out.println(date +" : "+aDouble)));
    }

    public static void main(String[] args) {
        List<Transcation> transcationList = Arrays.asList(
                new Transcation(LocalDate.parse("2026-08-19"), 10.0),
                new Transcation(LocalDate.parse("2026-08-19"), 10.0),
                new Transcation(LocalDate.parse("2026-08-20"), 11.0),
                new Transcation(LocalDate.parse("2026-08-21"), 10.0),
                new Transcation(LocalDate.parse("2026-08-20"), 11.0)
        );
        FindSumOfTranscationsForEachDay(transcationList);
    }


}

class Transcation {
    LocalDate transcationDate;
    Double amount;

    public Transcation() {
    }

    public Transcation(LocalDate transcationDate, Double amount) {
        this.transcationDate = transcationDate;
        this.amount = amount;
    }


    public LocalDate getTranscationDate() {
        return transcationDate;
    }

    public void setTranscationDate(LocalDate transcationDate) {
        this.transcationDate = transcationDate;
    }

    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }
}
