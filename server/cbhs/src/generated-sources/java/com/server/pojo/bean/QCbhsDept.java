package com.server.pojo.bean;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;


/**
 * QCbhsDept is a Querydsl query type for CbhsDept
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QCbhsDept extends EntityPathBase<CbhsDept> {

    private static final long serialVersionUID = 2143784225L;

    public static final QCbhsDept cbhsDept = new QCbhsDept("cbhsDept");

    public final StringPath content = createString("content");

    public final StringPath name = createString("name");

    public final NumberPath<Integer> oid = createNumber("oid", Integer.class);

    public final BooleanPath status = createBoolean("status");

    public QCbhsDept(String variable) {
        super(CbhsDept.class, forVariable(variable));
    }

    public QCbhsDept(Path<? extends CbhsDept> path) {
        super(path.getType(), path.getMetadata());
    }

    public QCbhsDept(PathMetadata metadata) {
        super(CbhsDept.class, metadata);
    }

}

