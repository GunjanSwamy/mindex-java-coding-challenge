package com.mindex.challenge.service;

import com.mindex.challenge.data.ReportingStructure;

public interface ReportingStructureService {

    ReportingStructure getDirectReports(String id);
}