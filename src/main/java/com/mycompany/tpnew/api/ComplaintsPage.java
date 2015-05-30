package com.mycompany.tpnew.api;

import com.mycompany.tpnew.domain.Complaints;
import com.mycompany.tpnew.model.ComplaintsResource;
import com.mycompany.tpnew.services.ComplaintsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.Link;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;


import java.util.ArrayList;
import java.util.List;

/**
 * Created by user on 5/24/15.
 */

@RestController
@RequestMapping(value="/complaint/**")
public class ComplaintsPage {
    @Autowired
    private ComplaintsService service;
    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public List<Complaints> getComplaints(@PathVariable Long id) {
        return service.getComplaints();
    }

    @RequestMapping(value="/complaint", method=RequestMethod.GET)
    public List<ComplaintsResource> getManyComplaints() {
        List<ComplaintsResource> hateos = new ArrayList<>();
        List<Complaints> complaints = service.getComplaints();
        for (Complaints complaint : complaints) {
            ComplaintsResource res = new ComplaintsResource
                    .Builder(complaint.getUsername())
                    .complaint(complaint.getComplaint())
                    .timeStamp(complaint.getTimestamp())
                    .user(complaint.getUser())
                    .build();

            Link complaints1 = new
                    Link("http://localhost:8080/complaint/"+res.getResid().toString())
                    .withRel("comps");
            //res.add(complaints1);
            hateos.add(res);
        }
        return hateos;
    }
}
