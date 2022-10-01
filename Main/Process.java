package org.example;

import java.util.ArrayList;
import java.util.List;
public class Process {
    int id;
    String name;
    String description;
    List <Risk> riskList = new ArrayList < > ();

    public Process(int argId, String argName, String argDescription) {
        id = argId;
        name = argName;
        description = argDescription;

        //System.out.println("Obiect process creat: \n" + id + " " + name + " " +  description + "\n");
    }

    void printRisks() {
        System.out.println("riscurile procesului " + name + ":");
        for (Risk risk: riskList) {

            System.out.println(risk.getID() + " " + risk.getName() + " " + risk.getDescription());
        }
    }

    public void addRisk(Risk argRisk) {
        riskList.add(argRisk);
    }

    int getRiskCount() {
        return riskList.size();
    }

    void setDescription(String arg) {
        description = arg;
    }

    void setName(String arg) {
        name = arg;
    }

    void setId(short arg) {
        id = arg;
    }

    int getID() {
        return id;
    }

    String getName() {
        return name;
    }

    String getDescription() {
        return description;
    }
}