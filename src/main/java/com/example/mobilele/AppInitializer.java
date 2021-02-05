package com.example.mobilele;


import com.example.mobilele.models.entities.*;
import com.example.mobilele.models.entities.enums.Category;
import com.example.mobilele.models.entities.enums.Role;
import com.example.mobilele.repositories.UserRepository;
import com.example.mobilele.repositories.UserRoleRepository;
import com.example.mobilele.services.BrandService;
import com.example.mobilele.services.ModelService;
import com.example.mobilele.services.OfferService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import org.springframework.security.crypto.password.PasswordEncoder;



import java.time.Instant;
import java.util.List;


@Component
public class AppInitializer implements CommandLineRunner {

    private final BrandService brandService;
    private final ModelService modelService;
    private final OfferService offerService;
    private final UserRoleRepository  userRoleRepository;
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;


    @Autowired
    public AppInitializer(BrandService brandService, ModelService modelService, OfferService offerService, UserRoleRepository userRoleRepository, UserRepository userRepository, PasswordEncoder passwordEncoder) {
        this.brandService = brandService;
        this.modelService = modelService;
        this.offerService = offerService;
        this.userRoleRepository = userRoleRepository;
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }


    @Override
    public void run(String... args) throws Exception {

//         brandService.seedData();
//
//
//        initTT(this.brandService.getBrandByName("Audi"));
//        initEQ7(this.brandService.getBrandByName("Audi"));
//        initNC750S(this.brandService.getBrandByName("Honda"));
//        this.offerService.seedOffers();
//        initUsers();







    }

    private void initNC750S(Brand honda) {
        Model nc750s = new Model();

        nc750s.
                setName("NC750S").
                setCategory(Category.MOTORCYCLE).
                setImageUrl("https://www.mitchellsmc.co.uk/wp-content/uploads/2020/07/IMG_0686.jpg").
                setStartYear(2014).
                setBrand(honda);

        setCurrentTimestamps(nc750s);

         modelService.saveEntities(nc750s);
    }

    private void setCurrentTimestamps(BaseEntity baseEntity) {
        baseEntity.setCreated(Instant.now());
        baseEntity.setModified(Instant.now());

    }


    private void initEQ7(Brand audi) {

        Model model = new Model();
        model.
                setName("Q7").
                setCategory(Category.CAR).
                setImageUrl("https://cdn.motor1.com/images/mgl/zowB0/s3/2020-audi-q7.jpg").
                setStartYear(2020).
                setBrand(audi);

        setCurrentTimestamps(model);

        modelService.saveEntities(model);
    }

    private void initTT(Brand audi) {
        Model model = new Model();
        model.
                setName("TT").
                setCategory(Category.CAR).
                setImageUrl("https://media.ed.edmunds-media.com/audi/tt/2019/oem/2019_audi_tt_coupe_20-tfsi-quattro_fq_oem_1_1600.jpg").
                setStartYear(2020).
                setBrand(audi);

        setCurrentTimestamps(model);

        modelService.saveEntities(model);
    }


    private void initUsers() {

        UserRole adminRole = new UserRole().setRole(Role.ADMIN);
        UserRole userRole = new UserRole().setRole(Role.USER);

        userRoleRepository.saveAll(List.of(adminRole, userRole));

        User admin = new User();
        admin.setFirstName("Kiril");
        admin.setLastName("Dimitrov");
        admin.setUsername("admin");
        admin.setPassword(passwordEncoder.encode("topsecret"));
        admin.setUserRoles(List.of(adminRole, userRole));
        setCurrentTimestamps(admin);


        User pesho = new User();
        pesho.
                setFirstName("Pepi").
                setLastName("Ivanov").
                setUsername("pesho").
                setPassword(passwordEncoder.encode("topsecret")).
                setUserRoles(List.of(userRole));
        setCurrentTimestamps(pesho);

        userRepository.saveAll(List.of(admin, pesho));
    }



}
