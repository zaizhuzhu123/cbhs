package com.server.pojo.bean;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;


/**
 * QCbhsFbCompany is a Querydsl query type for CbhsFbCompany
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QCbhsFbCompany extends EntityPathBase<CbhsFbCompany> {

    private static final long serialVersionUID = -1169058107L;

    public static final QCbhsFbCompany cbhsFbCompany = new QCbhsFbCompany("cbhsFbCompany");

    public final StringPath name = createString("name");

    public final NumberPath<Integer> oid = createNumber("oid", Integer.class);

    public final NumberPath<Integer> personCount = createNumber("personCount", Integer.class);

    public final BooleanPath status = createBoolean("status");

    public QCbhsFbCompany(String variable) {
        super(CbhsFbCompany.class, forVariable(variable));
    }

    public QCbhsFbCompany(Path<? extends CbhsFbCompany> path) {
        super(path.getType(), path.getMetadata());
    }

    public QCbhsFbCompany(PathMetadata metadata) {
        super(CbhsFbCompany.class, metadata);
    }

}

