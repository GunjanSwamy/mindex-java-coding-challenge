package com.mindex.challenge.controller;

import com.mindex.challenge.data.ReportingStructure;
import com.mindex.challenge.service.ReportingStructureService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/** The controller class to handle the GET request for direct reports, it has getDirectReports method which
*   takes employee id as argument which is parsed from the GET url.
*   It calls the getDirectReports method in ReportingStructureService.
*/

@RestController
public class ReportingStructureController {
    private static final Logger LOG = LoggerFactory.getLogger(ReportingStructureController.class);

    @Autowired
    private ReportingStructureService ReportingStructureService;

    @GetMapping("/ReportingStructure/{id}")
    public ReportingStructure getDirectReports(@PathVariable String id){

        LOG.debug("Get Request received for employee id [{}]: ", id);
        return ReportingStructureService.getDirectReports(id);
    }

}