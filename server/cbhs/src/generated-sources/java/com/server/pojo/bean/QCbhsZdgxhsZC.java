package com.server.pojo.bean;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;


/**
 * QCbhsZdgxhsZC is a Querydsl query type for CbhsZdgxhsZC
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QCbhsZdgxhsZC extends EntityPathBase<CbhsZdgxhsZC> {

    private static final long serialVersionUID = -1299483029L;

    public static final QCbhsZdgxhsZC cbhsZdgxhsZC = new QCbhsZdgxhsZC("cbhsZdgxhsZC");

    public final NumberPath<java.math.BigDecimal> clCount = createNumber("clCount", java.math.BigDecimal.class);

    public final StringPath clKemuName = createString("clKemuName");

    public final NumberPath<Integer> clKemuOid = createNumber("clKemuOid", Integer.class);

    public final StringPath clName = createString("clName");

    public final NumberPath<Integer> clOid = createNumber("clOid", Integer.class);

    public final StringPath clStyle = createString("clStyle");

    public final NumberPath<java.math.BigDecimal> clTotalPrice = createNumber("clTotalPrice", java.math.BigDecimal.class);

    public final StringPath clUnit = createString("clUnit");

    public final NumberPath<java.math.BigDecimal> clUnitPrice = createNumber("clUnitPrice", java.math.BigDecimal.class);

    public final NumberPath<Integer> oid = createNumber("oid", Integer.class);

    public final NumberPath<Integer> zytjOid = createNumber("zytjOid", Integer.class);

    public QCbhsZdgxhsZC(String variable) {
        super(CbhsZdgxhsZC.class, forVariable(variable));
    }

    public QCbhsZdgxhsZC(Path<? extends CbhsZdgxhsZC> path) {
        super(path.getType(), path.getMetadata());
    }

    public QCbhsZdgxhsZC(PathMetadata metadata) {
        super(CbhsZdgxhsZC.class, metadata);
    }

}

