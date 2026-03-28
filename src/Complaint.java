public class Complaint {
    int id;
    String description;
    String status;
    int studentId;
    Complaint(int id, String description,String status,int studentId){
        this.id=id;
        this.description=description;
        this.studentId=studentId;
        this.status="pending";
    }
    void display(){
        System.out.println("ComplaintId:"+ id );
        System.out.println("Description:"+ description);
        System.out.println("Status:"+ status);
        System.out.println("StudentId:"+ studentId);
    }
}
