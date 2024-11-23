package com.example.finances.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ReportData {
    private List<Double> salaries;
    private List<Double> expenses;
}
