package org.example;

import Utils.ExcelUtils;

import java.util.ArrayList;
import java.util.List;

public class Main {


    public static void main(String[] args) {

        ExcelUtils excelFile = new ExcelUtils(convertStringArrayToString(args));

        List <Process> processList = new ArrayList <> ();
        List <Risk> riskList = new ArrayList <> ();
        excelFile.populateProcessList(processList, riskList);

        System.out.println("Numar de procese: " + processList.size());
        riskCount(riskList);
        riskiestProcess(processList);
    }

    static void riskCount(List <Risk> riskList) {
        int i = 0;
        for (Risk risk: riskList) {
            if (risk.getID() > i) {
                i = risk.getID();
            }
        }
        System.out.println("Numar de riscuri: " + i);
    }

    static void riskiestProcess(List <Process> processList) {
        int j = 0;
        Process riskiestProcess = null;

        for (Process process: processList) {
            if (process.getRiskCount() > j) {
                j = process.getRiskCount();
                riskiestProcess = process;
            }
        }

        if (riskiestProcess == null) {
            System.out.println("Nici un proces citit");
        } else {
            System.out.println("Procesul cu cele mai multe riscuri: " +
                    riskiestProcess.getName() + " are " + riskiestProcess.getRiskCount() + " riscuri");
        }
    }

    static String convertStringArrayToString(String[] strArr){
        StringBuilder sb = new StringBuilder();

        for(String string : strArr){
            sb.append(string);
        }

        return sb.toString();
    }
}