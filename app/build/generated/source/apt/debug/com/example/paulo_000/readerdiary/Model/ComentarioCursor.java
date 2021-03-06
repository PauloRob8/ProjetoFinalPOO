package com.example.paulo_000.readerdiary.Model;

import java.util.List;

import io.objectbox.BoxStore;
import io.objectbox.Cursor;
import io.objectbox.annotation.apihint.Internal;
import io.objectbox.internal.CursorFactory;

// THIS CODE IS GENERATED BY ObjectBox, DO NOT EDIT.

/**
 * ObjectBox generated Cursor implementation for "Comentario".
 * Note that this is a low-level class: usually you should stick to the Box class.
 */
public final class ComentarioCursor extends Cursor<Comentario> {
    @Internal
    static final class Factory implements CursorFactory<Comentario> {
        @Override
        public Cursor<Comentario> createCursor(io.objectbox.Transaction tx, long cursorHandle, BoxStore boxStoreForEntities) {
            return new ComentarioCursor(tx, cursorHandle, boxStoreForEntities);
        }
    }

    private static final Comentario_.ComentarioIdGetter ID_GETTER = Comentario_.__ID_GETTER;


    private final static int __ID_descricao = Comentario_.descricao.id;
    private final static int __ID_dataHora = Comentario_.dataHora.id;

    public ComentarioCursor(io.objectbox.Transaction tx, long cursor, BoxStore boxStore) {
        super(tx, cursor, Comentario_.__INSTANCE, boxStore);
    }

    @Override
    public final long getId(Comentario entity) {
        return ID_GETTER.getId(entity);
    }

    /**
     * Puts an object into its box.
     *
     * @return The ID of the object within its box.
     */
    @Override
    public final long put(Comentario entity) {
        String descricao = entity.getDescricao();
        int __id1 = descricao != null ? __ID_descricao : 0;
        String dataHora = entity.getDataHora();
        int __id2 = dataHora != null ? __ID_dataHora : 0;

        long __assignedId = collect313311(cursor, entity.getId(), PUT_FLAG_FIRST | PUT_FLAG_COMPLETE,
                __id1, descricao, __id2, dataHora,
                0, null, 0, null,
                0, 0, 0, 0,
                0, 0, 0, 0,
                0, 0, 0, 0,
                0, 0, 0, 0);

        entity.setId(__assignedId);

        return __assignedId;
    }

}
