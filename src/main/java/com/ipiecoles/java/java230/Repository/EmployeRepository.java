package com.ipiecoles.java.java230.Repository;

import com.ipiecoles.java.java230.model.Employe;
import org.springframework.data.repository.CrudRepository;

public interface EmployeRepository extends CrudRepository<Employe,Long> { //Long est le type de la clé primaire d'Employe
    /*
    public interface CrudRepository<T,I extends Serializable> extends Repository<T,I> {
      <S extends T> S save(S entity);
      <S extends T> Iterable<S> save(Iterable<S> entities);
      T findOne(I id);
      boolean exists(I id);
      Iterable<T> findAll();
      Iterable<T> findAll(Iterable<I> ids);
      long count();
      void delete(I id);
      void delete(T entity);
      void delete(Iterable<? extends T> entities);
      void deleteAll();
    }
    1 - Déclarer les méthodes permettant d'effectuer les recherches suivantes :
        Recherche d'employés par matricule
        Recherche d'employés par nom et prénom
        Recherche d'employés par nom sans prendre en compte la casse
        Recherche d'employés embauchés avant une certaine date
        Recherche d'employés embauchés après une certaine date
        Recherche d'employés gagnant plus de X euros et ordonnés selon leur salaire
        (ceux qui gagnent le plus d'abord).
    */
    
    /*
    2 - Modifier EmployeRepository pour lui faire implémenter PagingAndSortingRepository
    et ajouter une méthode permettant de rechercher les employés en fonction de leur nom,
    sans prendre en compte la casse, et ce de manière paginée.

    3 - Ajouter une méthode findByNomOrPrenomAllIgnoreCase prenant en parametre un String nomOuPrenom
    et qui recherche sans prendre en compte la casse les employés ayant ce paramètre en nom ou en prénom.
    Utiliser @Param.

    4 - Ajouter une méthode findEmployePlusRiches qui récupère les employés dont le salaire est supérieur
     au salaire moyen des employés (voir requête SQL exo 13 du TP MySQL)

     */
}
