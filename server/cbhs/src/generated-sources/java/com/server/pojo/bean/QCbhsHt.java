package com.server.pojo.bean;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;


/**
 * QCbhsHt is a Querydsl query type for CbhsHt
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QCbhsHt extends EntityPathBase<CbhsHt> {

    private static final long serialVersionUID = -1629052184L;

    public static final QCbhsHt cbhsHt = new QCbhsHt("cbhsHt");

    public final StringPath fbCompanyName = createString("fbCompanyName");

    public final NumberPath<Integer> fbCompanyOid = createNumber("fbCompanyOid", Integer.class);

    public final StringPath htId = createString("htId");

    public final StringPath htName = createString("htName");

    public final NumberPath<Integer> oid = createNumber("oid", Integer.class);

    public final BooleanPath status = createBoolean("status");

    public QCbhsHt(String variable) {
        super(CbhsHt.class, forVariable(variable));
    }

    public QCbhsHt(Path<? extends CbhsHt> path) {
        super(path.getType(), path.getMetadata());
    }

    public QCbhsHt(PathMetadata metadata) {
        super(CbhsHt.class, metadata);
    }

}

