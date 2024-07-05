package com.intern.irr.DAO;

import com.intern.irr.entity.inspectionFormat;
import com.intern.irr.entity.inspectionReport;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository

public class inspectionFormatDAOimpl implements inspectionFormatDAO{
    private EntityManager em;

    //Constructor Injection of Entity manager
    @Autowired
    public inspectionFormatDAOimpl(EntityManager emanager){
        this.em = emanager;
    }
    @Override
    public inspectionFormat getData(String format) {
        TypedQuery<inspectionFormat> q = em.createQuery("SELECT format FROM inspectionFormat format WHERE format.frNo=:theFormat", inspectionFormat.class);
        q.setParameter("theFormat", format);
        return q.getSingleResult();
    }

    @Override
    public List<inspectionFormat> getAllFormats() {
        TypedQuery<inspectionFormat> q = em.createQuery("SELECT format FROM inspectionFormat format",inspectionFormat.class );
        List<inspectionFormat> temp = q.getResultList();
        return temp;
    }

}
