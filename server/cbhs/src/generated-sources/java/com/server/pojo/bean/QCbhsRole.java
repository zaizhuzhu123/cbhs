package com.server.pojo.bean;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;


/**
 * QCbhsRole is a Querydsl query type for CbhsRole
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QCbhsRole extends EntityPathBase<CbhsRole> {

    private static final long serialVersionUID = 2144210770L;

    public static final QCbhsRole cbhsRole = new QCbhsRole("cbhsRole");

    public final StringPath content = createString("content");

    public final StringPath menuids = createString("menuids");

    public final StringPath name = createString("name");

    public final NumberPath<Integer> oid = createNumber("oid", Integer.class);

    public final BooleanPath status = createBoolean("status");

    public QCbhsRole(String variable) {
        super(CbhsRole.class, forVariable(variable));
    }

    public QCbhsRole(Path<? extends CbhsRole> path) {
        super(path.getType(), path.getMetadata());
    }

    public QCbhsRole(PathMetadata metadata) {
        super(CbhsRole.class, metadata);
    }

}

