public class Sprint {
    private int capacity;       
    private int ticketLimit;    
    private Ticket[] tickets;   
    private int count;          

    public Sprint(int capacity, int ticketLimit) {
        this.capacity = capacity;
        this.ticketLimit = ticketLimit;
        this.tickets = new Ticket[ticketLimit];
        this.count = 0;
    }

    public boolean addUserStory(UserStory userStory) {
        if (userStory == null || userStory.isCompleted()) {
            return false;
        }
        return addTicket(userStory);
    }

    public boolean addBug(Bug bugReport) {
        if (bugReport == null || bugReport.isCompleted()) {
            return false;
        }
        return addTicket(bugReport);
    }

    private boolean addTicket(Ticket ticket) {
        if (count >= ticketLimit) {
            return false;
        }
        if (getTotalEstimate() + ticket.getEstimate() > capacity) {
            return false;
        }
        tickets[count] = ticket;
        count++;
        return true;
    }

    public Ticket[] getTickets() {
        Ticket[] copy = new Ticket[count];
        for (int i = 0; i < count; i++) {
            copy[i] = tickets[i];
        }
        return copy;
    }

    public int getTotalEstimate() {
        int total = 0;
        for (int i = 0; i < count; i++) {
            total += tickets[i].getEstimate();
        }
        return total;
    }
}
