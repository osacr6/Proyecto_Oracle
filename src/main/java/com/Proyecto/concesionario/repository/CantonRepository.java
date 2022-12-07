package com.Proyecto.concesionario.repository;



import com.Proyecto.concesionario.entity.Canton;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface CantonRepository extends JpaRepository<Canton, Long> {

    @Query(value = "SELECT * FROM T_CANTON", nativeQuery = true)
    public List<Canton> findAll();

    @Query(value = "insert into T_CANTON (canton) values (:canton)", nativeQuery = true)
    public Canton save(@Param("canton") String canton);

    @Query(value = "DELETE FROM T_CANTON WHERE canton_id =:canton_id", nativeQuery = true)
    public Canton delete(@Param("canton_id") long canton_id);

    @Query(value = "update T_CANTON set canton=:canton where canton_id =:canton_id", nativeQuery = true)
    public Canton update(@Param("canton_id") long canton_id, @Param("canton") String canton);

    @Query(value = "SELECT * FROM T_CANTON WHERE canton_id = :canton_id", nativeQuery = true)
    public Canton findById(@Param("canton_id") long canton_id);

}
