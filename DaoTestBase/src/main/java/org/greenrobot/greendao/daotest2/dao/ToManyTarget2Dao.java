package org.greenrobot.greendao.daotest2.dao;

import java.util.List;
import android.database.Cursor;

import de.greenrobot.dao.AbstractDao;
import de.greenrobot.dao.Property;
import de.greenrobot.dao.internal.DaoConfig;
import de.greenrobot.dao.database.Database;
import de.greenrobot.dao.database.DatabaseStatement;
import de.greenrobot.dao.query.Query;
import de.greenrobot.dao.query.QueryBuilder;

import org.greenrobot.greendao.daotest2.ToManyTarget2;

// THIS CODE IS GENERATED BY greenDAO, DO NOT EDIT.
/** 
 * DAO for table "TO_MANY_TARGET2".
*/
public class ToManyTarget2Dao extends AbstractDao<ToManyTarget2, Long> {

    public static final String TABLENAME = "TO_MANY_TARGET2";

    /**
     * Properties of entity ToManyTarget2.<br/>
     * Can be used for QueryBuilder and for referencing column names.
    */
    public static class Properties {
        public final static Property Id = new Property(0, Long.class, "id", true, "_id");
        public final static Property FkId = new Property(1, Long.class, "fkId", false, "FK_ID");
    };

    private Query<ToManyTarget2> relationSource2_ToManyTarget2ListQuery;

    public ToManyTarget2Dao(DaoConfig config) {
        super(config);
    }
    
    public ToManyTarget2Dao(DaoConfig config, DaoSession daoSession) {
        super(config, daoSession);
    }

    /** Creates the underlying database table. */
    public static void createTable(Database db, boolean ifNotExists) {
        String constraint = ifNotExists? "IF NOT EXISTS ": "";
        db.execSQL("CREATE TABLE " + constraint + "\"TO_MANY_TARGET2\" (" + //
                "\"_id\" INTEGER PRIMARY KEY ," + // 0: id
                "\"FK_ID\" INTEGER);"); // 1: fkId
    }

    /** Drops the underlying database table. */
    public static void dropTable(Database db, boolean ifExists) {
        String sql = "DROP TABLE " + (ifExists ? "IF EXISTS " : "") + "\"TO_MANY_TARGET2\"";
        db.execSQL(sql);
    }

    /** @inheritdoc */
    @Override
    protected void bindValues(DatabaseStatement stmt, ToManyTarget2 entity) {
        stmt.clearBindings();
 
        Long id = entity.getId();
        if (id != null) {
            stmt.bindLong(1, id);
        }
 
        Long fkId = entity.getFkId();
        if (fkId != null) {
            stmt.bindLong(2, fkId);
        }
    }

    /** @inheritdoc */
    @Override
    public Long readKey(Cursor cursor, int offset) {
        return cursor.isNull(offset + 0) ? null : cursor.getLong(offset + 0);
    }    

    /** @inheritdoc */
    @Override
    public ToManyTarget2 readEntity(Cursor cursor, int offset) {
        ToManyTarget2 entity = new ToManyTarget2( //
            cursor.isNull(offset + 0) ? null : cursor.getLong(offset + 0), // id
            cursor.isNull(offset + 1) ? null : cursor.getLong(offset + 1) // fkId
        );
        return entity;
    }
     
    /** @inheritdoc */
    @Override
    public void readEntity(Cursor cursor, ToManyTarget2 entity, int offset) {
        entity.setId(cursor.isNull(offset + 0) ? null : cursor.getLong(offset + 0));
        entity.setFkId(cursor.isNull(offset + 1) ? null : cursor.getLong(offset + 1));
     }
    
    /** @inheritdoc */
    @Override
    protected Long updateKeyAfterInsert(ToManyTarget2 entity, long rowId) {
        entity.setId(rowId);
        return rowId;
    }
    
    /** @inheritdoc */
    @Override
    public Long getKey(ToManyTarget2 entity) {
        if(entity != null) {
            return entity.getId();
        } else {
            return null;
        }
    }

    /** @inheritdoc */
    @Override    
    protected boolean isEntityUpdateable() {
        return true;
    }
    
    /** Internal query to resolve the "toManyTarget2List" to-many relationship of RelationSource2. */
    public List<ToManyTarget2> _queryRelationSource2_ToManyTarget2List(Long fkId) {
        synchronized (this) {
            if (relationSource2_ToManyTarget2ListQuery == null) {
                QueryBuilder<ToManyTarget2> queryBuilder = queryBuilder();
                queryBuilder.where(Properties.FkId.eq(null));
                relationSource2_ToManyTarget2ListQuery = queryBuilder.build();
            }
        }
        Query<ToManyTarget2> query = relationSource2_ToManyTarget2ListQuery.forCurrentThread();
        query.setParameter(0, fkId);
        return query.list();
    }

}
