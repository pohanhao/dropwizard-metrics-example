package idv.hank.dropwizard.metrics.example.service.impl;

import idv.hank.dropwizard.metrics.example.aop.DurationLog;
import idv.hank.dropwizard.metrics.example.model.Domain;
import idv.hank.dropwizard.metrics.example.service.DomainService;

import java.util.LinkedList;
import java.util.List;

public class DomainServiceImpl implements DomainService {

    @Override
    @DurationLog
    public List<Domain> getAll() {
        List<Domain> domains = new LinkedList<>();
        domains.add(new Domain("domain1", "version1"));
        domains.add(new Domain("domain2", "version2"));
        domains.add(new Domain("domain3", "version3"));
        return domains;
    }
}
