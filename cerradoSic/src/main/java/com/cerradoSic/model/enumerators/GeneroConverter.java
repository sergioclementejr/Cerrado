package com.cerradoSic.model.enumerators;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;

@Converter
public class GeneroConverter implements AttributeConverter<Genero, Integer>{

  @Override
  public Integer convertToDatabaseColumn(Genero attribute) {
    Integer integer;
    switch (attribute) {
      case MASCULINO:
        integer = 1;
        break;
        
      case FEMININO:
        integer = 2;
        break;

      default:
        integer = 3;
        break;
    }
    return integer;
  }

  @Override
  public Genero convertToEntityAttribute(Integer dbData) {
    Genero genero;
    switch (dbData) {
      case 1:
        genero = Genero.MASCULINO;
        break;
        
      case 2:
        genero = Genero.FEMININO;
        break;

      default:
        genero = Genero.NULL;
        break;
    }
    return genero;
  }
}