package models.pojo;

public class JobAndNameResponseModel {
    // String authData = "{\"name\": \"morpheus\", \"job\": \"zion resident\"}";
    String name, job, updatedAt;


    public String getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(String updatedAt) {
        this.updatedAt = updatedAt;
    }

    public String getName() {
        return name;
    }



    public String getJob() {
        return job;
    }



}
