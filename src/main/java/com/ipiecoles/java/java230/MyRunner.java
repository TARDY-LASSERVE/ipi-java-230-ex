package com.ipiecoles.java.java230;

import org.joda.time.LocalDate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import com.ipiecoles.java.java230.model.*;
import com.ipiecoles.java.java230.Repository.*;

import java.util.List;

@Component
public class MyRunner implements CommandLineRunner {

    @Autowired
    private EmployeRepository employeRepository;

    @Autowired
    private TechnicienRepository technicienRepository;

    @Autowired
    private ManagerRepository managerRepository;

    @Autowired
    private CommercialRepository commercialRepository;

    @Override
    public void run(String... strings) throws Exception {

        System.out.println("Coucou !!");

        Employe t = employeRepository.findByMatricule("T02141");
        Technicien technicien = (Technicien) t;
        System.out.println(technicien.getManager());

        Manager m = managerRepository.findById(11L); //Matricule 'M02149'
        for(Technicien tech : m.getEquipe()){
            System.out.println(tech);
        }
        LocalDate date = new LocalDate(2015, 1, 1);
        List<Technicien> techniciens;
        techniciens = technicienRepository.findByGradeAndManagerDateEmbaucheAfter(1, date);
        for(Technicien technicien2 : techniciens){
            System.out.println(technicien2);
            System.out.println(technicien2.getManager().getDateEmbauche());
        }

        /*Page<Employe> e = employeRepository.findAll(new PageRequest(0, 10));
        for(Employe employe : e){
            if (employe instanceof Technicien){
                ((Technicien) employe).getGrade();
            }
            System.out.println(employe);
        }

        List<Technicien> t = technicienRepository.findByGradeBetween(1, 1);
        for(Technicien technicien : t){
            System.out.println(technicien);
        }

        List<Manager> m = managerRepository.findByPerformanceGreaterThan(3);
        for(Manager manager : m){
            System.out.println(manager);
        }

        List<Commercial> c = commercialRepository.findByPerformanceGreaterThan(9);
        for(Commercial commercial : c){
            System.out.println(commercial);
        }
        */
    }

    public static void print(Object t) {
        System.out.println(t);
    }
}
