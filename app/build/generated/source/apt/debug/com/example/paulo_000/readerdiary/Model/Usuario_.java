
package com.example.paulo_000.readerdiary.Model;

import com.example.paulo_000.readerdiary.Model.UsuarioCursor.Factory;

import io.objectbox.EntityInfo;
import io.objectbox.Property;
import io.objectbox.annotation.apihint.Internal;
import io.objectbox.internal.CursorFactory;
import io.objectbox.internal.IdGetter;


// THIS CODE IS GENERATED BY ObjectBox, DO NOT EDIT.

/**
 * Properties for entity "Usuario". Can be used for QueryBuilder and for referencing DB names.
 */
public final class Usuario_ implements EntityInfo<Usuario> {

    // Leading underscores for static constants to avoid naming conflicts with property names

    public static final String __ENTITY_NAME = "Usuario";

    public static final int __ENTITY_ID = 1;

    public static final Class<Usuario> __ENTITY_CLASS = Usuario.class;

    public static final String __DB_NAME = "Usuario";

    public static final CursorFactory<Usuario> __CURSOR_FACTORY = new Factory();

    @Internal
    static final UsuarioIdGetter __ID_GETTER = new UsuarioIdGetter();

    public final static Property id = new Property(0, 1, long.class, "id", true, "id");
    public final static Property nome = new Property(1, 4, String.class, "nome");
    public final static Property email = new Property(2, 2, String.class, "email");
    public final static Property senha = new Property(3, 3, String.class, "senha");

    public final static Property[] __ALL_PROPERTIES = {
        id,
        nome,
        email,
        senha
    };

    public final static Property __ID_PROPERTY = id;

    public final static Usuario_ __INSTANCE = new Usuario_();

    @Override
    public String getEntityName() {
        return __ENTITY_NAME;
    }

    @Override
    public int getEntityId() {
        return __ENTITY_ID;
    }

    @Override
    public Class<Usuario> getEntityClass() {
        return __ENTITY_CLASS;
    }

    @Override
    public String getDbName() {
        return __DB_NAME;
    }

    @Override
    public Property[] getAllProperties() {
        return __ALL_PROPERTIES;
    }

    @Override
    public Property getIdProperty() {
        return __ID_PROPERTY;
    }

    @Override
    public IdGetter<Usuario> getIdGetter() {
        return __ID_GETTER;
    }

    @Override
    public CursorFactory<Usuario> getCursorFactory() {
        return __CURSOR_FACTORY;
    }

    @Internal
    static final class UsuarioIdGetter implements IdGetter<Usuario> {
        @Override
        public long getId(Usuario object) {
            return object.getId();
        }
    }

}
