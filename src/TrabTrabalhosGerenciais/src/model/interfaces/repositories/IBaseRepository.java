/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model.interfaces.repositories;

import java.util.ArrayList;

/**
 *
 * @author Davi
 */
public interface IBaseRepository<T> {
    void insert(T model);
    void update(T model);
    void delete(int id);
    T select(int id);
    ArrayList<T> select();
}
