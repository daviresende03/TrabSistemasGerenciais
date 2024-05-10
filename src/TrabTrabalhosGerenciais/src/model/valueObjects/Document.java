/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model.valueObjects;

import model.enums.DocumentType;

/**
 *
 * @author Davi
 */
public class Document {
    private DocumentType type;
    private String number;

    public Document(DocumentType type, String number) {
        this.type = type;
        this.number = number;
    }
}
