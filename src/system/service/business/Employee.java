/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package system.service.business;

/**
 *
 * @author taiminh
 */
public class Employee {
    private int employeeID;
    private String firstName;
    private String lastName;
    private int shopID;
    private int roleID;

    public Employee(int employeeID, String firstName, String lastName, int shopID, int roleID) {
        this.employeeID = employeeID;
        this.firstName = firstName;
        this.lastName = lastName;
        this.shopID = shopID;
        this.roleID = roleID;
    }

    public int getEmployeeID() {
        return employeeID;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public int getShopID() {
        return shopID;
    }

    public int getRoleID() {
        return roleID;
    }
    
    
    
}
