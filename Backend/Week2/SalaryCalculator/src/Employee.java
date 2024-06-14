public class Employee {
    //creating variables
    String name;
    int salary;
    int workHours;
    int hireYear;

    //Constructor method
    Employee(String name, int salary, int workHours, int hireYear){
        this.name = name;
        this.salary = salary;
        this.workHours = workHours;
        this.hireYear = hireYear;
    }

    //Calculating the tax - bonus - raise
    double tax(){
        double taxPay = 0.0;
        if (this.salary >= 1000){
            taxPay = this.salary * 0.03;
        }
        return taxPay;
    }
    int bonus(){
        int bonus = 0;
        int addBonus = 0;
        if (this.workHours > 40){
            bonus = this.workHours - 40;
            addBonus = bonus * 30;
        }
        return addBonus;
    }

    double raiseSalary(){
        double raise = 0;
        if (2021 - this.hireYear < 10){
            raise = this.salary * 0.05;
        }
        if (2021 - this.hireYear > 9 && 2021 - this.hireYear < 20){
            raise = this.salary * 0.1;

        }if (2021 - this.hireYear > 19){
            raise = this.salary * 0.15;
        }
        return raise;
    }

    //Printing
    @Override
    public String toString() {

        return
                "Name = " + this.name + '\n' +
                "Salary = " + this.salary + '\n' +
                "Worked Hours=" + this.workHours + '\n' +
                "Hire Year= " + this.hireYear + '\n' +
                "Tax : " + this.tax() + "\n" +
                "Bonus : " + this.bonus() + "\n" +
                "Raie : " + this.raiseSalary() + "\n" +
                "Total Salary : " + (this.salary - this.tax() + this.bonus() + this.raiseSalary());

    }
}
