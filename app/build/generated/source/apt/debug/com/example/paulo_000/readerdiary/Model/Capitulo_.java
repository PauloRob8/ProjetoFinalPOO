
package com.example.paulo_000.readerdiary.Model;

import com.example.paulo_000.readerdiary.Model.CapituloCursor.Factory;
import io.objectbox.EntityInfo;
import io.objectbox.annotation.apihint.Internal;
import io.objectbox.internal.CursorFactory;
import io.objectbox.internal.IdGetter;
import io.objectbox.relation.RelationInfo;
import io.objectbox.relation.ToOne;
import io.objectbox.internal.ToOneGetter;


// THIS CODE IS GENERATED BY ObjectBox, DO NOT EDIT.

/**
 * Properties for entity "Capitulo". Can be used for QueryBuilder and for referencing DB names.
 */
public final class Capitulo_ implements EntityInfo<Capitulo> {

    // Leading underscores for static constants to avoid naming conflicts with property names

    public static final String __ENTITY_NAME = "Capitulo";

    public static final int __ENTITY_ID = 5;

    public static final Class<Capitulo> __ENTITY_CLASS = Capitulo.class;

    public static final String __DB_NAME = "Capitulo";

    public static final CursorFactory<Capitulo> __CURSOR_FACTORY = new Factory();

    @Internal
    static final CapituloIdGetter __ID_GETTER = new CapituloIdGetter();

    public final static Capitulo_ __INSTANCE = new Capitulo_();

    public final static io.objectbox.Property<Capitulo> id =
        new io.objectbox.Property<>(__INSTANCE, 0, 1, long.class, "id", true, "id");

    public final static io.objectbox.Property<Capitulo> titulo =
        new io.objectbox.Property<>(__INSTANCE, 1, 2, String.class, "titulo");

    public final static io.objectbox.Property<Capitulo> capNum =
        new io.objectbox.Property<>(__INSTANCE, 2, 3, int.class, "capNum");

    public final static io.objectbox.Property<Capitulo> descricao =
        new io.objectbox.Property<>(__INSTANCE, 3, 4, String.class, "descricao");

    public final static io.objectbox.Property<Capitulo> favorito =
        new io.objectbox.Property<>(__INSTANCE, 4, 6, boolean.class, "favorito");

    public final static io.objectbox.Property<Capitulo> marcado =
        new io.objectbox.Property<>(__INSTANCE, 5, 7, boolean.class, "marcado");

    public final static io.objectbox.Property<Capitulo> livroId =
        new io.objectbox.Property<>(__INSTANCE, 6, 5, long.class, "livroId", true);

    @SuppressWarnings("unchecked")
    public final static io.objectbox.Property<Capitulo>[] __ALL_PROPERTIES = new io.objectbox.Property[]{
        id,
        titulo,
        capNum,
        descricao,
        favorito,
        marcado,
        livroId
    };

    public final static io.objectbox.Property<Capitulo> __ID_PROPERTY = id;

    @Override
    public String getEntityName() {
        return __ENTITY_NAME;
    }

    @Override
    public int getEntityId() {
        return __ENTITY_ID;
    }

    @Override
    public Class<Capitulo> getEntityClass() {
        return __ENTITY_CLASS;
    }

    @Override
    public String getDbName() {
        return __DB_NAME;
    }

    @Override
    public io.objectbox.Property<Capitulo>[] getAllProperties() {
        return __ALL_PROPERTIES;
    }

    @Override
    public io.objectbox.Property<Capitulo> getIdProperty() {
        return __ID_PROPERTY;
    }

    @Override
    public IdGetter<Capitulo> getIdGetter() {
        return __ID_GETTER;
    }

    @Override
    public CursorFactory<Capitulo> getCursorFactory() {
        return __CURSOR_FACTORY;
    }

    @Internal
    static final class CapituloIdGetter implements IdGetter<Capitulo> {
        @Override
        public long getId(Capitulo object) {
            return object.getId();
        }
    }

    /** To-one relation "livro" to target entity "Livro". */
    public static final RelationInfo<Capitulo, Livro> livro =
            new RelationInfo<>(Capitulo_.__INSTANCE, Livro_.__INSTANCE, livroId, new ToOneGetter<Capitulo>() {
                @Override
                public ToOne<Livro> getToOne(Capitulo entity) {
                    return entity.getLivro();
                }
            });

}
