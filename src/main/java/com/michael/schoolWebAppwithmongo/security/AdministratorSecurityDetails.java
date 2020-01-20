package com.michael.schoolWebAppwithmongo.security;

import com.michael.schoolWebAppwithmongo.documents.Administrator;
import com.michael.schoolWebAppwithmongo.repository.AdministratorRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;

public class AdministratorSecurityDetails implements UserDetailsService {

    private AdministratorRepository repository;
   public AdministratorSecurityDetails(AdministratorRepository repository){
       this.repository = repository;
   }

    Logger log = LoggerFactory.getLogger(AdministratorSecurityDetails.class);
    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        try{
            final Administrator admin = repository.findAdministratorByEmailIgnoreCase(s);
            log.info(admin.getPassword());
            log.info(admin.getEmail());
            if(admin != null){
                return User.withUsername(admin.getEmail())
                        .accountLocked(false)
                        .roles(admin.getRole())
                        .password(encodePassword(admin.getPassword()))
                        .build();
            }

        }catch (Exception e){
            e.printStackTrace();
        }
        throw new UsernameNotFoundException(s +"Not found");

    }

    public String encodePassword(String str){
        return PasswordEncoderFactories.createDelegatingPasswordEncoder().encode(str);
    }
}
