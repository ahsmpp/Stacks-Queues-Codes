import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

class SiteStats {
    private String url;
    private int numVisits;

    /**
     * Constructor for the SiteStats class
     * 
     * @param url
     *            String that represents an URL that the user has visited
     * @param numVisits
     *            An int that represents the number of times that the user has
     *            visited the url
     */
    public SiteStats(String url, int numVisits) {
        this.url = url;
        this.numVisits = numVisits;
    }

    /**
     * This method returns the number of times that the user has visited the url.
     * 
     * @return An int that represents the number of times that the user has visited
     *         the url
     */
    public int getNumVisits() {
        return this.numVisits;
    }

    /**
     * This method returns the url that we are currently tracking
     * 
     * @return A String that represents the url that we are currently tracking
     */
    public String getUrl() {
        return this.url;
    }

    /**
     * This method updates the number of times that we have visited the url
     * 
     * @param an
     *            int that represents the number that we want to set numVisits to
     */
    public void setNumVisits(int updatedNumVisits) {
        this.numVisits = updatedNumVisits;
    }

    public String toString() {
        return this.url + " | " + this.numVisits;
    }

}

public class SolutionB {

    private static Queue<SiteStats> sites = new LinkedList<SiteStats>();


    // Main method to list top n visited sites
    public static void listTopVisitedSites(Queue<SiteStats> sites, int n) {
        // WRITE CODE HERE
        int size = sites.size();

        //*****     Sorting in Deceding Order       *****
        for(int i = 1; i <= size; i++) {
            //Setting head of queue as MaxVisit
            SiteStats maxVisit = sites.remove();

            //Traversing throught the queue to get MaxVisit
            for(int j = 1; j <= size - i; j++) {
                if(maxVisit.getNumVisits() < sites.peek().getNumVisits()) {
                    sites.add(maxVisit);
                    maxVisit = sites.remove();
                } else {
                    sites.add(sites.remove());
                }
            }

            //Adding MaxVisit at the tail of the queue
            for(int k = i; k > 1; k--) {
                sites.add(sites.remove());
            }
            sites.add(maxVisit);
        }
        //*****     *************************       *****

        //Displaying Top n Sites
        for(int i = 1; i <= size && i <= n; i++) {
            System.out.println(sites.peek().toString());
            sites.add(sites.remove());
        }
    }

    // Method to find the website in the queue and increment the visited count by 1, adding new node in case website is not found
    public static void updateCount(String url) {
        // WRITE CODE HERE
        //If Queue is empty then add 1st element
        if(sites.isEmpty()) {
            sites.add(new SiteStats(url, 1));
            return;
        }

        //Cycling through the queue 
        for(int i = 0; i < sites.size(); i++) {
            //If url is in the queue then increment the count
            if(sites.peek().getUrl().equals(url)) {
                sites.peek().setNumVisits(sites.peek().getNumVisits() + 1);
                return;
            }
            sites.add(sites.remove());
        }

        //Add new url added to queue
        sites.add(new SiteStats(url, 1));
    }

    public static void main(String[] args) {
        String[] visitedSites = { "www.google.co.in", "www.google.co.in", "www.facebook.com", "www.upgrad.com", "www.google.co.in", "www.youtube.com",
                "www.facebook.com", "www.upgrad.com", "www.facebook.com", "www.google.co.in", "www.microsoft.com", "www.9gag.com", "www.netflix.com",
                "www.netflix.com", "www.9gag.com", "www.microsoft.com", "www.amazon.com", "www.amazon.com", "www.uber.com", "www.amazon.com",
                "www.microsoft.com", "www.upgrad.com" };

        for (String url : visitedSites) {
            updateCount(url);
        }
        listTopVisitedSites(sites, 5);
    }
}
