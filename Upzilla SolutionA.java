import java.util.Stack;
import java.util.Scanner;

public class SolutionA {

    private static Stack<String> history = new Stack<String>();

    public static Boolean isBrowsingHistoryEmpty() {
        // Check if Stack is Empty
        return history.empty();
    }

    public static String mostRecentlyVisitedSite() {
        // Returns Last url
        return history.peek();
    }

    public static void addSiteToHistory(String url) {
        // Adds url to Stack
        history.push(url);
    }

    public static void goBackInTime(int n) {
        // Deletes n elements from Stack
        for(int i = 0; i < n && !history.empty(); i++) {
            history.pop();
        }
    }

    public static void printBrowsingHistory() {
        // Prints Stack
        System.out.println(history);
    }

    public static void main(String[] args) {
        System.out.println(isBrowsingHistoryEmpty()); // Checking if Browsing History is Empty
        addSiteToHistory("www.google.co.in"); // Navigating to Google
        addSiteToHistory("www.facebook.com"); // Navigating to Facebook
        addSiteToHistory("www.upgrad.com"); // Navigating to UpGrad
        System.out.println(isBrowsingHistoryEmpty()); // Checking if Browsing History is Empty
        System.out.println(mostRecentlyVisitedSite()); // Fetching most recently visited site (UpGrad)
        addSiteToHistory("www.youtube.com"); // Navigating to Youtube
        goBackInTime(2); // Going back by 2 sites
        addSiteToHistory("www.yahoo.com"); // Navigating to UpGrad platform site
        System.out.println(mostRecentlyVisitedSite()); // Fetching most recently visited site (UpGrad Learn Platform)
        printBrowsingHistory(); // Printing browsing history
    }
}

/**
 * Your code should have the following Output:
 * <p>
 * true
 * false
 * www.upgrad.com
 * www.yahoo.com
 * [www.google.co.in, www.facebook.com, www.yahoo.com]
 */
