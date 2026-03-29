package com.kush.studyplan.lld;
import java.util.*;

public class SplitwiseApp {
    public static void main(String[] args) {
        User user1 = new User("1", "Alice", "alice@example.com", "1234567890");
        User user2 = new User("2", "Bob", "bob@example.com", "9876543210");

        Expense expense = new Expense();
        expense.setDescription("Dinner");
        expense.setTotalAmount(100.0);
        expense.setExpenseType(ExpenseType.EQUAL);
        expense.setPaidBy(user1);

        ExpenseManager expenseManager = new ExpenseManager();
        expenseManager.addUser(user1);
        expenseManager.addUser(user2);
        expenseManager.addExpense(expense);

        expense.splitExpense(List.of(user1, user2));

        Map<User, Double> user1Balances = expenseManager.calculateBalances(user1);
        for (Map.Entry<User, Double> entry : user1Balances.entrySet()) {
            System.out.println("User: " + entry.getKey().getName() + " Balance: " + entry.getValue());
        }

        // Simulating mail sending
        MailCaller.sendMail(user1.getEmail(), "Expense Summary", "Your expenses summary...");
    }
}

class User {
    private String userId;
    private String name;
    private String email;
    private String mobileNumber;

    public User(String userId, String name, String email, String mobileNumber) {
        this.userId = userId;
        this.name = name;
        this.email = email;
        this.mobileNumber = mobileNumber;
    }

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getMobileNumber() {
		return mobileNumber;
	}

	public void setMobileNumber(String mobileNumber) {
		this.mobileNumber = mobileNumber;
	}

}

enum ExpenseType {
    EQUAL,
    EXACT,
    PERCENT
}

class Expense {
    private String description;
    private double totalAmount;
    private ExpenseType expenseType;
    private User paidBy;
    private Map<User, Double> shares;

    public Expense() {
        this.shares = new HashMap<>();
    }
    
   
    public String getDescription() {
		return description;
	}



	public void setDescription(String description) {
		this.description = description;
	}



	public double getTotalAmount() {
		return totalAmount;
	}



	public void setTotalAmount(double totalAmount) {
		this.totalAmount = totalAmount;
	}



	public ExpenseType getExpenseType() {
		return expenseType;
	}



	public void setExpenseType(ExpenseType expenseType) {
		this.expenseType = expenseType;
	}



	public User getPaidBy() {
		return paidBy;
	}



	public void setPaidBy(User paidBy) {
		this.paidBy = paidBy;
	}



	public Map<User, Double> getShares() {
		return shares;
	}



	public void setShares(Map<User, Double> shares) {
		this.shares = shares;
	}



	public void splitExpense(List<User> usersInvolved) {
        // Logic to split the expense based on the expense type
        System.out.println("Splitting expense...");
        // Handle EQUAL, EXACT, and PERCENT cases
    }

    private boolean validateExpenseShares() {
        // Logic to validate shares based on the expense type
        System.out.println("Validating expense shares...");
        // Check if the total sum of percentage shares is 100 (for PERCENT)
        // Check if the total sum of shares is equal to the total amount (for EXACT)
		return false;
    }
}

class ExpenseManager {
    private List<User> users;
    private List<Expense> expenses;

    public ExpenseManager() {
        this.users = new ArrayList<>();
        this.expenses = new ArrayList<>();
    }

    public void addUser(User user) {
        users.add(user);
        System.out.println("User added: " + user.getName());
    }

    public void addExpense(Expense expense) {
        expenses.add(expense);
        System.out.println("Expense added: " + expense.getDescription());
    }

    public Map<User, Double> calculateBalances(User user) {
        System.out.println("Calculating balances...");
        // Calculate balances for the specified user
        // Return a map of User and their balances with the specified user
        return new HashMap<>();
    }

    // Other methods for expense management
}

class MailCaller {
    public static void sendMail(String email, String subject, String body) {
        // Simulate sending mail by logging
        System.out.println("Sending email to: " + email);
        System.out.println("Subject: " + subject);
        System.out.println("Body: " + body);
    }
}
