/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model.interfaces.repositories;

import java.sql.SQLException;
import model.entities.PersonModel;

public interface IPersonRepository extends IBaseRepository<PersonModel>{
    PersonModel select(String document) throws SQLException;
}
