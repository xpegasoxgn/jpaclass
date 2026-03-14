package com.clasejava.demo_jpa.exception;

import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.clasejava.demo_jpa.utils.JsonResult;

@RestControllerAdvice
//esta anotación indica que esta clase manejará excepciones de manera global para todos los controladores
// esta clase controla los errores de todos los controllers, es decir, si ocurre una excepción en cualquier controlador, esta clase la manejará y devolverá una respuesta adecuada
public class GlobalExceptionHandler {
    @ExceptionHandler(Exception.class)
    public JsonResult handleAllExceptions(Exception ex) {
        // Aquí puedes registrar el error o realizar cualquier acción adicional
        System.err.println("Ocurrió un error: " + ex.getMessage());

        return new JsonResult(false, ex.getMessage(), null);
         // Retorna el nombre de la vista de error (error.html)
    }
    
}
