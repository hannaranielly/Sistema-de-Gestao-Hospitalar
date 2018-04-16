/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ufersa.controlConsult.model.exceptions;

/**
 *
 * @author juan
 */
public class CampoLimiteStringException extends Exception {

    public CampoLimiteStringException(String message, Throwable cause) {
        super(message, cause);
    }

    public CampoLimiteStringException(String message) {
        super(message);
    }
}
