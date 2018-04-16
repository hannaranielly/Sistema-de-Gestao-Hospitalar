/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ufersa.controlConsult.model.exceptions;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author juan
 */
public class CampoObrigatorioException extends Exception {

    public CampoObrigatorioException(String message, Throwable cause) {
        super(message, cause);
    }

    public CampoObrigatorioException(String message) {
        super(message);
    }

}
