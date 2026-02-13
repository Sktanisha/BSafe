package edu.bd.ewu.besafe;

public class Complaint_List {
    public String complaint_id;
    public String issue = "";
    public String address = "";
    public String problem_faced = "";
    public String urgency = "";


    public Complaint_List(String complaint_id, String issue, String address, String problem_faced, String urgency){
        this.complaint_id = complaint_id;
        this.issue = issue;
        this.address = address;
        this.problem_faced = problem_faced;
        this.urgency = urgency;

    }

}
