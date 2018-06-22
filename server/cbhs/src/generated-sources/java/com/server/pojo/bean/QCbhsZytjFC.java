package com.server.pojo.bean;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;


/**
 * QCbhsZytjFC is a Querydsl query type for CbhsZytjFC
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QCbhsZytjFC extends EntityPathBase<CbhsZytjFC> {

    private static final long serialVersionUID = -759238322L;

    public static final QCbhsZytjFC cbhsZytjFC = new QCbhsZytjFC("cbhsZytjFC");

    public final NumberPath<java.math.BigDecimal> clCount = createNumber("clCount", java.math.BigDecimal.class);

    public final StringPath clName = createString("clName");

    public final NumberPath<Integer> clOid = createNumber("clOid", Integer.class);

    public final StringPath clStyle = createString("clStyle");

    public final NumberPath<java.math.BigDecimal> clTotalPrice = createNumber("clTotalPrice", java.math.BigDecimal.class);

    public final StringPath clUnit = createString("clUnit");

    public final NumberPath<java.math.BigDecimal> clUnitPrice = createNumber("clUnitPrice", java.math.BigDecimal.class);

    public final NumberPath<Integer> oid = createNumber("oid", Integer.class);

    public final NumberPath<Integer> zytjOid = createNumber("zytjOid", Integer.class);

    public QCbhsZytjFC(String variable) {
        super(CbhsZytjFC.class, forVariable(variable));
    }

    public QCbhsZytjFC(Path<? extends CbhsZytjFC> path) {
        super(path.getType(), path.getMetadata());
    }

    public QCbhsZytjFC(PathMetadata metadata) {
        super(CbhsZytjFC.class, metadata);
    }

}

