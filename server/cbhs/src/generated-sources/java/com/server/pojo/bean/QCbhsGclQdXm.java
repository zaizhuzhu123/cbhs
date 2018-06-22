package com.server.pojo.bean;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;


/**
 * QCbhsGclQdXm is a Querydsl query type for CbhsGclQdXm
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QCbhsGclQdXm extends EntityPathBase<CbhsGclQdXm> {

    private static final long serialVersionUID = 1912770364L;

    public static final QCbhsGclQdXm cbhsGclQdXm = new QCbhsGclQdXm("cbhsGclQdXm");

    public final StringPath name = createString("name");

    public final StringPath nodeId = createString("nodeId");

    public final NumberPath<Integer> oid = createNumber("oid", Integer.class);

    public final StringPath pNodeId = createString("pNodeId");

    public final BooleanPath status = createBoolean("status");

    public final StringPath unit = createString("unit");

    public QCbhsGclQdXm(String variable) {
        super(CbhsGclQdXm.class, forVariable(variable));
    }

    public QCbhsGclQdXm(Path<? extends CbhsGclQdXm> path) {
        super(path.getType(), path.getMetadata());
    }

    public QCbhsGclQdXm(PathMetadata metadata) {
        super(CbhsGclQdXm.class, metadata);
    }

}

