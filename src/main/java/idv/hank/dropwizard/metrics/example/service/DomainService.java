package idv.hank.dropwizard.metrics.example.service;

import idv.hank.dropwizard.metrics.example.model.Domain;

import java.util.List;

public interface DomainService {

    List<Domain> getAll();
}
