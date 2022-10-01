package org.example;

public class Risk {
    int id;
    String name;
    String description;
    Process parentProcess;

    public Risk(int argId, String argName, String argDescription, Process argProcess) {
        id = argId;
        name = argName;
        description = argDescription;
        parentProcess = argProcess;

        //System.out.println("Obiect risk creat: \n" + id + " " +  name + " " +  description + "\n");
    }

    public void printProcess() {
        System.out.println(parentProcess.getName());
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