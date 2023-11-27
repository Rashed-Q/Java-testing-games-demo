import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

// Define a simple structure to represent a task
class Task {
    String name;
    String dueDate;
    String priority;
}

// Create a task manager program
public class TaskManager {

    // Function to add a new task to the task list
    static void addTask(List<Task> taskList, Task newTask) {
        taskList.add(newTask);
        organizeTasks(taskList);
    }

    // Function to display tasks based on user preference
    static void displayTasks(List<Task> taskList, String sortBy) {
        if (taskList.isEmpty()) {
            System.out.println("No tasks found.");
        } else {
            if (sortBy.equals("DueDate")) {
                sortByDueDate(taskList);
            } else if (sortBy.equals("Priority")) {
                sortByPriority(taskList);
            }
            printTasks(taskList);
        }
    }

    // Function to organize tasks by due date
    static void organizeTasks(List<Task> taskList) {
        // Implementation details to organize tasks by due date
    }

    // Function to sort tasks by due date
    static void sortByDueDate(List<Task> taskList) {
        // Implementation details to sort tasks by due date
    }

    // Function to sort tasks by priority
    static void sortByPriority(List<Task> taskList) {
        // Implementation details to sort tasks by priority
    }

    // Function to print tasks with improved formatting
    static void printTasks(List<Task> taskList) {
        System.out.println("Tasks:");
        for (Task task : taskList) {
            System.out.println("Task: " + task.name + ", Due Date: " + task.dueDate + ", Priority: " + task.priority);
        }
        System.out.println("-----------------------------");
    }

    // Function to get a valid date input from the user
    static String getValidDateInput(Scanner scanner) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        dateFormat.setLenient(false);

        String date;
        while (true) {
            System.out.print("Enter due date (YYYY-MM-DD): ");
            date = scanner.nextLine().trim();
            try {
                // Attempt to parse the input as a valid date
                Date parsedDate = dateFormat.parse(date);
                break;
            } catch (ParseException e) {
                System.out.println("Error: Invalid date format. Please enter a valid date in YYYY-MM-DD format.");
            }
        }
        return date;
    }

    // Function to get valid priority input from the user
    static String getValidPriorityInput(Scanner scanner) {
        String priority;
        while (true) {
            System.out.print("Enter priority (low/medium/high): ");
            priority = scanner.nextLine().trim().toLowerCase();
            if (priority.equals("low") || priority.equals("medium") || priority.equals("high")) {
                break;
            } else {
                System.out.println("Error: Invalid priority. Please enter 'low', 'medium', or 'high'.");
            }
        }
        return priority;
    }

    // Function to get a valid task name input from the user
    static String getValidTaskNameInput(Scanner scanner) {
        String taskName;
        while (true) {
            System.out.print("Enter task name: ");
            taskName = scanner.nextLine().trim();
            if (!taskName.isEmpty()) {
                break;
            } else {
                System.out.println("Error: Task name cannot be empty. Please enter a valid task name.");
            }
        }
        return taskName;
    }

    // Main program to interactively get tasks from the user and display them
    public static void main(String[] args) {
        List<Task> taskList = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);

        // Loop for user input
        while (true) {
            Task newTask = new Task();
            // Get valid task name input
            newTask.name = getValidTaskNameInput(scanner);
            // Get valid due date input
            newTask.dueDate = getValidDateInput(scanner);
            // Get valid priority input
            newTask.priority = getValidPriorityInput(scanner);

            // Add the task
            addTask(taskList, newTask);

            System.out.print("Do you want to add another task? (yes/no): ");
            String response = scanner.nextLine().trim();
            if (!response.equalsIgnoreCase("yes")) {
                break;
            }
        }

        // Check if taskList is empty before displaying tasks
        if (taskList.isEmpty()) {
            System.out.println("No tasks found.");
        } else {
            // Display tasks sorted by priority
            displayTasks(taskList, "Priority");
        }

        // Close the scanner
        scanner.close();
    }
}
