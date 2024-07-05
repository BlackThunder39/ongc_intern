package com.intern.irr.DAO;

import com.intern.irr.entity.inspectionReport;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public class inspectionReportDAOimpl implements inspectionReportDAO{
    //define fields for entity manager (Created by springBoot)
    private EntityManager em;

    //Constructor Injection of Entity manager
    @Autowired
    public inspectionReportDAOimpl(EntityManager emanager){
        this.em = emanager;
    }


    //Implement methods
    @Override
    public List<inspectionReport> getAll() {
        TypedQuery<inspectionReport> q = em.createQuery("from inspectionReport",inspectionReport.class );
        List<inspectionReport> temp = q.getResultList();
//        for(inspectionReport i : temp){
//            System.out.println(i);
//        }
        return temp;
    }

    @Override
    public List<inspectionReport> searchReports(String x) {
        // Include wildcards
        String pattern = "%" + x + "%";
        TypedQuery<inspectionReport> q = em.createQuery(
                "SELECT rep FROM inspectionReport rep " +
                        "WHERE rep.uuid = :x " +
                        "OR rep.frNo LIKE :pattern " +
                        "OR rep.author LIKE :pattern " +
                        "OR rep.inspectionAndTesting LIKE :pattern",
                inspectionReport.class
        );
        q.setParameter("x", x);
        q.setParameter("pattern", pattern);

        return q.getResultList();
    }


    @Override
    public  inspectionReport createReport(inspectionReport report) {
        return em.merge(report);
    }

    @Override
    public inspectionReport getReportByUUID(String uuid) {
        TypedQuery<inspectionReport> q = em.createQuery("SELECT rep FROM inspectionReport rep WHERE rep.uuid=:theUUID", inspectionReport.class);
        q.setParameter("theUUID", uuid);
        return q.getSingleResult();
    }

    @Override
    public void deleteReportByUUID(String uuid) {
        TypedQuery<inspectionReport> q = em.createQuery("SELECT rep FROM inspectionReport rep WHERE rep.uuid=:theUUID", inspectionReport.class);
        q.setParameter("theUUID", uuid);
        inspectionReport rep = q.getSingleResult();
        System.out.println("Deleted this object:"+ rep);
        em.remove(rep);
    }
}
