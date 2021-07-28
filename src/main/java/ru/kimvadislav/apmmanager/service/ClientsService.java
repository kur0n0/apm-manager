package ru.kimvadislav.apmmanager.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.kimvadislav.apmmanager.dao.LoanRequestRepository;
import ru.kimvadislav.apmmanager.model.LoanRequest;

import java.util.List;

@Service
public class ClientsService {
    private LoanRequestRepository requestRepository;

    @Autowired
    public ClientsService(LoanRequestRepository requestRepository) {
        this.requestRepository = requestRepository;
    }

    public List<LoanRequest> getAllClients() {
        return requestRepository.findAll();
    }
}
