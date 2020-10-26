package per.bryan.temperature.pojo;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.validator.constraints.NotEmpty;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * temperature
 * @author bryan.c
 */
@Table(name="temperature")
@Data
@Setter
@Getter
public class Temperature implements Serializable {
    @Id
    @GeneratedValue(generator = "JDBC")
    private Integer id;

    @NotEmpty
    private String greenhouseNo;

    @NotEmpty
    private String sensorNo;

    private String temperature;

    private String humidity;

    private LocalDateTime date;

    private static final long serialVersionUID = 1L;

    @Override
    public boolean equals(Object that) {
        if (this == that) {
            return true;
        }
        if (that == null) {
            return false;
        }
        if (getClass() != that.getClass()) {
            return false;
        }
        Temperature other = (Temperature) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getGreenhouseNo() == null ? other.getGreenhouseNo() == null : this.getGreenhouseNo().equals(other.getGreenhouseNo()))
            && (this.getSensorNo() == null ? other.getSensorNo() == null : this.getSensorNo().equals(other.getSensorNo()))
            && (this.getTemperature() == null ? other.getTemperature() == null : this.getTemperature().equals(other.getTemperature()))
            && (this.getHumidity() == null ? other.getHumidity() == null : this.getHumidity().equals(other.getHumidity()))
            && (this.getDate() == null ? other.getDate() == null : this.getDate().equals(other.getDate()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getGreenhouseNo() == null) ? 0 : getGreenhouseNo().hashCode());
        result = prime * result + ((getSensorNo() == null) ? 0 : getSensorNo().hashCode());
        result = prime * result + ((getTemperature() == null) ? 0 : getTemperature().hashCode());
        result = prime * result + ((getHumidity() == null) ? 0 : getHumidity().hashCode());
        result = prime * result + ((getDate() == null) ? 0 : getDate().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", greenhouseNo=").append(greenhouseNo);
        sb.append(", sensorNo=").append(sensorNo);
        sb.append(", temperature=").append(temperature);
        sb.append(", humidity=").append(humidity);
        sb.append(", date=").append(date);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}