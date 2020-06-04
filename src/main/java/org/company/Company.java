package org.company;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class Company {
    private int controllersAmount;
    private int employeesAmount;
    private final String RUN_PROCESS = "RUN";
    private final String PROGRAM_PROCESS = "PROGRAM";
    private ArrayList<String> controllersList;

    public Company() {
        this(1100, 1100);
    }

    public Company(int controllersAmount, int employeesAmount) {
        this.controllersAmount = controllersAmount;
        this.employeesAmount = employeesAmount;
    }

    public int getAmountOfControllersInRunState() {
        if (controllersAmount <= 0 || employeesAmount <= 0) {
            return 0;
        }
        controllersList = new ArrayList<>(Arrays.asList(new String[controllersAmount]));
        return getAmountOfControllersInRunStateForPositiveInt();
    }

    private int getAmountOfControllersInRunStateForPositiveInt() {
        for (int employeeIndex = 0; employeeIndex < employeesAmount; employeeIndex++) {
            for (int controllerIndex = 0; controllerIndex < controllersAmount; controllerIndex++) {
                if ((controllerIndex + 1) % (employeeIndex + 1) == 0) {
                    controllersList.set(controllerIndex, getChangedProcessName(controllersList.get(controllerIndex)));
                }
            }
        }
        return Collections.frequency(controllersList, RUN_PROCESS);
    }

    private String getChangedProcessName(String currentProcess) {
        if (currentProcess == null || currentProcess.equals(PROGRAM_PROCESS)) {
            return RUN_PROCESS;
        }
        return PROGRAM_PROCESS;
    }
}
