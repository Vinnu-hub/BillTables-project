package com.example.Spring_task_interview.repository;

import com.example.Spring_task_interview.dTO.BillOutputDTO;
import com.example.Spring_task_interview.entity.BillParent;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface BillParentRepository extends JpaRepository<BillParent, Long> {

    @Query("SELECT new com.example.Spring_task_interview.dTO.BillOutputDTO(bp.billId, bp.billDate, bp.station, "
            + "bc.category, bc.subcategory, bc.origin, bc.manufacturing, bc.hsnCode, "
            + "bc.store, bc.name, bc.size, bc.mrp, bc.qty) "
            + "FROM BillParent bp JOIN bp.billChildren bc")
    List<BillOutputDTO> findAllBillOutputs();
}
