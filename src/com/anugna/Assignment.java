package com.anugna;
import javax.swing.*;

public class Assignment {
    String firstName,lastName;
    int hours,smallBoxes,largeBoxes;
    float services,options,items,totalCost;
    char packg;
    Assignment(String firstName, String lastName, int hoursTaken, char packg, int nofLargeBoxes, int nofSmallBoxes) {
        setFirstName(firstName);
        setLastName(lastName);
        setHoursTaken(hoursTaken);
        setLargeBoxes(nofLargeBoxes);
        setPackg(packg);
        setSmallBoxes(nofSmallBoxes);
    }
    public float getItemsCost() {
        items = 2.50f * smallBoxes + 4.50f * largeBoxes;
        return items;
    }
    public float getOptionsCost() {
        options = (8.0f + 20.11f) * hours / 24;
        return options;
    }
    public float getServicesCost() {
        if (packg == 'A')
            services = 100 * hours;
        if (packg == 'B')
            services = 150 * hours;
        return services;
    }
    public float getTotalCost() {
        totalCost = getServicesCost() + getItemsCost() + getOptionsCost();
        return totalCost;
    }
    public void setHoursTaken(int hoursTaken) {
        this.hours = hoursTaken;
    }
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
    public void setSmallBoxes(int nofSmallBoxes) {
        this.smallBoxes = nofSmallBoxes;
    }
    public void setLargeBoxes(int nofLargeBoxes) {
        this.largeBoxes = nofLargeBoxes;
    }
    public void setPackg(char packg) {
        this.packg = packg;
    }
    public String getData() {
        String s = "Customer : " + firstName + " " + lastName;
        s += "\nServices Cost : " + getServicesCost();
        s += "\nOptions Cost : " + getOptionsCost();
        s += "\nItems Cost : " + getItemsCost();
        s += "\nTotal Cost : " + getTotalCost();
        return s;
    }
    public static void main(String[] args) {
        String userName = "Anugna";
        String password = "password";
        int attempts = 0;
        String user_name = JOptionPane.showInputDialog("Enter Username:");
        String pwd = JOptionPane.showInputDialog("Enter Password:");
        while (!(user_name.equals(userName) && pwd.equals(password)) && attempts < 2)
        {
            attempts++;
            JOptionPane.showMessageDialog(null, "Incorrect Credentials\nTry Again");
            user_name = JOptionPane.showInputDialog("Enter Username :");
            pwd = JOptionPane.showInputDialog("Enter Password :");
        }
        if (attempts >= 2) {
            JOptionPane.showMessageDialog(null, "You've exceeded your try's\nGood Bye!");
            System.exit(1);
        }
        try
        {
            String firstName = JOptionPane.showInputDialog("Enter the Customer's First Name:");
            String lastName = JOptionPane.showInputDialog("Enter the Customer's Last Name:");
            char pkg = Character.toUpperCase(JOptionPane.showInputDialog("Enter the package selected (A or B): \n").charAt(0));
            if (pkg != 'A' && pkg != 'B')
                throw new Exception();
            int hoursTaken = Integer.parseInt(JOptionPane.showInputDialog("Enter the hours taken:\n"));
            int nofSmallBoxes = Integer.parseInt(JOptionPane.showInputDialog("Enter the number of small boxes:\n"));
            int nofLargeBoxes = Integer.parseInt(JOptionPane.showInputDialog("Enter the number of large boxes:\n"));
            Assignment a = new Assignment(firstName, lastName, hoursTaken, pkg, nofLargeBoxes, nofSmallBoxes);
            JOptionPane.showMessageDialog(null, a.getData());
        }
        catch (Exception e)
        {
            JOptionPane.showMessageDialog(null, "Wrong Input");
            System.exit(1);
        }
    }
}

