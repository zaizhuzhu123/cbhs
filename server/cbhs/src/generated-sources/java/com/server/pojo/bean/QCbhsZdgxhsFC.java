package com.server.pojo.bean;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;


/**
 * QCbhsZdgxhsFC is a Querydsl query type for CbhsZdgxhsFC
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QCbhsZdgxhsFC extends EntityPathBase<CbhsZdgxhsFC> {

    private static final long serialVersionUID = -1299483649L;

    public static final QCbhsZdgxhsFC cbhsZdgxhsFC = new QCbhsZdgxhsFC("cbhsZdgxhsFC");

    public final NumberPath<java.math.BigDecimal> clCount = createNumber("clCount", java.math.BigDecimal.class);

    public final StringPath clName = createString("clName");

    public final NumberPath<Integer> clOid = createNumber("clOid", Integer.class);

    public final StringPath clStyle = createString("clStyle");

    public final NumberPath<java.math.BigDecimal> clTotalPrice = createNumber("clTotalPrice", java.math.BigDecimal.class);

    public final StringPath clUnit = createString("clUnit");

    public final NumberPath<java.math.BigDecimal> clUnitPrice = createNumber("clUnitPrice", java.math.BigDecimal.class);

    public final NumberPath<Integer> oid = createNumber("oid", Integer.class);

    public final NumberPath<Integer> zytjOid = createNumber("zytjOid", Integer.class);

    public QCbhsZdgxhsFC(String variable) {
        super(CbhsZdgxhsFC.class, forVariable(variable));
    }

    public QCbhsZdgxhsFC(Path<? extends CbhsZdgxhsFC> path) {
        super(path.getType(), path.getMetadata());
    }

    public QCbhsZdgxhsFC(PathMetadata metadata) {
        super(CbhsZdgxhsFC.class, metadata);
    }

}

