package com.server.pojo.bean;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;


/**
 * QCbhsGz is a Querydsl query type for CbhsGz
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QCbhsGz extends EntityPathBase<CbhsGz> {

    private static final long serialVersionUID = -1629052209L;

    public static final QCbhsGz cbhsGz = new QCbhsGz("cbhsGz");

    public final StringPath content = createString("content");

    public final StringPath name = createString("name");

    public final NumberPath<Integer> oid = createNumber("oid", Integer.class);

    public final BooleanPath status = createBoolean("status");

    public QCbhsGz(String variable) {
        super(CbhsGz.class, forVariable(variable));
    }

    public QCbhsGz(Path<? extends CbhsGz> path) {
        super(path.getType(), path.getMetadata());
    }

    public QCbhsGz(PathMetadata metadata) {
        super(CbhsGz.class, metadata);
    }

}

