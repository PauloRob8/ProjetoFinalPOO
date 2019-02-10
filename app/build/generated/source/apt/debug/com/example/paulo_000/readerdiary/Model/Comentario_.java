
package com.example.paulo_000.readerdiary.Model;

import com.example.paulo_000.readerdiary.Model.ComentarioCursor.Factory;
import io.objectbox.EntityInfo;
import io.objectbox.annotation.apihint.Internal;
import io.objectbox.internal.CursorFactory;
import io.objectbox.internal.IdGetter;


// THIS CODE IS GENERATED BY ObjectBox, DO NOT EDIT.

/**
 * Properties for entity "Comentario". Can be used for QueryBuilder and for referencing DB names.
 */
public final class Comentario_ implements EntityInfo<Comentario> {

    // Leading underscores for static constants to avoid naming conflicts with property names

    public static final String __ENTITY_NAME = "Comentario";

    public static final int __ENTITY_ID = 6;

    public static final Class<Comentario> __ENTITY_CLASS = Comentario.class;

    public static final String __DB_NAME = "Comentario";

    public static final CursorFactory<Comentario> __CURSOR_FACTORY = new Factory();

    @Internal
    static final ComentarioIdGetter __ID_GETTER = new ComentarioIdGetter();

    public final static Comentario_ __INSTANCE = new Comentario_();

    public final static io.objectbox.Property<Comentario> id =
        new io.objectbox.Property<>(__INSTANCE, 0, 3, long.class, "id", true, "id");

    public final static io.objectbox.Property<Comentario> descricao =
        new io.objectbox.Property<>(__INSTANCE, 1, 1, String.class, "descricao");

    public final static io.objectbox.Property<Comentario> dataHora =
        new io.objectbox.Property<>(__INSTANCE, 2, 2, String.class, "dataHora");

    @SuppressWarnings("unchecked")
    public final static io.objectbox.Property<Comentario>[] __ALL_PROPERTIES = new io.objectbox.Property[]{
        id,
        descricao,
        dataHora
    };

    public final static io.objectbox.Property<Comentario> __ID_PROPERTY = id;

    @Override
    public String getEntityName() {
        return __ENTITY_NAME;
    }

    @Override
    public int getEntityId() {
        return __ENTITY_ID;
    }

    @Override
    public Class<Comentario> getEntityClass() {
        return __ENTITY_CLASS;
    }

    @Override
    public String getDbName() {
        return __DB_NAME;
    }

    @Override
    public io.objectbox.Property<Comentario>[] getAllProperties() {
        return __ALL_PROPERTIES;
    }

    @Override
    public io.objectbox.Property<Comentario> getIdProperty() {
        return __ID_PROPERTY;
    }

    @Override
    public IdGetter<Comentario> getIdGetter() {
        return __ID_GETTER;
    }

    @Override
    public CursorFactory<Comentario> getCursorFactory() {
        return __CURSOR_FACTORY;
    }

    @Internal
    static final class ComentarioIdGetter implements IdGetter<Comentario> {
        @Override
        public long getId(Comentario object) {
            return object.getId();
        }
    }

}