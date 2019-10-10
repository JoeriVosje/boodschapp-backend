package com.hhs.boodschapp.service;

import com.hhs.boodschapp.exception.BoodschappErrorException;
import org.springframework.http.HttpStatus;

import java.lang.reflect.Field;

public class PatchMappingService {
    public static void set(Object object, String fieldName, Object fieldValue) {
        Class<?> clazz = object.getClass();
        while (clazz != null) {
            try {
                Field field = clazz.getDeclaredField(fieldName);
                field.setAccessible(true);
                field.set(object, fieldValue);
                clazz = null;
            } catch (NoSuchFieldException e) {
                throw new BoodschappErrorException("Wrong field name entered.", HttpStatus.BAD_REQUEST);
            } catch (Exception e) {
                throw new BoodschappErrorException("Error occured", HttpStatus.BAD_REQUEST);
            }
        }
    }
}
