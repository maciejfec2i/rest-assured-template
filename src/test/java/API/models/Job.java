package API.models;

public class Job {

    private String id;
    private String title;
    private String url;
    private String createdAt;
    private String company;
    private String location;
    private String country;

    public Job() {}

    public String getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getUrl() {
        return url;
    }

    public String getCreatedAt() {
        return createdAt;
    }

    public String getCompany() {
        return company;
    }

    public String getLocation() {
        return location;
    }

    public String getCountry() {
        return country;
    }

    @Override
    public String toString() {
        return "{\n" +
                "\t\"id\": " + "\"" + id + "\",\n" +
                "\t\"title\": " + "\"" + title + "\",\n" +
                "\t\"url\": " + "\"" + url + "\",\n" +
                "\t\"created_at\": " + "\"" + createdAt + "\",\n" +
                "\t\"company\": " + "\"" + company + "\",\n" +
                "\t\"location\": " + "\"" + location + "\",\n" +
                "\t\"country\": " + "\"" + country + "\"\n" +
                "}";
    }
}
