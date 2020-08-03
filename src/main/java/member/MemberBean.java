package member;

public class MemberBean {
    private String car_number;
    private String start_date;
    private String end_date;
    private String owner_name;

    public String getCar_number() {
        return car_number;
    }

    public void setCar_number(String car_number) {
        this.car_number = car_number;
    }

    public String getStart_date() {
        return start_date;
    }

    public void setStart_date(String start_date) {
        this.start_date = start_date;
    }

    public String getEnd_date() {
        return end_date;
    }

    public void setEnd_date(String end_date) {
        this.end_date = end_date;
    }

    public String getOwner_name() {
        return owner_name;
    }

    public void setOwner_name(String owner_name) {
        this.owner_name = owner_name;
    }

    @Override
    public String toString() {
        return "MemberBean{" +
                "car_number='" + car_number + '\'' +
                ", start_date='" + start_date + '\'' +
                ", end_date='" + end_date + '\'' +
                ", owner_name='" + owner_name + '\'' +
                '}';
    }
}
