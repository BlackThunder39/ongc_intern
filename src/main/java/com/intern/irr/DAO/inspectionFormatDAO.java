package com.intern.irr.DAO;

import com.intern.irr.entity.inspectionFormat;
import com.intern.irr.entity.inspectionReport;

import java.util.List;

public interface inspectionFormatDAO {
    inspectionFormat getData(String format);
    List<inspectionFormat> getAllFormats();
}
