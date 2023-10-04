package co.edu.unisabana.parcialarquitectura.repository.entity;

import co.edu.unisabana.parcialarquitectura.service.model.Checkin;
import java.time.LocalDateTime;
import javax.persistence.*;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Data
@Table(name = "CHECKPOINT")
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class CheckpointEntity {

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  @Column
  private Integer id;

  @Column
  private String type;

  @Column
  private String facility;

  @Column
  private String driver;

  @Column
  private int dayOfMonth;

  @Column
  private LocalDateTime creationDate;

  @Column
  private boolean finalized;

  public Checkin toCheckin() {
    Checkin checkin = new Checkin(this.facility, this.driver, this.dayOfMonth);
    checkin.setId(this.id);
    return checkin;
  }

  public void setId(Integer id) {
    this.id = id;
  }

  public void setType(String type) {
    this.type = type;
  }

  public void setFacility(String facility) {
    this.facility = facility;
  }

  public void setDriver(String driver) {
    this.driver = driver;
  }

  public void setDayOfMonth(int dayOfMonth) {
    this.dayOfMonth = dayOfMonth;
  }

  public void setCreationDate(LocalDateTime creationDate) {
    this.creationDate = creationDate;
  }

  public void setFinalized(boolean finalized) {
    this.finalized = finalized;
  }

  public static CheckpointEntity fromCheckin(Checkin checkin) {
    CheckpointEntity checkpoint = new CheckpointEntity();
    checkpoint.setCreationDate(LocalDateTime.now());
    checkpoint.setDriver(checkin.getDriver());
    checkpoint.setFacility(checkin.getFacility());
    checkpoint.setDayOfMonth(checkin.getDayOfMonth());
    checkpoint.setType("CHECKIN");
    checkpoint.setFinalized(false);
    return checkpoint;
  }


}