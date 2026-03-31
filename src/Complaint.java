public class Complaint {

    int id;
    String description;
    String status;
    String studentId;
    String adminNote;
    Complaint(int id, String description,String status,String studentId,String adminNote){
        this.id=id;
        this.description=description;
        this.studentId=studentId;
        this.status="pending";
        this.adminNote="no note yet!";
    }
    void display(){
        System.out.println("ComplaintId:"+ id );
        System.out.println("Description:"+ description);
        System.out.println("Status:"+ status);
        System.out.println("StudentId:"+ studentId);
        System.out.println("AdminNote:"+adminNote);
    }
}
