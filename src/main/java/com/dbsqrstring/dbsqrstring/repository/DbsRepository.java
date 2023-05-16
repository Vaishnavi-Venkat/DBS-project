package com.dbsqrstring.dbsqrstring.repository;

import com.dbsqrstring.dbsqrstring.model.Dbs;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DbsRepository extends JpaRepository<Dbs, Integer> {

    //@Query(value = "SELECT d.address,d.bank_name,d.branch_code,d.branch_name,d.city,d.country,d.customer_name,d.customer_name,d.date,d.email_id,d.mcc,d.mobile_number,d.nature_of_business,d.pan,d.pincode,d.state,d.vpa  from dbs d", nativeQuery = true)
    @Query(value="Select * from dbs d",nativeQuery = true)
    List<Dbs> getData();
}
