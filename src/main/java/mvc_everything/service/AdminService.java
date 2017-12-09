package mvc_everything.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import mvc_everything.model.Admin;
import mvc_everything.repository.AdminRepository;

@Service
public class AdminService {

    @Autowired
    AdminRepository repository;

    public List<Admin> getAll() {
        return repository.findAll();
    }

    public Admin getByUsername(String name) {
        return repository.findOne(name);
    }

    public boolean validate(Admin adminSign) {
        if (adminSign.getName().equals("Admin")) {
            if (adminSign.getPassword().equals("123")) {
                return true;
            } else {
                return false;
            }
        } else {
            return false;
        }
    }

}
