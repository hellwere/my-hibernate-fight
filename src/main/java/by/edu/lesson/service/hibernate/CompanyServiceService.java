package by.edu.lesson.service.hibernate;

import by.edu.lesson.entity.CompanyService;
import by.edu.lesson.repository.hibernate.CompanyServiceRepository;

import java.util.ArrayList;
import java.util.List;

public class CompanyServiceService {

    private final CompanyServiceRepository repository;

    public CompanyServiceService() {
        this.repository = new CompanyServiceRepository();
    }

    public List<CompanyService> addCompanyService(List<CompanyService> companyServices) {
        ArrayList<CompanyService> lst = new ArrayList<>();
        for (CompanyService companyService : companyServices) {
            lst.add(this.addCompanyService(companyService));
        }
        return lst;
    }

    public CompanyService addCompanyService(CompanyService companyService) {
        return repository.addCompanyService(companyService);
    }

    public List<CompanyService> findActivityWithCriteria(String activity) {
        return repository.findMinAmountActivityWithCriteria(activity);
    }

    public List<CompanyService> findActivityWithCacheTwoTimes(List<Long> ids) {
        return repository.findActivityWithCacheTwoTimes(ids);
    }

    public List<CompanyService> findActivityWithCacheThreeTimes(List<Long> ids) {
        return repository.findActivityWithCacheThreeTimes(ids);
    }

    public List<CompanyService> findActivityWithCacheSecondLevel(List<Long> ids) {
        return repository.findActivityWithCacheSecondLevel(ids);
    }

}
