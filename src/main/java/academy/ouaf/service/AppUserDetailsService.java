package academy.ouaf.service;

import academy.ouaf.dao.users.AdminDao;
import academy.ouaf.dao.users.CoachDao;
import academy.ouaf.dao.users.OwnerDao;
import academy.ouaf.model.Coach;
import academy.ouaf.model.Owner;
import academy.ouaf.security.AppUserDetails;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AppUserDetailsService implements UserDetailsService {

    protected CoachDao coachDao;
    protected OwnerDao ownerDao;
    protected AdminDao adminDao;

    @Autowired
    public AppUserDetailsService(OwnerDao ownerDao, CoachDao coachDao, AdminDao adminDao) {
        this.ownerDao = ownerDao;
        this.coachDao = coachDao;
        this.adminDao = adminDao;
    }

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {


        Optional<Owner> optionalOwner = ownerDao.findByEmail(email);


        if (optionalOwner.isEmpty()) {
            Optional<Coach> optionalCoach = coachDao.findByEmail(email);

            if (optionalCoach.isEmpty()) {
                throw new UsernameNotFoundException("User not found");
            } else {
                return new AppUserDetails(optionalCoach.get());
            }
        } else {
            return new AppUserDetails(optionalOwner.get());
        }
    }
}