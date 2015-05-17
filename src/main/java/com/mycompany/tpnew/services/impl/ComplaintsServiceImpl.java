package com.mycompany.tpnew.services.impl;

import com.mycompany.tpnew.domain.Complaints;
import com.mycompany.tpnew.repository.ComplaintsRepository;
import com.mycompany.tpnew.services.ComplaintsService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by user on 5/17/15.
 */
@Service
public class ComplaintsServiceImpl implements ComplaintsService {

    ComplaintsRepository repository;
    @Override
    public List<Complaints> getComplaints() {
        List<Complaints> accountInfo = new ArrayList<>();
        Iterable<Complaints> values = repository.findAll();
        for (Complaints value: values) {
            accountInfo.add(value);
        }

        return accountInfo;
    }
}
