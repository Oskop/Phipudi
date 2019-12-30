//package OOP2.D.MokhamadWijaya.Phipudi.entity;
//
//import lombok.Getter;
//import lombok.Setter;
//import org.hibernate.annotations.Fetch;
//import org.hibernate.annotations.FetchMode;
//import org.springframework.format.annotation.DateTimeFormat;
//
//import javax.persistence.*;
//import java.util.Date;
//
//@Entity
//public class Transaksi {
//    @Id
//    @Getter @Setter
//    private int id;
//
//    @Getter @Setter
//    private int hupi_id;
//
//    @ManyToOne(fetch = FetchType.LAZY)
//    @Fetch(FetchMode.JOIN)
//    private Hupi hupi;
//
//    @Getter @Setter
//    private float jumlah;
//
//    @Temporal(TemporalType.TIMESTAMP)
//    @Getter @Setter
//    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
//    private Date createdat;
//
//    @Temporal(TemporalType.TIMESTAMP)
//    @Getter @Setter
//    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
//    private Date updatedat;
//
//    @Temporal(TemporalType.TIMESTAMP)
//    @Getter @Setter
//    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
//    private Date deletedat;
//}
