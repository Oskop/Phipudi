package OOP2.D.MokhamadWijaya.Phipudi.entity;

import lombok.Getter;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Entity
public class Hupi {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Getter @Setter
    public int hupiid;

    @Getter @Setter
    public String orang;

    @Getter @Setter
    public String keterangan;

//    @OneToMany(targetEntity = Transaksi.class)
//    private List<Transaksi> transaksis;

    @Getter @Setter
    public String tipe;

    @Getter @Setter
    public String jumlah;

    @Getter @Setter
    public String cicilan;

    @Basic
    @Getter @Setter
    @Temporal(TemporalType.DATE)
    @DateTimeFormat(pattern = "MM/dd/yyyy")
    public Date jatuhtempo;

    @Temporal(TemporalType.TIMESTAMP)
    @Getter @Setter
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    public Date createdat;

    @Temporal(TemporalType.TIMESTAMP)
    @Getter @Setter
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    public Date updatedat;

    @Temporal(TemporalType.TIMESTAMP)
    @Getter @Setter
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    public Date deletedat;
}
