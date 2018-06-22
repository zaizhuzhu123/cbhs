package com.server.pojo.bean;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;


/**
 * QCbhsZytjGZ is a Querydsl query type for CbhsZytjGZ
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QCbhsZytjGZ extends EntityPathBase<CbhsZytjGZ> {

    private static final long serialVersionUID = -759238268L;

    public static final QCbhsZytjGZ cbhsZytjGZ = new QCbhsZytjGZ("cbhsZytjGZ");

    public final NumberPath<Integer> grCount = createNumber("grCount", Integer.class);

    public final NumberPath<java.math.BigDecimal> gzhj = createNumber("gzhj", java.math.BigDecimal.class);

    public final NumberPath<Integer> gzOid = createNumber("gzOid", Integer.class);

    public final NumberPath<java.math.BigDecimal> gzprice = createNumber("gzprice", java.math.BigDecimal.class);

    public final NumberPath<Integer> oid = createNumber("oid", Integer.class);

    public final NumberPath<Integer> zytjOid = createNumber("zytjOid", Integer.class);

    public QCbhsZytjGZ(String variable) {
        super(CbhsZytjGZ.class, forVariable(variable));
    }

    public QCbhsZytjGZ(Path<? extends CbhsZytjGZ> path) {
        super(path.getType(), path.getMetadata());
    }

    public QCbhsZytjGZ(PathMetadata metadata) {
        super(CbhsZytjGZ.class, metadata);
    }

}

