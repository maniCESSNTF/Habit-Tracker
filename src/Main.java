//Salma Esfidany
//Mani Abdolalizade

import TaskPackage.Task;
import UserPackage.User;
import UtilityPackage.Utility;

import java.text.DecimalFormat;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        // Taking user input and creating a user
        Scanner scan = new Scanner(System.in);
        System.out.println("Enter your username: ");
        String username = scan.next();
        System.out.println("Enter your password: ");
        String password = scan.next();
        
        System.out.println("Enter your full name: ");
        String first_name = scan.next();
        String last_name = scan.next();
        System.out.println("Enter your email: ");
        String email = scan.next();
        User user = new User(username, password, first_name, last_name, email);
        // Displaying the user info
        System.out.println("---User Created---");
        System.out.println("Welcome " + user.getFullName() + "!");
        user.printUserInfo();

        // Changing username and password with setter methods
        System.out.println("Would you like to change your username and password? (y/n)");
        char answer = scan.next().charAt(0);
        if (answer == 'y') {
            System.out.println("Changing username and password...");
            System.out.println("Enter new username: ");
            String username2 = scan.next();
            user.setUsername(username2);
            System.out.println("Enter new password: ");
            String password2 = scan.next();
            user.setPassword(password2);
            // Changing the streak
            user.streak = 2;
        }

        // Creating tasks for a specific user
        System.out.println("Would you like to create a task? (y/n)");
        do {
            answer = scan.next().charAt(0);
            if (!(answer == 'y' || answer == 'n'))
                System.out.println("Your answer is unacceptable!");
        } while (!(answer == 'y' || answer == 'n'));
        while (answer == 'y') {
            System.out.println("Creating task...");
            System.out.println("Please enter task's name");
            String TASKname = scan.next();
            String Color = null;
            System.out.println("Do you want to consider a color for your task(y/n)?");
            do {
                answer = scan.next().charAt(0);
                if(!(answer=='y' ||  answer == 'n'))
                    System.out.println("Your answer is unacceptable!");
            }while (!(answer=='y' ||  answer == 'n'));
            if (answer=='y') {
                System.out.println("Please enter task's color");
                Color = scan.next();
            }
            Task newtask = user.createTask(TASKname, Color);
            System.out.println("Please enter StartTime and FinishTime");
            double StartTime, FinishTime;
            StartTime = Double.parseDouble(scan.next());
            newtask.setStart_time(StartTime);
            FinishTime = Double.parseDouble(scan.next());
            newtask.setFinish_time(FinishTime);
            DecimalFormat df = new DecimalFormat("##.00");
            System.out.println(newtask.getname() + " duration: " + df.format(newtask.getDuration()));
            System.out.println("Would you like to create a task again? (y/n)");
            do {
                answer = scan.next().charAt(0);
                if (!(answer == 'y' || answer == 'n'))
                    System.out.println("Your answer is unacceptable!");
            } while (!(answer == 'y' || answer == 'n'));


        }
        char answerColor;
        System.out.println("Do you want to receive the created tasks by color?(y/n)");
        do {
            answerColor = scan.next().charAt(0);
            if (!(answerColor == 'y' || answerColor == 'n'))
                System.out.println("Your answer is unacceptable!");
        } while (!(answerColor == 'y' || answerColor == 'n'));

        if (answerColor=='y') {
            System.out.println("Enter the desired color");
            String color = scan.next();
            Task[] TaskColor = user.getTaskByColor(color);
            for (int i = 0; i < TaskColor.length; i++) {
                System.out.println(TaskColor[i].getname());
            }
        }


        // Closing the Scanner
        scan.close();

        System.out.println("Username: " + user.getUsername() + "\nFull name: " + user.getFullName()
                + "\nPassword: " + user.getPassword() + "\nEmail: " + user.getemail() + "\nYou have been using the app for " + user.streak + " days.");
    }
    }
