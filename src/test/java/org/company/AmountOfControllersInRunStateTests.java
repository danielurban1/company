package org.company;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class AmountOfControllersInRunStateTests {

    @Test(dataProvider = "getData")
    public void amountOfControllersInRunStateTest(int controllersAmount, int employeesAmount,
                                                  int expectedAmountOfControllersInRunState) {
        Company company = new Company(controllersAmount, employeesAmount);
        int actualAmountOfControllersInRunState = company.getAmountOfControllersInRunState();
        assertEquals(actualAmountOfControllersInRunState, expectedAmountOfControllersInRunState);
    }

    @DataProvider
    public Object[][] getData() {
        return new Object[][]{
                {0, 0, 0},
                {-1, -1, 0},
                {0, 1, 0},
                {1, 0, 0},
                {1, 1, 1},
                {2, 2, 1},
                {5, 5, 2}
        };
    }
}
