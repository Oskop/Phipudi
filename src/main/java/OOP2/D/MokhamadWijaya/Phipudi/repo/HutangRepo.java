package OOP2.D.MokhamadWijaya.Phipudi.repo;

import OOP2.D.MokhamadWijaya.Phipudi.entity.Hupi;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;

import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import java.util.Date;
import java.util.List;

@Repository
public interface HutangRepo extends JpaRepository<Hupi, String>{
    public List<Hupi> findByTipeEqualsAndDeletedatIsNull(@Param("tipe") String tipe);

    public List<Hupi> findByDeletedatIsNull();

    public Hupi findByHupiid(@Param("hupiid") int hupiid);

    @Query(value = "SELECT SUM(jumlah) jumlah FROM hupi WHERE tipe = ?1 AND deletedat IS NULL", nativeQuery = true)
    public Object sumJumlah(@Param("tipe") String tipe);

    @Query(value = "SELECT MAX(updatedat) tanggal FROM hupi WHERE tipe = ?1", nativeQuery = true)
    public Date lastHupi(@Param("tipe") String tipe);

    @Query(value = "SELECT COUNT(cicilan) angsuran FROM `hupi` WHERE cicilan IS NOT NULL AND tipe = ?1 AND deletedat IS NULL", nativeQuery = true)
    public int countAngsuran(@Param("tipe") String tipe);

    @Query(value = "SELECT COUNT(cicilan) angsuran FROM `hupi` WHERE cicilan IS NOT NULL AND deletedat IS NOT NULL", nativeQuery = true)
    public int countLunas();

    @Query(value = "SELECT * FROM `hupi` WHERE jatuhtempo >= CURRENT_DATE AND deletedat IS NULL", nativeQuery = true)
    public List<Hupi> jatuhTempo();

    @Query(value = "SELECT * FROM `hupi` WHERE deletedat IS NOT NULL", nativeQuery = true)
    public List<Hupi> lunas();

}
