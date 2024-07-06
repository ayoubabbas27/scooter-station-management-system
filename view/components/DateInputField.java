package view.components;
import java.time.*;

import javax.swing.JComboBox;
import javax.swing.JPanel;

import java.awt.Color;
import java.awt.GridLayout;

public class DateInputField extends JPanel {
    private JComboBox<Integer> daysDropDown;
    private JComboBox<String> monthsDropDown;
    private JComboBox<Integer> yearsDropDown;
    public DateInputField (){
        super();

        daysDropDown = new JComboBox<>();
        for (int i = 1 ; i <= 31 ; i++){
            daysDropDown.addItem(i);
        }

        String[] months = {"Janvier", "Février", "Mars", "Avril", "Mai", "Juin", "Juillet", "Août", "Septembre", "Octobre", "Novembre", "Décembre"};
        monthsDropDown = new JComboBox<String>(months);

        Integer[] years = {Year.now().getValue() , Year.now().getValue()+1};
        yearsDropDown = new JComboBox<Integer>(years);

        this.setLayout(new GridLayout(1,3,8,0));
        this.setBackground(new Color(0, 0, 0, 0));
        this.add(daysDropDown);
        this.add(monthsDropDown);
        this.add(yearsDropDown);

        this.setVisible(true);
        this.show();
    }
    public int getSelectedDay (){
        return (int) this.daysDropDown.getSelectedItem();
    }
    public String getSelectedMonth(){
        return (String) this.monthsDropDown.getSelectedItem();
    }
    public int getSelectedYear (){
        return (int) this.yearsDropDown.getSelectedItem();
    }
    public LocalDate getDate (){
        if (isDateValide(this.getSelectedYear(), getMonthValue(this.getSelectedMonth()), this.getSelectedDay())){
            return LocalDate.of(this.getSelectedYear(), getMonthValue(this.getSelectedMonth()), this.getSelectedDay());
        }else{
            return null;
        }
    }

    static private boolean isDateValide (int year , int month , int day){
        if (month==2 && day>29){
            return false;
        }

        if (!anneeBissextile(year) && month==2 && day>28){
            return false;
        }

        if ((month == 4 || month == 6 || month == 9 || month == 11) && day > 30) {
            return false;
        }

        return true;
    }

    static private int getMonthValue (String monthString){
        switch (monthString) {
            case "Janvier":
                return 1;
            case "Février" :
                return 2;
            case "Mars" :
                return 3;
            case "Avril" :
                return 4;
            case "Mai" :
                return 5;
            case "Juin" :
                return 6;
            case "Juillet" :
                return 7;
            case "Août" :
                return 8;
            case "Septembre" :
                return 9;
            case "Octobre" :
                return 10;
            case "Novembre" :
                return 11;
            case "Décembre" :
                return 12;
            default:
                return 0;
        }
    }
    static private boolean anneeBissextile(int year) {
        return ((year % 4 == 0 && year % 100 != 0) || year % 400 == 0);
    }
}
