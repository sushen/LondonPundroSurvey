package blog.video.biswas.londonpundrosurvey;

public class PundroFrom {
    private String id;
    private String fristName;
    private String lastName;
    private String mail;
    private String Comment;
    private String rgq1;
    private String CBq1;
    private String date;
    private String time;


//    public PundroFrom(String fristName, String lastName, String mail, String comment, String rgq1) {
//        this.fristName = fristName;
//        lastName = lastName;
//        this.mail = mail;
//        Comment = comment;
//        this.rgq1 = rgq1;
//    }

    public String getRgq1() {
        return rgq1;
    }

    public void setRgq1(String rgq1) {
        this.rgq1 = rgq1;
    }

    public String getComment() {
        return Comment;
    }

    public void setComment(String comment) {
        Comment = comment;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getFristName() {
        return fristName;
    }

    public void setFristName(String fristName) {
        this.fristName = fristName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public String getCBq1() {
        return CBq1;
    }

    public void setCBq1(String CBq1) {
        this.CBq1 = CBq1;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }
}
