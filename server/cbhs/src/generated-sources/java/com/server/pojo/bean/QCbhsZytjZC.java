package com.server.pojo.bean;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;


/**
 * QCbhsZytjZC is a Querydsl query type for CbhsZytjZC
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QCbhsZytjZC extends EntityPathBase<CbhsZytjZC> {

    private static final long serialVersionUID = -759237702L;

    public static final QCbhsZytjZC cbhsZytjZC = new QCbhsZytjZC("cbhsZytjZC");

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

    public QCbhsZytjZC(String variable) {
        super(CbhsZytjZC.class, forVariable(variable));
    }

    public QCbhsZytjZC(Path<? extends CbhsZytjZC> path) {
        super(path.getType(), path.getMetadata());
    }

    public QCbhsZytjZC(PathMetadata metadata) {
        super(CbhsZytjZC.class, metadata);
    }

}

