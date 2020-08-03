package parking;

public class CarBean {
    private int parking_log_id;
    private String in_time;
    private String out_time;
    private int paid;
    private String car_number;

    @Override
    public String toString() {
        return "CarBean{" +
                "parking_log_id=" + parking_log_id +
                ", in_time='" + in_time + '\'' +
                ", out_time='" + out_time + '\'' +
                ", paid=" + paid +
                ", car_number='" + car_number + '\'' +
                '}';
    }

    public int getParking_log_id() {
        return parking_log_id;
    }

    public void setParking_log_id(int parking_log_id) {
        this.parking_log_id = parking_log_id;
    }

    public String getIn_time() {
        return in_time;
    }

    public void setIn_time(String in_time) {
        this.in_time = in_time;
    }

    public String getOut_time() {
        return out_time;
    }

    public void setOut_time(String out_time) {
        this.out_time = out_time;
    }

    public int getPaid() {
        return paid;
    }

    public void setPaid(int paid) {
        this.paid = paid;
    }

    public String getCar_number() {
        return car_number;
    }

    public void setCar_number(String car_number) {
        this.car_number = car_number;
    }
}
