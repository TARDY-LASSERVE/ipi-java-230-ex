package com.ipiecoles.java.java230.Repository;

import com.ipiecoles.java.java230.model.Employe;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import org.joda.time.LocalDate;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface EmployeRepository extends JpaRepository<Employe,Long> { //Long est le type de la clé primaire d'Employe
    //1 - Déclarer les méthodes permettant d'effectuer les recherches suivantes :
    //a - Recherche d'employés par matricule : SELECT * FROM employe WHERE matricule = ?;
    Employe findByMatricule(String matricule);

    //b - Recherche d'employés par nom et prénom
    List<Employe> findByNomAndPrenom(String nom, String prenom);

    //c - Recherche d'employés par nom sans prendre en compte la casse : SELECT * FROM employe WHERE lower(nom) = ?;
    List<Employe> findByNomIgnoreCase(String nom);

    //d - Recherche d'employés embauchés avant une certaine date
    List<Employe> findByDateEmbaucheBefore(LocalDate dateEmbauche);

    //e - Recherche d'employés embauchés après une certaine date
    List<Employe> findByDateEmbaucheAfter(LocalDate dateEmbauche);

    //f - Recherche d'employés gagnant plus de X euros et ordonnés selon leur salaire
    //(ceux qui gagnent le plus d'abord).
    List<Employe> findBySalaireGreaterThanOrderBySalaireAsc(Double salaire);


    /* 2 - Modifier EmployeRepository pour lui faire implémenter PagingAndSortingRepository
    et ajouter une méthode permettant de rechercher les employés en fonction de leur nom,
    sans prendre en compte la casse, et ce de manière paginée. */
    List<Employe> findByNomIgnoreCase(String nom, Pageable page);

    /* 3 - Ajouter une méthode findByNomOrPrenomAllIgnoreCase prenant en parametre un String nomOuPrenom
    et qui recherche sans prendre en compte la casse les employés ayant ce paramètre en nom ou en prénom.
    Utiliser @Param. */
    @Query(value = "SELECT * FROM Employe WHERE lower(nom) = lower(:nOuP) OR lower(prenom) = lower(:nOuP)", nativeQuery = true)
    List<Employe> findByNomOrPrenomAllIgnoreCase(@Param("nOuP") String nomOuPrenom);

    /* 4 - Ajouter une méthode findEmployePlusRiches qui récupère les employés dont le salaire est supérieur
    au salaire moyen des employés (voir requête SQL exo 13 du TP MySQL)
    */
    @Query("SELECT e FROM Employe e WHERE e.salaire > (SELECT AVG(e2.salaire) FROM Employe e2)")
    List<Employe> findEmployePlusRiches();
}
