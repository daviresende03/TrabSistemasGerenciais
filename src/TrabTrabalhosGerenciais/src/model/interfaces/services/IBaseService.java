/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model.interfaces.services;

import java.util.ArrayList;

/**
 *
 * @author Davi
 */
public interface IBaseService<T> {
    void insert(T model);
    void remove(int id);
    void update(T model);
    T get(int id);
    ArrayList<T> getAll();
}
