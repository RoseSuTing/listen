package mg.studio.weatherappdesign;

/**
 * Created by Administrator on 2018/3/20.
 */

public class Temperature {
    public String temp;
    public String hightemp;
    public String date;
    public String type;
    public String city;

    public String getTemp() {return temp;}
    public String getHightemp() {return hightemp;}
    public String getDate() {return date;}
    public String getType() {return type;}
    public String getCity() {return city;}

    public void setHightemp(String hightemp) {this.hightemp = hightemp;}
    public void setDate(String date) {this.date = date;}
    public void setTemp(String temp) {this.temp = temp;}
    public void setType(String type) {this.type = type;}
    public void setCity(String city) {this.city = city;}

    @Override
    public String toString() {
        return "temperature{temp="+temp+'/'+"hightemp='"+hightemp+'/'+"date='"+date+'/'+"type='"+type+'/'+"city='"+city+'}';
    }
}