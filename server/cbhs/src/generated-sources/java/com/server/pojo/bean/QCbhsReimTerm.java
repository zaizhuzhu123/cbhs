package com.server.pojo.bean;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;


/**
 * QCbhsReimTerm is a Querydsl query type for CbhsReimTerm
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QCbhsReimTerm extends EntityPathBase<CbhsReimTerm> {

    private static final long serialVersionUID = -1423069057L;

    public static final QCbhsReimTerm cbhsReimTerm = new QCbhsReimTerm("cbhsReimTerm");

    public final StringPath content = createString("content");

    public final StringPath name = createString("name");

    public final NumberPath<Integer> oid = createNumber("oid", Integer.class);

    public final NumberPath<java.math.BigDecimal> price = createNumber("price", java.math.BigDecimal.class);

    public final NumberPath<Integer> reimOid = createNumber("reimOid", Integer.class);

    public QCbhsReimTerm(String variable) {
        super(CbhsReimTerm.class, forVariable(variable));
    }

    public QCbhsReimTerm(Path<? extends CbhsReimTerm> path) {
        super(path.getType(), path.getMetadata());
    }

    public QCbhsReimTerm(PathMetadata metadata) {
        super(CbhsReimTerm.class, metadata);
    }

}

