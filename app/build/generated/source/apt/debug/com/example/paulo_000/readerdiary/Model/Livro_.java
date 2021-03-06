
package com.example.paulo_000.readerdiary.Model;

import com.example.paulo_000.readerdiary.Model.LivroCursor.Factory;
import io.objectbox.EntityInfo;
import io.objectbox.annotation.apihint.Internal;
import io.objectbox.internal.CursorFactory;
import io.objectbox.internal.IdGetter;
import io.objectbox.relation.RelationInfo;
import io.objectbox.relation.ToOne;
import io.objectbox.internal.ToOneGetter;
import io.objectbox.internal.ToManyGetter;

import java.util.List;


// THIS CODE IS GENERATED BY ObjectBox, DO NOT EDIT.

/**
 * Properties for entity "Livro". Can be used for QueryBuilder and for referencing DB names.
 */
public final class Livro_ implements EntityInfo<Livro> {

    // Leading underscores for static constants to avoid naming conflicts with property names

    public static final String __ENTITY_NAME = "Livro";

    public static final int __ENTITY_ID = 3;

    public static final Class<Livro> __ENTITY_CLASS = Livro.class;

    public static final String __DB_NAME = "Livro";

    public static final CursorFactory<Livro> __CURSOR_FACTORY = new Factory();

    @Internal
    static final LivroIdGetter __ID_GETTER = new LivroIdGetter();

    public final static Livro_ __INSTANCE = new Livro_();

    public final static io.objectbox.Property<Livro> id =
        new io.objectbox.Property<>(__INSTANCE, 0, 1, long.class, "id", true, "id");

    public final static io.objectbox.Property<Livro> titulo =
        new io.objectbox.Property<>(__INSTANCE, 1, 2, String.class, "titulo");

    public final static io.objectbox.Property<Livro> autor =
        new io.objectbox.Property<>(__INSTANCE, 2, 3, String.class, "autor");

    public final static io.objectbox.Property<Livro> genero =
        new io.objectbox.Property<>(__INSTANCE, 3, 4, String.class, "genero");

    public final static io.objectbox.Property<Livro> ano =
        new io.objectbox.Property<>(__INSTANCE, 4, 5, String.class, "ano");

    public final static io.objectbox.Property<Livro> qtdPg =
        new io.objectbox.Property<>(__INSTANCE, 5, 6, String.class, "qtdPg");

    public final static io.objectbox.Property<Livro> pgAtual =
        new io.objectbox.Property<>(__INSTANCE, 6, 7, String.class, "pgAtual");

    public final static io.objectbox.Property<Livro> status =
        new io.objectbox.Property<>(__INSTANCE, 7, 8, String.class, "status");

    public final static io.objectbox.Property<Livro> dataInicial =
        new io.objectbox.Property<>(__INSTANCE, 8, 9, String.class, "dataInicial");

    public final static io.objectbox.Property<Livro> dataFinal =
        new io.objectbox.Property<>(__INSTANCE, 9, 10, String.class, "dataFinal");

    public final static io.objectbox.Property<Livro> notaDeAvaliação =
        new io.objectbox.Property<>(__INSTANCE, 10, 13, float.class, "notaDeAvaliação");

    public final static io.objectbox.Property<Livro> donoId =
        new io.objectbox.Property<>(__INSTANCE, 11, 11, long.class, "donoId", true);

    @SuppressWarnings("unchecked")
    public final static io.objectbox.Property<Livro>[] __ALL_PROPERTIES = new io.objectbox.Property[]{
        id,
        titulo,
        autor,
        genero,
        ano,
        qtdPg,
        pgAtual,
        status,
        dataInicial,
        dataFinal,
        notaDeAvaliação,
        donoId
    };

    public final static io.objectbox.Property<Livro> __ID_PROPERTY = id;

    @Override
    public String getEntityName() {
        return __ENTITY_NAME;
    }

    @Override
    public int getEntityId() {
        return __ENTITY_ID;
    }

    @Override
    public Class<Livro> getEntityClass() {
        return __ENTITY_CLASS;
    }

    @Override
    public String getDbName() {
        return __DB_NAME;
    }

    @Override
    public io.objectbox.Property<Livro>[] getAllProperties() {
        return __ALL_PROPERTIES;
    }

    @Override
    public io.objectbox.Property<Livro> getIdProperty() {
        return __ID_PROPERTY;
    }

    @Override
    public IdGetter<Livro> getIdGetter() {
        return __ID_GETTER;
    }

    @Override
    public CursorFactory<Livro> getCursorFactory() {
        return __CURSOR_FACTORY;
    }

    @Internal
    static final class LivroIdGetter implements IdGetter<Livro> {
        @Override
        public long getId(Livro object) {
            return object.getId();
        }
    }

    /** To-one relation "dono" to target entity "Usuario". */
    public static final RelationInfo<Livro, Usuario> dono =
            new RelationInfo<>(Livro_.__INSTANCE, Usuario_.__INSTANCE, donoId, new ToOneGetter<Livro>() {
                @Override
                public ToOne<Usuario> getToOne(Livro entity) {
                    return entity.getDono();
                }
            });

    /** To-many relation "comentarios" to target entity "Comentario". */
    public static final RelationInfo<Livro, Comentario> comentarios = new RelationInfo<>(Livro_.__INSTANCE, Comentario_.__INSTANCE,
            new ToManyGetter<Livro>() {
                @Override
                public List<Comentario> getToMany(Livro entity) {
                    return entity.getComentarios();
                }
            },
             1);

    /** To-many relation "capitulos" to target entity "Capitulo". */
    public static final RelationInfo<Livro, Capitulo> capitulos = new RelationInfo<>(Livro_.__INSTANCE, Capitulo_.__INSTANCE,
            new ToManyGetter<Livro>() {
                @Override
                public List<Capitulo> getToMany(Livro entity) {
                    return entity.getCapitulos();
                }
            },
             2);

}
